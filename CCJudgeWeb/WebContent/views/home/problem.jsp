<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="cc" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="elh" uri="http://www.neumont.edu/elhelper" %>
<%@ taglib prefix="cct" uri="http://www.neumont.edu/ccjudge" %>
<cc:CCJudgeMe title="Problem Details for ${problem.shortName}">
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
<h2>${problem.name}</h2>

<c:if test="${not empty team}">
<c:if test="${elh:collectionSize(submissions) > 0 }">
<table border="1">
	<tr><th>Id</th><th>File</th><th>Submission Time</th><th>Judge Time</th><th>Passed</th><th>Score</th><th>Code</th></tr>
	<c:forEach items="${submissions}" var="submission">
	<tr>
		<td>${submission.id }</td>
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
			${submission.status}<br />
			<c:if test="${adminuser or elh:compareDates(contest.endTime, elh:now()) lt 0}">
				${submission.results}
			</c:if>
			</div>
			</td>
		<td>${submission.score}</td>
		<td><a href="#" onclick="toggleResults('code${submission.id}'); return false;">View Code</a>
			<div id="code${submission.id}" class="expandable" style="display:none;">
				<pre>${elh:htmlentities(submission.fileContents)}</pre>
			</div></td>
	</tr>
	</c:forEach>
</table>
</c:if>
<c:if test="${member.id gt 0 && empty passed or adminuser}">
<form method="post" action="${baseURL}/home/submit" enctype="multipart/form-data">
	<input type="hidden" name="problemId" value="${problem.id}" />
	Upload Submission:<br />
	<input type="file" name="sourceFile" size="55" /><br />
	Double check that you are submitting the correct file name and that you are 
	reading and writing the correct filenames.
	<br />
	<input type="submit" value="Upload" />
</form>
</c:if>
</c:if>
<br /><hr /><br />

<div class="description">
${problem.description}
</div>

<c:if test="${member.id gt 0 and elh:compareDates(contest.endTime, elh:now()) lt 0}">
<h3>Actual Test Input</h3>
<pre>
${problem.input}
</pre>
<h3>Expected Test Output</h3>
<pre>
${problem.output}
</pre>
</c:if>

</cc:CCJudgeMe>