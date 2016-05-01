<%-- 
    Document   : login
    Created on : 19-apr-2016, 23.04.21
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
    <head><!-- contiene informazioni generali sulla pagina -->
        <title>Login</title>
        <!--<base href="M3/">-->
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Mura Alessandro">
        <meta name="keywords" content="LOGIN, HTML, AMM">
        <meta name="description" content="Login del cliente">
	<!--link per foglio di stile e per l'icona del sito-->
        <link href="style.css" rel="stylesheet" type="text/css" media="screen">
	<link rel="icon" href="IMG/icon.ico">
    </head>
    <body><!--Contiene il corpo del sito che verrà creato, ovvero il contenuto della pagina-->
        <header>
            <img title="logo_sito" alt="logo" src="IMG/logsc.png" width="400" height="70">
            <h1>Effettua il Login nel nostro sito</h1>
        </header>
        
        <div id="sidebar">
           <!--  <c:if test="${logClient== true || logSel == true}">
                 <a href="descrizione.html?ss=1">logout</a>
             </c:if>-->   
            <nav> <!-- sezione di navigazione -->
                <a href="descrizione.html" class="invio">Home di descrizione</a>
                <a href="cliente.html" class="invio">Cliente</a>
                <a href="venditore.html" class="invio">Venditore</a>
            </nav>
         </div>
        
        
        LogClient - logSel <br>
        ${logClient}-${logSel}
        
        <div id="content_page" class="error">
            <c:if test="${(logClient == false && logSel == false) || logClient == false || logSel == false}">    
                         <h2><!--Username e/o Password errato--> Accesso negato</h2>
            </c:if>
           <!-- <c:if test="${logClient == null}">    
                        <h2>Accesso negato, non sei un cliente</h2>
            </c:if>
            <c:if test="${logSel == null}">    
                        <h2>Accesso negato, non sei un venditore</h2>
            </c:if>-->
        </div>
               
        <c:if test="${logClient != true && logSel != true}">
            <div id="content">    
                <!--Creazione del form per l'inserimento dei dati, che poi riutilizzeremo in seguito-->
                <form action="login.html" method="POST">
                    <input type="hidden" name="bb" value="true">
                    <label for="user">Username:</label>
                    <input type="text" name="user" id="user" value="">
                    <label for="psw">Password:</label> 
                    <input type="password" name="psw" id="psw" >
                    <input type="reset" value="reset" id="reset">
                    <input type="submit" value="invia" id="submit" name="submit" >
                </form>    
            </div>
        </c:if> 
        
        
        <%@include file="footer.jsp" %>
    </body>
</html>
