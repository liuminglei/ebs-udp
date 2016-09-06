<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html>
<html>
<head>
  <base href="<%=basePath%>">
  <title>欢迎登录</title>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="">
  <meta name="author" content="">
  <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/css/metisMenu.min.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/css/timeline.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/css/morris.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <link href="<%=request.getContextPath()%>/css/sb-admin-2.css" rel="stylesheet">
  <script src="<%=request.getContextPath()%>/script/jquery.min.js"></script>
  <script src="<%=request.getContextPath()%>/script/bootstrap.min.js"></script>
  <script src="<%=request.getContextPath()%>/script/metisMenu.min.js"></script>
  <script src="<%=request.getContextPath()%>/script/raphael-min.js"></script>
  <script src="<%=request.getContextPath()%>/script/morris.min.js"></script>
  <script src="<%=request.getContextPath()%>/script/morris-data.js"></script>
  <script src="<%=request.getContextPath()%>/script/sb-admin-2.js"></script>

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
          <!-- /.dropdown-messages -->
        </li>
        <!-- /.dropdown -->
        
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
          <!-- /.dropdown-tasks -->
        </li>
        <!-- /.dropdown -->
        
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
          <!-- /.dropdown-alerts -->
        </li>
        <!-- /.dropdown -->
        
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#"><i class="fa fa-user fa-fw"></i><i class="fa fa-caret-down"></i></a>
          <ul class="dropdown-menu dropdown-user">
            <li><a href="#"><i class="fa fa-user fa-fw"></i> 用户配置</a></li>
            <li><a href="#"><i class="fa fa-gear fa-fw"></i> 设置</a></li>
            <li class="divider"></li>
            <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i> 退出系统</a></li>
          </ul> 
          <!-- /.dropdown-user -->
        </li>
        <!-- /.dropdown -->
      </ul>
      <!-- /.navbar-top-links -->
      
      <div class="navbar-default sidebar" role="navigation">
        <div class="sidebar-nav navbar-collapse">
          <ul class="nav" id="side-menu">
            <li class="sidebar-search">
              <div class="input-group custom-search-form">
                <input type="text" class="form-control" placeholder="Search..." /> 
                <span class="input-group-btn">
                  <button class="btn btn-default" type="button"><i class="fa fa-search"></i></button>
                </span>
              </div> 
              <!-- /input-group -->
            </li>
            <li><a href="index.html"><i class="fa fa-dashboard fa-fw"></i> 首页</a></li>
            <li>
              <a href="#">
                <i class="fa fa-bar-chart-o fa-fw"></i> 图表<span class="fa arrow"></span>
              </a>
              <ul class="nav nav-second-level">
                <li><a href="flot.html">Flot Charts</a></li>
                <li><a href="morris.html">Morris.js Charts</a></li>
              </ul> 
              <!-- /.nav-second-level -->
            </li>
            <li><a href="tables.html"><i class="fa fa-table fa-fw"></i> 表格</a></li>
            <li><a href="forms.html"><i class="fa fa-edit fa-fw"></i> 表单</a></li>
            <li>
              <a href="#"><i class="fa fa-wrench fa-fw"></i> UI 元素<span class="fa arrow"></span></a>
              <ul class="nav nav-second-level">
                <li><a href="panels-wells.html">面板 和 Wells</a></li>
                <li><a href="buttons.html">按钮</a></li>
                <li><a href="notifications.html">通知</a></li>
                <li><a href="typography.html">Typography</a></li>
                <li><a href="icons.html"> 图标</a></li>
                <li><a href="grid.html">布局</a></li>
              </ul> 
              <!-- /.nav-second-level -->
            </li>
            <li>
              <a href="#"><i class="fa fa-sitemap fa-fw"></i> 混合菜单<span class="fa arrow"></span></a>
              <ul class="nav nav-second-level">
                <li><a href="#">第二级菜单项</a></li>
                <li><a href="#">第二级菜单项</a></li>
                <li>
                  <a href="#">第二级菜单项<span class="fa arrow"></span></a>
                  <ul class="nav nav-third-level">
                    <li><a href="#">第三级菜单项</a></li>
                    <li><a href="#">第三级菜单项</a></li>
                    <li><a href="#">第三级菜单项</a></li>
                    <li><a href="#">第三级菜单项</a></li>
                  </ul> 
                  <!-- /.nav-third-level -->
                </li>
              </ul> 
              <!-- /.nav-second-level -->
            </li>
            <li>
              <a href="#"><i class="fa fa-files-o fa-fw"></i>实例页<span class="fa arrow"></span></a>
              <ul class="nav nav-second-level">
                <li><a href="blank.html">空白页</a></li>
                <li><a href="login.html">登录页</a></li>
              </ul> 
              <!-- /.nav-second-level -->
            </li>
          </ul>
        </div>
        <!-- /.sidebar-collapse -->
      </div>
      <!-- /.navbar-static-side -->
    </nav>

    <div id="page-wrapper">
      <div class="row">
        <div class="col-lg-12">
          <h1 class="page-header">e招标</h1>
        </div>
      </div>
      <div class="row">
        <div class="col-lg-3 col-md-6">
          <div class="panel panel-primary">
            <div class="panel-heading">
              <div class="row">
                <div class="col-xs-3">
                  <i class="fa fa-comments fa-5x"></i>
                </div>
                <div class="col-xs-9 text-right">
                  <div class="huge">26</div>
                  <div>新评论!</div>
                </div>
              </div>
            </div>
            <a href="#">
              <div class="panel-footer">
                <span class="pull-left">更多</span><span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                <div class="clearfix"></div>
              </div>
            </a>
          </div>
        </div>
        <div class="col-lg-3 col-md-6">
          <div class="panel panel-green">
            <div class="panel-heading">
              <div class="row">
                <div class="col-xs-3">
                  <i class="fa fa-tasks fa-5x"></i>
                </div>
                <div class="col-xs-9 text-right">
                  <div class="huge">12</div>
                  <div>新任务!</div>
                </div>
              </div>
            </div>
            <a href="#">
              <div class="panel-footer">
                <span class="pull-left">更多</span> <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                <div class="clearfix"></div>
              </div>
            </a>
          </div>
        </div>
        <div class="col-lg-3 col-md-6">
          <div class="panel panel-yellow">
            <div class="panel-heading">
              <div class="row">
                <div class="col-xs-3">
                  <i class="fa fa-shopping-cart fa-5x"></i>
                </div>
                <div class="col-xs-9 text-right">
                  <div class="huge">124</div>
                  <div>新订单!</div>
                </div>
              </div>
            </div>
            <a href="#">
              <div class="panel-footer">
                <span class="pull-left">更多</span> <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                <div class="clearfix"></div>
              </div>
            </a>
          </div>
        </div>
        <div class="col-lg-3 col-md-6">
          <div class="panel panel-red">
            <div class="panel-heading">
              <div class="row">
                <div class="col-xs-3">
                  <i class="fa fa-support fa-5x"></i>
                </div>
                <div class="col-xs-9 text-right">
                  <div class="huge">13</div>
                  <div>支持票!</div>
                </div>
              </div>
            </div>
            <a href="#">
              <div class="panel-footer">
                <span class="pull-left">更多</span><span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                <div class="clearfix"></div>
              </div>
            </a>
          </div>
        </div>
      </div>
      <div class="row">
        <div class="col-lg-8">
          <div class="panel panel-default">
            <div class="panel-heading">
              <i class="fa fa-bar-chart-o fa-fw"></i> Area Chart 示例
              <div class="pull-right">
                <div class="btn-group">
                  <button type="button" class="btn btn-default btn-xs dropdown-toggle" data-toggle="dropdown">操作<span class="caret"></span></button>
                  <ul class="dropdown-menu pull-right" role="menu">
                    <li><a href="#">Action</a></li>
                    <li><a href="#">Another action</a></li>
                    <li><a href="#">Something else here</a></li>
                    <li class="divider"></li>
                    <li><a href="#">Separated link</a></li>
                  </ul>
                </div>
              </div>
            </div>
            <div class="panel-body">
              <div id="morris-area-chart"></div>
            </div>
          </div>
          <div class="panel panel-default">
            <div class="panel-heading">
              <i class="fa fa-bar-chart-o fa-fw"></i> Bar Chart 示例
              <div class="pull-right">
                <div class="btn-group">
                  <button type="button" class="btn btn-default btn-xs dropdown-toggle" data-toggle="dropdown">Actions<span class="caret"></span></button>
                  <ul class="dropdown-menu pull-right" role="menu">
                    <li><a href="#">Action</a></li>
                    <li><a href="#">Another action</a></li>
                    <li><a href="#">Something else here</a></li>
                    <li class="divider"></li>
                    <li><a href="#">Separated link</a></li>
                  </ul>
                </div>
              </div>
            </div>
            <div class="panel-body">
              <div class="row">
                <div class="col-lg-4">
                  <div class="table-responsive">
                    <table class="table table-bordered table-hover table-striped">
                      <thead>
                        <tr>
                          <th>#</th>
                          <th>Date</th>
                          <th>Time</th>
                          <th>Amount</th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr>
                          <td>3326</td>
                          <td>10/21/2013</td>
                          <td>3:29 PM</td>
                          <td>$321.33</td>
                        </tr>
                        <tr>
                          <td>3325</td>
                          <td>10/21/2013</td>
                          <td>3:20 PM</td>
                          <td>$234.34</td>
                        </tr>
                        <tr>
                          <td>3324</td>
                          <td>10/21/2013</td>
                          <td>3:03 PM</td>
                          <td>$724.17</td>
                        </tr>
                        <tr>
                          <td>3323</td>
                          <td>10/21/2013</td>
                          <td>3:00 PM</td>
                          <td>$23.71</td>
                        </tr>
                        <tr>
                          <td>3322</td>
                          <td>10/21/2013</td>
                          <td>2:49 PM</td>
                          <td>$8345.23</td>
                        </tr>
                        <tr>
                          <td>3321</td>
                          <td>10/21/2013</td>
                          <td>2:23 PM</td>
                          <td>$245.12</td>
                        </tr>
                        <tr>
                          <td>3320</td>
                          <td>10/21/2013</td>
                          <td>2:15 PM</td>
                          <td>$5663.54</td>
                        </tr>
                        <tr>
                          <td>3319</td>
                          <td>10/21/2013</td>
                          <td>2:13 PM</td>
                          <td>$943.45</td>
                        </tr>
                      </tbody>
                    </table>
                  </div>
                </div>
                <div class="col-lg-8">
                  <div id="morris-bar-chart"></div>
                </div>
              </div>
            </div>
          </div>
          <div class="panel panel-default">
            <div class="panel-heading">
              <i class="fa fa-clock-o fa-fw"></i> Responsive Timeline
            </div>
            <div class="panel-body">
              <ul class="timeline">
                <li>
                  <div class="timeline-badge">
                    <i class="fa fa-check"></i>
                  </div>
                  <div class="timeline-panel">
                    <div class="timeline-heading">
                      <h4 class="timeline-title">Lorem ipsum dolor</h4>
                      <p>
                        <small class="text-muted"><i class="fa fa-clock-o"></i> 11 小时前 来自 Twitter</small>
                      </p>
                    </div>
                    <div class="timeline-body">
                      <p>
                        2月18日凌晨5点开始，Apple Pay正式进入中国市场。据银联内部人士确认，18日下午5点在银联内部发布的报告显示，Apple Pay已经绑定超过3800万张银联银行卡。据统计从2014年10月发售的iPhone 6算起，到2015年年底。大中华区共卖出8219万部iPhone 6以上的机型！
                      </p>
                    </div>
                  </div>
                </li>
                <li class="timeline-inverted">
                  <div class="timeline-badge warning">
                    <i class="fa fa-credit-card"></i>
                  </div>
                  <div class="timeline-panel">
                    <div class="timeline-heading">
                      <h4 class="timeline-title">Lorem ipsum dolor</h4>
                    </div>
                    <div class="timeline-body">
                      <p>
                        500块，现在谁挣钱容易呀，我就是这样一个节约小能手！
                      </p>
                      <p>谦哥为了500，我为了第一跑…我们必须向谦哥学习，勤俭节约！叶子说：谦儿哥就是不让我们罚500块，挣点钱咋这么难</p>
                    </div>
                  </div>
                </li>
                <li>
                  <div class="timeline-badge danger">
                    <i class="fa fa-bomb"></i>
                  </div>
                  <div class="timeline-panel">
                    <div class="timeline-heading">
                      <h4 class="timeline-title">Lorem ipsum dolor</h4>
                    </div>
                    <div class="timeline-body">
                      <p>河南省气象台2月19日06时10分发布大风蓝色预警信号：预计今天白天到夜里，焦作、济源、三门峡、洛阳、郑州、开封、许昌、漯河、平顶山、周口十地区和新乡南部、驻马店北部及巩义、汝州有4到5级西北风，局部阵风6级。请注意防范。
                      </p>
                    </div>
                  </div>
                </li>
                <li class="timeline-inverted">
                  <div class="timeline-panel">
                    <div class="timeline-heading">
                      <h4 class="timeline-title">Lorem ipsum dolor</h4>
                    </div>
                    <div class="timeline-body">
                      <p>要珍惜那种主动跟你说话，跟你聊天，给你发短信，甚至在你说了一句“嗯”之后依旧滔滔不绝的人，因为没有谁会吃饱了撑的来讨好一个自己不关心的人，不要让那些真正对你好的人，慢慢的从你的生活中消失，无论爱情还是友情，不去经营，都会形同陌路。
                      </p>
                    </div>
                  </div>
                </li>
                <li>
                  <div class="timeline-badge info">
                    <i class="fa fa-save"></i>
                  </div>
                  <div class="timeline-panel">
                    <div class="timeline-heading">
                      <h4 class="timeline-title">Lorem ipsum dolor</h4>
                    </div>
                    <div class="timeline-body">
                      <p>说一说你是如何形容卸了妆素颜的自己的。</p>
                      <hr>
                      <div class="btn-group">
                        <button type="button" class="btn btn-primary btn-sm dropdown-toggle" data-toggle="dropdown">
                          <i class="fa fa-gear"></i> <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu" role="menu">
                          <li><a href="#">Action</a></li>
                          <li><a href="#">Another action</a></li>
                          <li><a href="#">Something else here</a></li>
                          <li class="divider"></li>
                          <li><a href="#">Separated link</a></li>
                        </ul>
                      </div>
                    </div>
                  </div>
                </li>
                <li>
                  <div class="timeline-panel">
                    <div class="timeline-heading">
                      <h4 class="timeline-title">Lorem ipsum dolor</h4>
                    </div>
                    <div class="timeline-body">
                      <p>人生重要的两件事。一件是在这个世界曾经有所创造、分享、布施、给予。另一件是充分而深刻、温柔而丰盛地爱过、被爱过。</p>
                    </div>
                  </div>
                </li>
                <li class="timeline-inverted">
                  <div class="timeline-badge success">
                    <i class="fa fa-graduation-cap"></i>
                  </div>
                  <div class="timeline-panel">
                    <div class="timeline-heading">
                      <h4 class="timeline-title">Lorem ipsum dolor</h4>
                    </div>
                    <div class="timeline-body">
                      <p>人要拿得起，也要放得下。拿得起是生存，放得下是生活；拿得起是能力，放得下是智慧。有的人拿不起，也就无所谓放下；有的人拿得起，却放不下。拿不起，就会庸庸碌碌；放不下，就会疲惫不堪。人生有许多东西需要放下。只有放下那些无谓的负担，我们才能一路潇洒前行。
                      </p>
                    </div>
                  </div>
                </li>
              </ul>
            </div>
          </div>
        </div>
        <div class="col-lg-4">
          <div class="panel panel-default">
            <div class="panel-heading">
              <i class="fa fa-bell fa-fw"></i>通知面板
            </div>
            <div class="panel-body">
              <div class="list-group">
                <a href="#" class="list-group-item"> 
                  <i class="fa fa-comment fa-fw"></i> 新评论 <span class="pull-right text-muted small"><em>4分钟前</em></span>
                </a> 
                <a href="#" class="list-group-item"> 
                  <i class="fa fa-twitter fa-fw"></i> 3 个新粉丝 <span class="pull-right text-muted small"><em>12 分钟前</em> </span>
                </a> 
                <a href="#" class="list-group-item"> 
                  <i class="fa fa-envelope fa-fw"></i> 消息发送 <span class="pull-right text-muted small"><em>27分钟前</em> </span>
                </a> 
                <a href="#" class="list-group-item"> 
                  <i class="fa fa-tasks fa-fw"></i> 新任务 <span class="pull-right text-muted small"><em>43分钟前</em> </span>
                </a> 
                <a href="#" class="list-group-item"> 
                  <i class="fa fa-upload fa-fw"></i> 服务重启 <span class="pull-right text-muted small"><em>上午 11:32</em> </span>
                </a> 
                <a href="#" class="list-group-item"> 
                  <i class="fa fa-bolt fa-fw"></i> 服务宕机! <span class="pull-right text-muted small"><em>上午 11:13</em> </span>
                </a> 
                <a href="#" class="list-group-item"> 
                  <i class="fa fa-warning fa-fw"></i> 服务无应答 <span class="pull-right text-muted small"><em>上午10:57</em></span>
                </a> 
                <a href="#" class="list-group-item"> 
                  <i class="fa fa-shopping-cart fa-fw"></i> 有新的订单 <span class="pull-right text-muted small"><em>上午 9:49</em> </span>
                </a> 
                <a href="#" class="list-group-item"> 
                  <i class="fa fa-money fa-fw"></i> 付款回执 <span class="pull-right text-muted small"><em>昨天</em> </span>
                </a>
              </div>
              <a href="#" class="btn btn-default btn-block">所有通知</a>
            </div>
          </div>
          <div class="panel panel-default">
            <div class="panel-heading">
              <i class="fa fa-bar-chart-o fa-fw"></i> Donut Chart 示例
            </div>
            <div class="panel-body">
              <div id="morris-donut-chart"></div>
              <a href="#" class="btn btn-default btn-block">更多</a>
            </div>
          </div>
          
          <div class="chat-panel panel panel-default">
            <div class="panel-heading">
              <i class="fa fa-comments fa-fw"></i> 图表
              <div class="btn-group pull-right">
                <button type="button" class="btn btn-default btn-xs dropdown-toggle" data-toggle="dropdown"><i class="fa fa-chevron-down"></i></button>
                <ul class="dropdown-menu slidedown">
                  <li>
                    <a href="#"> <i class="fa fa-refresh fa-fw"></i> Refresh</a>
                  </li>
                  <li>
                    <a href="#"> <i class="fa fa-check-circle fa-fw"></i> Available</a>
                  </li>
                  <li>
                    <a href="#"> <i class="fa fa-times fa-fw"></i> Busy</a>
                  </li>
                  <li>
                    <a href="#"> <i class="fa fa-clock-o fa-fw"></i> Away</a>
                  </li>
                  <li class="divider"></li>
                  <li>
                    <a href="#"> <i class="fa fa-sign-out fa-fw"></i> Sign Out</a>
                  </li>
                </ul>
              </div>
            </div>
            <div class="panel-body">
              <ul class="chat">
                <li class="left clearfix">
                  <span class="chat-img pull-left">
                    <img src="http://placehold.it/50/55C1E7/fff" alt="User Avatar" class="img-circle" />
                  </span>
                  <div class="chat-body clearfix">
                    <div class="header">
                      <strong class="primary-font">郭德纲</strong> <small class="pull-right text-muted"> <i class="fa fa-clock-o fa-fw"></i> 12分钟前
                      </small>
                    </div>
                    <p>清者自清，不需要太多辩解。</p>
                  </div>
                </li>
                <li class="right clearfix">
                  <span class="chat-img pull-right"> 
                    <img src="http://placehold.it/50/FA6F57/fff" alt="User Avatar" class="img-circle" />
                  </span>
                  <div class="chat-body clearfix">
                    <div class="header">
                      <small class=" text-muted"><i class="fa fa-clock-o fa-fw"></i> 13分钟前</small> 
                      <strong class="pull-right primary-font">于谦</strong>
                    </div>
                    <p>同意。</p>
                  </div>
                </li>
                <li class="left clearfix">
                  <span class="chat-img pull-left"> 
                    <img src="http://placehold.it/50/55C1E7/fff" alt="User Avatar" class="img-circle" />
                  </span>
                  <div class="chat-body clearfix">
                    <div class="header">
                      <strong class="primary-font">郭德纲</strong> <small class="pull-right text-muted"> <i class="fa fa-clock-o fa-fw"></i> 14分钟前
                      </small>
                    </div>
                    <p>我的弟子没有打人。</p>
                  </div>
                </li>
                <li class="right clearfix">
                  <span class="chat-img pull-right"> 
                    <img src="http://placehold.it/50/FA6F57/fff" alt="User Avatar" class="img-circle" />
                  </span>
                  <div class="chat-body clearfix">
                    <div class="header">
                      <small class=" text-muted"><i class="fa fa-clock-o fa-fw"></i> 15分钟前</small> 
                      <strong class="pull-right primary-font">于谦</strong>
                    </div>
                    <p>德云社演员一项严于律己，从不会出现打人事件。</p>
                  </div>
                </li>
              </ul>
            </div>
            <div class="panel-footer">
              <div class="input-group">
                <input id="btn-input" type="text" class="form-control input-sm" placeholder="Type your message here..." /> 
                <span class="input-group-btn">
                  <button class="btn btn-warning btn-sm" id="btn-chat">发送</button>
                </span>
              </div>
            </div>
          </div>
          <!-- /.panel .chat-panel -->
        </div>
        <!-- /.col-lg-4 -->
      </div>
      <!-- /.row -->
    </div>
    <!-- /#page-wrapper -->
  </div>
  <!-- /#wrapper -->
</body>
</html>
