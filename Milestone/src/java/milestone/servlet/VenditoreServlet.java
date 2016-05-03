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
@WebServlet(name = "Venditore", urlPatterns = {"/venditore.html"})
public class VenditoreServlet extends HttpServlet {

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
      //  request.setAttribute("form", false);
        
      
        if(session == null){
                    request.getRequestDispatcher("accessoNegato.jsp").forward(request, response);
           }
           if(session.getAttribute("utente")!=null && (Utente)session.getAttribute("utente") instanceof Cliente){
                    request.getRequestDispatcher("accessoNegato.jsp").forward(request, response);

           }
        ArrayList<ObjectSale> objects = ObjectSaleFactory.getInstance().getSellingObjectList();
       
           
            if(request.getParameter("submit") != null){
                    //per calcolare un id differente per tutti gli oggetti
                    Integer num = null;
                    for(ObjectSale u : objects){
                        num=u.getId();
                    }
                    
                    ObjectSale obj = new ObjectSale();
                    obj.setId(num+1);
                    obj.setNome(request.getParameter("nome"));
                    obj.setDescrizione(request.getParameter("descrizione"));
                    obj.setUrl(request.getParameter("url"));
                    Venditore v=(Venditore) session.getAttribute("utente");
                    obj.setIdVenditore(v.getId());
                   //correzzione errori di inserimento
                   if(obj.getNome()== "" || obj.getUrl()== "" || obj.getDescrizione()== ""){
                        
                        String error="Devi compilare tutti i campi per poter inserire il nuovo prodotto";
                        request.setAttribute("er", error);
                        request.setAttribute("form", null);
                        request.getRequestDispatcher("venditore.jsp").forward(request, response);
                    }
                    try{
                    obj.setPrice(Double.parseDouble(request.getParameter("price")));
                    obj.setQ(Integer.parseInt(request.getParameter("q")));
                    }
                    catch(RuntimeException exception){
                        String error="Devi compilare tutti i campi per poter inserire il nuovo prodotto";
                        request.setAttribute("er", error);
                        request.setAttribute("form", null);
                        request.getRequestDispatcher("venditore.jsp").forward(request, response);
                    }
                    
                    
                    
                    
                    request.setAttribute("obj", obj);
                    objects.add(obj);

                    request.setAttribute("form", true);
                   
                    
                    }
            if(session.getAttribute("utente")!=null && (Utente)session.getAttribute("utente") instanceof Venditore)
                request.getRequestDispatcher("venditore.jsp").forward(request, response);
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
