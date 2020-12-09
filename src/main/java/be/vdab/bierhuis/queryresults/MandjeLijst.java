package be.vdab.bierhuis.queryresults;

import java.math.BigDecimal;

public class MandjeLijst {

    private final String naam;
    private final BigDecimal prijs;
    private final long aantal;

    public MandjeLijst(String naam, BigDecimal prijs, long aantal) {
        this.naam = naam;
        this.prijs = prijs;
        this.aantal = aantal;
    }

    public String getNaam() {
        return naam;
    }

    public BigDecimal getPrijs() {
        return prijs;
    }

    public long getAantal() {
        return aantal;
    }

    public BigDecimal getTotaal() {
        BigDecimal aantalBig = new BigDecimal(aantal);
        return prijs.multiply(aantalBig);
    }


}
