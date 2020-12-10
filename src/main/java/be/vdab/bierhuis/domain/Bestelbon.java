package be.vdab.bierhuis.domain;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Bestelbon {
    @NotBlank
    private final int id;
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

    public Bestelbon(@NotBlank int id,@NotBlank String naam,@NotBlank String straat,@NotBlank String huisNummer, int postcode,@NotBlank String gemeente) {
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

    public int getPostcode() {
        return postcode;
    }

    public String getGemeente() {
        return gemeente;
    }
}
