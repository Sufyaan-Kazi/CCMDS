package demo.config;

import java.sql.DriverManager;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration
@ConfigurationProperties(prefix="spring.datasource")
@Profile("local")
//@EnableAutoConfiguration
//@EnableConfigurationProperties
//@PropertySources(value = { @PropertySource("classpath:/jdbc.properties") })
public class DataSourceConfig {

	//@Autowired
	//private Environment env;
	
	@Value("${driverClassName:Hello}")
	private String driverClassName;
	@Value("${url:Hello}")
	private String url;
	@Value("${username:Hello}")
	private String username;
	@Value("${password:Hello}")
	private String password;

	//@Autowired
	//public static final DataSourceConfig INSTANCE = new DataSourceConfig();

	public DataSourceConfig() {
		super();
	}

	@Bean
	public DataSource dataSource() {
		SimpleDriverDataSource dataSource = null;
		try {
			Class.forName(this.driverClassName);
			dataSource = new SimpleDriverDataSource();
			dataSource.setDriver(DriverManager.getDriver(this.url));
			dataSource.setUrl(this.url);
			dataSource.setUsername(this.username);
			dataSource.setPassword(this.password);
			
			//Class.forName(env.getRequiredProperty("driverClassName"));
			//dataSource = new SimpleDriverDataSource();
			//dataSource.setDriver(DriverManager.getDriver(env.getRequiredProperty("url")));
			//dataSource.setUrl(env.getRequiredProperty("url"));
			//dataSource.setUsername(env.getRequiredProperty("username"));
			//dataSource.setPassword(env.getRequiredProperty("password"));
		} catch (Exception e) {
			throw new IllegalStateException("An Exception occurred initialising datasource", e);
		}

		return dataSource;
	}

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
