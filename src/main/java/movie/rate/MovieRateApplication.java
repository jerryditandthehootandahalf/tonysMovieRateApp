package movie.rate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"movie.rate"})
@EnableJpaRepositories(basePackages = {"movie.rate.persistence.repository"})
public class MovieRateApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieRateApplication.class, args);
    }
}
