package com.web;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.google.common.base.Predicate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;


@SpringBootApplication
@EnableSwagger2
@EnableAutoConfiguration


public class Application extends SpringBootServletInitializer {

	// @PostConstruct
	// public void configBootAdmin() {
	// adminProperties
	// .setUrl(C_SBA.getString("staplesBootAdminUrl",
	// "http://lptsdnasv06.staples.com:8101/StaplesBootApp"));
	// adminClientProperties.setServiceUrl("http://lptsdnasv06.staples.com:8101/MobileServicesApp");
	// }

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public Docket documentation() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any()).paths(paths())
				.build().pathMapping("/").useDefaultResponseMessages(false).apiInfo(apiInfo());
	}

	@Bean
	public UiConfiguration uiConfig() {
		return UiConfiguration.DEFAULT;
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("SMS REST API").description("SMS Operations").version("2.0")
				.contact("Dan@email.com").build();
	}

	public ObjectMapper objectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JodaModule());
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		return mapper;
	}
	@Bean
	public ContentNegotiatingViewResolver viewResolver() {
		ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
		List<ViewResolver> viewResolvers = new ArrayList<>(1);
		viewResolvers.add(jspViewResolver());
		resolver.setViewResolvers(viewResolvers);
		List<View> views = new ArrayList<>();
		views.add(jsonView());
		resolver.setDefaultViews(views);
		return resolver;
	}


	@Bean
	public MappingJackson2JsonView jsonView() {
		MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
		jsonView.setObjectMapper(objectMapper());
		jsonView.setContentType("application/json");

		return jsonView;
	}

	@Bean
	public InternalResourceViewResolver jspViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setOrder(1);
		//resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");// <prefix>/viewName.<suffix>
		resolver.setRedirectHttp10Compatible(false);
		resolver.setViewClass(JstlView.class);
		return resolver;
	}

	@SuppressWarnings("unchecked")
	private Predicate<String> paths() {
		return or(regex("/sms.*"));
	}

}
