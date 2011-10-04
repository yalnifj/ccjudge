<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="cc" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="cct" uri="http://www.neumont.edu/ccjudge" %>
<%@ taglib prefix="elh" uri="http://www.neumont.edu/elhelper" %>
<cc:CCJudgeMe title="${contest.name} Scoreboard">
<script type="text/javascript">
<!--
window.setInterval("window.location.reload()", 30000);

var tips = new Array();
tips['score'] = "Total number of minutes (including penalties) required to solve this problem.";
tips['subcount'] = "Total number of attempted submissions for this problem.";
tips['totaltime'] = "The total number of minutes (including penalties) required to solve the correct submissions.";
tips['totalsolved'] = "The total number of correctly solved problems.";

function hideDialog() {
	 $("#congrats").close();
}

$(document).ready(function(){
  $(".score, .subcount, .totaltime, .totalsolved").hover(function(e){
	$("body").append("<p id='tooltip' class='tooltip'>"+tips[this.className]+"</p>");
	$("#tooltip")
	   .css("top",(e.pageY - 20) + "px")
	   .css("left",(e.pageX + 20) + "px")
	   .fadeIn("fast");
	 },
	 function(){
	   $("#tooltip").remove();
	 });
	 
	 $(".score, .subcount, .totaltime, .totalsolved").mousemove(function(e){
	   $("#tooltip")
	   .css("top",(e.pageY - 20) + "px")
	   .css("left",(e.pageX + 20) + "px");
	 });

	 $("#congrats").dialog({
			bgiframe: true,
			height: 500,
			width: 500,
			modal: true
	 });
	 window.setTimeout("hideDialog", 30000);
 });

//-->
</script>
<style type="text/css">
.subcount {
  color: black;
}
.teamlink {
  color: black;
}
#congrats {
	display: none;
}
.teamname:hover .teammembers {
	display: block;
}
</style>
<h2>${contest.name} Scoreboard</h2>
<c:if test="${elh:collectionSize(recentPasses)>0}">
<div id="congrats" title="Congratulations">
<img src="${baseURL}/images/congratulations.gif" /><br />
<c:forEach items="${recentPasses}" var="sub">
<strong>${sub.team.name}</strong> passed <strong>${sub.problem.name}</strong><br />
</c:forEach>
</div>
</c:if>
<c:if test="${limitDates}"><a href="${baseURL}/scoreboard?contestId=${contest.id}&limitDates=false">Include submissions after contest deadline</a></c:if>
<c:if test="${!limitDates}"><a href="${baseURL}/scoreboard?contestId=${contest.id}&limitDates=true">Don't include submissions after contest deadline</a></c:if>
<table id="scoreboardtable" border="1">
<tr>
	<th>Rank</th>
	<th>Team</th>
	<c:forEach items="${contest.problems}" var="problem" varStatus="counter">
	<th><a href="${baseURL}/home/problem?id=${problem.id}">${problem.shortName}</a> (${counter.count})</th>
	</c:forEach>
	<th>Total</th>
</tr>
<c:forEach items="${teams}" var="team" varStatus="counter">
	<tr>
		<td>${counter.count}</td>
		<td><span class="teamname"><c:if test="${adminuser}"><a class="teamlink" href="${baseURL}/team/view?id=${team.id}">${team.name}</a></c:if>
		<c:if test="${!adminuser}">${team.name}</c:if>
		<div class="teammembers tooltip">
		<c:forEach items="${team.members}" var="member">
			${member.member.name}<br />
		</c:forEach>
		</div></span></td>
		<c:forEach items="${contest.problems}" var="problem">
			<td>
			<cct:SubmissionStatus team="${team}" problem="${problem}" contest="${contest}">
				<c:if test="${not empty submission}">
					<span class="score">${submission.scoreHour}:${submission.scoreMin}</span> 
					<c:if test="${adminuser}"><a href="${baseURL}/submission/list?team=${team.id}&problem=${submission.problem.id}" class="subcount">(${count})</a></c:if>
					<c:if test="${!adminuser}"><span class="subcount">(${count})</span></c:if>
				</c:if>
				<c:if test="${empty submission}">
					&nbsp;
				</c:if>
			</cct:SubmissionStatus>
			</td>
		</c:forEach>
		<td><span class="totaltime">${teamScores[team.id]}</span> <span class="totalsolved">(${teamPassed[team.id]})</span></td>
	</tr>
</c:forEach>
</table>
</cc:CCJudgeMe>