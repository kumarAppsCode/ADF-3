1.2. @CrossOrigin at Class/Controller Level

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
public class HomeController 
{
    @GetMapping(path="/")
    public String homeInit(Model model) {
        return "home";
    }
}

************************************************
1.3. @CrossOrigin at Method Level

@Controller
public class HomeController 
{
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping(path="/")
    public String homeInit(Model model) {
        return "home";
    }
}

************************************************
1.4. @CrossOrigin Overridden at Method Level

homeInit() method will be accessible only from domain http://example.com. Rest other methods in HomeController will be accessible from all domains.

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HomeController 
{
    @CrossOrigin(origins = "http://example.com")
    @GetMapping(path="/")
    public String homeInit(Model model) {
        return "home";
    }
}
************************************************
2.1. Implement WebMvcConfigurer

To enable CORS for the whole application, use WebMvcConfigurer to add CorsRegistry.



import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
 
@Configuration
@EnableWebMvc
public class CorsConfiguration implements WebMvcConfigurer
{
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("GET", "POST");
    }
}
************************************************
2.2. WebMvcConfigurer Bean

In spring boot application, it is recommended to just declare a WebMvcConfigurer bean.


  @Configuration
public class CorsConfiguration 
{
    @Bean
    public WebMvcConfigurer corsConfigurer() 
    {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:8080");
            }
        };
    }
}
************************************************
2.3. CORS with Spring Security

To enable CORS support through Spring security, configure CorsConfigurationSource bean and use HttpSecurity.cors() configuration.


  @EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and()
            //other config
    }
 
    @Bean
    CorsConfigurationSource corsConfigurationSource() 
    {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("https://example.com"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
************************************************
