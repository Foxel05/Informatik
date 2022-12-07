public class MergeSort {

    public MergeSort() {

    }

    public List<Schueler> mergeSort(List<Schueler> givenList) {
        if (givenList.getLength() == 1)
            return givenList; // Wenn die Liste nur einen Schüler beinhaltet, zurück (da man schlecht nur eine
                              // Sache sortieren kann)

        Schueler tempSchueler = givenList.toLast().getContent();

        givenList.toFirst();

        int i = 0;
        List<Schueler> ersteListe = new List<Schueler>();
        List<Schueler> zweiteListe = new List<Schueler>();

        while (givenList.hasAccess()) {
            if (givenList.getContent().getSprung() < tempSchueler.getSprung()){
                ersteListe.append(givenList.getContent());
            } else if (givenList.getContent().getSprung() > tempSchueler.getSprung()){
                zweiteListe.append(givenList.getContent());
            }
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

}