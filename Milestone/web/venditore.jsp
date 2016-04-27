<%-- 
    Document   : venditore
    Created on : 19-apr-2016, 23.05.08
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
            <nav>
                <a href="descrizione.html" class="invio">Home di descrizione</a> 
                <a href="login.html" class="invio">Login</a>
            </nav>
        </div>
         <!--Creazione del form per l'inserimento dei dati, che permetterà di inserire un nuovo oggetto-->
        <div id="content">
            <form action="venditore.jsp" method="GET">
                <!--il tag label è l'etichetta che è correlata ad uno specifico input-->
                <label for="nome">Nome oggetto:</label>
                <input type="text" id="nome" name="nome">

                <label for="url">Immagine dell'oggetto:</label> 
                <input type="url" id="url" name="url">
                 
                <label for="descrizione">Descrizione:</label>
                <textarea rows="10" cols="20" name="descrizione" id="descrizione"></textarea>
                
                <label for="q">Quantità disponibile dell'oggetto:</label>
                <input type="number" id="q" name="q" min="0"><!--Utilizzo il tag min perchè non è possibile avere meno di 0 oggetti, un valore negativo non avrebbe significato-->
                
                <label for="price">Prezzo dell'oggetto:</label>
                <input type="number" id="price" name="price" step="0.01" min="0">
                <!--Uso il tag min perchè non è possibile che il prezzo sia un numero negativo, il minimo può essere 0, ovvero gratis-->
                <!--Uso il tag step poichè il prezzo può essere un numero non intero, quindi è necessario utilizzare anche numeri decimali-->
                
                <input type="submit" value="invia" id="submit">
            </form>
        </div>    
         
        <%@include file="footer.jsp" %>
         
    </body>
</html>

