<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
  <title>欢迎登录</title>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="">
  <meta name="author" content="">
  <link type="text/css" href="<%=request.getContextPath()%>/css/basic.css" rel="stylesheet">
  <script src="<%=request.getContextPath()%>/script/jquery.min.js"></script>
  <script src="<%=request.getContextPath()%>/script/InitScript.js"></script>
  <script type="text/javascript">
  <!--
    function adjustFrameSize() {
      //适应高度
      var obj = document.getElementById("MainWorkArea");
      obj.height = 0;
      obj.height = obj.contentWindow.document.body.scrollHeight + obj.offsetTop;
      $(document.body).css("overflow", "visible");
	}
  
  //-->
  </script>
</head>

<body>
  <div id="wrapper">
    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
          <span class="sr-only">Toggle navigation</span> 
          <span class="icon-bar"></span> 
          <span class="icon-bar"></span> 
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="index.html">e招标 v1.0</a>
      </div>
      <!-- /.navbar-header -->

      <ul class="nav navbar-top-links navbar-right">
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#"> 
            <i class="fa fa-envelope fa-fw"></i> 
            <i class="fa fa-caret-down"></i>
          </a>
          <ul class="dropdown-menu dropdown-messages">
            <li>
              <a href="#">
                <div>
                  <strong>刘明磊</strong> 
                  <span class="pull-right text-muted"><em>昨天</em></span>
                </div>
                <div>精英团队制作，敬请期待...</div>
              </a>
            </li>
            <li class="divider"></li>
            <li>
              <a href="#">
                <div>
                  <strong>刘明磊</strong> 
                  <span class="pull-right text-muted"> <em>昨天</em>
                  </span>
                </div>
                <div>精英团队制作，敬请期待...</div>
              </a>
            </li>
            <li class="divider"></li>
            <li>
              <a href="#">
                <div>
                  <strong>刘明磊</strong> 
                  <span class="pull-right text-muted"> <em>昨天</em>
                  </span>
                </div>
                <div>精英团队制作，敬请期待...</div>
              </a>
            </li>
            <li class="divider"></li>
            <li>
              <a class="text-center" href="#"><strong>所有消息</strong><i class="fa fa-angle-right"></i></a>
            </li>
          </ul> 
          <!-- 邮件下沉菜单结束 -->
        </li>
        <!-- 邮件下沉结束 -->
        
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#"> 
            <i class="fa fa-tasks fa-fw"></i><i class="fa fa-caret-down"></i>
          </a>
          <ul class="dropdown-menu dropdown-tasks">
            <li>
              <a href="#">
                <div>
                  <p>
                    <strong>任务1</strong> <span class="pull-right text-muted">40% 已完成</span>
                  </p>
                  <div class="progress progress-striped active">
                    <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
                      <span class="sr-only">40% 已完成 (成功)</span>
                    </div>
                  </div>
                </div>
              </a>
            </li>
            <li class="divider"></li>
            <li>
              <a href="#">
                <div>
                  <p>
                    <strong>任务2</strong><span class="pull-right text-muted">20% 已完成</span>
                  </p>
                  <div class="progress progress-striped active">
                    <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 20%">
                      <span class="sr-only">20% 已完成</span>
                    </div>
                  </div>
                </div>
              </a>
            </li>
            <li class="divider"></li>
            <li>
              <a href="#">
                <div>
                  <p>
                    <strong>任务 3</strong> <span class="pull-right text-muted">60% 已完成</span>
                  </p>
                  <div class="progress progress-striped active">
                    <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
                      <span class="sr-only">60% 已完成 (警告)</span>
                    </div>
                  </div>
                </div>
              </a>
            </li>
            <li class="divider"></li>
            <li>
              <a href="#">
                <div>
                  <p>
                    <strong>任务 4</strong> <span class="pull-right text-muted">80% 已完成</span>
                  </p>
                  <div class="progress progress-striped active">
                    <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
                      <span class="sr-only">80% 已完成 (危险)</span>
                    </div>
                  </div>
                </div>
              </a>
            </li>
            <li class="divider"></li>
            <li>
              <a class="text-center" href="#"><strong>所有任务</strong> <i class="fa fa-angle-right"></i></a>
            </li>
          </ul> 
          <!-- 任务进度下沉菜单结束 -->
        </li>
        <!-- 任务进度下沉结束 -->
        
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#"> 
            <i class="fa fa-bell fa-fw"></i><i class="fa fa-caret-down"></i>
          </a>
          <ul class="dropdown-menu dropdown-alerts">
            <li>
              <a href="#">
                <div>
                  <i class="fa fa-comment fa-fw"></i> 新回复 <span class="pull-right text-muted small">4分钟前</span>
                </div>
              </a>
            </li>
            <li class="divider"></li>
            <li>
              <a href="#">
                <div>
                  <i class="fa fa-twitter fa-fw"></i> 3个回复 <span class="pull-right text-muted small">12分钟前</span>
                </div>
              </a>
            </li>
            <li class="divider"></li>
            <li>
              <a href="#">
                <div>
                  <i class="fa fa-envelope fa-fw"></i> 消息发送 <span class="pull-right text-muted small">4分钟前</span>
                </div>
              </a>
            </li>
            <li class="divider"></li>
            <li>
              <a href="#">
                <div>
                  <i class="fa fa-tasks fa-fw"></i> 新任务 <span class="pull-right text-muted small">4分钟前</span>
                </div>
              </a>
            </li>
            <li class="divider"></li>
            <li>
              <a href="#">
                <div>
                  <i class="fa fa-upload fa-fw"></i> 服务重启 <span class="pull-right text-muted small">4分钟前</span>
                </div>
              </a>
            </li>
            <li class="divider"></li>
            <li>
              <a class="text-center" href="#"><strong>所有通知</strong><i class="fa fa-angle-right"></i></a>
            </li>
          </ul> 
          <!-- 系统通知下沉菜单结束 -->
        </li>
        <!-- 系统通知下沉结束 -->
        
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#"><i class="fa fa-user fa-fw"></i><i class="fa fa-caret-down"></i></a>
          <ul class="dropdown-menu dropdown-user">
            <li><a href="#"><i class="fa fa-user fa-fw"></i> 用户配置</a></li>
            <li><a href="#"><i class="fa fa-gear fa-fw"></i> 设置</a></li>
            <li class="divider"></li>
            <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i> 退出系统</a></li>
          </ul> 
          <!-- 用户菜单下沉菜单结束 -->
        </li>
        <!-- 用户菜单下沉结束 -->
      </ul>
      <!-- 导航栏上部工具栏结束 -->
      <jsp:include page="/login/menu.do"></jsp:include>      
      <!-- 导航栏左侧菜单栏结束 -->
    </nav>
    
    <!-- 主任务区开始 -->
    <iframe id="MainWorkArea" name="MainWorkArea" src="${pageContext.request.contextPath}/login/desk.do" marginWidth="0" marginHeight="0" frameBorder="0" width="100%" height="100%" scrolling="no" onload="adjustFrameSize()"></iframe>
    <!-- 主任务区结束 -->

    <!-- 信息提示部分开始 -->
    <div class="modal-footer" style="display:none">
      <iframe id="SysInforArea" name="SysInforArea" src="" marginWidth="0" marginHeight="0" frameBorder="0" width="100%" height="100%" scrolling="auto"></iframe>
    </div>
    <!-- 信息提示部分结束 -->
  </div>
  <!-- /#wrapper -->
</body>
</html>
