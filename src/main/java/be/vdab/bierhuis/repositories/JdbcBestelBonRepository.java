package be.vdab.bierhuis.repositories;

import be.vdab.bierhuis.domain.Bestelbon;
import be.vdab.bierhuis.domain.Bier;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;

@Repository
 class JdbcBestelBonRepository implements BestelBonRepository {
    private final JdbcTemplate template;
    private final SimpleJdbcInsert insert;

    JdbcBestelBonRepository(JdbcTemplate template) {
        this.template = template;
        this.insert = new SimpleJdbcInsert(template)
                .withTableName("bestelbonnen");
    }

    @Override
    public long create(Bestelbon bestelbon) {
        var kolomWaarden = Map.of("naam", bestelbon.getNaam(),
                "straat", bestelbon.getStraat(),
                "huisNr", bestelbon.getHuisNummer(),
                "postcode",bestelbon.getPostcode()
        ,"gemeente",bestelbon.getGemeente());
        var id = insert.execute(kolomWaarden);
        return 0;
    }

    private final RowMapper<Bestelbon> bestelbonRowMapper = (result, rowNum) ->
            new Bestelbon(result.getInt("id"), result.getString("naam"),
                    result.getString("straat"),result.getString("huisNr"),
                    result.getInt("postcode"),result.getString("gemeente"));

    @Override
    public Optional<Bestelbon> findIdByNaam(String naam) {
            try {
                var sql ="select id,naam,straat,huisNr,postcode,gemeente from bestelbonnen where naam like ? order by id desc limit 1";
                Optional<Bestelbon> bestelbon = Optional.of(template.queryForObject(sql, bestelbonRowMapper, naam));
                return bestelbon;
            } catch (IncorrectResultSizeDataAccessException ex) {
                return Optional.empty();
            }
        }
    }

