public class Selectionsort {

    public Selectionsort() {

    }

    public static List<Schueler> sort(List<Schueler> givenList) {
        List<Schueler> sortedList = new List<Schueler>();
        double gemerkterWert;
        while (!givenList.isEmpty) {
            givenList.toFirst();
            gemerkterWert = givenList.getContent().getSprung();
            while (givenList.hasAccess()) {
                givenList.next();
                if (gemerkterWert > givenList.getContent().getSprung()) {
                    gemerkterWert = givenList.getContent().getSprung();
                }
            }
            givenList.toFirst();
            while (given.hasAccess() && givenList.getContent().getSprung() != gemerkterWert) givenList.next();
            sortedList.append(givenList.getContent());
            givenList.remove();
        }
        return sortedList;
    }

}