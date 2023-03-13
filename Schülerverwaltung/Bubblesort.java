public class Bubblesort {

    public Bubblesort() {

    }

    public static List<Schueler> sort(List<Schueler> givenList) {
        Schueler copyedschueler = null;
        int i = givenList.length() - 1;
        while (i != 0) {
            givenList.toFirst();
            while (givenList.hasAccess()) {
                copyedschueler = givenList.getContent();
                givenList.remove();
                if (givenList.getContent().getSprung() > copyedschueler.getSprung() && givenList.getContent() != null) {
                    givenList.insert(copyedschueler);
                } else if (givenList.getContent().getSprung() < copyedschueler.getSprung()) {
                    givenList.insert(givenList.getContent());
                    givenList.setContent(copyedschueler);
                }
            }
            i = i - 1;
        }
        return givenList;
    }

}