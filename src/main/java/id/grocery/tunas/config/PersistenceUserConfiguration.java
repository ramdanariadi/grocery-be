package id.grocery.tunas.config;

import com.google.common.base.Strings;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableJpaRepositories(
        basePackages = {"id.grocery.tunas.security"},
        entityManagerFactoryRef = "userEntityManger",
        transactionManagerRef = "userTransactionManager"
)
public class PersistenceUserConfiguration {

    private Environment env;


    public PersistenceUserConfiguration(){}

    @Autowired
    public PersistenceUserConfiguration(Environment env) {
        this.env = env;
    }

    @Primary
    @Bean
    @ConfigurationProperties(prefix = "datasource-user")
    public DataSource userDatasource(){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName(Strings.nullToEmpty(env.getProperty("datasource-user.driver-class-name")));
        driverManagerDataSource.setUrl(env.getProperty("datasource-user.url"));
        driverManagerDataSource.setSchema(env.getProperty("datasource-user.schema"));
        driverManagerDataSource.setUsername(env.getProperty("datasource-user.username"));
        driverManagerDataSource.setPassword(env.getProperty("datasource-user.password"));
        return driverManagerDataSource;
    }

    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean userEntityManger(){
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        localContainerEntityManagerFactoryBean.setDataSource(userDatasource());

        String[] packagesToScan = new String[]{
                "id.grocery.tunas.security.role",
                "id.grocery.tunas.security.user",
        };
        localContainerEntityManagerFactoryBean.setPackagesToScan(packagesToScan);

        Map<String, Object> jpaPropertiesMap = new HashMap<>();
        //        jpaPropertiesMap.put("jpa.show-sql", env.getProperty("user.show-sql"));
        jpaPropertiesMap.put("hibernate.hbm2ddl.dialect", env.getProperty("user.properties.hibernate.dialect"));
//        jpaPropertiesMap.put("jpa.properties.hibernate.format_sql", env.getProperty("user.properties.hibernate.format_sql"));
        jpaPropertiesMap.put("hibernate.hbm2ddl.auto", env.getProperty("user.hibernate.ddl-auto"));
        localContainerEntityManagerFactoryBean.setJpaPropertyMap(jpaPropertiesMap);
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(hibernateJpaVendorAdapter);
        return localContainerEntityManagerFactoryBean;
    }

    @Primary
    @Bean
    public PlatformTransactionManager userTransactionManager(){
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(userEntityManger().getObject());
        return jpaTransactionManager;
    }
}
