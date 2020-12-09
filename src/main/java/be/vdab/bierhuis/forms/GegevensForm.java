package be.vdab.bierhuis.forms;

public class GegevensForm {
    private final String naam;
    private final String straat;
    private final String huisNummer;
    private final int postcode;
    private final String gemeente;

    public GegevensForm(String naam, String straat, String huisNummer, int postcode, String gemeente) {
        this.naam = naam;
        this.straat = straat;
        this.huisNummer = huisNummer;
        this.postcode = postcode;
        this.gemeente = gemeente;
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
}
