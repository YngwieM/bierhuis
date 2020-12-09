package be.vdab.bierhuis.sessions;

import be.vdab.bierhuis.domain.BestelBonLijn;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

@Component
@SessionScope
public class Mandje implements Serializable {
    private static final long serialVersionUID = 1L;


private final Set<Long> bestelBonId = new LinkedHashSet<>();

    private final Map<Long, Long> ids = new HashMap<>();

    public void voegToe(long id, long aantal) {
        ids.put(id, aantal);
    }
    public void voegBestelBonIdToe(long id) {bestelBonId.add(id);}



    public Map<Long,Long> getIds() {
        return ids;
    }

    public void maakMandjeLeeg() {

        ids.clear();
        bestelBonId.clear();
    }

    public Set<Long> getBierIds() {
        return ids.keySet();
    }

    public Set<Long> getBestelBonId() { return bestelBonId;}

    public Long getAantalVanBierId(long bierId) {
        return ids.get(bierId);
    }
}
