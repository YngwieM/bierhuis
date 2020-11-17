package be.vdab.bierhuis.domain;

import java.math.BigDecimal;

public class Bier {
    private final int id;
    private final String naam;
    private final int brouwerId;
    private final int soortId;
    private final BigDecimal alcohol;
    private final BigDecimal prijs;
    private final int besteld;

    public Bier(int id, String naam, int brouwerId, int soortId, BigDecimal alcohol, BigDecimal prijs, int besteld) {
        this.id = id;
        this.naam = naam;
        this.brouwerId = brouwerId;
        this.soortId = soortId;
        this.alcohol = alcohol;
        this.prijs = prijs;
        this.besteld = besteld;
    }

    public int getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public int getBrouwerId() {
        return brouwerId;
    }

    public int getSoortId() {
        return soortId;
    }

    public BigDecimal getAlcohol() {
        return alcohol;
    }

    public BigDecimal getPrijs() {
        return prijs;
    }

    public int getBesteld() {
        return besteld;
    }
}


