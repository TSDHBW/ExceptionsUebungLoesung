import java.util.InputMismatchException;
import java.util.Scanner;

public class MVC {

    public static void main(String[] args) {

        Preisverwaltung preise = new Preisverwaltung(5);

        Scanner scan = new Scanner(System.in);

        boolean exit = false;

        while (!exit){

            System.out.println("Aktion auswählen");
            System.out.println("1: Produkt aufnehmen");
            System.out.println("2: Produkt anzeigen");
            System.out.println("3: Beenden");
            // Falls kein Int eingegeben wird, entsteht eine InputMismachtException, die abzufangen ist
            int auswahl=0;
            boolean auswahlErfolg = false;
            // Schleife läuft mind. 1x mit dem Ziel über einen Try-Catch Konstrukt fehlerhafte Eingaben z.B. von Buchstaben
            // abzufangen. die Schleife läuft so lange bis eine korrekte Eingabe erfolgt ist.
            do {
                try {
                    auswahl = scan.nextInt();
                    auswahlErfolg = true;
                } catch (InputMismatchException e){
                    //scan.next sorgt dafür, dass die fehlerhafte Eingabe aus dem Puffer gelöscht wird.
                    System.out.println(scan.next() + " ist Keine gültige Auswahl. Bitte 1,2 oder 3 eingeben");
                }
            } while (!auswahlErfolg);

            if (auswahl == 1){

                System.out.println("Gib den Namen des Produkts ein");
                // Je nach Art der verwalteten Produktpreise kann es Sinn machen die Eingabe des Namens gesondert zu
                // behandeln z.B. um eine Eingabe von Zahlen zu verhindern
                String name = scan.next();
                System.out.println("Gib den Preis des Produkts ein");
                // Falls kein Double oder implizit konvertierbarer Wert (z.B: int) eingegeben wird, entsteht eine
                // InputMismatchException, die abzufangen ist
                double preis =0.0;
                auswahlErfolg = false;
                // Schleife läuft mind. 1x mit dem Ziel über einen Try-Catch Konstrukt fehlerhafte Eingaben z.B. von Buchstaben
                // abzufangen. die Schleife läuft so lange bis eine korrekte Eingabe erfolgt ist.
                do {
                    try {
                        preis = scan.nextDouble();
                        auswahlErfolg = true;
                    } catch (InputMismatchException e){
                        //scan.next sorgt dafür, dass die fehlerhafte Eingabe aus dem Puffer gelöscht wird.
                        //Prüfung auf negative Werte kann inhaltlich zusätzlich ergänzt werden.
                        System.out.println(scan.next() + " ist Keine gültige Auswahl. Bitte eine Zahl eingeben");
                    }
                } while (!auswahlErfolg);

                Produkt produkt = new Produkt(name, preis);
                preise.nehmeProduktAuf(produkt);
                System.out.println("Produkt erfolgreich aufgenommen");

            } else if (auswahl == 2){

                System.out.println("Gib den Namen des Produkts ein");
                // Prüfen warum NullPointerException -> ggf. durch .equals?
                String name = scan.next();
                // zeigeProdukt(name) kann ein null zurückgeben, falls kein Produkt gefunden wird. Ohne Behandlung
                // entsteht bei den Ausgaben eine NUllPointerException, da "null" kein Namen oder Preis hat.
                if (preise.zeigeProdukt(name) != null){

                    System.out.println(preise.zeigeProdukt(name).name);
                    System.out.println(preise.zeigeProdukt(name).preis);

                } else {
                    System.out.println("Produkt nicht gefunden. Bitte Name prüfen");
                }
            }
            if (auswahl == 3){
                exit = true;
            }
            // Ergänzung für ungültige Auswahl.
            if (auswahl != 1 & auswahl !=2 & auswahl !=3 ){

                System.out.println("Ungültige Auswahl");

            }
        }
        scan.close();
    }
}
