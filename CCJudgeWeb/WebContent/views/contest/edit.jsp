<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="edu.neumont.ccjudge.model.JudgeType" %>
<%@ taglib prefix="cc" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<cc:CCJudge title="Contest Information">
<script type="text/javascript" charset="utf-8" src="${baseURL}/js/tinymce/jscripts/tiny_mce/tiny_mce.js"></script>
<script type="text/javascript" charset="utf-8" src="${baseURL}/js/ccjudge.js"></script>
<script type="text/javascript" charset="utf-8">
	tinyMCE.init(tiny_mce_config);
	tinyMCE.execCommand("mceAddControl", true, "description");
</script>
<h2>Edit ${contest.name}</h2>
<form method="post" action="${baseURL}/contest/update">
<table>
	<tr><td>ID</td><td><input type="hidden" name="id" value="${contest.id}"/>${contest.id}
	<c:if test="${contest.id gt 0}">
	<a href="${baseURL}/contest/delete?id=${contest.id}"><img src="${baseURL}/images/delete.png" border="0" alt="delete" title="delete" onclick="return confirm('Are you sure you want to delete this contest?');"/></a>
	</c:if>
	</td></tr>
	<tr><td>Name</td><td><input type="text" name="name" value="${contest.name}" size="40" /></td></tr>
	<tr><td>Description</td><td><textarea name="description" id="description" rows="5" cols="40">${contest.description}</textarea></td></tr>
	<tr><td>Max Members Per Team</td><td><input type="text" name="membersPerTeam" value="${contest.membersPerTeam}" /></td></tr>
	<tr><td>Start Time</td><td>
	<cc:dateSelector name="startTime" date="${contest.startTime}"></cc:dateSelector> at
	<cc:timeSelector name="startTime" date="${contest.startTime}"></cc:timeSelector>
	</td></tr>
	<tr><td>End Time</td><td>
	<cc:dateSelector name="endTime" date="${contest.endTime}"></cc:dateSelector> at
	<cc:timeSelector name="endTime" date="${contest.endTime}"></cc:timeSelector>
	</td></tr>
	<tr><td>Judge Input Type</td><td><select name="judgeType"><option value="0" ${contest.judgeType==JudgeType.FILEIO ? 'selected="selected"':''}>File I/O</option><option value="1" ${contest.judgeType==JudgeType.CONSOLEIO ? 'selected="selected"':''}>Console I/O</option></select></td></tr>
	<tr><td>Teams can self register:</td><td><input type="checkbox" name="canRegister" ${contest.canRegister?'checked="checked"':'' } value="true" /></td></tr>
</table>
<input type="submit" value="Save" />  <input type="button" value="Cancel" onclick="window.location='${baseURL}/contest/view?id=${contest.id}';" />
</form>
</cc:CCJudge>