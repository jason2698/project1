package Firstproject.eshop.Configuration;


import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import Firstproject.eshop.Model.CartItem;
import Firstproject.eshop.Model.Category;
import Firstproject.eshop.Model.Product;
import Firstproject.eshop.Model.UserDetail;


@Configuration
@EnableTransactionManagement
@Component("Firstproject.eshop")
public class DBConfig 
{


	@Bean(name="dataSource")
	public DataSource getH2DataSource()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/proj1");
		dataSource.setUsername("sa");
		dataSource.setPassword("jason");
		
		System.out.println("---DataSource object is Created");
		return dataSource;
	}
	
	

	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
		Properties properties=new Properties();
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");	
		properties.put("hibernate.show_sql", true);

		
		DataSource dataSource=this.getH2DataSource();
		LocalSessionFactoryBuilder factory=new LocalSessionFactoryBuilder(dataSource);
		factory.addProperties(properties);
		
		factory.addAnnotatedClass(Category.class);
		factory.addAnnotatedClass(Product.class);
		factory.addAnnotatedClass(UserDetail.class);
		factory.addAnnotatedClass(CartItem.class);
		
		System.out.println("---Session Factory Object is created---");
		SessionFactory sessionFactory=factory.buildSessionFactory();
		return sessionFactory;
	}
	
	
	@Bean(name="txManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("---Transaction Manager Object is Created ---");
		return new HibernateTransactionManager(sessionFactory);
	}
	
}

