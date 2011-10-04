<%@ attribute name="title" required="false" rtexprvalue="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${baseURL}/style.css" type="text/css" media="all" />
<script type="text/javascript" src="${baseURL}/js/jquery-1.3.2.min.js"></script>
<title>Neumont Coding Contest Judging System - ${title}</title>
</head>
<body>
<div id="header">
<ul class="navtop">
		<li class="has_navchild"><a href="${baseURL }/home"><img src="${baseURL}/images/team.png" border="0" height="32" />Home</a></li>
		<li class="has_navchild"><a href="${baseURL }/contest/list"><img src="${baseURL}/images/contest.png" border="0" height="32" />Contests</a></li>
		<li class="has_navchild"><a href="${baseURL }/team/list"><img src="${baseURL}/images/team.png" border="0" height="32" />Teams</a></li>
		<li class="has_navchild"><a href="${baseURL }/user/list"><img src="${baseURL}/images/team.png" border="0" height="32" />Users</a></li>
		<li class="has_navchild"><a href="${baseURL }/problem/list"><img src="${baseURL}/images/problem.png" border="0" height="32" />Problems</a></li>
		<li class="has_navchild"><a href="${baseURL }/resource/list"  onclick="window.open(this.href, '', 'toolbar=0,resizable=1,scrollbars=1,width=600,height=500'); return false;"><img src="${baseURL}/images/problem.png" border="0" height="32" />Resources</a></li>
		<c:if test="${not empty member}"><li class="has_navchild"><a href="${baseURL }/logout"><img src="${baseURL}/images/exit.png" border="0" height="32" />Logout</a></li></c:if>
</ul>
</div>
<div id="content">
	<div id="mainBody">
	<h1 id="pagetitle">Administration</h1>
	<jsp:doBody />
	</div>
	<div id="altcontainer">
		<div id="logo">
			<a id="homeLink" href="http://www.neumont.edu/index.html" target="_blank"></a>
		</div>
	</div>
</div>
<div id="footer">
&copy; 2009 Neumont University. All rights reserved.<br />
Developed By <a href="http://www.neumont.edu/aboutus/faculty/john_finlay.html" target="_blank">John Finlay</a>
<br /><br />
SOUTH JORDAN CAMPUS -- 10701 SOUTH RIVER FRONT PARKWAY, SUITE 300, SOUTH JORDAN, UT 84095
</div>
</body>
</html>