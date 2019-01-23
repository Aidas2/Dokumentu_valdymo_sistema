package lt.sventes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
//@ImportResource("classpath*:application-context.xml")
public class App extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(lt.sventes.App.class, args);
    }
    protected SpringApplicationBuilder configure (SpringApplicationBuilder builder) {
        return builder.sources(lt.sventes.App.class);
    }

    @Bean
    public Docket swaggerDocket() {
        return new Docket (DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("lt.sventes"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("IT Akademija REST Documentation (by Migle Babickaite)")
                .version("0.0.1-SNAPSHOT")
                .build();
    }

}
