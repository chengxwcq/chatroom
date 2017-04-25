<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<c:if test="${!empty user}" >
    <div align="center">
        当前用户: ${user.name} <br>
    </div>
</c:if>


<%@ include file="record.jsp" %>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<form action="submit_content" method="post">
输入聊天内容: <input type = "text" name = "text" />
                <!--style = "height:300px;width:500px;" />  -->
<br>
<input type = "submit" value = "submit" />
</form>

<!-- <div>留 言<br> <textarea name="textfield3" cols="30" rows="3"></textarea> -->