package be.vdab.bierhuis.domain;

import java.math.BigDecimal;

public class BestelBonLijn {
    private final long bestelBonId;
    private final long bierId;
    private final long aantal;
    private final BigDecimal prijs;

    public BestelBonLijn(long bestelBonId, long bierId, long aantal, BigDecimal prijs) {
        this.bestelBonId = bestelBonId;
        this.bierId = bierId;
        this.aantal = aantal;
        this.prijs = prijs;
    }

    public long getBestelBonId() {
        return bestelBonId;
    }

    public long getBierId() {
        return bierId;
    }

    public long getAantal() {
        return aantal;
    }

    public BigDecimal getPrijs() {
        return prijs;
    }
}
