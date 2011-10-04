<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="cc" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<cc:CCJudge title="Problem List">
<h2>Problem List <c:if test="${contest != null }"> for Contest ${contest.name}</c:if></h2>
<table border="1" cellpadding="2">
	<tr><th>Short Name</th><th>Name</th><th>Contests</th><th></th></tr>
	<c:forEach items="${list}" var="problem">
		<tr>
		<td><a href="${baseURL}/problem/view?id=${problem.id}">${problem.shortName}</a></td>
		<td><a href="${baseURL}/problem/view?id=${problem.id}">${problem.name}</a></td>
		<td>
			<cc:contestList contests="${problem.contests}"></cc:contestList>
		</td>
		<td><a href="${baseURL}/problem/edit?id=${problem.id}"><img src="${baseURL}/images/edit.png" border="0" alt="edit" title="edit"/></a>
		<a href="${baseURL}/problem/delete?id=${problem.id}"><img src="${baseURL}/images/delete.png" border="0" alt="delete" title="delete" onclick="return confirm('Are you sure you want to delete this problem');"/></a>
		</td>
		</tr>
	</c:forEach>
</table>
<a href="${baseURL}/problem/edit"><img src="${baseURL}/images/add_problem.png" border="0" alt="add" title="add"/>Add new problem</a>
</cc:CCJudge>