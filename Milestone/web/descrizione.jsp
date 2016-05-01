<%-- 
    Document   : descrizione
    Created on : 19-apr-2016, 22.51.10
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
    <head>  <!-- contiene informazioni generali sulla pagina -->
        <title>Descrizione</title> <!-- definizione del titolo del documento -->
        <!-- meta-informazioni -->
        
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Mura Alessandro">
        <meta name="keywords" content="SCARPE, HTML, AMM">
        <meta name="description" content="Descrizione del sito di ecommerce scarpe">
	<!--link per foglio di stile e per l'icona del sito-->
        <link href="style.css" rel="stylesheet" type="text/css" media="screen">
	<link rel="icon" href="IMG/icon.ico">
        <!--<meta http-equiv="refresh" content="20">-->   
    </head>
    <body><!--Contiene il corpo del sito che verrà creato, ovvero il contenuto della pagina-->
    <!--logo del sito-->    
    <header>
        <img title="logo_sito" alt="logo" src="IMG/logsc.png" width="400" height="70">    
        <h1>Ecommerce Scarpe</h1>
    </header>
    <div  id="sidebar">
        ${logClient} - ${logSel}
        
        <c:if test="${logClient== true || logSel == true}">
                 <a href="descrizione.html?ss=1">logout</a>
        </c:if>
        
        <nav>Effettua il <a href="login.html" class="invio">Login</a></nav> <!-- sezione di navigazione -->
        
        <ol><!--creazione del sommario-->
            <li><a href="#1">Descrizione</a></li>
            <li><a href="#2">Scarpe in vendita</a>
                <ul>
                    <li><a href="#2a">Scarpe da Uomo</a></li>
                    <li><a href="#2b">Scarpe da Donna</a></li>
                </ul>  
            </li>
            <li><a href="#3">Modalità di vendita</a></li>
            <li><a href="#4">Informazioni per il cliente</a></li>
        </ol>
    </div>
    
    
    <div id="main">
        <h2 id="1">Descrizione</h2>
        <img title="scarpa" alt="Illustrazione di una scarpa" src="IMG/scarpa.png"><!--Aggiungo un'immagine descrittiva, che mi dica come è strutturata una scarpa-->
        <p class="center">La scarpa è una calzatura che permette di coprire e proteggere il piede dalle possibili intemperie giornaliere, 
        Una scarpa può essere realizzata in pelle, stoffa, cuoio o vari materiali sintetici 
        ed è costituita da una parte inferiore che poggia a terra, ovvero la <strong>suola</strong>, e 
        da una parte superiore più o meno estesa detta <strong>tomaia</strong> che ricopre il dorso del piede fino all'altezza del malleolo. 
        Una scarpa può avere la suola piatta o essere dotata di un tacco che rende la camminata più agevole ( non credo XD ) e conferisce una 
        maggiore altezza a chi la indossa. La tomaia può essere dotata di una <strong>stringatura</strong> che permette alla calzatura di 
        aderire più strettamente al piede che la indossa.
        La parte anteriore della scarpa che riveste le falangi è chiamata <strong>puntale</strong> e può essere fatto di un differente materiale, 
        per esempio per le calzature infortunistiche i puntali sono fatti d'acciaio. 
        La parte che ricopre la parte laterale del piede si chiama <strong>intersuola</strong>.
        </p>

        <!--Utilizzo il tag strong per enfatizzare le parte che costituiscono una scarpa, molto utile se la pagina
            viene visitata da una persona non vedente-->

        <h2 id="2">Scarpe in vendita</h2>
        <p class="center">Nel nostro sito di ecommerce potrai trovare una vasta gamma di scarpe per uomo e donna, da bambino a adulto,
        da quelle sportive a quelle eleganti...</p>

        <h3 id="2a">Scarpe da Uomo</h3>
        <p>Le ossa del piede sono più grandi e pesanti, l'appoggio del tallone risulta quindi essere più laterale rispetto a quello femminile (più centrato).
             Ecco quindi che le aziende si sono adeguate inserendo nei modelli specifici da uomo dei sistemi 
             ammortizzanti in posizione più laterali rispetto a quelli da donna.</p>

        <h3 id="2b">Scarpe da Donna</h3>
        <p>L’anatomia femminile è caratterizzata dal fatto che il corpo della donna è 
            “costruito” per essere in grado, all’occorrenza, di portare avanti una gravidanza e di partorire. 
            Quindi la principale differenza anatomica riguarda il bacino che è più largo rispetto a quello dell’uomo.
            La conseguenza di questa diversa architettura del bacino e delle anche è che si hanno delle linee di forza 
            differenti che agiscono su gli arti inferiori e sul piede. Rispetto al piede maschile, quindi, 
            quello femminile presenta solitamente un arco plantare più alto. Per questo motivo i modelli per la 
            donna hanno una tomaia con più supporto a livello dell’arco plantare, vale a dire la parte interna della scarpa.
            Alcune aziende hanno studiato modelli che hanno integrato in questa zona la tomaia con l’intersuola.</p>

        <h2 id="3">Modalità di vendita</h2>
        <p class="center">La vendita di tutti i prodotti in catalogo è possibile ai soli utenti iscritti a questo sito di ecommerce.</p>

        <h2 id="4">Informazioni per il cliente</h2>
        <p class="center">Offriamo ai nostri clienti costi di consegna differenziati. I prodotti acquistati ti saranno consegnati 
            ovunque tu desideri ed il costo dipenderà dall'area geografica, dal tipo di spedizione ed eventualmente dal peso del pacco.<br>
           L' annullamento di un ordine può avvenire esclusivamente mediante contatto telefonico, 
           (+39 34******** / 07******* ) senza particolari motivazioni, e se la spedizione non abbia già avuto luogo.
        </p> 

    </div>
    
    <%@include file="footer.jsp" %>
    
    </body>
</html>
