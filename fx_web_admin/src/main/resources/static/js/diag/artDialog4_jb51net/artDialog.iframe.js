/*!
 * artDialog iframeTools
 * Date: 2011-11-25 13:54
 * http://code.google.com/p/artdialog/
 * (c) 2009-2011 TangBin, http://www.planeArt.cn
 *
 * This is licensed under the GNU LGPL, version 2.1 or later.
 * For details, see: http://creativecommons.org/licenses/LGPL/2.1/
 */
 
;(function ($, window, artDialog, undefined) {

var _topDialog, _proxyDialog, _zIndex,
	_data = '@ARTDIALOG.DATA',
	_open = '@ARTDIALOG.OPEN',
	_opener = '@ARTDIALOG.OPENER',
	_winName = window.name = window.name
	|| '@ARTDIALOG.WINNAME' + + new Date,
	_isIE6 = window.VBArray && !window.XMLHttpRequest;

$(function () {
	!window.jQuery && document.compatMode === 'BackCompat'
	// 涓嶆敮鎸佹€紓妯″紡锛岃鐢ㄤ富娴佺殑XHTML1.0鎴栬€匟TML5鐨凞OCTYPE鐢虫槑
	&& alert('artDialog Error: document.compatMode === "BackCompat"');
});
	
	
/** 鑾峰彇 artDialog 鍙法绾ц皟鐢ㄧ殑鏈€楂樺眰鐨� window 瀵硅薄 */
var _top = artDialog.top = function () {
	var top = window,
	test = function (name) {
		try {
			var doc = window[name].document;	// 璺ㄥ煙|鏃犳潈闄�
			doc.getElementsByTagName; 			// chrome 鏈湴瀹夊叏闄愬埗
		} catch (e) {
			return false;
        }
        return window[name].artDialog
		// 妗嗘灦闆嗘棤娉曟樉绀虹涓夋柟鍏冪礌
		&& doc.getElementsByTagName('frameset').length === 0;
	};
	
	if (test('top')) {
		top = window.top;
	} else if (test('parent')) {
		top = window.parent;
    }
    return top;
}();
artDialog.parent = _top; // 鍏煎v4.1涔嬪墠鐗堟湰锛屾湭鏉ョ増鏈皢鍒犻櫎姝�


_topDialog = _top.artDialog;


// 鑾峰彇椤跺眰椤甸潰瀵硅瘽妗嗗彔鍔犲€�
_zIndex = function () {
	return _topDialog.defaults.zIndex;
};



/**
 * 璺ㄦ鏋舵暟鎹叡浜帴鍙�
 * @see		http://www.planeart.cn/?p=1554
 * @param	{String}	瀛樺偍鐨勬暟鎹悕
 * @param	{Any}		灏嗚瀛樺偍鐨勪换鎰忔暟鎹�(鏃犳椤瑰垯杩斿洖琚煡璇㈢殑鏁版嵁)
 */
artDialog.data = function (name, value) {
	var top = artDialog.top,
		cache = top[_data] || {};
	top[_data] = cache;
	
	if (value !== undefined) {
		cache[name] = value;
	} else {
		return cache[name];
    }
    return cache;
};


/**
 * 鏁版嵁鍏变韩鍒犻櫎鎺ュ彛
 * @param	{String}	鍒犻櫎鐨勬暟鎹悕
 */
artDialog.removeData = function (name) {
	var cache = artDialog.top[_data];
	if (cache && cache[name]) delete cache[name];
};


/** 璺ㄦ鏋舵櫘閫氬璇濇 */
artDialog.through = _proxyDialog = function () {
	var api = _topDialog.apply(this, arguments);
		
	// 缂撳瓨浠庡綋鍓� window锛堝彲鑳戒负iframe锛夎皟鍑烘墍鏈夎法妗嗘灦瀵硅瘽妗嗭紝
	// 浠ヤ究璁╁綋鍓� window 鍗歌浇鍓嶅幓鍏抽棴杩欎簺瀵硅瘽妗嗐€�
	// 鍥犱负iframe娉ㄩ攢鍚庝篃浼氫粠鍐呭瓨涓垹闄ゅ叾鍒涘缓鐨勫璞★紝杩欐牱鍙互闃叉鍥炶皟鍑芥暟鎶ラ敊
	if (_top !== window) artDialog.list[api.config.id] = api;
	return api;
};

// 妗嗘灦椤甸潰鍗歌浇鍓嶅叧闂墍鏈夌┛瓒婄殑瀵硅瘽妗�
_top !== window && $(window).bind('unload', function () {
	var list = artDialog.list, config;
	for (var i in list) {
		if (list[i]) {
			config = list[i].config;
			if (config) config.duration = 0; // 鍙栨秷鍔ㄧ敾
			list[i].close();
			//delete list[i];
        }
    }
});


/**
 * 寮圭獥 (iframe)
 * @param	{String}	鍦板潃
 * @param	{Object}	閰嶇疆鍙傛暟. 杩欓噷浼犲叆鐨勫洖璋冨嚱鏁版帴鏀剁殑绗�1涓弬鏁颁负iframe鍐呴儴window瀵硅薄
 * @param	{Boolean}	鏄惁鍏佽缂撳瓨. 榛樿true
 */
artDialog.open = function (url, options, cache) {
	options = options || {};
	
	var api, DOM,
		$content, $main, iframe, $iframe, $idoc, iwin, ibody,
		top = artDialog.top,
		initCss = 'position:absolute;left:-9999em;top:-9999em;border:none 0;background:transparent',
		loadCss = 'width:100%;height:100%;border:none 0';
		
	if (cache === false) {
		var ts = + new Date,
			ret = url.replace(/([?&])_=[^&]*/, "$1_=" + ts );
		url = ret + ((ret === url) ? (/\?/.test(url) ? "&" : "?") + "_=" + ts : "");
    }
    var load = function () {
		var iWidth, iHeight,
			loading = DOM.content.find('.aui_loading'),
			aConfig = api.config;
			
		$content.addClass('aui_state_full');
		
		loading && loading.hide();
		
		try {
			iwin = iframe.contentWindow;
			$idoc = $(iwin.document);
			ibody = iwin.document.body;
		} catch (e) {// 璺ㄥ煙
			iframe.style.cssText = loadCss;
			
			aConfig.follow
			? api.follow(aConfig.follow)
			: api.position(aConfig.left, aConfig.top);
			
			options.init && options.init.call(api, iwin, top);
			options.init = null;
			return;
        }
        // 鑾峰彇iframe鍐呴儴灏哄
		iWidth = aConfig.width === 'auto'
		? $idoc.width() + (_isIE6 ? 0 : parseInt($(ibody).css('marginLeft')))
		: aConfig.width;
		
		iHeight = aConfig.height === 'auto'
		? $idoc.height()
		: aConfig.height;
		
		// 閫傚簲iframe灏哄
		setTimeout(function () {
			iframe.style.cssText = loadCss;
		}, 0);// setTimeout: 闃叉IE6~7瀵硅瘽妗嗘牱寮忔覆鏌撳紓甯�
		api.size(iWidth, iHeight);
		
		// 璋冩暣瀵硅瘽妗嗕綅缃�
		aConfig.follow
		? api.follow(aConfig.follow)
		: api.position(aConfig.left, aConfig.top);
		
		options.init && options.init.call(api, iwin, top);
		options.init = null;
	};
		
	var config = {
		zIndex: _zIndex(),
		init: function () {
			api = this;
			DOM = api.DOM;
			$main = DOM.main;
			$content = DOM.content;
			
			iframe = api.iframe = top.document.createElement('iframe');
			iframe.src = url;
			iframe.name = 'Open' + api.config.id;
			iframe.style.cssText = initCss;
			iframe.setAttribute('frameborder', 0, 0);
			iframe.setAttribute('allowTransparency', true);
			
			$iframe = $(iframe);
			api.content().appendChild(iframe);
			iwin = iframe.contentWindow;
			
			try {
				iwin.name = iframe.name;
				artDialog.data(iframe.name + _open, api);
				artDialog.data(iframe.name + _opener, window);
            } catch (e) {
            }
            $iframe.bind('load', load);
		},
		close: function () {
			$iframe.css('display', 'none').unbind('load', load);
			
			if (options.close && options.close.call(this, iframe.contentWindow, top) === false) {
				return false;
            }
            $content.removeClass('aui_state_full');
			
			// 閲嶈锛侀渶瑕侀噸缃甶frame鍦板潃锛屽惁鍒欎笅娆″嚭鐜扮殑瀵硅瘽妗嗗湪IE6銆�7鏃犳硶鑱氱劍input
			// IE鍒犻櫎iframe鍚庯紝iframe浠嶇劧浼氱暀鍦ㄥ唴瀛樹腑鍑虹幇涓婅堪闂锛岀疆鎹rc鏄渶瀹规槗瑙ｅ喅鐨勬柟娉�
			$iframe[0].src = 'about:blank';
			$iframe.remove();
			
			try {
				artDialog.removeData(iframe.name + _open);
				artDialog.removeData(iframe.name + _opener);
            } catch (e) {
            }
        }
	};
	
	// 鍥炶皟鍑芥暟绗竴涓弬鏁版寚鍚慽frame鍐呴儴window瀵硅薄
	if (typeof options.ok === 'function') config.ok = function () {
		return options.ok.call(api, iframe.contentWindow, top);
	};
	if (typeof options.cancel === 'function') config.cancel = function () {
		return options.cancel.call(api, iframe.contentWindow, top);
	};
	
	delete options.content;

	for (var i in options) {
		if (config[i] === undefined) config[i] = options[i];
    }
    return _proxyDialog(config);
};


/** 寮曠敤open鏂规硶鎵╁睍鏂规硶(鍦╫pen鎵撳紑鐨刬frame鍐呴儴绉佹湁鏂规硶) */
artDialog.open.api = artDialog.data(_winName + _open);


/** 寮曠敤open鏂规硶瑙﹀彂鏉ユ簮椤甸潰window(鍦╫pen鎵撳紑鐨刬frame鍐呴儴绉佹湁鏂规硶) */
artDialog.opener = artDialog.data(_winName + _opener) || window;
artDialog.open.origin = artDialog.opener; // 鍏煎v4.1涔嬪墠鐗堟湰锛屾湭鏉ョ増鏈皢鍒犻櫎姝�

/** artDialog.open 鎵撳紑鐨刬frame椤甸潰閲屽叧闂璇濇蹇嵎鏂规硶 */
artDialog.close = function () {
	var api = artDialog.data(_winName + _open);
	api && api.close();
	return false;
};

// 鐐瑰嚮iframe鍐呭鍒囨崲鍙犲姞楂樺害
_top != window && $(document).bind('mousedown', function () {
	var api = artDialog.open.api;
	api && api.zIndex();
});


/**
 * Ajax濉厖鍐呭
 * @param	{String}			鍦板潃
 * @param	{Object}			閰嶇疆鍙傛暟
 * @param	{Boolean}			鏄惁鍏佽缂撳瓨. 榛樿true
 */
artDialog.load = function(url, options, cache){
	cache = cache || false;
	var opt = options || {};
		
	var config = {
		zIndex: _zIndex(),
		init: function(here){
			var api = this,
				aConfig = api.config;
			
			$.ajax({
				url: url,
				success: function (content) {
					api.content(content);
					opt.init && opt.init.call(api, here);		
				},
				cache: cache
			});
			
		}
	};
	
	delete options.content;
	
	for (var i in opt) {
		if (config[i] === undefined) config[i] = opt[i];
    }
    return _proxyDialog(config);
};


/**
 * 璀﹀憡
 * @param	{String}	娑堟伅鍐呭
 */
artDialog.alert = function (content, callback) {
	return _proxyDialog({
		id: 'Alert',
		zIndex: _zIndex(),
		icon: 'warning',
		fixed: true,
		lock: true,
		content: content,
		ok: true,
		close: callback
	});
};


/**
 * 纭
 * @param	{String}	娑堟伅鍐呭
 * @param	{Function}	纭畾鎸夐挳鍥炶皟鍑芥暟
 * @param	{Function}	鍙栨秷鎸夐挳鍥炶皟鍑芥暟
 */
artDialog.confirm = function (content, yes, no) {
	return _proxyDialog({
		id: 'Confirm',
		zIndex: _zIndex(),
		icon: 'question',
		fixed: true,
		lock: true,
		opacity: .1,
		content: content,
		ok: function (here) {
			return yes.call(this, here);
		},
		cancel: function (here) {
			return no && no.call(this, here);
		}
	});
};


/**
 * 鎻愰棶
 * @param	{String}	鎻愰棶鍐呭
 * @param	{Function}	鍥炶皟鍑芥暟. 鎺ユ敹鍙傛暟锛氳緭鍏ュ€�
 * @param	{String}	榛樿鍊�
 */
artDialog.prompt = function (content, yes, value) {
	value = value || '';
	var input;
	
	return _proxyDialog({
		id: 'Prompt',
		zIndex: _zIndex(),
		icon: 'question',
		fixed: true,
		lock: true,
		opacity: .1,
		content: [
			'<div style="margin-bottom:5px;font-size:12px">',
				content,
			'</div>',
			'<div>',
				'<input value="',
					value,
				'" style="width:18em;padding:6px 4px" />',
			'</div>'
			].join(''),
		init: function () {
			input = this.DOM.content.find('input')[0];
			input.select();
			input.focus();
		},
		ok: function (here) {
			return yes && yes.call(this, input.value, here);
		},
		cancel: true
	});
};


/**
 * 鐭殏鎻愮ず
 * @param	{String}	鎻愮ず鍐呭
 * @param	{Number}	鏄剧ず鏃堕棿 (榛樿1.5绉�)
 */
artDialog.tips = function (content, time) {
	return _proxyDialog({
		id: 'Tips',
		zIndex: _zIndex(),
		title: false,
		cancel: false,
		fixed: true,
		lock: false
	})
	.content('<div style="padding: 0 1em;">' + content + '</div>')
	.time(time || 1.5);
};


// 澧炲己artDialog鎷栨嫿浣撻獙
// - 闃叉榧犳爣钀藉叆iframe瀵艰嚧涓嶆祦鐣�
// - 瀵硅秴澶у璇濇鎷栧姩浼樺寲
$(function () {
	var event = artDialog.dragEvent;
	if (!event) return;

	var $window = $(window),
		$document = $(document),
		positionType = _isIE6 ? 'absolute' : 'fixed',
		dragEvent = event.prototype,
		mask = document.createElement('div'),
		style = mask.style;
		
	style.cssText = 'display:none;position:' + positionType + ';left:0;top:0;width:100%;height:100%;'
	+ 'cursor:move;filter:alpha(opacity=0);opacity:0;background:#FFF';
		
	document.body.appendChild(mask);
	dragEvent._start = dragEvent.start;
	dragEvent._end = dragEvent.end;
	
	dragEvent.start = function () {
		var DOM = artDialog.focus.DOM,
			main = DOM.main[0],
			iframe = DOM.content[0].getElementsByTagName('iframe')[0];
		
		dragEvent._start.apply(this, arguments);
		style.display = 'block';
		style.zIndex = artDialog.defaults.zIndex + 3;
		
		if (positionType === 'absolute') {
			style.width = $window.width() + 'px';
			style.height = $window.height() + 'px';
			style.left = $document.scrollLeft() + 'px';
			style.top = $document.scrollTop() + 'px';
        }
        if (iframe && main.offsetWidth * main.offsetHeight > 307200) {
			main.style.visibility = 'hidden';
        }
    };
	
	dragEvent.end = function () {
		var dialog = artDialog.focus;
		dragEvent._end.apply(this, arguments);
		style.display = 'none';
		if (dialog) dialog.DOM.main[0].style.visibility = 'visible';
	};
});

})(this.art || this.jQuery, this, this.artDialog);

