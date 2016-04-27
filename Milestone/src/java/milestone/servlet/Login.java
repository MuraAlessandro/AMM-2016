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
        
        
        
        HttpSession session = request.getSession();
        
        if(request.getParameter("submit") != null)
        {
            // Preleva i dati inviati
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            
            ArrayList<Cliente> listaClienti = ClienteFactory.getInstance().getClientList();
            for(Cliente u : listaClienti)
            {
                if(u.getUsername().equals(username) &&   u.getPassword().equals(password))
                {
                    session.setAttribute("loggedIn", true);
                    
                    if(u instanceof Cliente) 
                    {
                        request.setAttribute("cliente", u);
                       // request.setAttribute("alunni", UtentiFactory.getInstance().getStudenteList());
                        request.getRequestDispatcher("login.jsp").forward(request, response);
                    }
                                      
                }
            }
            
            ArrayList<Venditore> vende = VenditoreFactory.getInstance().getSellerList();
            for(Venditore u : vende)
            {
                if(u.getUsername().equals(username) &&    u.getPassword().equals(password))
                {
                    session.setAttribute("loggedIn", true);
                    {
                        request.setAttribute("venditore", u);
                        request.getRequestDispatcher("login.jsp").forward(request, response);  
                    }  
                }
            }
            
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
