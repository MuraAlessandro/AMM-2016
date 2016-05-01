package milestone.classi;


import milestone.classi.Utente;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ale
 */
public class Venditore extends Utente {
    
    private String impresa;//nome dell'impresa che vende il prodotto


    /**
     * @return the impresa
     */
    public String getImpresa() {
        return impresa;
    }

    /**
     * @param impresa the impresa to set
     */
    public void setImpresa(String impresa) {
        this.impresa = impresa;
    }
    
    public void vendi(Venditore venditore, ObjectSale object){
              venditore.getConto().saldo=venditore.conto.getSaldo()+object.getPrice();
    }
}
