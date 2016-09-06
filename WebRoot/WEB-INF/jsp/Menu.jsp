<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="navbar-default sidebar" role="navigation">
  <div class="sidebar-nav navbar-collapse">
    <ul class="nav" id="side-menu">
      <li class="sidebar-search">
        <div class="input-group custom-search-form">
          <input type="text" class="form-control" placeholder="搜索..." /> 
          <span class="input-group-btn">
            <button class="btn btn-default" type="button"><i class="fa fa-search"></i></button>
          </span>
        </div> 
      </li>
      <li><a href="index.html"><i class="fa fa-dashboard fa-fw"></i> 首页</a></li>
      <!-- 循环第一级菜单 -->
      <c:forEach items="${listXtgn}" var="curXt">
        <li>
          <a href="#"><i class="fa fa-sitemap fa-fw"></i>${curXt.jdmc}<span class="fa arrow"></span></a>
          <c:forEach items="${curXt.mkList}" var="curMk">
            <ul class="nav nav-second-level">
              <li>
                <a href="#">${curMk.jdmc}<span class="fa arrow"></span></a>
                <c:forEach items="${curMk.gnList}" var="curGn">
                  <ul class="nav nav-third-level">
                    <li><a href="${pageContext.request.contextPath}/${curGn.gndz}" target="MainWorkArea">${curGn.jdmc}</a></li>
                  </ul>
                </c:forEach>
              </li>
            </ul>
          </c:forEach>
        </li>
      </c:forEach>
    </ul>
  </div>
  <!-- /.sidebar-collapse -->
</div>