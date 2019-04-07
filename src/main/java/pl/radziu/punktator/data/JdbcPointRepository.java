package pl.radziu.punktator.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import pl.radziu.punktator.Point;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcPointRepository implements PointRepository {

    private JdbcOperations jdbc;

    @Autowired
    public JdbcPointRepository(JdbcOperations jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public List<Point> findPoints() {
        return jdbc.query("select * from points order by id", new PointRowMapper());
                }

private static class PointRowMapper implements RowMapper<Point> {
    public Point mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Point(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("description"),
                rs.getDouble("longitude"),
                rs.getDouble("latitude"));
    }
}
}
