import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

// Dette er et eksempel på serialiseing med XML-fil i sin enkleste form
// med beans' XML encoder. Der kan ikke laves tags, men det kræver ikke yderligere biblioteker.
// Bemærk, at modelklasserne skal have:
// - set og get metoder med korrekte navne og paramtre
// - en tom konstruktør (!)
// EK nov 2026

public class XmlSerializableDemo {


    public static void main(String[] args) throws IOException {
        Person p = new Person(42,"Erik");
        Adresse a = new Adresse("Godvej", 5666, "Sydby");
        p.tilknytAdresse(a);
        p.tilknytAdresse(new Adresse("Langgade", 4800, "Nykøbing F"));

        // 1) Gem som XML
        try (XMLEncoder enc = new XMLEncoder(
                new BufferedOutputStream(new FileOutputStream("person.xml")))) {
            enc.writeObject(p);
        }
        System.out.println("Gemt i person.xml");

        // -----

        // 2) Indlæs fra XML
        Person laast;
        try (XMLDecoder dec = new XMLDecoder(
                new BufferedInputStream(new FileInputStream("person.xml")))) {
            laast = (Person) dec.readObject();
        }
        System.out.println("Indlæst: " + laast);
    }
}