<%-- 
    Document   : venditore
    Created on : 19-apr-2016, 23.05.08
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
        <title>Venditore</title>
       <!-- <base href="M3/">-->
        <meta charset="UTF-8">       
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Mura Alessandro">
        <meta name="keywords" content="VENDERE, HTML, AMM">
        <meta name="description" content="Pagina dedicata al venditore">
	<!--link per foglio di stile e per l'icona del sito-->
        <link href="style.css" rel="stylesheet" type="text/css" media="screen">
	<link rel="icon" href="IMG/icon.ico">
    </head>
    <body>
        
        <header>
            <img title="logo_sito" alt="logo" src="IMG/logsc.png" width="400" height="70">
            <h1>Pagina riservata al Venditore</h1>
        </header>
        
        <div id="sidebar" >
            <c:if test="${sessionScope.utente != null}"><!-- accedo alla variabile di sessione -->
                 <a href="logout.html">--LOGOUT--</a>
            </c:if>
            <nav>
                <a href="descrizione.html" class="invio">Home di descrizione</a> 
                <a href="login.html" class="invio">Login</a>
            </nav>
        </div>
         <!--Creazione del form per l'inserimento dei dati, che permetterà di inserire un nuovo oggetto-->
        <c:if test="${form==null}">
            <div id="content_page" class="error">
                <h2>${er}</h2>
            </div>
           </c:if>
        <div id="content">    
            <c:if test="${form==null}">   
                <ol>   
                    <li>Aggiungi oggetto   
                        <form action="venditore.html" method="GET">
                            <!--il tag label è l'etichetta che è correlata ad uno specifico input-->
                            <label for="nome">Nome oggetto:</label>
                            <input type="text" id="nome" name="nome">

                            <label for="url">Immagine dell'oggetto:</label> 
                            <input type="url" id="url" name="url" >

                            <label for="descrizione">Descrizione:</label>
                            <textarea rows="10" cols="20" id="descrizione" name="descrizione" ></textarea>

                            <label for="q">Quantità disponibile dell'oggetto:</label>
                            <input type="number" id="q" name="q" min="1" ><!--Utilizzo il tag min perchè non è possibile avere meno di 0 oggetti, un valore negativo non avrebbe significato-->

                            <label for="price">Prezzo dell'oggetto:</label>
                            <input type="number" id="price" name="price" step="0.01" min="0" >
                            <!--Uso il tag min perchè non è possibile che il prezzo sia un numero negativo, il minimo può essere 0, ovvero gratis-->
                            <!--Uso il tag step poichè il prezzo può essere un numero non intero, quindi è necessario utilizzare anche numeri decimali-->

                            <input type="hidden" name="idV" value="${id}">
                            <input type="submit" value="invia" id="submit" name="submit">
                        </form>
                    </li>  
                    <li> Modifica oggetto</li> 
                    
                    
                    
                    
                    
                    <li> Elimina oggetto
                       
                        <form action="venditore.html" method="GET">
                            <select name="ogget">
                                <c:forEach var="objec" items="${ob}">
                                    <option value="k">lò</option>
                                </c:forEach>
                            </select>
                            <input type="submit" value="invia" id="send" name="send">
                        </form>

                    </li>    
                </ol>       

            </c:if> 
            <!--conferma dell'inserimento dell'oggetto-->
            <c:if test="${form==true}">
                <div>
                <strong>Inserimento riuscito</strong>
                <label>Nome: ${obj.nome}</label>
                <label><img title=" scarpa " alt="Foto di una scarpa" src="${obj.url}" width="150" height="150"></label>
                <label>Quantità: ${obj.q}</label>
                <label>Prezzo: ${obj.price}</label>
                <label>Descrizione: ${obj.descrizione}</label>
                <label>Idvenditore: ${obj.idVenditore}</label>
                <label>Id: ${obj.id}</label>
                </div>
            </c:if> 
        </div>    
         
        <%@include file="footer.jsp" %>
         
    </body>
</html>

