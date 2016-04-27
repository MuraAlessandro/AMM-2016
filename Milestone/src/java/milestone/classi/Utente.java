package milestone.classi;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ale
 */
public class Utente 
{
    private int id;
    private String nome;//per fare il bentornato 
    private String cognome;
    private String username;
    private String password;
    private int idConto;
    

    /**
     * @return the username
     */
    //get restituisce il valore (per visualizzarlo)
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    //set imposta il valore
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cognome
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * @param cognome the cognome to set
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * @return the idConto
     */
    public int getIdConto() {
        return idConto;
    }

    /**
     * @param idConto the idConto to set
     */
    public void setIdConto(int idConto) {
        this.idConto = idConto;
    }

    
}
