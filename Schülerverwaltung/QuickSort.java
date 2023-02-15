public class QuickSort {

    public QuickSort() {

    }

    public List<Schueler> sort(List<Schueler> givenList) {
        if (givenList.getLength() == 1)
            return givenList; // Wenn die Liste nur einen Schüler beinhaltet, zurück (da man schlecht nur eine
                              // Sache sortieren kann)
        givenList.toLast();
        Schueler tempSchueler = givenList.getContent();

        givenList.toFirst();

        List<Schueler> ersteListe = new List<Schueler>();
        List<Schueler> zweiteListe = new List<Schueler>();

        while (givenList.hasAccess()) {
            if (givenList.getContent().getSprung() < tempSchueler.getSprung()) {
                ersteListe.append(givenList.getContent());
            } else if (givenList.getContent().getSprung() > tempSchueler.getSprung()) {
                zweiteListe.append(givenList.getContent());
            }
            givenList.next();
        }

        ersteListe = sort(ersteListe);
        zweiteListe = sort(zweiteListe);

        ersteListe.toFirst();
        zweiteListe.toFirst();

        List<Schueler> newList = new List<Schueler>();
        List<Schueler> emptyList = new List<Schueler>();

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
        return newList;
    }

    public List<Schueler> sort2(List<Schueler> givenList) {
        givenList.toFirst();
        if (givenList.length() > 3) {
            Schueler Pivot = givenList.getContent();
            givenList.remove();

            List<Schueler> vorPivotListe = new List<Schueler>;
            List<Schueler> nachPivotListe = new List<Schueler>;

            while (!givenList.isEmpty()) {
                if (givenList.getContent().getSprung() < Pivot.getSprung() ) {
                    vorPivotListe.append(givenList.getContent());
                }
                else {
                    nachPivotListe.append(givenList.getContent());
                }
                givenList.remove();
            }
            vorPivotListe.append(Pivot);
            vorPivotListe.concat(nachPivotListe);
            return vorPivotListe;
        }
        else {
            Schueler ZwischenGespeicherterSchüler = givenList.getContent();
            givenList.next();
            if (ZwischenGespeicherterSchüler == null || givenList.getPrevious() == ZwischenGespeicherterSchüler) {
                return givenList;
            }
            else {
                givenList.toFirst();
                while (givenList.getContent() != ZwischenGespeicherterSchüler) givenList.next();
                givenList.remove();
                givenList.append(ZwischenGespeicherterSchüler);
            }
        }
    }

}