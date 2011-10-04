<%@ attribute name="team" type="edu.neumont.ccjudge.model.Team" required="true" rtexprvalue="true" %>
<%@ attribute name="edit" type="java.lang.Boolean" required="false" rtexprvalue="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${edit}">
<script language="JavaScript" type="text/javascript">
<!--
$(document).ready(function() {
   $("#addlink").toggle(function(){
     $("#addmember").load('${baseURL}/member/edit?team=${team.id}');
     $("#addmember").show('slow');
   },function(){
     $("#addmember").hide('fast');
   });

 });

function showMembers() {
	$("#teamMembers${team.id}").load('${baseURL}/member/members?team=${team.id}&edit=${edit}');
}
//-->
</script>
</c:if>
<div id="teamMembers${team.id}">
<%@ include file="/views/member/teamMembers.jsp" %>
</div>
<c:if test="${edit}">
<a id="addlink" href="${baseURL}/member/edit"><img src="${baseURL}/images/add_teammember.png" border="0" alt="add team member" title="add team member"/>Add team member</a>
<div id="addmember" class="hiddenpopup">
Hello popup
</div>
</c:if>