package com.crud.tasks.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@EnableScheduling
@EnableSwagger2
@Configuration
public class CoreConfiguration implements WebMvcConfigurer {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate(); //klassa umożliwiająca realizowanie żądań pomiędzy serwerami
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.crud.tasks.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        // required by Swagger UI configuration
        registry.addResourceHandler("/lib/**").addResourceLocations("/lib/").setCachePeriod(0);
        registry.addResourceHandler("/images/**").addResourceLocations("/images/").setCachePeriod(0);
        registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(0);
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    public void configurePathMatch(PathMatchConfigurer configurer) { }

    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) { }

    public void configureAsyncSupport(AsyncSupportConfigurer configurer) { }

    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) { }

    public void addFormatters(FormatterRegistry registry) { }

    public void addInterceptors(InterceptorRegistry registry) { }

    public void addCorsMappings(CorsRegistry registry) { }

    public void addViewControllers(ViewControllerRegistry registry) { }

    public void configureViewResolvers(ViewResolverRegistry registry) { }

    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) { }

    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) { }

    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) { }

    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) { }

    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) { }

    public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) { }

    public Validator getValidator() { return null; }

    public MessageCodesResolver getMessageCodesResolver() { return null; }
}
