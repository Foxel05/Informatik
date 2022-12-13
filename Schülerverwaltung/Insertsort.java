public class InsertSort {

    public InsertSort() {

    }

    public List<Schueler> InsertSort(List<Schueler> givenList) {
        if (givenList.getLength() == 1)
            return givenList; // Wenn die Liste nur einen Schüler beinhaltet, zurück (da man schlecht nur eine
                              // Sache sortieren kann)

        List<Schueler> copyList = givenList

        givenList.toFirst();
        givenList.next();
        copyList.toFirst();
        Schueler givenListStudent = givenList.getContent(); 
        Schueler copyListStudent = copyList.getContent();

        Schueler tempStudent;
        while (givenList.hasAccess()){
            tempStudent = givenList.current;
            copyListStudent = back(givenList, tempStudent);
            while (copyList != null && copyListStudent.getSprung() > tempStudent.getSprung()){
                givenList.setContent(copyListStudent);
                copyListStudent = back(givenList, copyListStudent);
            }
            while ()
        }
    }

    public Schueler back(List<Schueler> givenList, Schueler tempStudent){
        givenList.toFirst();
        if (givenList.first == tempStudent) return null;
        while (givenList.current.getNextNode().getContent() != tempStudent){
            givenList.next();
        }
        return givenList.current;
    }

}