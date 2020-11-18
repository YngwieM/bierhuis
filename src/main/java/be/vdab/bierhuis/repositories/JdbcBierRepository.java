package be.vdab.bierhuis.repositories;

import be.vdab.bierhuis.domain.Bier;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
class JdbcBierRepository implements BierRepository {
    private final JdbcTemplate template;

    JdbcBierRepository(JdbcTemplate template) {
        this.template = template;
    }
    private final RowMapper<Bier> bierRowMapper = (result, rowNum) ->
            new Bier(result.getInt("id"), result.getString("naam"),
                    result.getInt("brouwerid"),result.getInt("soortid"),
                    result.getBigDecimal("alcohol"),result.getBigDecimal("prijs"));


    @Override
    public Optional<Bier> findById(long id) {
        try {
            var sql ="select id,naam,brouwerid,soortid,alcohol,prijs from bieren where id = ?";
            Optional<Bier> bieren = Optional.of(template.queryForObject(sql, bierRowMapper, id));
            return bieren;
        } catch (IncorrectResultSizeDataAccessException ex) {
            return Optional.empty();
        }
    }

    @Override
    public List<Bier> findByBrouwerId(long id) {
        try {
            var sql ="select id,naam,brouwerid,soortid,alcohol,prijs from bieren where brouwerid = ? order by naam";
            List<Bier> bieren = template.query(sql, bierRowMapper, id);

            return bieren;
        } catch (IncorrectResultSizeDataAccessException ex) {
            return Collections.emptyList();
        }
    }

    @Override
    public long findAantal() {
        return template.queryForObject("select count(*) from bieren", Long.class);
    }

    @Override
    public List<Bier> findByIds(Set<Long> ids) {
        if (ids.isEmpty()) {
            return List.of();
        }
        var sql = "select id,naam,brouwerid,soortid,alcohol,prijs from bieren where id in (" + "?,".repeat(ids.size() - 1) +"?) order by naam";
        return template.query(sql, ids.toArray(), bierRowMapper);
    }
}
