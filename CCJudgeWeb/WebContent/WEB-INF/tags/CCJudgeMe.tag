<%@ attribute name="title" required="false" rtexprvalue="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${baseURL}/style.css" type="text/css" media="all" />
<link rel="stylesheet" href="${baseURL}/js/css/ui-darkness/jquery-ui-1.7.2.custom.css" type="text/css" media="all" />
<script type="text/javascript" src="${baseURL}/js/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="${baseURL}/js/jquery-ui-1.7.2.custom.min.js"></script>
<title>Neumont Coding Contest Judging System - ${title}</title>
</head>
<body>
<div id="header">
<ul class="navtop">
		<li class="has_navchild"><a href="${baseURL }/home"><img src="${baseURL}/images/team.png" border="0" height="32" />Home</a></li>
		<c:if test="${not empty sessionScope.contest}"><li class="has_navchild"><a href="${baseURL }/home/problems"><img src="${baseURL}/images/problem.png" border="0" height="32" />Problems</a></li>
		<li class="has_navchild"><a href="${baseURL }/scoreboard"><img src="${baseURL}/images/scoreboard.png" border="0" height="32" />Scoreboard</a></li></c:if>
		<%-- <li class="has_navchild"><a href="${baseURL }/profile"><img src="${baseURL}/images/teammember.png" border="0" height="32" />Profile</a></li> --%>
		<li class="has_navchild"><a href="${baseURL }/home/help" target="_blank"><img src="${baseURL}/images/help.png" border="0" height="32" />Help</a></li>
		<c:if test="${adminuser}"><li class="has_navchild"><a href="${baseURL }/contest"><img src="${baseURL}/images/admin.png" border="0" height="32" />Admin</a></li></c:if>
		<c:if test="${not empty member and not empty member.username}">
			<li class="has_navchild"><a href="${baseURL }/register/register"><img src="${baseURL}/images/exit.png" border="0" height="32" alt="Register for another contest" title="Register your team" />Register</a>
			<li class="has_navchild"><a href="${baseURL }/logout"><img src="${baseURL}/images/exit.png" border="0" height="32" />Logout</a></li>
		</c:if>
		<c:if test="${not empty member and empty member.username}">
			<li class="has_navchild"><a href="${baseURL }/login"><img src="${baseURL}/images/exit.png" border="0" height="32" />Login</a></li>
			<li class="has_navchild"><a href="${baseURL }/register"><img src="${baseURL}/images/exit.png" border="0" height="32" alt="Register your team" title="Register your team" />Register</a></li>
		</c:if>
</ul>
</div>
<div id="content">
	<div id="mainBody">
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