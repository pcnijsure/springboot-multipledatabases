package com.example.demo;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.example.demo.postgresql",
transactionManagerRef = "postgresqlTM",
entityManagerFactoryRef = "postgresqlLCEMFB")
public class postgresqlConfig {

	@Bean
	@ConfigurationProperties(prefix = "spring.postgresql.datasource")
	public DataSourceProperties postgresqlDataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean
	public DataSource postgresqlDS(@Qualifier("postgresqlDataSourceProperties") DataSourceProperties postgresqlDataSourceProperties)
	{
		return postgresqlDataSourceProperties.initializeDataSourceBuilder().build();
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean postgresqlLCEMFB(@Qualifier("postgresqlDS") DataSource postgresqlDS)
	{
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
	    entityManagerFactoryBean.setDataSource(postgresqlDS);
	    entityManagerFactoryBean.setPackagesToScan("com.example.demo.postgresql");
	    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	    vendorAdapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQLDialect");
	    entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
	    return entityManagerFactoryBean;
	}
	
	@Bean
	public PlatformTransactionManager postgresqlTM(@Qualifier("postgresqlLCEMFB") EntityManagerFactory factory)
	{
		return new JpaTransactionManager(factory);
	}
}