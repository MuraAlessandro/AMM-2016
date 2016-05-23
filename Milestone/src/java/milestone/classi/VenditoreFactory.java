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
public class VenditoreFactory {
 
 // Codice che permette di creare una sola istanza della classe
    private static VenditoreFactory singleton;
    public static VenditoreFactory getInstance() {
        if (singleton == null) {
            singleton = new VenditoreFactory();
        }
        return singleton;
    }    
    
    private ArrayList<Venditore> listaVenditori = new ArrayList<Venditore>();
    private String connectionString;
    
    public VenditoreFactory (){
        Venditore vend1 = new Venditore();
     //   vend1.setImpresa("TuttoTacchi");
        vend1.setUsername("maniR");
        vend1.setPassword("m");
        vend1.setNome("Manila");
        vend1.setCognome("Rossi");
        vend1.setId(15);
        vend1.conto.setSaldo(300.99);
        listaVenditori.add(vend1);
        
        
        Venditore vend2 = new Venditore();
      //  vend2.setImpresa("JapanShoes");
        vend2.setUsername("jss");
        vend2.setPassword("b");
        vend2.setNome("Ilario");
        vend2.setCognome("Sakata");
        vend2.setId(1);
        vend2.conto.setSaldo(40000.00);
        listaVenditori.add(vend2);

        

    }
    
    public ArrayList<Venditore> getSellerList(){
       return listaVenditori;
    }
    
       public void setConnectionString(String s){
	this.connectionString = s;
    }
    
    public String getConnectionString(){
	return this.connectionString;
    } 
    
     public Venditore getVenditore(String username, String password)
    {
        try
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "MuraAlessandro", "0000");
            String query = "select * from venditore where username = ? and password = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            // Si associano i valori
            stmt.setString(1, username);
            stmt.setString(2, password);
            // Esecuzione query
            ResultSet set = stmt.executeQuery();
           
            if(set.next())
            {
                Venditore venditore = new Venditore();
                //set.getInt("id"); restituisce il valore della colonna id del database
                venditore.id = set.getInt("id");
                venditore.nome = set.getString("nome");
                venditore.cognome = set.getString("cognome");
                venditore.username = set.getString("username");
                venditore.password = set.getString("password");
                
                try
                {
                    query = "SELECT saldo " +
                            "FROM conto " +
                            "JOIN venditore ON conto.id=venditore.IdConto " +
                            "WHERE venditore.id= "+venditore.id;
                    Statement st = conn.createStatement();
                    ResultSet res2 = st.executeQuery(query);
                    while(res2.next())
                    {
                        Conto conto = new Conto();
                        venditore.conto.setSaldo(res2.getDouble("saldo"));
                    }
                    st.close();
                }
                catch (SQLException t) 
                {
                    t.printStackTrace();
                }
                
                stmt.close();
                conn.close();
                
                return venditore;
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
