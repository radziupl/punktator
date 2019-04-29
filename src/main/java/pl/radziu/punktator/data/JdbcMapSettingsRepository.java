package pl.radziu.punktator.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import pl.radziu.punktator.MapSettings;
import pl.radziu.punktator.Point;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcMapSettingsRepository implements MapSettingsRepository {

    private JdbcOperations jdbc;

    @Autowired
    public JdbcMapSettingsRepository(JdbcOperations jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public MapSettings findMapSettings(){
            return jdbc.queryForObject("select * from mapsettings", new MapSettingsRowMapper());
    }

    @Override
    public MapSettings updateMapSettings(MapSettings mapSettings) {
        jdbc.update("update mapsettings set" +
                " title = '" + mapSettings.getTitle() +"'" +
                ", latitude = " + mapSettings.getLatitude() +
                ", longitude = " + mapSettings.getLongitude() +
                ", zoom = " + mapSettings.getZoom() +
                " where id = " + mapSettings.getId());
        return mapSettings;
    }

    private static class MapSettingsRowMapper implements RowMapper<MapSettings> {
        public MapSettings mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new MapSettings(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getDouble("latitude"),
                    rs.getDouble("longitude"),
                    rs.getInt("zoom"));
        }
    }

}
