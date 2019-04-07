package pl.radziu.punktator.data;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;
import pl.radziu.punktator.Point;
import pl.radziu.punktator.web.PointController;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class PointTest {

    @Test
    public void shouldShowAllPoints() throws Exception {
        List<Point> expectedPoints = createPointList(5);
        PointRepository mockRepository = mock(PointRepository.class);
        when(mockRepository.findPoints()).thenReturn(expectedPoints);

        PointController controller = new PointController(mockRepository);

        MockMvc mockMvc = standaloneSetup(controller).setSingleView(
                new InternalResourceView("/WEB-INF/views/points.html")).build();
        mockMvc.perform(get("/points"))
                .andExpect(view().name("points"))
                .andExpect(model().attributeExists("pointList"));
    }

    private List<Point> createPointList(int count) {
        List<Point> points = new ArrayList<Point>();
        for (int i = 0; i < count; i++) {
            points.add(new Point(i, "Punkt: " + i, "Opis punktu: " + i, null, null));
        }
        return points;
    }

}
