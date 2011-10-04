<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="cc" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<cc:CCJudge title="Contest List">
<h2>Contest List</h2>
<table border="1" cellpadding="2">
	<tr><th>Contest</th><th>Time</th><th>Teams</th><th>Problems</th><th></th></tr>
	<c:forEach items="${list}" var="contest">
		<tr>
		<td><a href="${baseURL}/contest/view?id=${contest.id}">${contest.name}</a></td>
		<td>${contest.startTime} - ${contest.endTime}</td>
		<td><a href="${baseURL}/team/list?contest=${contest.id}">Teams</a></td>
		<td><a href="${baseURL}/problem/list?contest=${contest.id}">Problems</a></td>
		<td>
		<a href="${baseURL }/scoreboard?contestId=${contest.id}"><img src="${baseURL}/images/scoreboard.png" border="0" height="16" alt="Scoreboard" /></a>
		<a href="${baseURL}/contest/edit?id=${contest.id}"><img src="${baseURL}/images/edit.png" border="0" alt="edit" title="edit"/></a>
		<a href="${baseURL}/contest/delete?id=${contest.id}"><img src="${baseURL}/images/delete.png" border="0" alt="delete" title="delete" onclick="return confirm('Are you sure you want to delete this contest?');"/></a>
		</td>
		</tr>
	</c:forEach>
</table>
<a href="${baseURL}/contest/edit"><img src="${baseURL}/images/add_contest.png" border="0" alt="add" title="add"/>Add new contest</a>
</cc:CCJudge>