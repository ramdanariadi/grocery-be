package id.grocery.tunas.config;

import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
        basePackages = {
                "id.grocery.tunas.cart",
                "id.grocery.tunas.category",
                "id.grocery.tunas.product",
                "id.grocery.tunas.shop",
                "id.grocery.tunas.transaction",
                "id.grocery.tunas.wishlist",
        },
        entityManagerFactoryRef = "groceryEntityManager",
        transactionManagerRef = "groceryTransactionManager"
)
public class PersistenceGroceryConfiguration {
    private Environment env;

    public PersistenceGroceryConfiguration(){}

    @Autowired
    public PersistenceGroceryConfiguration(Environment env) {
        this.env = env;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean groceryEntityManager(){
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        localContainerEntityManagerFactoryBean.setDataSource(groceryDatasource());
        String[] packagesToScan = new String[]{
                "id.grocery.tunas.category",
                "id.grocery.tunas.product",
                "id.grocery.tunas.cart",
                "id.grocery.tunas.shop",
                "id.grocery.tunas.transaction",
                "id.grocery.tunas.wishlist",
        };
        localContainerEntityManagerFactoryBean.setPackagesToScan(packagesToScan);
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(hibernateJpaVendorAdapter);
        Map<String, Object> jpaPropertiesMap = new HashMap<>();

//        jpaPropertiesMap.put("jpa.show-sql", env.getProperty("grocery.show-sql"));
        jpaPropertiesMap.put("hibernate.hbm2ddl.dialect", env.getProperty("grocery.properties.hibernate.dialect"));
//        jpaPropertiesMap.put("jpa.properties.hibernate.format_sql", env.getProperty("grocery.properties.hibernate.format_sql"));
        jpaPropertiesMap.put("hibernate.hbm2ddl.auto", env.getProperty("grocery.hibernate.ddl-auto"));
        localContainerEntityManagerFactoryBean.setJpaPropertyMap(jpaPropertiesMap);
        return localContainerEntityManagerFactoryBean;
    }

    @Bean
    @ConfigurationProperties(prefix = "datasource-grocery")
    public DataSource groceryDatasource(){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName(Strings.nullToEmpty(env.getProperty("datasource-grocery.driver-class-name")));
        driverManagerDataSource.setUrl(env.getProperty("datasource-grocery.url"));
        driverManagerDataSource.setSchema(env.getProperty("datasource-grocery.schema"));
        driverManagerDataSource.setUsername(env.getProperty("datasource-grocery.username"));
        driverManagerDataSource.setPassword(env.getProperty("datasource-grocery.password"));
        return driverManagerDataSource;
    }

    @Bean
    public PlatformTransactionManager groceryTransactionManager(){
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(groceryEntityManager().getObject());
        return jpaTransactionManager;
    }
}
