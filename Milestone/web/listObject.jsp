<%-- 
    Document   : listObject
    Created on : 9-giu-2016, 16.40.30
    Author     : Ale

--%>


<%@page contentType="application/json" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<json:array><%-- creazione dell'array json --%>
    <c:forEach var="objec" items="${objects}">
        <json:object>
            <json:property name="nome" value="${objec.nome}"/>
            <json:property name="url" value="${objec.url}"/>
            <json:property name="q" value="${objec.q}"/>
            <json:property name="price" value="${objec.price}"/>
            <json:property name="id" value="${objec.id}"/>
        </json:object>
    </c:forEach>
</json:array>