package models;

public class Oeuf {

    private Ovipare pere;
    private Ovipare mere;

    public Oeuf(Ovipare pere, Ovipare mere){
        this.pere = pere;
        this.mere = mere;
    }

    public Ovipare getPere() {
        return pere;
    }

    public Ovipare getMere() {
        return mere;
    }
}
