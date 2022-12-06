public class ListHandler {

    public ListHandler() {

    }

    public void exchangeStudentData(List<Schueler> tempList, Schueler x) {
        tempList.toFirst();
        while (tempList.getContent() != x) {
            tempList.next();
        }
        tempList.setContent(x);
    }

    public void listStudentfromList(List<Schueler> tempList) {
        tempList.toFirst();
        int i = 0;

        while (tempList.hasAccess()) {
            i++;
            System.out.println(i + ": [Name]: " + tempList.getContent().vorname() + " " + tempList.getContent().name());
            tempList.next();
        }
    }

    public Schueler cloneStudent(List<Schueler> tempList, int auswahl) {
        tempList.toFirst();
        System.out.println("Schüler (" + auswahl + ") ausgewählt!");
        int i = 0;

        while (i == auswahl) {
            i++;
            tempList.next();
        }

        Schueler tempStudent = tempList.getContent();

        return tempStudent;
    }
}
