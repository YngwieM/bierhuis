package be.vdab.bierhuis.forms;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class GegevensForm {
    @NotBlank
    private final String naam;
    @NotBlank
    private final String straat;
    @NotBlank
    private final String huisNummer;
    @Min(1000)
    @Max(9999)
    private final int postcode;
    @NotBlank
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
