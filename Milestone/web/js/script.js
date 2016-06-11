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
                aggiornaLista(data);
            },
            error : function(data, state){     
            }
        });
        
       // Funzione che viene richiamata in caso di successo
                function aggiornaLista(objects)
        {
            // Cancella la lista
            $("#objects").empty();
            //
            document.getElementById("demo").innerHTML = " ";
            
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
                    // Crea un nuovo tag li
                    var newli = document.createElement("tr");
                    newli.setAttribute("name", "objec");

                    // testo



                    var td=document.createElement("td");
                    var text = document.createTextNode(objects[objec].nome);
                    td.appendChild(text);
                    newli.appendChild(td);

                    var td=document.createElement("td");
                    var img=document.createElement("IMG");
                    img.setAttribute("src", objects[objec].url);
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
                    var link = document.createElement("a");
                    link.setAttribute("href", "cliente.html?obID="+objects[objec].id);
                    var registraTxt = document.createTextNode("Aggiungi al Carrello");
                    link.appendChild(registraTxt);
                    td.appendChild(link);
                    newli.appendChild(td);


                    // Aggiunge il tag li al tag ul
                    $("#objects").append(newli);

                }

            }else {
                    document.getElementById("demo").innerHTML = "Non c'è nessuna corrispondenza";
            }
        }
    }); 
});