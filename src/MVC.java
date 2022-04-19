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
            int auswahl = scan.nextInt();

            if (auswahl == 1){

                System.out.println("Gib den Namen des Produkts ein");
                String name = scan.next();
                System.out.println("Gib den Preis des Produkts ein");
                double preis = scan.nextDouble();
                Produkt produkt = new Produkt(name, preis);
                preise.nehmeProduktAuf(produkt);
                System.out.println("Produkt erfolgreich aufgenommen");

            } else if (auswahl == 2){

                System.out.println("Gib den Namen des Produkts ein");
                String name = scan.next();
                System.out.println(preise.zeigeProdukt(name).name);
                System.out.println(preise.zeigeProdukt(name).preis);

            }
            if (auswahl == 3){
                exit = true;
            }
        }
    }
}
