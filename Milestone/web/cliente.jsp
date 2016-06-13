<%-- 
    Document   : cliente
    Created on : 19-apr-2016, 23.03.50
    Author     : Ale
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <!-- il TAGLIB è usato per utilizzare i costrutti if foreach..-->
    
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
        
        
        <!-- jQuery -->
        <script type="text/javascript" src="js/jquery-2.2.4.min.js"></script>
        <script type="text/javascript" src="js/script.js"></script>
        
    </head>
    <body>
        <header>
        <img title="logo_sito" alt="logo" src="IMG/logsc.png" width="400" height="70">
        <h1>Pagina per il Cliente</h1>
        </header>
        
        <div id="sidebar">
            <c:if test="${sessionScope.utente != null}"><!-- accedo alla variabile di sessione -->
                 <a href="logout.html">--LOGOUT--</a>
            </c:if>
            <nav>
                <a href="descrizione.html" class="invio">Home di descrizione</a>
                <a href="login.html" class="invio">Login</a>
            </nav>
        </div>
        
        <div id="content_page">
                <div id="rcr"><!--Textfield per la ricerca di un oggetto-->
                    <label for="ricerca">Filtra:</label>
                    <input type="text" id="ricerca" size="15"/>
                </div>
                
                
                <h2 id="demo"></h2><!--il contenuto dipende dal file script.js-->
                
                <c:if test="${conferma == true}">
                    <h2>Riepilogo: per confermare l'acquisto premi su ok</h2>         
                </c:if>
                
                <table id="objects"><!--Creo una tabella che contiene gli oggetti che saranno venduti all'interno del sito-->
                    <c:if test="${ok == null}">
                            <tr><th>Nome</th><th>Foto</th><th class="space_table">Quantità</th><th class="space_table">Prezzo</th><th class="space_table">Link</th></tr>
                    </c:if>
                
                
                    <c:forEach var="objec" items="${objects}">
                        <tr>
                            <td>${objec.nome}</td>
                            <td><img title=" scarpa " alt="Foto di una scarpa" src="${objec.url}" width="150" height="150"> </td>
                            <td>${objec.q}</td> 
                            <td> ${objec.price} </td>
                            <td><a href="cliente.html?obID=${objec.id}" class="space_table">Aggiungi al carrello</a></td>
                        </tr>
                    </c:forEach>
                    
                    
                    
                    
                    
                <!--stampo il riepilogo-->
                <c:if test="${conferma == true}">
                    <!--<h2>Vuoi confermare l'acquisto del seguente oggetto?</h2>--> 
                    <form action="cliente.html" method="GET">
                    <tr><td>${oggetto.nome}</td>
                    <td><img title=" scarpa " alt="Foto di una scarpa" src="${oggetto.url}" width="100" height="100"></td>
                    <td>1</td>
                    <td>${oggetto.price}</td>
                    <input type="hidden" name="i" value="${oggetto.id}">
                    <td><input type="submit" value="OK" id="submit" name="submit"></td>
                    </form>
                </c:if>
                </table>
                
            <c:if test="${ok == false}">
                <h2>Non hai abbastanza soldi</h2>
            </c:if>
            <c:if test="${ok == true}">
                <h2>L'oggetto è stato acquistato con successo</h2>
            </c:if>
        </div>
        <%@include file="footer.jsp" %>
        
    </body>
</html>

