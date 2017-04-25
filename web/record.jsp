<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>



<c:forEach items="${contents}" var="content" varStatus="st">
    <font color="#FF0000"> ${content.stime} 12333</font> <br>
    <Strong> <font color="#000079"> ${content.username}: </font> </Strong>
    ${content.content} <br> <br>
</c:forEach>


