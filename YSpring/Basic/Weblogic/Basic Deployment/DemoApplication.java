@SpringBootApplication
public class DemoApplication extends SpringBootServletInitializer implements WebApplicationInitializer{

 

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(DemoApplication.class);
    }

 

}
