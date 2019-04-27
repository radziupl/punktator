package pl.radziu.punktator.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;
import pl.radziu.punktator.Point;
import pl.radziu.punktator.data.PointRepository;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class PointControllerTest {

    @Test
    public void testPointsPage() throws Exception {
        PointRepository mockRepository = mock(PointRepository.class);
        PointController controller = new PointController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).setSingleView(
                new InternalResourceView("/WEB-INF/views/points.html")).build();
        mockMvc.perform(get("/points"))
                .andExpect(view().name("points"));
    }
}
