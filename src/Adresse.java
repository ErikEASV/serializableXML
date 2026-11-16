import java.io.Serializable;

public class Adresse implements Serializable {
    // id til serialisering skal være unikt for hver klasse
    private static final long serialVersionUID = 1L;

    private String vej;
    private int postnr;
    private String by;

    public Adresse() {}

    public Adresse(String vej, int postnr, String by) {
        this.vej = vej;
        this.postnr = postnr;
        this.by = by;
    }

    public void setVej(String vej) {
        this.vej = vej;
    }

    public void setPostnr(int p) {
        postnr = p;
    }

    public void setBy(String b) {
        by = b;
    }

    public String getVej() {
        return vej;
    }

    public int getPostnr() {
        return postnr;
    }

    public String getBy() {
        return by;
    }


    @Override
    public String toString() {
        return vej+" "+postnr+" "+by+" /";
    }

}