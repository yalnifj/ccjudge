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
<br />
</div>
<div id="content">
	<div id="mainBody">
	<jsp:doBody />
	</div>
</div>
<div id="footer">
&copy; 2009 Neumont University. All rights reserved.<br />
Developed By <a href="http://www.neumont.edu/education/learnfromthebest/faculty/john_finlay.html" target="_blank">John Finlay</a>
<br /><br />
SOUTH JORDAN CAMPUS -- 10701 SOUTH RIVER FRONT PARKWAY, SUITE 300, SOUTH JORDAN, UT 84095
</div>
</body>
</html>