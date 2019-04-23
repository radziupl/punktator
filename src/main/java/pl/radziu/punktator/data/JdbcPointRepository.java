package pl.radziu.punktator.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;
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
                    rs.getDouble("latitude"),
                    rs.getDouble("longitude"));
        }
    }

    @Override
    public Point addPoint(Point point) {
        jdbc.update("insert into points ( name, description, latitude, longitude) values (?, ?, ?, ?)",
                point.getName(),
                point.getDescription(),
                point.getLatitude(),
                point.getLongitude());
        return point;
    }

    @Override
    public Point updatePoint(Point point) {
        jdbc.update("update points set" +
                " name = '" + point.getName() +"'" +
                ", description = '" + point.getDescription() +"'" +
                ", latitude = " + point.getLatitude() +
                ", longitude = " + point.getLongitude() +
                " where id = " + point.getId());
        return point;
    }

    @Override
    public void deletePoint(Point point) {
        jdbc.execute("delete from points where id = " + point.getId());
    }
}
