package be.vdab.bierhuis.domain;

public class Bestelbon {
    private final int id;
    private final String naam;
    private final String straat;
    private final String huisNummer;
    private final String postcode;
    private final String gemeente;

    public Bestelbon(int id, String naam, String straat, String huisNummer, String postcode, String gemeente) {
        this.id = id;
        this.naam = naam;
        this.straat = straat;
        this.huisNummer = huisNummer;
        this.postcode = postcode;
        this.gemeente = gemeente;
    }

    public int getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public String getStraat() {
        return straat;
    }

    public String getHuisNummer() {
        return huisNummer;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getGemeente() {
        return gemeente;
    }
}
