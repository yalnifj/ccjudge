<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="cc" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<cc:CCJudge title="Team Information">
<h2>${team.name}</h2>
<table>
	<tr><td>ID</td><td>${team.id} 
		<a href="${baseURL}/team/edit?id=${team.id}"><img src="${baseURL}/images/edit.png" border="0" alt="edit" title="edit"/></a>
		<a href="${baseURL}/team/deleteProcess?option=2&amp;id=${team.id}"><img src="${baseURL}/images/delete.png" border="0" alt="delete" title="delete" onclick="return confirm('Are you sure you want to delete this team?');"/></a>
	</td></tr>
	<tr><td>Name</td><td>${team.name}</td></tr>
	<tr><td>Contest</td><td>
		<cc:contestList contests="${team.contests}"></cc:contestList>
	</td></tr>
	<tr><td>Members</td><td>
		<cc:teamMembers team="${team}" edit="true"></cc:teamMembers>
	</td></tr>
	<tr><td colspan="2"><a href="${baseURL}/submission/list?team=${team.id}">View Submissions</a></td></tr>
</table>
</cc:CCJudge>