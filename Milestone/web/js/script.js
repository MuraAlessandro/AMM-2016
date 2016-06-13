/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function ()
{
   $("#ricerca").keyup(function()
    {  
        // Preleva il valore
        var text = $("#ricerca").val();
       
        $.ajax(
        {
            url: "filter.json",
            data:{
              cmd: "search",
              q: text
            },
            dataType: 'json',
            success : function(data, state){
                aggiornaLista(data);// Funzione che viene richiamata in caso di successo
            },
            error : function(data, state){   //In caso di insuccesso da parte del server non viene richiamato nulla   
            }
        });
        
       
                function aggiornaLista(objects)
        {
            // Cancella la lista
            $("#objects").empty();
            //cancello il contenuto dell'elemento con id demo
            document.getElementById("demo").innerHTML = " ";
            //se la lunhezza dell'array è diversa da 0, allora vuol dire che ci sono oogetti 
            if(objects.length!==0)
            {
                // creo l'intestazione della tabella
                var newli = document.createElement("tr");

                var td=document.createElement("th");
                var text = document.createTextNode("Nome");
                td.appendChild(text);
                newli.appendChild(td);

                var td=document.createElement("th");
                var text = document.createTextNode("Foto");
                td.appendChild(text);   
                newli.appendChild(td);

                var td=document.createElement("th");
                var text = document.createTextNode("Quantità");
                td.appendChild(text);
                newli.appendChild(td);

                var td=document.createElement("th");
                var text = document.createTextNode("Prezzo");
                td.appendChild(text); 
                newli.appendChild(td);

                var td=document.createElement("th");
                var text = document.createTextNode("Link");
                td.appendChild(text);
                newli.appendChild(td);
                $("#objects").append(newli);

                for(var objec in objects)
                {
                    // Crea un nuovo tag tr
                    var newli = document.createElement("tr");
                    newli.setAttribute("name", "objec");

                    



                    var td=document.createElement("td");//creo il tag td
                    var text = document.createTextNode(objects[objec].nome);// creo un nuovo nodo con nome dell'oggetto
                    td.appendChild(text);//aggiungiamo il nodo testuale al tag td
                    newli.appendChild(td);//aggiungiamo il nodo td al tag tr

                    var td=document.createElement("td");
                    var img=document.createElement("IMG");//creo il tag img
                    img.setAttribute("src", objects[objec].url);//setto i vari attributi del tag imm
                    img.setAttribute("width", "150");
                    img.setAttribute("height", "150");
                    img.setAttribute("alt", "Foto di una scarpa");
                    td.appendChild(img);
                    newli.appendChild(td);

                    var td=document.createElement("td");
                    var text = document.createTextNode(objects[objec].q );
                    td.appendChild(text);
                    newli.appendChild(td);

                    var td=document.createElement("td");
                    var text = document.createTextNode(objects[objec].price);
                    td.appendChild(text);
                    newli.appendChild(td);

                    var td=document.createElement("td");
                    var link = document.createElement("a");//creo il tag a
                    link.setAttribute("href", "cliente.html?obID="+objects[objec].id);//setto gli attributi del tag a
                    var registraTxt = document.createTextNode("Aggiungi al Carrello");//creo nodo testuale
                    link.appendChild(registraTxt);
                    td.appendChild(link);
                    newli.appendChild(td);


                    
                    $("#objects").append(newli);

                }

            }else {
                    document.getElementById("demo").innerHTML = "Non c'è nessuna corrispondenza";
            }
        }
    }); 
});