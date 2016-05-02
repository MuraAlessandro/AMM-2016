package milestone.classi;

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
public class Cliente extends Utente
{
 /*   private String foto;
    //vendi
    
    /**
     * @return the foto
     */
   /* public String getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
   /* public void setFoto(String foto) {
        this.foto = foto;
    }*/
    public Boolean compra(Cliente cliente, ObjectSale object, ArrayList<ObjectSale> objects){
        Boolean saldoOk;
        if(object.getPrice()<=cliente.getConto().getSaldo())
        {
                saldoOk=true;
                cliente.getConto().saldo=cliente.getConto().getSaldo()-object.getPrice();
                for(ObjectSale u : objects){            
                    if((object.getId()).equals(u.id)&& object.getQ()>1)
                      object.setQ(object.getQ()-1);
                    else 
                     // if((object.getId()).equals(u.id)&& object.getQ().equals(1))
                               objects.remove(object); 
              }
        }
        else
            saldoOk=false;
        return saldoOk;
    }
}
