package com.bookapp.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.bookapp.model.persitance.BookDao;
import com.bookapp.model.service.BookService;
import com.bookapp.model.service.BookServiceImpl;

@Configuration
@ComponentScan(basePackages = {"com.bookapp"})
@PropertySource(value = "classpath:db.properties")
@EnableAspectJAutoProxy
@EnableTransactionManagement
@Import(DbConfig.class)
public class BookConfig {
	
	@Bean
	public LocalSessionFactoryBean getLocalSessionFactoryBean(DataSource dataSource) {
		LocalSessionFactoryBean lsb=new LocalSessionFactoryBean();
		lsb.setDataSource(dataSource);
		lsb.setPackagesToScan(new String[] {"com.bookapp.model.persitance"});
		lsb.setHibernateProperties(getHibernateProperties());
		return lsb;
	}
	private Properties getHibernateProperties() {
		Properties properties=new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.format_sql", "true");
		
		return properties;
	}

	
	@Bean
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager ht=new HibernateTransactionManager();
		ht.setSessionFactory(sessionFactory);
		return ht;
	}
}
