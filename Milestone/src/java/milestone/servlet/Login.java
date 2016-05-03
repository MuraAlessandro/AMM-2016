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
        
        HttpSession session = request.getSession(true);//effettuo la sessione
        // utilizzo instanceof per determinare che l'utente sia un venditore o cliente e li mando alla corrispettive pagine.jsp
        if(session.getAttribute("utente")!=null && (Utente)session.getAttribute("utente") instanceof Cliente){
              //passo la lista degli oggetti in vendita 
              ArrayList<ObjectSale> lista = ObjectSaleFactory.getInstance().getSellingObjectList();
              request.setAttribute("objects", lista);
              request.getRequestDispatcher("cliente.jsp").forward(request, response); 
        }
        if(session.getAttribute("utente")!=null && (Utente)session.getAttribute("utente") instanceof Venditore){
              request.getRequestDispatcher("venditore.jsp").forward(request, response);
         
        }
        
        if(request.getParameter("submit") != null)
        {
           
            // Preleva i dati inviati
            String username = request.getParameter("user");
            String password = request.getParameter("psw");
            
            //Importo la lista  
            ArrayList<Cliente> listaClienti = ClienteFactory.getInstance().getClientList();//restituisce la lista
            for(Cliente u : listaClienti)
            {
                if(u.getUsername().equals(username) &&  u.getPassword().equals(password))//controlla se ce qualche corrispondenza
                {
                    session.setAttribute("utente", u);                     
                    ArrayList<ObjectSale> lista = ObjectSaleFactory.getInstance().getSellingObjectList();
                    request.setAttribute("objects", lista);
                    request.getRequestDispatcher("cliente.jsp").forward(request, response); 
                }
            }
            //stessa cosa per i venditori
            ArrayList<Venditore> listaVenditori = VenditoreFactory.getInstance().getSellerList();
            for(Venditore u : listaVenditori)
            {
                if(u.getUsername().equals(username) && u.getPassword().equals(password))
                {
                    session.setAttribute("utente", u);
                    request.setAttribute("id", u.getId());//mi serve per il caricamento dell'oggetto
                    request.getRequestDispatcher("venditore.jsp").forward(request, response);  
                    
                }
            }

            request.setAttribute("error", true);
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
