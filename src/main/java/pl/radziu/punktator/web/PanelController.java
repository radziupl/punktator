package pl.radziu.punktator.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.radziu.punktator.Point;
import pl.radziu.punktator.data.PointRepository;

@Controller
@RequestMapping("/panel")
public class PanelController {

    private PointRepository pointRepository;

    @Autowired
    public PanelController(PointRepository pointRepository) {
        this.pointRepository = pointRepository;
    }

//    @RequestMapping(method = RequestMethod.GET)
//    public List<Point> points(){
//        return pointRepository.findPoints();
//    }

    @RequestMapping(method = RequestMethod.GET)
    public String points(Model model) {
        model.addAttribute(pointRepository.findPoints());
        return "panel";
    }

    @RequestMapping(params = {"add"})
    public String addPoint(Point point) {
        pointRepository.addPoint(point);
        return "redirect:points";
    }

    @RequestMapping(params = {"update"})
    public String updatePoint(Point point) {
        pointRepository.updatePoint(point);
        return "redirect:points";
    }

    @RequestMapping(params = {"remove"})
    public String deletePoint(Point point) {
        pointRepository.deletePoint(point);
        return "redirect:points";
    }
}
