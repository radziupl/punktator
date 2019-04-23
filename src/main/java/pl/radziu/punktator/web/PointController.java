package pl.radziu.punktator.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.radziu.punktator.Point;
import pl.radziu.punktator.data.PointRepository;

import java.util.List;

@Controller
@RequestMapping("/points")
public class PointController {

    private PointRepository pointRepository;

    @Autowired
    public PointController(PointRepository pointRepository){ this.pointRepository = pointRepository; }

//    @RequestMapping(method = RequestMethod.GET)
//    public List<Point> points(){
//        return pointRepository.findPoints();
//    }

    @RequestMapping(method = RequestMethod.GET)
    public String points (Model model){
        model.addAttribute(pointRepository.findPoints());
        return "points";
    }

}
