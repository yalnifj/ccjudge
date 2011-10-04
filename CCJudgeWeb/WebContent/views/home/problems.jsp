<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="cc" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="elh" uri="http://www.neumont.edu/elhelper" %>
<%@ taglib prefix="cct" uri="http://www.neumont.edu/ccjudge" %>
<cc:CCJudgeMe title="My Problems">
<h2>Problem List <c:if test="${contest != null }"> for Contest ${contest.name}</c:if></h2>
<table border="1" cellpadding="2">
	<tr><th>Short Name</th><th>Name</th><th>Status</th><th>Score</th></tr>
	<c:forEach items="${contest.problems}" var="problem">
		<tr>
		<td><a href="${baseURL}/home/problem?id=${problem.id}">${problem.shortName}</a></td>
		<td><a href="${baseURL}/home/problem?id=${problem.id}">${problem.name}</a></td>
			<cct:SubmissionStatus team="${team}" problem="${problem}" contest="${contest}">
				<c:if test="${not empty submission}">
					<td>
					<c:if test="${submission.passed}">
						<span class="passed">Passed</span><br />
					</c:if>
					<span class="smalltime">Submission time: ${submission.submissionTime }</span><br />
					<span class="smalltime" onmouseover="$('#results${problem.id}).show('fast');" onmouseout="$('#results${problem.id}).hide('fast');">Judge time: ${submission.judgeTime }</span>
						<div id="results${problem.id}" class="hiddenpopup">
							${submission.results}
						</div>
					<br />
					</td>
					<td>${submission.score}</td>
				</c:if>
				<c:if test="${empty submission}">
					<td>
					<span class="notsubmitted">Not Submitted</span>
					</td>
					<td></td>
				</c:if>
			</cct:SubmissionStatus>
		</tr>
	</c:forEach>
</table>
</cc:CCJudgeMe>