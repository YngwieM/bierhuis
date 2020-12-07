package be.vdab.bierhuis.repositories;

import be.vdab.bierhuis.domain.BestelBonLijn;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Optional;

public class JdbcBestelBonLijnRepository implements BestelBonLijnRepository {
    private final JdbcTemplate template;

    public JdbcBestelBonLijnRepository(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public Optional<BestelBonLijn> findById(long id) {
        return Optional.empty();
    }

    @Override
    public long create(BestelBonLijn bestelBonLijn) {
        return 0;
    }
}
