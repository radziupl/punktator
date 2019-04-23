package pl.radziu.punktator.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@Configuration
@EnableWebMvc
@ComponentScan("pl.radziu.punktator.web")
public class WebConfig implements WebMvcConfigurer {

//    @Override
//    public void configureContentNegotiation(ContentNegotiationConfigurer configurer){
//        configurer.defaultContentType(MediaType.TEXT_HTML);
//    }
//
//    @Bean
//    public ViewResolver cnViewResolver(ContentNegotiationManager cnm) {
//        ContentNegotiatingViewResolver cnvr =
//                new ContentNegotiatingViewResolver();
//        cnvr.setContentNegotiationManager(cnm);
//        return cnvr;
//    }
//
//    @Bean
//    public ViewResolver beanNameViewResolver() {
//        return new BeanNameViewResolver();
//    }
//
//    @Bean
//    public View points() {
//        return new MappingJackson2JsonView();
//    }

//    @Bean
//    public ViewResolver viewResolver() {
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix("/WEB-INF/views/");
//        resolver.setSuffix(".jsp");
//        resolver.setExposeContextBeansAsAttributes(true);
//        return resolver;
//    }
//
//    @Override
//    public void configureDefaultServletHandling
//        (DefaultServletHandlerConfigurer configurer) {
//        configurer.enable();
//    }


}
