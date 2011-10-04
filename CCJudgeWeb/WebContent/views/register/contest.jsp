<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="cc" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="elh" uri="http://www.neumont.edu/elhelper"%>
<cc:CCJudgeMe title="Register Your Team">
	<h1 id="pagetitle">Register Your Team : Choose a contest</h1>
	<span class="error">${error}</span><br />
	<c:choose>
		<c:when test="${elh:collectionSize(contests)>0}">
Which contest would you like the register for?<br /><br />
			<c:forEach var="contest" items="${contests}">
				<a href="${baseURL}/register/contest?contest_id=${contest.id}">${contest.name}</a>
				<br />
					${contest.description}
					<br /><br />
				</c:forEach>
			<br />
		</c:when>
		<c:otherwise>
	Sorry.  There are no upcoming contests for which you may register.<br />
	Please try again later.
		</c:otherwise>
	</c:choose>
</cc:CCJudgeMe>