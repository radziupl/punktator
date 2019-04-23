package pl.radziu.punktator.data;

import pl.radziu.punktator.Point;

import java.util.List;

public interface PointRepository {

    List<Point> findPoints();
    Point addPoint(Point point);
    Point updatePoint(Point point);
    void deletePoint(Point id);

}
