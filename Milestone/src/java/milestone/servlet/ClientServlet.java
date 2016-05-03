/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package milestone.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import milestone.classi.Cliente;
import milestone.classi.ObjectSale;
import milestone.classi.ObjectSaleFactory;
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

     
     HttpSession session = request.getSession(false); 
     
     ArrayList<ObjectSale> lista = ObjectSaleFactory.getInstance().getSellingObjectList();
     if(session == null){
              request.getRequestDispatcher("accessoNegato.jsp").forward(request, response);
     }
     if(session.getAttribute("utente")!= null && (Utente)session.getAttribute("utente") instanceof Venditore){
              request.getRequestDispatcher("accessoNegato.jsp").forward(request, response);
         
     }
     if(request.getParameter("obID")!=null)
        for(ObjectSale u : lista){
            if(u.getId().equals(Integer.parseInt(request.getParameter("obID")))){
                request.setAttribute("oggetto", u);
                request.setAttribute("conferma",true);
            }
            request.getRequestDispatcher("cliente.jsp").forward(request, response);
        }
     
     if(request.getParameter("submit") != null) {
      /*  Boolean saldoOk=compra((Cliente)session.getAttribute("utente"),(ObjectSale)request.getAttribute("oggetto"),lista);
        if(saldoOk==true){
           ObjectSale ogg = (ObjectSale) request.getAttribute("oggetto"); 
           ArrayList<Venditore> listaVenditori = VenditoreFactory.getInstance().getSellerList();
           for(Venditore u : listaVenditori){
               if(u.getId().equals(Integer.parseInt(ogg.getIdVenditore())))
                   vendi(u,ogg);
           }
         
       
       }*/
           
     }
     
     
     
        request.setAttribute("objects", lista);   
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
