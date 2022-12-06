import java.util.*;

public class Main {
    static Scanner mS = new Scanner(System.in);
    static List<Schueler> meineListe = new List<Schueler>();

    public static void main(String[] args) {

        meineListe.append(new Schueler("Simon", "Kebekus", 17, 'm', "11", 2, 23, 226));
        meineListe.append(new Schueler("Tim", "Rix", 17, 'm', "11", 2, 3, 16));
        meineListe.append(new Schueler("Emil", "Kirk", 17, 'm', "11", 2, 3, 14));
        meineListe.append(new Schueler("Nico", "Goehr", 16, 'm', "11", 2, 3, 12));
        meineListe.append(new Schueler("Lukas", "Rutenbeck", 15, 'm', "11", 2, 3, 13));
        meineListe.append(new Schueler("Magnus", "Temeplmann", 17, 'm', "11", 2, 3, 27));

        while (true) {
            Scanner mS = new Scanner(System.in);
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
                anzeigen();
            else if (eingabe == 3)
                showLength();
            else if (eingabe == 4)
                removeObject();
            else if (eingabe == 5)
                findObject();
            else if (eingabe == 6)
                collectResults();
            else if (eingabe == 7)
                meineListe = mergeSort(meineListe, "Sprung", "down");
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

    public static void anzeigen() {

        System.out.println("------------------------------------");
        System.out.println("Alle Schüler anzeigen");
        System.out.println("------------------------------------");

        listStudent();

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

    public static void collectResults() {
        System.out.println("------------------------------------");
        System.out.println("Schüler Werte angeben:");
        System.out.println("------------------------------------");
        Schueler tempStudent = null;
        collectResults_selectStudent(tempStudent);

    }

    public static void collectResults_selectStudent(Schueler tempStudent) {
        tempStudent = selectStudent();
        collectResults_selectSport(tempStudent);
    }

    public static void collectResults_selectSport(Schueler tempStudent) {
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

        collectResults_Save(tempStudent);
    }

    public static void collectResults_Save(Schueler tempStudent) {
        System.out.println();
        System.out.println(
                "Anderen Schülerauswählen [s], andere Sportart wählen [w], beenden (und speichern) [e], beenden (nicht speichern) [f]");
        char tempchar = mS.next().charAt(0);
        System.out.println(tempchar);

        if (tempchar != 's' && tempchar != 'w' && tempchar != 'e' && tempchar != 'f') {
            System.out.println("Falsches Zeichen!");
            collectResults_Save(tempStudent);
        } else if (tempchar == 's') {
            selectStudentend(tempStudent);
            collectResults_selectStudent(tempStudent);
        } else if (tempchar == 'w') {
            collectResults_selectSport(tempStudent);
        } else if (tempchar == 'e') {
            selectStudentend(tempStudent);
        }
    }

    public static List<Schueler> mergeSort(List<Schueler> givenList, String term, String direction) {
        if (givenList.getLength() == 1)
            return givenList; // Wenn die Liste nur einen Schüler beinhaltet, zurück (da man schlecht nur eine
                              // Sache sortieren kann)

        givenList.toFirst();

        int i = 0;
        List<Schueler> ersteListe = new List<Schueler>();
        List<Schueler> zweiteListe = new List<Schueler>();

        while (i < (givenList.getLength() / 2)) {
            i++;
            ersteListe.append(givenList.getContent());
            givenList.next();
        }
        while (givenList.hasAccess()) {
            zweiteListe.append(givenList.getContent());
            givenList.next();
        }

        if (ersteListe.getLength() != 1) {
            ersteListe = mergeSort(ersteListe, term, direction);
        }
        if (zweiteListe.getLength() != 1) {
            zweiteListe = mergeSort(zweiteListe, term, direction);
        }

        ersteListe.toFirst();
        zweiteListe.toFirst();

        List<Schueler> newList = new List<Schueler>();
        List<Schueler> emptyList = new List<Schueler>();

        if (direction.equals("up")) {
            if (term.equals("Sprung")) {
                while (!ersteListe.isEmpty() && !zweiteListe.isEmpty()) {

                    if (ersteListe.getContent().getSprung() > zweiteListe.getContent().getSprung()) {
                        newList.append(zweiteListe.getContent());
                        zweiteListe.remove();
                    } else if (ersteListe.getContent().getSprung() < zweiteListe.getContent().getSprung()) {
                        newList.append(ersteListe.getContent());
                        ersteListe.remove();
                    }
                    if (ersteListe.isEmpty()) {
                        newList.concat(zweiteListe);
                        ersteListe = emptyList;
                    } else if (zweiteListe.isEmpty()) {
                        newList.concat(ersteListe);
                        zweiteListe = emptyList;
                    }
                }
            } else if (term.equals("Wurf")) {
                while (!ersteListe.isEmpty() && !zweiteListe.isEmpty()) {

                    if (ersteListe.getContent().getWurf() > zweiteListe.getContent().getWurf()) {
                        newList.append(zweiteListe.getContent());
                        zweiteListe.remove();
                    } else if (ersteListe.getContent().getWurf() < zweiteListe.getContent().getWurf()) {
                        newList.append(ersteListe.getContent());
                        ersteListe.remove();
                    }
                    if (ersteListe.isEmpty()) {
                        newList.concat(zweiteListe);
                        ersteListe = emptyList;
                    } else if (zweiteListe.isEmpty()) {
                        newList.concat(ersteListe);
                        zweiteListe = emptyList;
                    }
                }
            } else if (term.equals("Lauf")) {
                while (!ersteListe.isEmpty() && !zweiteListe.isEmpty()) {

                    if (ersteListe.getContent().getLauf() > zweiteListe.getContent().getLauf()) {
                        newList.append(zweiteListe.getContent());
                        zweiteListe.remove();
                    } else if (ersteListe.getContent().getLauf() < zweiteListe.getContent().getLauf()) {
                        newList.append(ersteListe.getContent());
                        ersteListe.remove();
                    }
                    if (ersteListe.isEmpty()) {
                        newList.concat(zweiteListe);
                        ersteListe = emptyList;
                    } else if (zweiteListe.isEmpty()) {
                        newList.concat(ersteListe);
                        zweiteListe = emptyList;
                    }
                }
            }
        } else if (direction.equals("down")) {
            if (term.equals("Sprung")) {
                while (!ersteListe.isEmpty() && !zweiteListe.isEmpty()) {

                    if (ersteListe.getContent().getSprung() < zweiteListe.getContent().getSprung()) {
                        newList.append(zweiteListe.getContent());
                        zweiteListe.remove();
                    } else if (ersteListe.getContent().getSprung() > zweiteListe.getContent().getSprung()) {
                        newList.append(ersteListe.getContent());
                        ersteListe.remove();
                    }
                    if (ersteListe.isEmpty()) {
                        newList.concat(zweiteListe);
                        ersteListe = emptyList;
                    } else if (zweiteListe.isEmpty()) {
                        newList.concat(ersteListe);
                        zweiteListe = emptyList;
                    }
                }
            } else if (term.equals("Wurf")) {
                while (!ersteListe.isEmpty() && !zweiteListe.isEmpty()) {

                    if (ersteListe.getContent().getWurf() < zweiteListe.getContent().getWurf()) {
                        newList.append(zweiteListe.getContent());
                        zweiteListe.remove();
                    } else if (ersteListe.getContent().getWurf() > zweiteListe.getContent().getWurf()) {
                        newList.append(ersteListe.getContent());
                        ersteListe.remove();
                    }
                    if (ersteListe.isEmpty()) {
                        newList.concat(zweiteListe);
                        ersteListe = emptyList;
                    } else if (zweiteListe.isEmpty()) {
                        newList.concat(ersteListe);
                        zweiteListe = emptyList;
                    }
                }
            } else if (term.equals("Lauf")) {
                while (!ersteListe.isEmpty() && !zweiteListe.isEmpty()) {

                    if (ersteListe.getContent().getLauf() < zweiteListe.getContent().getLauf()) {
                        newList.append(zweiteListe.getContent());
                        zweiteListe.remove();
                    } else if (ersteListe.getContent().getLauf() > zweiteListe.getContent().getLauf()) {
                        newList.append(ersteListe.getContent());
                        ersteListe.remove();
                    }
                    if (ersteListe.isEmpty()) {
                        newList.concat(zweiteListe);
                        ersteListe = emptyList;
                    } else if (zweiteListe.isEmpty()) {
                        newList.concat(ersteListe);
                        zweiteListe = emptyList;
                    }
                }
            }
        }
        return newList;
    }

    // Weitere Dienste, die einiges vereinfachen!!!
    public static void selectStudentend(Schueler x) {
        meineListe.toFirst();
        while (meineListe.getContent() != x) {
            meineListe.next();
        }
        meineListe.setContent(x);
    }

    public static Schueler selectStudent() {
        System.out.println("Schüler von Liste auswählen: ");
        listStudent();
        int auswahl = mS.nextInt();
        return cloneStudent(auswahl);
    }

    public static void listStudent() {
        meineListe.toFirst();
        int i = 0;

        while (meineListe.hasAccess()) {
            i++;
            System.out.println(
                    i + ": [Name]: " + meineListe.getContent().vorname() + " " + meineListe.getContent().name());
            meineListe.next();
        }
    }

    public static Schueler cloneStudent(int auswahl) {
        meineListe.toFirst();
        System.out.println("Schüler (" + auswahl + ") ausgewählt!");
        int i = 0;

        while (i == auswahl) {
            i++;
            meineListe.next();
        }

        Schueler tempStudent = meineListe.getContent();

        return tempStudent;
    }
}