/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package milestone.servlet;
import milestone.classi.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alessandro
 */
@WebServlet(name = "Login", urlPatterns = {"/login.html"})
public class Login extends HttpServlet {

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
        session.setAttribute("logClient", null);   
        session.setAttribute("logSel", null);
        
        if(request.getParameter("submit") != null)
        {
            
            // Preleva i dati inviati
            String username = request.getParameter("user");
            String password = request.getParameter("psw");
            
            //Ricerco se 
            ArrayList<Cliente> listaClienti = ClienteFactory.getInstance().getClientList();//restituisce la lista
            for(Cliente u : listaClienti)
            {
                if(u.getUsername().equals(username) &&   u.getPassword().equals(password))//controlla se ce qualche corrispondenza
                {
                    session.setAttribute("logClient", true);//se ce setto a true
                    request.setAttribute("cliente", u);                     
                    ArrayList<ObjectSale> lista = ObjectSaleFactory.getInstance().getSellingObjectList();
                    request.setAttribute("objects", lista);
                    request.getRequestDispatcher("cliente.jsp").forward(request, response); 
                }
                else
                    session.setAttribute("logClient", false);
            }
            
            
            ArrayList<Venditore> listaVenditori = VenditoreFactory.getInstance().getSellerList();
            for(Venditore u : listaVenditori)
            {
                if(u.getUsername().equals(username) && u.getPassword().equals(password))
                {
                    session.setAttribute("logSel", true);
                    request.setAttribute("venditore", u);
                    request.setAttribute("id", u.getId());
                    request.getRequestDispatcher("venditore.jsp").forward(request, response);  
                    
                }
                else
                    session.setAttribute("logSel", false);
            }
            
            
            
                    
            //if((Boolean)session.getAttribute("logSel") == false)
            
          
   
        
        }
       
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
