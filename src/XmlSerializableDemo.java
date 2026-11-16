import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.io.Serializable;

public class XmlSerializableDemo {

    // Bean-klasse der implementerer Serializable
    public static class Person implements Serializable {
        private String navn;
        private int alder;

        public Person() { } // påkrævet: default-konstruktør

        public Person(String navn, int alder) {
            this.navn = navn;
            this.alder = alder;
        }

        public String getNavn() { return navn; }
        public void setNavn(String navn) { this.navn = navn; }
        public int getAlder() { return alder; }
        public void setAlder(int alder) { this.alder = alder; }

        @Override
        public String toString() {
            return "Person{navn='" + navn + "', alder=" + alder + "}";
        }
    }

    public static void main(String[] args) throws IOException {
        Person p = new Person("Erik", 42);

        // 1) Gem som XML
        try (XMLEncoder enc = new XMLEncoder(
                new BufferedOutputStream(new FileOutputStream("person.xml")))) {
            enc.writeObject(p);
        }
        System.out.println("Gemt i person.xml");

        // 2) Indlæs fra XML
        Person laast;
        try (XMLDecoder dec = new XMLDecoder(
                new BufferedInputStream(new FileInputStream("person.xml")))) {
            laast = (Person) dec.readObject();
        }
        System.out.println("Indlæst: " + laast);
    }
}