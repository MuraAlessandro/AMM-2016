/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package milestone.classi;

/**
 *
 * @author Ale
 */

public class ObjectSale {

    Integer id;
    private String nome;
    private String url;
    private String descrizione;
    private Integer q;//quantità
    private Double price;
    private Integer idVenditore;
    
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
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
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the descrizione
     */
    public String getDescrizione() {
        return descrizione;
    }

    /**
     * @param descrizione the descrizione to set
     */
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    /**
     * @return the q
     */
    public Integer getQ() {
        return q;
    }

    /**
     * @param q the q to set
     */
    public void setQ(Integer q) {
      //  if(q >= 1)
            this.q = q;
      //  else
        //    this.q=1;
        
    }

    /**
     * @return the price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Double price) {
       // if(price >= 0.0)
            this.price = price;
       // else
       //     this.price=0.0;
    }

    /**
     * @return the idVenditore
     */
    public Integer getIdVenditore() {
        return idVenditore;
    }

    /**
     * @param idVenditore the idVenditore to set
     */
    public void setIdVenditore(Integer idVenditore) {
        this.idVenditore = idVenditore;
    }

    
}
