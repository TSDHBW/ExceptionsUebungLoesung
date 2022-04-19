public class Preisverwaltung {

    private Produkt[] preise;
    int index;

    public Preisverwaltung (int anzahl){

        preise = new Produkt[anzahl];
        index = 0;

    }

    public void nehmeProduktAuf (Produkt produkt){

        preise[index] = produkt;
        index++;

    }

    public Produkt zeigeProdukt (String name){

        for (int i = 0; i < preise.length; i++){

            if (preise[i].name.equals(name)){

                return preise[i];

            }

        }
        return null;

    }



}
