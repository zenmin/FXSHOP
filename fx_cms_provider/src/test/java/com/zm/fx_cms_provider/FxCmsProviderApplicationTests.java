package com.zm.fx_cms_provider;

import com.zm.fx_dao_common.bean.IndexContent;
import com.zm.fx_dao_common.dao.ContentCategoryMapper;
import com.zm.fx_dao_common.dao.IndexContentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FxCmsProviderApplicationTests {

    @Autowired
    ContentCategoryMapper contentCategoryMapper;
    @Autowired
    IndexContentMapper indexContentMapper;

    @Test
    public void contextLoads() {
        IndexContent indexContent = new IndexContent();
        indexContent.setId(System.currentTimeMillis());
        indexContent.setTitle("这是一个标题");
        indexContent.setCreated(new Date());
        indexContent.setDescrible("这是一个描述。。。。。。。。。。");
        indexContent.setImg("图片链接");
        indexContent.setParentid(1L);
        indexContent.setUpdated(new Date());
        indexContent.setUrl("http://baidu.com");
        indexContent.setName("首页1");
        indexContentMapper.insertSelective(indexContent);
    }

}
