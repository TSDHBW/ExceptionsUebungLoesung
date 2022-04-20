public class Preisverwaltung {

    private Produkt[] preise;
    int index;

    public Preisverwaltung (int anzahl){

        preise = new Produkt[anzahl];
        index = 0;

    }

    public void nehmeProduktAuf (Produkt produkt){

        // Bringt das Risiko von ArrayOutOfBoundExceptions, da der Index nicht an die Länge des Arrays gekoppelt ist
        // und daher versucht werden kann ein Produkt in das Array zu legen, obwohl es bereits voll ist
        if (index < preise.length){
            preise[index] = produkt;
            index++;
        } else {
            System.out.println("Es kann kein neues Produkt aufgenommen werden");
        }
        // Für eine optimale Benutzerführung wäre die Prüfung der Aufnahme vor Eingabe des Namens und des Preises besser

    }

    public Produkt zeigeProdukt (String name){

        for (int i = 0; i < preise.length; i++){
            if (preise[i] != null && preise[i].name.equals(name)){

                return preise[i];

            }
        }
        return null;
    }
}
