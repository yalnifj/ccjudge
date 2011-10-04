<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="cc" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="elh" uri="http://www.neumont.edu/elhelper" %>

<cc:CCJudge title="Edit Team Information">
<h2>Edit ${team.name}</h2>
<form method="post" action="${baseURL}/team/update">
<table>
	<tr><td>ID</td><td><input type="hidden" name="id" value="${team.id}"/>${team.id}
	<c:if test="${team.id gt 0}">
	<a href="${baseURL}/team/deleteProcess?option=2&amp;id=${team.id}"><img src="${baseURL}/images/delete.png" border="0" alt="delete" title="delete" onclick="return confirm('Are you sure you want to delete this team?');"/></a>
	</c:if>
	</td></tr>
	<tr><td>Name</td><td><input type="text" name="name" value="${team.name}" size="40" /></td></tr>
	<tr><td>Contest</td><td>
		<select name="contest" size="5" multiple="multiple">
			<c:forEach items="${contests}" var="contest">
				<option value="${contest.id}" ${elh:listContains(team.contests, contest) ? 'selected="selected"':'' }">${contest.name}</option>
			</c:forEach>
		</select>
	</td></tr>
	<tr><td>Members</td><td>
		<cc:teamMembers team="${team}" edit="${team.id gt 0}"></cc:teamMembers>
	</td></tr>
</table>
<input type="submit" value="Save" /> <input type="button" value="Cancel" onclick="window.location='${baseURL}/team/view?id=${team.id}';" />
</form>
</cc:CCJudge>