package be.vdab.bierhuis.sessions;

import be.vdab.bierhuis.domain.BestelBonLijn;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Component
@SessionScope
public class Mandje implements Serializable {
    private static final long serialVersionUID = 1L;

private final List<BestelBonLijn> bestelLijnLijst = new ArrayList<BestelBonLijn>();

    private final Set<Long> ids = new LinkedHashSet<>();
    public void voegLijnToe(long id, long aantal, BigDecimal prijs) {
        bestelLijnLijst.add(new BestelBonLijn(0,id,aantal,prijs));
    }

    public List<BestelBonLijn> getBestelLijnLijst() {
        return bestelLijnLijst;
    }
    public Set<Long> getIds() {
        return ids;
    }
}
