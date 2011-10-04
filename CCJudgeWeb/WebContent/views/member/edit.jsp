<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="cc" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
 function save() {
 	var i = document.getElementById('mrole').selectedIndex;
 	var role = document.getElementById('mrole').options[i].value;
 	var name = document.getElementById('mname').value;
 	var username = document.getElementById('musername').value;
 	var admin = document.getElementById('madmin').checked;
 	$.post("${baseURL}/member/update", { 
 		id: "${member.id}", 
 		name: name, 
 		username: username, 
 		admin: admin,
 		role: role,
 		team: "${team.id}" },
  function(data){
    if (data=='Information Saved') {
        showMembers();
    	hide();
    }
    else alert("Error: " + data);
  });
 	return false;
 }
 function hide() {
 	$('#addmember').hide('fast');
 }

 function add(id) {
	 $.ajax({
		 type: "GET",
		 url: "${baseURL}/member/add?team=${team.id}&id="+id,
		 dataType: "",
		 success: function(data) {
			 showMembers();
			 hide();
		 }
	 });
 }
 
 function find(uname) {
	 //alert(uname.value);
	 $.ajax({
         type: "GET",
         url: "${baseURL}/member/find?username="+uname.value,
         dataType: "xml",
         success: function(xml) {
        	 $('#findmember ul').html('');
             $(xml).find('member').each(function(){
                 var id_text = $(this).attr('id');
                 var name_text = $(this).find('name').text();
                 var username_text = $(this).find('username').text();
                 $('<li></li>')
                     .html('<a href="#" onclick="add(\''+id_text+'\'); return false;">'+name_text + ' (' + id_text + ')</a>')
                     .appendTo('#findmember ul');
             }); //close each(
         }
     });
	 return false;
 }
 var fint = null;
</script>
<form method="post" name="memberform" action="${baseURL}/member/update" onsubmit="return false;">
<input type="hidden" name="id" value="${member.id}"/>
<input type="hidden" name="team" value="${team.id}" />
<table>	
	<tr><td>Username</td>
		<td><input id="musername" type="text" name="username" value="${member.username}" size="40" onkeypress="if (fint) window.clearTimeout(fint); fint = window.setTimeout(find, 500, this);"/>
		<div id="findmember">
		<ul></ul>
		</div>
		</td></tr>
	<tr><td>Name</td>
		<td><input id="mname" type="text" name="name" value="${member.name}" size="40" /></td></tr>
	<tr><td>Admin</td>
		<td><input id="madmin" type="checkbox" name="admin" value="true" /></td></tr>
	<c:forEach items="${member.teams}" var="role">
	<tr><td>Role</td>
		<td><select id="mrole" name="role">
				<option ${role.role=='Participant'?'selected="selected"':''}>Participant</option>
				<option ${role.role=='Coach'?'selected="selected"':''}>Coach</option>
			</select>
			</td></tr>
	</c:forEach>
</table>
<input type="submit" value="Save" id="membersave" onclick="save(); return false;" />  <input type="button" value="Cancel" id="membercancel" onclick="hide();" />
</form>
