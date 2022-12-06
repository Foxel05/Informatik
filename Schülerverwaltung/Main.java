import java.util.*;

public class Main {
    static List<Schueler> meineListe = new List<Schueler>();
    static Scanner mS = new Scanner(System.in);
    static MergeSort mergeSort = new MergeSort();
    static ListHandler LH = new ListHandler();
    static SchuelerCreator SC = new SchuelerCreator(meineListe, 100);

    public static void main(String[] args) {

        while (true) {
            System.out.println();
            System.out.println("------------------------------------");
            System.out.println("Willkommen zu der Schuelerverwaltung");
            System.out.println("------------------------------------");
            System.out.println();
            System.out.println("[1] Schüöer anlegen");
            System.out.println("[2] Schüler anzeigen");
            System.out.println("[3] Anzahl der Schüler");
            System.out.println("[4] Schüler löschen");
            System.out.println("[5] Schüler suchen");
            System.out.println("[6] Schüler Werte angeben");
            System.out.println("[7] Schüler Werte sortieren");
            System.out.println("[8] Programm beenden");
            System.out.println();
            int eingabe = mS.nextInt();
            System.out.println();
            System.out.println("Es wird zum Menuepunkt " + eingabe + " gewechselt!");
            System.out.println();

            if (eingabe == 1)
                anlegen();
            else if (eingabe == 2)
                anzeigen(meineListe);
            else if (eingabe == 3)
                showLength();
            else if (eingabe == 4)
                removeObject();
            else if (eingabe == 5)
                findObject();
            else if (eingabe == 6)
                collectResults(meineListe);
            else if (eingabe == 7)
                collectSortedList();
            else if (eingabe == 8)
                System.exit(0);
        } // Ende der while Schleife
    } // Ende der main-Methode

    public static void anlegen() {

        System.out.println("------------------------------------");
        System.out.println("Neuen Schüler anlegen");
        System.out.println("------------------------------------");

        System.out.println(); // Leerzeile
        System.out.println("[Vorname]:");
        System.out.println(); // Leerzeile
        String vorname = mS.next();

        System.out.println(); // Leerzeile
        System.out.println("[Name]:");
        System.out.println(); // Leerzeile
        String name = mS.next();

        System.out.println(); // Leerzeile
        System.out.println("[Alter]:");
        System.out.println(); // Leerzeile
        int alter = mS.nextInt();

        System.out.println(); // Leerzeile
        System.out.println("[Geschlecht]:");
        System.out.println(); // Leerzeile
        char geschlecht = mS.next().charAt(0);

        System.out.println(); // Leerzeile
        System.out.println("[Klasse]:");
        System.out.println(); // Leerzeile
        String klasse = mS.next();

        // Jetzt stehen auf den Variablen name, vorname, alter, geschlecht und klasse
        // die notwendigen Informationen drauf
        Schueler neuerSchueler = new Schueler(vorname, name, alter, geschlecht, klasse, 0, 0, 0);
        meineListe.toLast();
        meineListe.append(neuerSchueler);

    }

    public static void anzeigen(List<Schueler> tempList) {

        System.out.println("------------------------------------");
        System.out.println("Alle Schüler anzeigen");
        System.out.println("------------------------------------");

        LH.listStudentfromList(tempList);

    }

    public static void showLength() {

        System.out.println("------------------------------------");
        System.out.println("Länge der Liste anzeigen");
        System.out.println("------------------------------------");

        String description;
        if (meineListe.getLength() > 1) {
            description = "Es befinden sich ";
        } else {
            description = "Es befindet sich ";
        }
        System.out.println(description + meineListe.getLength() + " Schüler in der Liste");
    }

    public static void findObject() {
        System.out.println("------------------------------------");
        System.out.println("Schüler suchen");
        System.out.println("------------------------------------");

        meineListe.toFirst();
        int i = 0;
        System.out.println("Vornamen eingeben: ");
        String input = mS.next();

        while (meineListe.hasAccess()) {
            if (meineListe.getContent().vorname().equals(input)) {
                System.out.println("Schüler (" + i + ") gefunden mit diesem Vornamen");
                System.out.println("[Vorname]: " + meineListe.getContent().vorname());
                System.out.println("[Name]: " + meineListe.getContent().name());
                System.out.println("[Alter]: " + meineListe.getContent().getAlter());
                System.out.println("[Geschlecht]: " + meineListe.getContent().geschlecht());
                System.out.println("[Klasse]: " + meineListe.getContent().klasse());
            }
            i++;
            meineListe.next();
        }
    }

    public static void removeObject() {
        System.out.println("------------------------------------");
        System.out.println("Schüler löschen (nach Vorname)");
        System.out.println("------------------------------------");

        meineListe.toFirst();
        System.out.println("Vornamen eingeben: ");
        String input = mS.next();

        for (int i = 0; i < meineListe.getLength(); i++) {

            if (!meineListe.getContent().vorname().equals(input)) {
                meineListe.next();

            } else {
                meineListe.remove();
            }

        }
    }

    public static void collectResults(List<Schueler> tempList) {
        System.out.println("------------------------------------");
        System.out.println("Schüler Werte angeben:");
        System.out.println("------------------------------------");
        Schueler tempStudent = null;
        collectResults_selectStudent(tempList, tempStudent);

    }

    public static void collectResults_selectStudent(List<Schueler> tempList, Schueler tempStudent) {
        System.out.println("Schüler von Liste auswählen: ");
        LH.listStudentfromList(tempList);
        int auswahl = mS.nextInt();
        collectResults_selectSport(tempList, LH.cloneStudent(tempList, auswahl));
    }

    public static void collectResults_selectSport(List<Schueler> tempList, Schueler tempStudent) {
        // Sportart auswählen
        System.out.println("Werte in Sportart angeben:");
        System.out.println("---------------------------");
        System.out.println("1. Sprung");
        System.out.println("2. Wurf");
        System.out.println("3. Lauf");
        System.out.println();

        int auswahl = mS.nextInt();

        double angabe;
        if (auswahl == 1) {
            // Sprung
            System.out.println("Sprung an geben:");
            angabe = mS.nextDouble();
            tempStudent.setSprung(angabe);
        } else if (auswahl == 2) {
            // Wurf
            System.out.println("Wurf an geben:");
            angabe = mS.nextDouble();
            tempStudent.setWurf(angabe);
        } else if (auswahl == 3) {
            // Lauf
            System.out.println("Lauf an geben:");
            angabe = mS.nextDouble();
            tempStudent.setLauf(angabe);
        }

        collectResults_Save(tempList, tempStudent);
    }

    public static void collectResults_Save(List<Schueler> tempList, Schueler tempStudent) {
        System.out.println();
        System.out.println(
                "Anderen Schülerauswählen [s], andere Sportart wählen [w], beenden (und speichern) [e], beenden (nicht speichern) [f]");
        char tempchar = mS.next().charAt(0);
        System.out.println(tempchar);

        if (tempchar != 's' && tempchar != 'w' && tempchar != 'e' && tempchar != 'f') {
            System.out.println("Falsches Zeichen!");
            collectResults_Save(tempList, tempStudent);
        } else if (tempchar == 's') {
            LH.exchangeStudentData(meineListe, tempStudent);
            collectResults_selectStudent(tempList, tempStudent);
        } else if (tempchar == 'w') {
            collectResults_selectSport(tempList, tempStudent);
        } else if (tempchar == 'e') {
            LH.exchangeStudentData(meineListe, tempStudent);
        }
    }

    public static void collectSortedList() {
        System.out.println("------------------------");
        System.out.println("Liste sortieren");
        System.out.println("------------------------");
        System.out.println();
        System.out.println("Sortieren nach Sprung, Lauf oder Wurf?");
        String tempterm = mS.next();
        System.out.println("Sortieren aufsteigend [up] oder absteigend [down]");
        String tempdirection = mS.next();
        System.out.println("Neue Sortierung der Schüler: ");
        LH.listStudentfromList(mergeSort.mergeSort(meineListe, tempterm, tempdirection));
    }
}