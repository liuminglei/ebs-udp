//取到页面上的style路径
var csspath;

$("link").each(function(){
	if($(this).attr("href").indexOf('basic.css')>-1) {
		csspath = $(this).attr("href");
	}
});

var csspathHead=csspath.substring(0,csspath.lastIndexOf('/') + 1);

//加载bootstrap
document.write("<link rel='stylesheet' type='text/css' href='"+csspathHead+"bootstrap.min.css"+"'/>");

//加载metisMenu
document.write("<link rel='stylesheet' type='text/css' href='"+csspathHead+"metisMenu/metisMenu.min.css"+"'/>");

//加载font-awesome
document.write("<link rel='stylesheet' type='text/css' href='"+csspathHead+"font-awesome.min.css"+"'/>");

//加载sb-admin-2
document.write("<link rel='stylesheet' type='text/css' href='"+csspathHead+"systemStyle.css"+"'/>");

//加载iCheck
document.write("<link rel='stylesheet' type='text/css' href='"+csspathHead+"iCheck/blue.css"+"'/>");

//取到页面上script的标签
var jspath;

$("script").each(function() {
	if ($(this).attr("src").indexOf('InitScript.js') > -1) {
		jspath = $(this).attr("src");
	}
});

var jspathHead = jspath.substring(0, jspath.lastIndexOf('/'));

// 取出路径，例如../../script/InitScript.js,取出../..
var rootPath = jspathHead.substring(0, jspathHead.lastIndexOf('/'));

if (jspathHead != "") {
	jspathHead = jspathHead + "/";
}

if (rootPath != "") {
	rootPath = rootPath + "/";
}

//加载bootstrap
document.write("<script language='javascript' type='text/javascript' src='"+jspathHead+"bootstrap.min.js"+"'></script>");

//加载菜单折叠效果
document.write("<script language='javascript' type='text/javascript' src='"+jspathHead+"metisMenu/metisMenu.min.js"+"'></script>");

//应用系统js
document.write("<script language='javascript' type='text/javascript' src='"+jspathHead+"systemScript.js"+"'></script>");

//应用iCheck样式
document.write("<script language='javascript' type='text/javascript' src='"+jspathHead+"iCheck/icheck.min.js"+"'></script>");


$(function() {
	$('.i-check').iCheck({
		checkboxClass: 'icheckbox_square-blue',
		radioClass: 'iradio_square-blue',
	});
});