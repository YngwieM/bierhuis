package be.vdab.bierhuis.domain;

public class Brouwer {
    private final int id;
    private final String naam;
    private final String straat;
    private final String huisNummer;
    private final int postcode;
    private final String gemeente;
    private final int omzet;


    public Brouwer(int id, String naam, String straat, String huisNummer, int postcode, String gemeente, int omzet) {
        this.id = id;
        this.naam = naam;
        this.straat = straat;
        this.huisNummer = huisNummer;
        this.postcode = postcode;
        this.gemeente = gemeente;
        this.omzet = omzet;
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

    public int getPostcode() {
        return postcode;
    }

    public String getGemeente() {
        return gemeente;
    }

    public int getOmzet() {
        return omzet;
    }
}
