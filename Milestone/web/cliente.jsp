<%-- 
    Document   : cliente
    Created on : 19-apr-2016, 23.03.50
    Author     : Ale
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!--usato per utilizzare i costrutti if foreach..-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Cliente</title>
       <!-- <base href="M3/">-->
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Mura Alessandro">
        <meta name="keywords" content="CLIENTE, HTML, PREZZO AMM">
        <meta name="description" content="Pagina dedicata al cliente">
	<!--link per foglio di stile e per l'icona del sito-->
        <link href="style.css" rel="stylesheet" type="text/css" media="screen">
	<link rel="icon" href="M3/IMG/icon.ico">
    </head>
    <body>
        <header>
        <img title="logo_sito" alt="logo" src="IMG/logsc.png" width="400" height="70">
        <h1>Pagina per il Cliente</h1>
        </header>
        
        <div id="sidebar">
        <nav>
            <a href="descrizione.html" class="invio">Home di descrizione</a>
            <a href="login.html" class="invio">Login</a>
        </nav>
        </div>
        
        <div id="content_page">
           
            ${cliente.nome} - ${cliente.cognome} ----- ${logClient}
            
            
                <table><!--Creo una tabella che contiene gli oggetti che saranno venduti all'interno del sito-->
                    <tr><th>Nome</th><th>Foto</th><th class="space_table">Quantità</th><th class="space_table">Prezzo</th><th>Link</th></tr>

                    <c:forEach var="objec" items="${objects}">
                    <tr>
                        <td>${objec.nome}</td>
                        <td><img title=" scarpa " alt="Foto di una scarpa" src="${objec.url}" width="150" height="150"></td>
                        <td>${objec.q}</td>
                        <td>${objec.price}</td>
                        <td><a href="cliente.html?obID=${objec.id}" class="space_table">Aggiungi al carrello</a></td>
                    </tr>
                    </c:forEach>
                </table>
                <c:if test="${conferma == true}">
                <form action="cliente.html?n=66" method="GET">
                <label>Nome: ${oggetto.nome}</label>
                <label>Prezzo: ${oggetto.price}</label>
                <label>Descrizione: ${oggetto.descrizione}</label>
                <input type="submit" value="invia" id="submit" name="submit">
                </form>
                </c:if>
        </div>
         ---------   
        ${n}
        <%@include file="footer.jsp" %>
        
    </body>
</html>

