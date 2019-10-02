package fr.move.in.med.medicTest;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
@EntityScan(basePackages = "fr.move.in.med")
@ComponentScan(basePackages = "fr.move.in.med")
@EnableJpaRepositories(basePackages = "fr.move.in.med")
public class MedicTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicTestApplication.class, args);
	}
	
	@Bean
	public Mapper mapper() {
		return new DozerBeanMapper();
	}
}
