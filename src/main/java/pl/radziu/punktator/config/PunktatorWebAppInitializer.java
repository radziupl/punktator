package pl.radziu.punktator.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import pl.radziu.punktator.web.WebConfig;

public class PunktatorWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected String[] getServletMappings(){
        return new String[] {"/"};
    }

    @Override
    protected Class<?>[] getRootConfigClasses(){
        return new Class<?>[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses(){
        return new Class<?>[] {WebConfig.class};}
    }
