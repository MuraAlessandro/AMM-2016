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
    //mi restituisce un booleano che mi indica che l'utente ha abbastanza soldi
    public Boolean compra(Cliente cliente, ObjectSale object, ArrayList<ObjectSale> objects){
        Boolean saldoOk;
        if(object.getPrice()<=cliente.getConto().getSaldo())
        {
                saldoOk=true;
                cliente.getConto().saldo=cliente.getConto().getSaldo()-object.getPrice();
                
        }
        else
            saldoOk=false;
        return saldoOk;
    }
}
