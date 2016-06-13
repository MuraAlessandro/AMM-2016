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
    
    
    public Boolean compra(ObjectSale oggetto, Cliente c, Venditore v) throws SQLException
    {
        Connection conn = DriverManager.getConnection(connectionString, "MuraAlessandro", "0000");
        
        PreparedStatement elimina = null;
        PreparedStatement diminuire = null;
        PreparedStatement aggiungere = null;
        
        String sql = "DELETE FROM oggetto WHERE id=? ";
        String sql2="UPDATE oggetto SET q=? WHERE id=? ";
        
        String sql3="UPDATE conto SET saldo=? WHERE conto.id=(SELECT cliente.idConto FROM cliente WHERE cliente.id=?) ";
        String sql4="UPDATE conto SET saldo=? WHERE conto.id=(SELECT venditore.idConto FROM venditore WHERE venditore.id=?) ";
        if(c.getConto().getSaldo()<oggetto.getPrice())//se il saldo è minore del prezzo dell'oggetto allora, acquisizione dell'oggetto non avviene
            return false;
        try
        {
            conn.setAutoCommit(false);
            if(oggetto.getQ()>1)//se la quantità dell'oggetto è >1 allora devo decrementare la quantita
            {
                elimina = conn.prepareStatement(sql2);
                elimina.setInt(1, oggetto.getQ()-1);
                elimina.setInt(2, oggetto.getId());
                int c1 = elimina.executeUpdate();
                if(c1!=1)//se la executeUpdate restituisce un valore != 1, allora o non ci sono occorrenze oppure è più di una, in sintesi si è verificato un errore
                {
                    conn.rollback();//riporto il database allo stato precedente alla setAutoCommit(false)
                    return false;
                }
            }    
            else if(oggetto.getQ()==1)//altrimenti elimino l'oggetto
            {
                
                elimina = conn.prepareStatement(sql);
                elimina.setInt(1, oggetto.getId());
                int c1 = elimina.executeUpdate();
                if(c1!=1)
                {
                    conn.rollback();
                    return false;
                }
            }
        
            if(c.getConto().getSaldo()>=oggetto.getPrice())
            {
                diminuire = conn.prepareStatement(sql3);
                diminuire.setDouble(1, c.getConto().getSaldo()-oggetto.getPrice());//setto il nuovo valore del saldo, con la detrazione del prezzo dell'oggetto comprato
                diminuire.setInt(2, c.getId());
                int d = diminuire.executeUpdate();
                if(d!=1)
                {
                    conn.rollback();
                    return false;
                }
            }
            else
            {
                conn.rollback();
                return false;
            }
            
            if(c.getConto().getSaldo()>=oggetto.getPrice())
            {
                aggiungere = conn.prepareStatement(sql4);
                aggiungere.setDouble(1, v.getConto().getSaldo()+oggetto.getPrice());//aumento il saldo del venditore pari all'ammontare del prezzo del venditore
                aggiungere.setInt(2, v.getId());
                int a = aggiungere.executeUpdate();
                if(a!=1)
                {
                    conn.rollback();
                    return false;
                }
            }
            else
            {
                conn.rollback();
                return false;
            }
            
            conn.commit();//salvo in maniera permanente le modifiche del database
        }
        catch(SQLException e)
        {
            e.printStackTrace();    
        }
        finally//blocco che viene eseguito comunque
        {
            if(elimina != null)
                elimina.close();//chiudo lo statement
            if(diminuire != null)
                diminuire.close();
            if(aggiungere != null)
                aggiungere.close();
            conn.setAutoCommit(true);//ripristino il comportamento standard
            conn.close();//chiudo la connessione
            
        }
        return true;//se tutto è andato ok allora la funzione restituisce true
        
    }
    
    
    
    public Cliente getClienteById(Integer id)
    {
        try
        {
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "MuraAlessandro", "0000");
            String query = "select * from cliente where id = ?  ";
            PreparedStatement stmt = conn.prepareStatement(query);
            // Si associano i valori
            stmt.setInt(1, id);
            // Esecuzione query
            ResultSet set = stmt.executeQuery();
           
            if(set.next())
            {
                Cliente cl = new Cliente();
                cl.id = set.getInt("id");
                cl.nome = set.getString("nome");
                cl.cognome = set.getString("cognome");
                cl.username = set.getString("username");
                cl.password = set.getString("password");
                
                try
                {
                    query = "SELECT saldo " +
                            "FROM conto " +
                            "JOIN cliente ON conto.id=cliente.IdConto " +
                            "WHERE cliente.id= "+cl.id;
                    Statement st = conn.createStatement();
                    ResultSet res2 = st.executeQuery(query);
                    while(res2.next())
                    {
                        Conto conto = new Conto();
                        cl.conto.setSaldo(res2.getDouble("saldo"));
                    }
                    st.close();
                }
                catch (SQLException t) 
                {
                    t.printStackTrace();
                }
                
                stmt.close();
                conn.close();
                
                return cl;
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
