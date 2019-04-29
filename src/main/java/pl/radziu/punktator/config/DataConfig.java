package pl.radziu.punktator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import java.util.TimeZone;

@Configuration
public class DataConfig {

//  @Bean
//  public DataSource dataSource() {
//    return new EmbeddedDatabaseBuilder()
//            .setType(EmbeddedDatabaseType.H2)
//            .setName("punktator")
//            .addScript("schema.sql")
//            .addScript("data.sql")
//            .build();
//  }

  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    dataSource.setUrl("jdbc:mysql://mysql/punktator");
//    dataSource.setUrl("jdbc:mysql://localhost/punktator?useSSL=false&&?allowPublicKeyRetrieval=true&serverTimezone=" + TimeZone.getDefault().getID());
    dataSource.setUsername("root");
    dataSource.setPassword("admin");
    return dataSource;
  }
  
  @Bean
  public JdbcOperations jdbcTemplate(DataSource dataSource) {
    return new JdbcTemplate(dataSource);
  }

}
