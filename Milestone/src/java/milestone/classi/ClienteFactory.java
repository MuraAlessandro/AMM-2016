package milestone.classi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ale
 */
public class ClienteFactory {
 
 // Codice che permette di creare una sola istanza della classe
    private static ClienteFactory singleton;
    public static ClienteFactory getInstance() {
        if (singleton == null) {
            singleton = new ClienteFactory();
        }
        return singleton;
    }    
    
    private ArrayList<Cliente> listaClienti = new ArrayList<Cliente>();
    private String connectionString;
    /*
    public ClienteFactory (){
        Cliente client1 = new Cliente();
        client1.setUsername("almura");
        client1.setPassword("0");
        client1.setNome("Alessandro");
        client1.setCognome("Mura");
       // client1.setFoto("http://immaginibuongiorno.it/wp-content/uploads/2015/08/Immagini-buongiorno-301-e1411874877531-320x296.jpg");
        client1.setId(0);
        client1.conto.setSaldo(1220.05);
        listaClienti.add(client1);
        
        
        Cliente client2 = new Cliente();
        client2.setUsername("petrap");
        client2.setPassword("1");
        client2.setNome("Petra");
        client2.setCognome("Pirastu");
       // client2.setFoto("http://static.tecnocino.it/r/845X0/www.tecnocino.it/img/San-Valentino-2016-e-cuore-rosso.jpg");
        client2.setId(1);
        client2.conto.setSaldo(95.30);
    
    
        
        listaClienti.add(client2);
        
        
        Cliente client3 = new Cliente();
        client3.setUsername("NBS");
        client3.setPassword("2");
        client3.setNome("Nobume");
        client3.setCognome("Smith");
       // client3.setFoto("http://i0.wp.com/www.alessiopomaro.com/wp-content/uploads/2014/03/scelta-immagini-emozioni-positive.jpg");
        client3.setId(2);
        client3.conto.setSaldo(1500.00);
        listaClienti.add(client3);
        
    }*/
    /*
    public ArrayList<Cliente> getClientList(){
       return listaClienti;
    }*/
    
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    
    public String getConnectionString(){
	return this.connectionString;
    } 
    
    
    public Cliente getCliente(String username, String password)
    {
        try
        {    // path, username, password
            Connection conn = DriverManager.getConnection(connectionString,"MuraAlessandro","0000");
            String query = "select * from cliente where username = ? and password = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            // Si associano i valori
            stmt.setString(1, username);
            stmt.setString(2, password);
            // Esecuzione query
            ResultSet set = stmt.executeQuery();
           
            if(set.next())
            {
                Cliente cliente = new Cliente();
                //set.getInt("id"); restituisce il valore della colonna id del database
                cliente.id = set.getInt("id");
                cliente.nome = set.getString("nome");
                cliente.cognome = set.getString("cognome");
                cliente.username = set.getString("username");
                cliente.password = set.getString("password");

                try
                {
                    query = "SELECT saldo " +
                            "FROM conto " +
                            "JOIN cliente ON conto.id=cliente.IdConto " +
                            "WHERE cliente.id= "+cliente.id;
                    Statement st = conn.createStatement();
                    ResultSet res2 = st.executeQuery(query);
                    while(res2.next())
                    {
                        Conto conto = new Conto();
                        cliente.conto.setSaldo(res2.getDouble("saldo"));
                    }
                    st.close();
                }
                catch (SQLException t) 
                {
                    t.printStackTrace();
                }
          
                stmt.close();
                conn.close();
                
                return cliente;
            }
            
            stmt.close();
            conn.close();
            
        }
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return null;
    }
}
