<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true" %>
<%@ taglib prefix="cc" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<cc:CCJudge title="Error">
<h2>Unable to process request</h2>
<span class="error">${error}</span>
<br />
<pre>${except.message} ${except.localizedMessage}
${except}</pre>
</cc:CCJudge>