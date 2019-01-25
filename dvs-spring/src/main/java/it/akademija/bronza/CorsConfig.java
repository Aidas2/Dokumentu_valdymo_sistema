package lt.sventes;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedMethods("*").allowedOrigins("*").allowCredentials(true);
	}
}

//si klase skirta tam kad viskas butu leidziama, niekas nieko neblokuotu (skrta tik studentiskam projektui, realiam gyvenime nenaudotina)
