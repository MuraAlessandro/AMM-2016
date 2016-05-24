/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package milestone.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import milestone.classi.Cliente;
import milestone.classi.ClienteFactory;
import milestone.classi.ObjectSale;
import milestone.classi.ObjectFactory;
import milestone.classi.Utente;
import milestone.classi.Venditore;
import milestone.classi.VenditoreFactory;


/**
 *
 * @author Ale
 */
@WebServlet(name = "ClientServlet", urlPatterns = {"/cliente.html"})
public class ClientServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

     
     HttpSession session = request.getSession(false); //controllo se è gia in corso una sessione 
     request.setAttribute("ok", null);//setto questa variabile per stampare o meno l'intestazione della tabella
     ArrayList<ObjectSale> lista = ObjectFactory.getInstance().getOggetti();//passo gli oggetti alla servlet
     //se non e' in corso la sessione o non e' un cliente allora lo manda alla jsp accesso negato
     if(session == null){
              request.getRequestDispatcher("accessoNegato.jsp").forward(request, response);
     }
     if(session.getAttribute("utente")!= null && (Utente)session.getAttribute("utente") instanceof Venditore){
              request.getRequestDispatcher("accessoNegato.jsp").forward(request, response);
         
     }
     //valore che passo alla servlet con la url encoding di cliente.jsp, se è diverso da null vorrà dire che ha
     //cliccato su aggiungi al carrello
     if(request.getParameter("obID")!=null)
     {
        ObjectSale u= ObjectFactory.getInstance().getOggetto(Integer.parseInt(request.getParameter("obID")));
            if(u !=null){
                request.setAttribute("oggetto", u);
                request.setAttribute("conferma",true);  //per stampare il riepilogo
            } 
        
        request.getRequestDispatcher("cliente.jsp").forward(request, response);
     }
     
     //indica che ha premuto sulla conferma dell'acquisto 
    if(request.getParameter("submit") != null) {
       request.setAttribute("ok", false);//per stampare che non ha abbastanza soldi
       Cliente cliente=(Cliente) session.getAttribute("utente");
       
      ObjectSale u= ObjectFactory.getInstance().getOggetto(Integer.parseInt(request.getParameter("i")));
      //restituire il venditore
     
      Venditore v=VenditoreFactory.getInstance().getVenditoreById(u.getIdVenditore());
            try {
                ClienteFactory.getInstance().compra(u, cliente, v);
            } catch (SQLException ex) {
                Logger.getLogger(ClientServlet.class.getName()).log(Level.SEVERE, null, ex);
            }


    //ricerco l'oggetto con id che ho passato con input hidden
      /*for(ObjectSale u : lista){
           if(u.getId().equals(Integer.parseInt(request.getParameter("i"))))
                request.setAttribute("oggetto", u);
       }
       ObjectSale ogg = (ObjectSale) request.getAttribute("oggetto");
       //metodo saldoOk 
       Boolean saldoOk=cliente.compra(cliente,ogg,lista);
       if(saldoOk==true){ //se è true il cliente ha abbastanza soldi per comprare l'oggetto
            request.setAttribute("ok", true);//per stampare la conferma dell'acquisto
            if( ogg.getQ()>1)//riduco la quantità
                 ogg.setQ(ogg.getQ()-1);
            else 
                lista.remove(ogg);//elimino l'oggetto
           ArrayList<Venditore> sellers = VenditoreFactory.getInstance().getSellerList();
           Venditore v;
           //aumento il saldo del venditore
           for(Venditore c : sellers)
                    if(c.getId().equals(ogg.getIdVenditore())){
                        v=c; 
                        v.vendi(v,ogg);
                    }
       }*/
       request.getRequestDispatcher("cliente.jsp").forward(request, response);        
    }
     
     
     
        request.setAttribute("objects", lista);   
        //se la sessione è in atto e l'utente è un cliente va in cliente.jsp
        if(session.getAttribute("utente")!=null && (Utente)session.getAttribute("utente") instanceof Cliente){
             
              request.setAttribute("objects", lista);
              request.getRequestDispatcher("cliente.jsp").forward(request, response); 
        }
        else
         request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
