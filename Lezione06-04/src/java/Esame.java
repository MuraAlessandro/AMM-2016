/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ale
 */
public class Esame 
{
    
    private String nomeStudente;
    private String cognomeStudente;
    private String matricola;
    private String nomeEsame;
    private String voto;
    private String note;

    //costruttore
    public Esame ()
    {
        nomeStudente="";
        cognomeStudente="";
        matricola="";
        nomeEsame="";
        voto="";
        note="_";
    }
    /**
     * @return the nomeStudente
     */
    public String getNomeStudente() {
        return nomeStudente;
    }

    /**
     * @param nomeStudente the nomeStudente to set
     */
    public void setNomeStudente(String nomeStudente) {
        this.nomeStudente = nomeStudente;
    }

    /**
     * @return the cognomeStudente
     */
    public String getCognomeStudente() {
        return cognomeStudente;
    }

    /**
     * @param cognomeStudente the cognomeStudente to set
     */
    public void setCognomeStudente(String cognomeStudente) {
        this.cognomeStudente = cognomeStudente;
    }

    /**
     * @return the matricola
     */
    public String getMatricola() {
        return matricola;
    }

    /**
     * @param matricola the matricola to set
     */
    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    /**
     * @return the nomeEsame
     */
    public String getNomeEsame() {
        return nomeEsame;
    }

    /**
     * @param nomeEsame the nomeEsame to set
     */
    public void setNomeEsame(String nomeEsame) {
        this.nomeEsame = nomeEsame;
    }

    /**
     * @return the voto
     */
    public String getVoto() {
        return voto;
    }

    /**
     * @param voto the voto to set
     */
    public void setVoto(String voto) {
        this.voto = voto;
    }

    /**
     * @return the nota
     */
    public String getNota() {
        return note;
    }

    /**
     * @param nota the nota to set
     */
    public void setNota(String nota) {
        this.note = note;
    }
    
}
