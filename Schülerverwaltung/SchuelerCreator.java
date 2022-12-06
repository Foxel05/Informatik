import com.oracle.jrockit.jfr.ContentType;
import java.io.*;
import java.util.*;

public class SchuelerCreator {

    static List<Schueler> meineListe = new List<Schueler>();
    String[] Svornamen = { "Simon", "Tim", "Lukas", "Magnus", "Conrad", "Lion", "Nico", "Andreas", "Arnold", "Paul",
            "Richard", "Timo", "Alex", "Felix", "Carlotta", "Lina", "Paulina", "Timo", "Finn", "Fynn", "Torben",
            "Leon" };
    String[] Snamen = { "Kebekus", "Rix", "Tempelmann", "Rutenbeck", "Klinkmann", "Sauerbier", "Müller", "Meier",
            "Schmidt", "Bäcker", "Lange", "Kurze", "Schneider", "Wortmann", "Koch", "Dick", "Stubbe" };

    public SchuelerCreator(List<Schueler> tempList, int plimit) {
        meineListe = tempList;
        create(plimit);
    }

    public void create(int limit) {
        int i = 0;
        while (i != limit) {
            i++;
            meineListe.append(new Schueler(Svornamen[(int) (Math.random() * Svornamen.length)],
                    Snamen[(int) (Math.random() * Snamen.length)], 16, 'w', "11", Math.random() * 12,
                    Math.random() * 12, Math.random() * 12));
        }
    }

}
