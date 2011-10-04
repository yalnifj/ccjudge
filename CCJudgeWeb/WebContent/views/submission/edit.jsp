<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="cc" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="elh" uri="http://www.neumont.edu/elhelper" %>

<cc:CCJudge title="Edit Submission">
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
<h2>Edit Submission ${submission.id} MOOO!</h2>
<form method="post" action="${baseURL}/submission/update">
<table>
	<tr><td>ID</td><td><input type="hidden" name="id" value="${submission.id}"/>${submission.id}
	<c:if test="${submission.id gt 0}">
	<a href="${baseURL}/submission/delete?id=${submission.id}"><img src="${baseURL}/images/delete.png" border="0" alt="delete" title="delete" onclick="return confirm('Are you sure you want to delete this submission?');"/></a>
	</c:if>
	</td></tr>
	<tr><td>Team</td><td>${submission.team.name} (${submission.team.id})</td></tr>
	<tr><td>Problem</td><td>${submission.problem.name} (${submission.problem.shortName})</td></tr>
	<tr><td>Contest</td><td>${submission.contest.name} (${submission.contest.id})</td></tr>
	
	<tr><td>Submission Time</td>
	<td>
		<cc:dateSelector name="submissionTime" date="${submission.submissionTime}"></cc:dateSelector> at
		<cc:timeSelector name="submissionTime" date="${submission.submissionTime}"></cc:timeSelector>
	</td></tr>
	
	<tr><td>Judge Time</td><td>
		<cc:dateSelector name="judgeTime" date="${submission.judgeTime}"></cc:dateSelector> at
		<cc:timeSelector name="judgeTime" date="${submission.judgeTime}"></cc:timeSelector>
	</td></tr>
	
	<tr><td>Passed</td><td><input type="checkbox" name="passed" value="true" ${submission.passed eq true ? 'checked="checked"':''}/></td></tr>
	<tr><td>Filename</td><td><input type="text" name="fileName" value="${submission.fileName}" /></td></tr>
	<tr><td>Score</td><td><input type="text" name="score" value="${submission.score}" /></td></tr>
	<tr><td>FileContents</td>
		<td><textarea name="fileContents" rows="20" cols="100">${elh:htmlentities(submission.fileContents)}</textarea>
		</td></tr>
	<tr><td>Output</td>
		<td><textarea name="output" rows="20" cols="100">${submission.output}</textarea>
		<a href="#" onclick="toggleResults('output${submission.id}'); return false;">Side-By-Side Output</a>
			<div id="output${submission.id}" class="expandable" style="display:none;">
			<table><tr><td><pre>${submission.output}</pre></td><td><pre>${submission.problem.output}</pre></td></tr></table>
			</div>
		</td></tr>
	<tr><td>Status</td>
		<td><textarea name="status" rows="20" cols="100">${elh:htmlentities(submission.status)}</textarea>
		</td></tr>
	<tr><td>Results</td>
		<td><textarea name="results" rows="20" cols="100">${elh:htmlentities(submission.results)}</textarea>
		</td></tr>
</table>
<input type="submit" value="Save" /> <input type="button" value="Cancel" onclick="window.location='${baseURL}/submission/list';" />
</form>
</cc:CCJudge>