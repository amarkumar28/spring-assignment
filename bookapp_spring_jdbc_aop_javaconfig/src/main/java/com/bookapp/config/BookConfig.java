package com.bookapp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.bookapp.model.persitance.BookDao;
import com.bookapp.model.service.BookService;
import com.bookapp.model.service.BookServiceImpl;

@Configuration
@ComponentScan(basePackages = {"com.bookapp"})
@PropertySource(value = "classpath:db.properties")
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class BookConfig {
	
	@Value("${jdbc.url}")
	private String url;
	
	@Value("${jdbc.driverName}")
	private String driverClassName;
	
	@Value("${jdbc.username}")
	private String username;
	
	@Value("${jdbc.password}")
	private String password;
	
	@Bean
	public DriverManagerDataSource getDriverManagerDataSource() {
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setDriverClassName(driverClassName);
		
		return dataSource;
	}
	
	@Bean(name="bookService")
	public BookService getBookService(BookDao bookDao)
	{
		BookServiceImpl bookServiceImpl =new BookServiceImpl();
		bookServiceImpl.setBookDao(bookDao);
		return bookServiceImpl;
	}
	@Bean
	public JdbcTemplate getJdbcTemplate(DriverManagerDataSource ds) {
		JdbcTemplate temp = new JdbcTemplate();
		temp.setDataSource(ds);
		return temp;
	}
	
	@Bean
	public DataSourceTransactionManager getManager(DriverManagerDataSource ds) {
		DataSourceTransactionManager manager = new DataSourceTransactionManager();
		manager.setDataSource(ds);
		return manager;
	}
}
