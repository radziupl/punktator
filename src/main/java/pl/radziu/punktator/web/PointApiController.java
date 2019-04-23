package pl.radziu.punktator.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.radziu.punktator.Point;
import pl.radziu.punktator.data.PointRepository;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class PointApiController {

    private PointRepository pointRepository;

    @Autowired
    public PointApiController (PointRepository pointRepository){ this.pointRepository = pointRepository; }

    @RequestMapping(method = RequestMethod.GET, produces="application/json")
    public List<Point> points() {
        return pointRepository.findPoints();
    }

}
