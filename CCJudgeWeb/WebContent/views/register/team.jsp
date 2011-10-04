<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="cc" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="elh" uri="http://www.neumont.edu/elhelper" %>
<cc:CCJudgeMe title="Register Your Team : Team information">
<h1 id="pagetitle">Register Your Team</h1>
<form method="post" action="${baseURL}/register/team">
<input type="hidden" name="contest_id" value="${contest.id}"/>
<span class="error">${error}</span>
<c:if test="${elh:collectionSize(member.teams)>0}">
<script type="text/javascript">
<!--
var teams = new Array();
<c:forEach items="${member.teams}" var="role">
teams[${role.team.id}] = new Array();
<c:forEach items="${role.team.members}" var="member" varStatus="loop">
teams[${role.team.id}][${loop.index}] = '${member.member.name}'; 
</c:forEach>
</c:forEach>

function showMembers(sel) {
	var team = sel.options[sel.selectedIndex].value;
	if (team) {
		var temp = teams[team];
		var teamdiv = document.getElementById('teammembers');
		teamdiv.innerHTML = '';
		for(var i=0; i<temp.length; i++) {
			teamdiv.innerHTML += temp[i]+"<br />\n";
		}
	}
}
//-->
</script>
<br />
Register one of your existing teams:<br />
<select name="team_id" onchange="showMembers(this);">
	<option value=""></option>
<c:forEach items="${member.teams}" var="role">
	<option value="${role.team.id}">${role.team.name}</option>
</c:forEach>
</select>
<div id="teammembers">
</div>
</c:if>
<br /><br />
or create a new team:<br />
<table>
	<tr>
		<td>Team Name:</td>
		<td><input type="text" name="name" value="${team.name}" /></td>
	</tr>
	<tr>
		<td colspan="2">
			Enter the usernames of the other teammates you would like to have on your team.
		</td>
	</tr>
	<c:forEach begin="1" end="${contest.membersPerTeam-1}" step="1" var="i">
	<tr>
		<td>Username ${i}:</td>
		<td><input type="text" name="username" /></td>
	</tr>
	</c:forEach>
</table>
<br />
<input type="submit" value="Continue" />
</form>
</cc:CCJudgeMe>