package com.example.demo.configurations;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@ConfigurationProperties(prefix = "postgre.management.datasource")
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "managementDatabaseEntityManager",
        transactionManagerRef = "managementDatabaseTransactionManager",
        basePackages = "com.example.demo.repositories"
)
public class PgManagementConfig extends PostgreConfig {

    private String url;

    private String userName;

    private String password;

    private String ddlAuto;

    @Primary
    @Bean
    public DataSource postgreManagementDataSource() {
        return getDataSource();
    }

    @Primary
    @Bean(name = "managementDatabaseEntityManager")
    public LocalContainerEntityManagerFactoryBean mysqlEntityManagerFactory() {
        return getEntityManagerFactory("com.example.demo.models");
    }

    @Primary
    @Bean(name = "managementDatabaseTransactionManager")
    public PlatformTransactionManager postgreTransactionManager(@Qualifier("managementDatabaseEntityManager") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

//    public String getUserName() {
//        return userName;
//    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDdlAuto(String ddlAuto) {
        this.ddlAuto = ddlAuto;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getDdlAuto() {
        return ddlAuto;
    }

//    @Override
//    public void setUsername(String userName) {
//        this.userName = userName;
//    }

}
