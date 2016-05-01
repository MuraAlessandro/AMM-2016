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
public class ObjectSaleFactory {
    
    
 // Attributi
    private static ObjectSaleFactory singleton;
    public static ObjectSaleFactory getInstance() {
        if (singleton == null) {
            singleton = new ObjectSaleFactory();
        }
        return singleton;
        
        
    }    
    
    private ArrayList<ObjectSale> objects = new ArrayList<ObjectSale>();   
    
    
    public ObjectSaleFactory (){
        ObjectSale obj1 = new ObjectSale();
        obj1.setId(0);
        obj1.setNome("Scarpa tacco Bm2004");
        obj1.setDescrizione("Colore: Celeste\n" +
                            "Materiale suola: Gomma\n" +
                            "Altezza tacco: 14 cm\n" +
                            "Tipo di tacco: Tacco A Spillo\n" +
                            "Composizione materiale: Sintetico\n"+
                            "Uso: Ottime per essere eleganti al mare e in piscina");
        obj1.setPrice(599.99);
        obj1.setQ(13);
        obj1.setUrl("IMG/ta.png");
        obj1.setIdVenditore(0);
        objects.add(obj1);
        
        
        ObjectSale obj2 = new ObjectSale();
        obj2.setId(1);
        obj2.setNome("Scarpa antinfortunistica mod.3796");
        obj2.setDescrizione("Colore: Nero\n" +
                            "Tomaia: Vitello Scamosciato\n" +
                            "Fodera: Air Mesh\n" +
                            "Suola: Poliuterano e Gomma\n" +
                            "Puntale: Alluminio mis. 10\n" +
                            "Lamina: Non metallica\n" +
                            "Plantare: Eva forata");
        obj2.setPrice(120.00);
        obj2.setQ(3);
        obj2.setUrl("IMG/ant1.png");
        obj2.setIdVenditore(1);
        objects.add(obj2);
        
        ObjectSale obj3 = new ObjectSale();
         obj3.setId(2);
        obj3.setNome("Scarpa tacco mod. XD-acrobat");
        obj3.setDescrizione("Materiale esterno: Sintetico\n" +
                            "Altezza tacco: 25 cm\n" +
                            "Tipo di tacco: Tacco a spillo\n" +
                            "Composizione materiale: Sintetico effetto pelle/camoscio");
        obj3.setPrice(985.00);
        obj3.setQ(7);
        obj3.setUrl("IMG/tacco.png");
        obj3.setIdVenditore(0);
        objects.add(obj3);

        ObjectSale obj4 = new ObjectSale();
         obj4.setId(3);
        obj4.setNome("Skechers Prospeed 52086 BKSL");
        obj4.setDescrizione("Materiale esterno: Sintetico\n" +
                            "Fodera: Sintetico\n" +
                            "Materiale suola: Gomma\n" +
                            "Chiusura: Stringata\n" +
                            "Peso articolo: 340 g");
        obj4.setPrice(74.90);
        obj4.setQ(11);
        obj4.setUrl("IMG/sport.png");
        obj4.setIdVenditore(1);
        objects.add(obj4);
        
        
        ObjectSale obj5 = new ObjectSale();
        obj5.setId(4);
        obj5.setNome("Ecco sandalo uomo");
        obj5.setDescrizione("Materiale esterno: Pelle\n" +
                            "Fodera: Sintetico\n" +
                            "Materiale suola: Plastica\n" +
                            "Chiusura: A strappo\n" +
                            "Altezza tacco: 2 cm\n" +
                            "Tipo di tacco: Senza tacco\n" +
                            "Composizione materiale: Pelle nabuk/olio Nubuc\n" +
                            "Calzata: Vestibilità normale\n" +
                            "Larghezza scarpa: Normale");
        obj5.setPrice(34.90);
        obj5.setQ(2);
        obj5.setUrl("IMG/san.png");
        obj5.setIdVenditore(1);
        objects.add(obj5);
        
        ObjectSale obj6 = new ObjectSale();
         obj6.setId(5);
        obj6.setNome("Scarpa Prada mod.666");
        obj6.setDescrizione("Materiale esterno: Pelle\n" +
                            "Fodera: Pelle\n" +
                            "Materiale suola: Gomma\n" +
                            "Chiusura: Stringata");
        obj6.setPrice(999.99);
        obj6.setQ(5);
        obj6.setUrl("IMG/eleg.png");
        obj6.setIdVenditore(1);
        objects.add(obj6);
        
        ObjectSale obj7 = new ObjectSale();
         obj7.setId(6);
        obj7.setNome("Scarpa tacco mod.E710");
        obj7.setDescrizione("Materiale suola: Gomma e Acciaio\n" +
                            "Chiusura: Senza chiusura\n" +
                            "Altezza tacco: 16 cm\n" +
                            "Tipo di tacco: Tacco A Spillo");
        obj7.setPrice(1200.99);
        obj7.setQ(1);
        obj7.setUrl("IMG/tac.png");
        obj7.setIdVenditore(0);
        objects.add(obj7);
        
        ObjectSale obj8 = new ObjectSale();
         obj8.setId(7);
        obj8.setNome("Scarpe da ginnastica luminose I Minions");
        obj8.setDescrizione("Divertenti, blu e gialli... hai indovinato? Ma sì, sono 'I Minions'! \n" +
                            "- Scarpe da ginnastica 'I Minions' \n" +
                            "- Chiusura con 2 cinturini a strappo di vernice \n" +
                            "- Inserti effetto 'mesh' \n" +
                            "- Patch effetto plastificato 'I Minions' \n" +
                            "- Giro caviglia imbottito \n" +
                            "- Tacca di flessione davanti \n" +
                            "- Suola antiscivolo");
        obj8.setPrice(45.00);
        obj8.setQ(17);
        obj8.setUrl("IMG/bimbo.png");
        obj8.setIdVenditore(1);
        objects.add(obj8);
    }
    
    public ObjectSale getObjectSaleById(int id){
        for(ObjectSale u : objects)
        {
            if(u.id == id)
                return u;
        }   
        return null;
    }
    
    
    public ArrayList<ObjectSale> getSellingObjectList(){
        return objects;
    }
    
    

    
}
