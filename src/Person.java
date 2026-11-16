import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// Der skal være set- og getmetoder til alle de instansvariable,
// der ønskes serialiseret

public class Person implements Serializable {
    // id til serialisering skal være unikt for hver klasse
    private static final long serialVersionUID = 2L;

    private int id;
    private String navn;
    private List<Adresse> adresser = new ArrayList<Adresse>();

    public Person() {}

    public Person(int id, String navn) {
        this.id = id;
        this.navn = navn;
    }

    public void setId(int i) {
        id = i;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getNavn() {
        return navn;
    }

    public int getId() {
        return id;
    }

    public void tilknytAdresse(Adresse adr) {
        adresser.add(adr);
    }

    public void setAdresser(ArrayList<Adresse> liste) {
        adresser = liste;
    }

    public List<Adresse> getAdresser() {
        return adresser;
    }

    @Override
    public String toString() {
        String al = "";
        for (Adresse a : adresser) al += " "+a;
        return id+" "+navn+" "+ al;
    }

}
