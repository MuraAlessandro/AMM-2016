/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package milestone.servlet;
import milestone.classi.*;
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

/**
 *
 * @author Alessandro
 */
@WebServlet(name = "Login", urlPatterns = {"/login.html"}, loadOnStartup = 0 )
public class Login extends HttpServlet {

    private static final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String DB_CLEAN_PATH = "../../web/WEB-INF/db/ammdb";
    private static final String DB_BUILD_PATH = "WEB-INF/db/ammdb";
    
    @Override 
    public void init(){
        String dbConnection = "jdbc:derby:" + this.getServletContext().getRealPath("/") + DB_BUILD_PATH;
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        ClienteFactory.getInstance().setConnectionString(dbConnection);
        VenditoreFactory.getInstance().setConnectionString(dbConnection);
        ObjectFactory.getInstance().setConnectionString(dbConnection);
        ContoFactory.getInstance().setConnectionString(dbConnection);
    }
    
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
              ArrayList<ObjectSale> lista = ObjectFactory.getInstance().getOggetti();
              request.setAttribute("objects", lista);
              request.getRequestDispatcher("cliente.jsp").forward(request, response); 
        }
        if(session.getAttribute("utente")!=null && (Utente)session.getAttribute("utente") instanceof Venditore){
            Venditore s =(Venditore) session.getAttribute("utente");
            Integer idVenditore=s.getId();
            ArrayList<ObjectSale> objId=ObjectFactory.getInstance().getOggettoByVend(idVenditore);
            request.setAttribute("ob", objId);
            request.getRequestDispatcher("venditore.jsp").forward(request, response);    
        }
        
       /* Cliente a=ClienteFactory.getInstance().getClienteById(1);
        ObjectSale u =ObjectFactory.getInstance().getObjectSaleById(2);
        Venditore p=VenditoreFactory.getInstance().getVenditoreById(1);
        try {      
            ClienteFactory.getInstance().compra(u, a, p);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
        if(request.getParameter("submit") != null)
        {
           
            // Preleva i dati inviati
            String username = request.getParameter("user");
            String password = request.getParameter("psw");
            //si passano ad un metodo
            Cliente c = ClienteFactory.getInstance().getCliente(username, password);
                
                if(c != null)//controlla se ce qualche corrispondenza
                {
                    session.setAttribute("utente", c);                     
                    ArrayList<ObjectSale> lista = ObjectFactory.getInstance().getOggetti();
                    request.setAttribute("objects", lista);
                    request.getRequestDispatcher("cliente.jsp").forward(request, response); 
                }
            
            Venditore v = VenditoreFactory.getInstance().getVenditore(username, password);
                if(v != null)
                {
                  //  int a=v.getId();
                    session.setAttribute("utente", v);
                    //request.setAttribute("id", v.getId());//mi serve per il caricamento dell'oggetto
                    Venditore s =(Venditore) session.getAttribute("utente");
                    Integer idVenditore=s.getId();
                    ArrayList<ObjectSale> objId=ObjectFactory.getInstance().getOggettoByVend(idVenditore);
                    request.setAttribute("ob", objId);
                    request.getRequestDispatcher("venditore.jsp").forward(request, response);  
                    
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
