package com.firstWebApp.firstWebAppDemo.configuration;

import java.sql.SQLException;
import javax.sql.DataSource;
import javax.validation.constraints.NotNull;

import oracle.jdbc.pool.OracleDataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

/*************THIS CLASS IS NOT USED***************/

/*@Configuration
@ConfigurationProperties("oracle")*/
public class OracleConfiguration {
	@NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String url;
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    @Bean
    @Primary
    DataSource dataSource() throws SQLException {
        OracleDataSource dataSource = new OracleDataSource();
        dataSource.setUser(username);
        dataSource.setPassword(password);
        dataSource.setURL(url);
        dataSource.setImplicitCachingEnabled(true);
        dataSource.setFastConnectionFailoverEnabled(true);
        return dataSource;
    }

}
