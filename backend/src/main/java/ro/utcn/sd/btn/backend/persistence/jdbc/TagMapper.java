package ro.utcn.sd.btn.backend.persistence.jdbc;

import org.springframework.jdbc.core.RowMapper;
import ro.utcn.sd.btn.backend.model.Tag;
import ro.utcn.sd.btn.backend.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TagMapper implements RowMapper<Tag> {

    @Override
    public Tag mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Tag(rs.getInt("id"),
                rs.getString("tag_name"));
    }

}