var pkg = require('../static/datas/package.json');

var gulp = require('gulp');
var uglify = require('gulp-uglify');
var minify = require('gulp-minify-css');
var concat = require('gulp-concat');
var rename = require('gulp-rename');
var header = require('gulp-header');
var del = require('del');
var gulpif = require('gulp-if');
var minimist = require('minimist');
var zip = require('gulp-zip');

var task = {
    mincss: function () {
        return gulp.src(['./src/css/**/*.css'])
            .pipe(minify())
            .pipe(header.apply(null, ['/** <%= pkg.name %>-v<%= pkg.version %> <%= pkg.license %> License By <%= pkg.homepage %> */\n', {pkg: pkg}]))
            .pipe(gulp.dest('./build/css'));
    },
    minjs: function () {
        return gulp.src('./src/js/*.js')
            .pipe(gulpif('!app.js', uglify()))
            .pipe(header.apply(null, ['/** <%= pkg.name %>-v<%= pkg.version %> <%= pkg.license %> License By <%= pkg.homepage %> */\n <%= js %>', {
                pkg: pkg,
                js: ';'
            }]))
            .pipe(gulp.dest('./build/js'));
    },
    file: function () {
        return gulp.src(['./src/images/**/*.{png,jpg,gif,html,mp3,json}'])
            .pipe(rename({}))
            .pipe(gulp.dest('./build/images'));
    }
};
gulp.task('minjs', task.minjs);
gulp.task('mincss', task.mincss);
gulp.task('file', task.file);
gulp.task('default', function () {

});
gulp.task('all', ['clear'], function () {
    for (var key in task) {
        task[key]();
    }
});
gulp.task('clear', function (cb) {
    return del(['./build/*'], cb);
});