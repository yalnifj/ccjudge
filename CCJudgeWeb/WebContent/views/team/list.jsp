<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="cc" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<cc:CCJudge title="Team List">
<script language="JavaScript" type="text/javascript">
<!--
var popupShown = "";
$(document).ready(function() {
	$(".deleteteam").bind("click", function() {
		if(popupShown != "#popup" + this.id) {
			hide();
			show(this.id, this.href);
		} else {
			hide();
		}
		return false;
	});
});

function show(id, href) {
	$("#popup" + id).load(href);
	$("#popup" + id).show('slow');
	popupShown = "#popup" + id;
}

function hide() {
	if(popupShown != "") {
		$(popupShown).hide('fast');
		popupShown = "";
	}
}
//-->
</script>
<h2>Team List <c:if test="${contest != null }"> for Contest ${contest.name}</c:if></h2>
<table border="1" cellpadding="2">
	<tr><th>id</th><th>Name</th><th>Members</th><th>Contests</th><th></th></tr>
	<c:forEach items="${list}" var="team" varStatus="count">
		<tr>
		<td>${team.id} (${count.count})</td>
		<td><a href="${baseURL}/team/view?id=${team.id}">${team.name}</a></td>
		<td>
			<cc:teamMembers team="${team}"></cc:teamMembers>
		</td>
		<td>
			<cc:contestList contests="${team.contests}"></cc:contestList>
		</td>
		<td><a href="${baseURL}/team/edit?id=${team.id}"><img src="${baseURL}/images/edit.png" border="0" alt="edit" title="edit"/></a>
		<a id="deleteteam${team.id}" href="${baseURL}/team/delete?option=2&amp;team=${team.id}&contest=${contest != null ? contest.id : 0}" class="deleteteam">
			<img src="${baseURL}/images/delete.png" border="0" alt="delete" title="delete"/>
		</a>
		<div id="popupdeleteteam${team.id}" class="hiddenpopup">
			Hello popup
		</div>
		</td>
		</tr>
	</c:forEach>
</table>
<a href="${baseURL}/team/edit${contest!=null?'?contest=':''}${contest.id}"><img src="${baseURL}/images/add_team.png" border="0" alt="add" title="add"/>Add new team</a>
</cc:CCJudge>