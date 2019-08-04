package com.stackroute.muzixapp.config;


import org.springframework.context.annotation.Configuration;


@Configuration

public class WebConfiguration {

   /* @Bean
    ServletRegistrationBean h2servletRegistration(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new WebServlet());
        servletRegistrationBean.addUrlMappings("/console/*");
        return servletRegistrationBean;

    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors
                        .basePackage("com.stackroute.muzixapp.controller"))
                .paths(PathSelectors.regex("/.*"))
                .build();
    }

*/
}
