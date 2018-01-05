package br.com.casadocodigo.loja.config;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
public class JPAConfiguration {

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
		LocalContainerEntityManagerFactoryBean managerFactoryBean = new LocalContainerEntityManagerFactoryBean();
//		JpaVendorAdapter jpaAdapter = new HibernateJpaVendorAdapter();
		HibernateJpaVendorAdapter jpaAdapter = new HibernateJpaVendorAdapter();
		jpaAdapter.setGenerateDdl(true);
		jpaAdapter.setShowSql(true);
		jpaAdapter.setDatabase(Database.ORACLE);
		managerFactoryBean.setJpaVendorAdapter(jpaAdapter);
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUsername("seguro");
        dataSource.setPassword("seguro");
        dataSource.setUrl("jdbc:oracle:thin:@localhost:1521/xe");
        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		
        managerFactoryBean.setDataSource(dataSource);

//        Properties props = new Properties();
//        org.hibernate.dialect.OracleDialect
//        org.hibernate.dialect.Oracle10gDialect
//        props.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle9iDialect");
//        props.setProperty("hibernate.show_sql", "true");
//        props.setProperty("hibernate.hbm2ddl.auto", "update");

//        managerFactoryBean.setJpaProperties(props);
        managerFactoryBean.setPackagesToScan("br.com.casadocodigo.loja.models");
		return managerFactoryBean;
	}
	
	@Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory emf){
        return new JpaTransactionManager(emf);
    }
}
