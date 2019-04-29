package pl.radziu.punktator.data;

import pl.radziu.punktator.MapSettings;
import pl.radziu.punktator.Point;

import java.util.List;

public interface MapSettingsRepository {

    MapSettings findMapSettings();
    MapSettings updateMapSettings(MapSettings mapSettings);

}
