package movie.rate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Configuration
public class ApplicationConfiguration {


    @Bean
    public EntityManagerFactory entityManagerFactory(){

        return Persistence.createEntityManagerFactory("movie-rate-persistence-unit");
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager dbTransactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();

        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }
}
