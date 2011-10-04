<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="cc" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form method="post" action="${baseURL}/team/deleteProcess" style="margin:10px;">
<input type="hidden" name="id" value="${team.id}" />
<c:choose>
	<c:when test="${contest != null}">
		<input type="hidden" name="contest" value="${contest.id}" />
		<input type="radio" name="option" id="option1" value="1" />
		<label for="option1">Remove team from this contest</label><br />
	</c:when>
	<c:otherwise>
		<input type="hidden" name="contest" value="0" />
	</c:otherwise>
</c:choose>

<input type="radio" name="option" id="option2" value="2" />
<label for="option2">Delete the team</label><br />
<input type="radio" name="option" id="option3" value="3" />
<label for="option3">Delete the team and the members</label><br /><br />
<div style="text-align:center;">
	<input type="submit" value="Confirm Deletion" />
	<input type="button" value="Cancel" onclick="hide()" />
</div>
</form>