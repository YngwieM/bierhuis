package be.vdab.bierhuis.domain;

public class Soorten {
    private final int id;
    private final String naam;

    public int getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public Soorten(int id, String naam) {
        this.id = id;
        this.naam = naam;
    }
}
