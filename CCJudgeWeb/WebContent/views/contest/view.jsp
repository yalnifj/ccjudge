<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="cc" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<cc:CCJudge title="Contest Information">
<h2>${contest.name}</h2>
<table>
	<tr><td>ID</td><td>${contest.id} 
		<a href="${baseURL}/contest/edit?id=${contest.id}"><img src="${baseURL}/images/edit.png" border="0" alt="edit" title="edit"/></a>
		<a href="${baseURL}/contest/delete?id=${contest.id}"><img src="${baseURL}/images/delete.png" border="0" alt="delete" title="delete" onclick="return confirm('Are you sure you want to delete this contest?');"/></a>
	</td></tr>
	<tr><td>Name</td><td>${contest.name}</td></tr>
	<tr><td>Max Members Per Team</td><td>${contest.membersPerTeam}</td></tr>
	<tr><td>Start Time</td><td>${contest.startTime}</td></tr>
	<tr><td>End Time</td><td>${contest.endTime}</td></tr>
	<tr><td>Judge Input Type</td><td>${contest.judgeType}</td></tr>
	<tr><td>Teams can self register</td><td>${contest.canRegister}</td></tr>
	<tr><td colspan="2"><a href="${baseURL}/team/list?contest=${contest.id}">View Teams</a></td></tr>
	<tr><td colspan="2"><a href="${baseURL}/problem/list?contest=${contest.id}">View Problems</a></td></tr>
</table>
</cc:CCJudge>