<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="cc" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="elh" uri="http://www.neumont.edu/elhelper" %>
<cc:CCJudgeMe title="My Home Page">
<h1 id="pagetitle">${member.name} Home</h1>
<h2>Contests</h2>
<c:forEach items="${member.teams}" var="role">
	<c:forEach items="${adminuser?role.team.contests:role.team.activeContests}" var="contest">
		<a href="${baseURL}/home/problems?contest=${contest.id}&amp;team=${role.team.id}">
			<img src="${baseURL}/images/contest.png" border="0" height="16" border="0" />
			<span class="${elh:compareDates(contest.endTime, elh:now())>0?'active':'inactive'}">${contest.name}</span> - ${role.team.name}
		</a><br />
		<span class="smalltime">End Time: ${contest.endTime}</span>
		<div class="indent">
			<c:forEach items="${role.team.members}" var="teamMemberRole">
				${teamMemberRole.role} - ${teamMemberRole.member.name}<br />
			</c:forEach>
		</div>
		<br />
	</c:forEach>
	<c:forEach items="${adminuser?'':role.team.inActiveContests}" var="contest">
			<img src="${baseURL}/images/contest.png" border="0" height="16" border="0" />
			<span class="${elh:compareDates(contest.endTime, elh:now())>0?'active':'inactive'}">${contest.name}</span> - ${role.team.name}
		<br />
		<span class="smalltime">Start Time: ${contest.startTime} <br />
			End Time: ${contest.endTime}</span>
		<div class="indent">
			<c:forEach items="${role.team.members}" var="teamMemberRole">
				${teamMemberRole.role} - ${teamMemberRole.member.name}<br />
			</c:forEach>
		</div>
		<br />
	</c:forEach>
</c:forEach>
</cc:CCJudgeMe>