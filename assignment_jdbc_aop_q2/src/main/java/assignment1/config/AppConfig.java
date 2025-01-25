package assignment1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "assignment1")
@EnableTransactionManagement
@PropertySource("classpath:dbconn.properties")
public class AppConfig {

    @Autowired
    private Environment environment;

    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public DriverManagerDataSource getDriverManagerDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUsername(environment.getProperty("jdbc.user"));
        dataSource.setPassword(environment.getProperty("jdbc.password"));
        dataSource.setDriverClassName(Objects.requireNonNull(environment.getProperty("jdbc.drivername")));
        dataSource.setUrl(environment.getProperty("jdbc.url"));

        return dataSource;
    }

    @Bean
    public DataSourceTransactionManager getdataSourceTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}