package be.vdab.bierhuis.repositories;

import be.vdab.bierhuis.domain.Brouwer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
class JdbcBrouwerRepository implements BrouwerRepository {
    private final JdbcTemplate template;

    JdbcBrouwerRepository(JdbcTemplate template) {
        this.template = template;
    }

    private final RowMapper<Brouwer> brouwerRowMapper = (result, rowNum) ->
            new Brouwer(result.getInt("id"), result.getString("naam"),
                    result.getString("straat"),result.getString("huisNr"),
                    result.getInt("postcode"),result.getString("gemeente"),
                    result.getInt("omzet"));

    @Override
    public List<Brouwer> findAll() {
        var sql = "select id,naam,straat,huisNr,postcode,gemeente,omzet from brouwers order by naam ";
        return template.query(sql,brouwerRowMapper);
    }
}
