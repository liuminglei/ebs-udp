<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

</head>

<body>
  <div class="container">
    <div class="row">
      <div class="col-md-4 col-md-offset-4">
        <div class="login-panel panel panel-default">
          <div class="panel-heading">
            <h3 class="panel-title">请登录</h3>
          </div>
          <div class="panel-body">
            <form role="form" action="j_spring_security_check" method="POST">
              <fieldset>
                <div class="form-group">
                  <input class="form-control" placeholder="E-mail" id="j_username" name="j_username" type="text" autofocus />
                </div>
                <div class="form-group">
                  <input class="form-control" placeholder="Password" id="j_password" name="j_password" type="password" value="" />
                </div>
                <div class="pull-left">
                  <label><input type="checkbox" name="remember" value="" class="i-check">记住我</label>
                </div>
                <button type="submit" class="btn btn-success btn-block" data-loading-text="登录中...">登录</button>
              </fieldset>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
</html>
