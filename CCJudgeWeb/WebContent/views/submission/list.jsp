<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="cc" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="elh" uri="http://www.neumont.edu/elhelper" %>
<%@ taglib prefix="ccj" uri="http://www.neumont.edu/ccjudge" %>
<cc:CCJudge title="Problem List">
<script language="JavaScript" type="text/javascript">
<!--
function toggleResults(elementId) {
	var element = document.getElementById(elementId);
	if (element.style.display=='none') {
		element.style.display = 'block';
	}
	else {
		element.style.display = 'none';
	}
}
//-->
</script>
<h2>Submission List <c:if test="${team != null }"> for Team ${team.name}</c:if><c:if test="${problem != null }"> for Problem ${problem.name}</c:if></h2>
<form name="filterform" method="get" action="${baseURL}/submission/list">
Filter by problem:
<select name="problem" onchange="document.filterform.submit();">
	<option value="0">All problems</option>
<c:forEach var="prob" items="${contest.problems}">
	<option value="${prob.id}" ${problem.id eq prob.id ? 'selected="selected"':'' }>${prob.shortName}</option>
</c:forEach>
</select> 
Filter by team:
<select name="team" onchange="document.filterform.submit();">
	<option value="0">All teams</option>
<c:forEach var="te" items="${contest.teams}">
	<option value="${te.id}" ${team.id eq te.id ? 'selected="selected"':'' }>${te.name}</option>
</c:forEach>
</select>
</form>
<table border="1">
	<tr><th>Id</th><th>Team</th><th>Problem</th><th>File</th><th>Submission Time</th><th>Judge Time</th><th>Passed</th><th>Score</th><th>Code</th><th></th></tr>
	<c:forEach items="${submissions}" var="submission">
	<tr>
		<td>${submission.id }</td>
		<td>${submission.team.name }</td>
		<td>${submission.problem.shortName }</td>
		<td>${submission.fileName}</td>
		<td>${submission.submissionTime}</td>
		<td>${submission.judgeTime }</td>
		<td><c:if test="${submission.passed}">
				<span class="passed">Passed</span>
				<c:set var="passed" value="true"></c:set>
			</c:if>
			<c:if test="${not submission.passed}">
				<span class="notpassed">Not Passed</span>
			</c:if>
			<br />
			<a href="#" onclick="toggleResults('results${submission.id}'); return false;">Results</a>
			<div id="results${submission.id}" class="expandable" style="display:none;">
			${submission.status}
			<c:if test="${not empty submission.results}">
				${submission.results}
			</c:if>
			</div>
			<c:if test="${not empty submission.output}">
			<a href="#" onclick="toggleResults('output${submission.id}'); return false;">Output</a>
			<div id="output${submission.id}" class="expandable" style="display:none;">
				<pre>${submission.output}</pre>
				<hr /><br />
				<h4>Diff Output</h4>
				<ccj:Diff submission="${submission}"/>
			</div>
			</c:if>
			</td>
		<td>${submission.score}</td>
		<td><a href="#" onclick="toggleResults('code${submission.id}'); return false;">View Code</a>
			<div id="code${submission.id}" class="expandable" style="display:none;">
				<pre>${elh:htmlentities(submission.fileContents)}</pre>
			</div></td>
		<td>
		<a href="${baseURL}/submission/regrade?id=${submission.id}&amp;team=${team.id}&amp;problem=${problem.id}"><img src="${baseURL}/images/scoreboard.png" width="16" border="0" alt="regrade" title="regrade" onclick="return confirm('Are you sure you want to regrade this submission?');"/></a>
		<a href="${baseURL}/submission/edit?id=${submission.id}&amp;team=${team.id}&amp;problem=${problem.id}"><img src="${baseURL}/images/edit.png" border="0" alt="edit" title="edit"/></a>
		<a href="${baseURL}/submission/delete?id=${submission.id}&amp;team=${team.id}&amp;problem=${problem.id}"><img src="${baseURL}/images/delete.png" border="0" alt="delete" title="delete" onclick="return confirm('Are you sure you want to delete this submission?');"/></a>
		</td>
	</tr>
	</c:forEach>
</table>
<a href="${baseURL}/submission/regradeAll?team=${team.id}&amp;problem=${problem.id}" onclick="return confirm('Are you sure you want to regrade all of these submission?');"><img src="${baseURL}/images/scoreboard.png" border="0" alt="regrade" title="regrade"/> Regrade all of these submissions</a>
</cc:CCJudge>