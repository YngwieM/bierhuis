package be.vdab.bierhuis.queryresults;

import be.vdab.bierhuis.domain.Bier;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Mand {

    private List<MandjeLijst> items = new ArrayList<>();
    private BigDecimal totaal = new BigDecimal(0);

    public void voegToe(Bier bier, long aantal) {
        items.add(new MandjeLijst(bier.getNaam(), bier.getPrijs(),aantal));
    }

    public List<MandjeLijst> getItems() {
        return items;
    }


    public BigDecimal getTotaalPrijs() {
        for (var item : items) {
            totaal = totaal.add(item.getTotaal());
        }
        return totaal;

    }
}
