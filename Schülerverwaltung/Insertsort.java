public class Insertsort {

    public Insertsort() {

    }

    public static List<Schueler> sort(List<Schueler> givenList) {
        List<Schueler> sortedList = new List<Schueler>();
        givenList.toFirst();
        while (!givenList.isEmpty()) {
            if (sortedList.isEmpty()) {
                sortedList.append(givenList.getContent());
                givenList.remove();
            }
            Schueler tempSchueler = givenList.getContent();
            sortedList.toFirst();
            while (sortedList.hasAccess() && tempSchueler != null) {
                if (tempSchueler.getSprung() < sortedList.getContent().getSprung()) {
                    sortedList.insert(tempSchueler);
                    tempSchueler = null;
                }
                if (sortedList.getContent() == null) {
                    sortedList.append(tempSchueler);
                    tempSchueler = null;
                }
                sortedList.next();

            }
        }
        return sortedList;
    }

}