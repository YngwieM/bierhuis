package be.vdab.bierhuis.repositories;

import be.vdab.bierhuis.domain.BestelBonLijn;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;

@Repository
 class JdbcBestelBonLijnRepository implements BestelBonLijnRepository {
    private final JdbcTemplate template;
    private final SimpleJdbcInsert insert;

    public JdbcBestelBonLijnRepository(JdbcTemplate template) {

        this.template = template;
        this.insert = new SimpleJdbcInsert(template)
                .withTableName("bestelbonlijnen");
    }

    @Override
    public Optional<BestelBonLijn> findById(long id) {
        return Optional.empty();
    }

    @Override
    public long create(BestelBonLijn bestelBonLijn) {
        var kolomWaarden = Map.of("bestelbonid", bestelBonLijn.getBestelBonId(),
                "bierid", bestelBonLijn.getBierId(),
                "aantal", bestelBonLijn.getAantal(),
                "prijs",bestelBonLijn.getPrijs());
        var id = insert.execute(kolomWaarden);
        return 0;
    }
}
