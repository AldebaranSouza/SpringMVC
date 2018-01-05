package br.com.casadocodigo.loja.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.casadocodigo.loja.models.conversors.LocalDateToStringConverter;
import br.com.casadocodigo.loja.models.conversors.StringToLocalDateConverter;

@EnableWebMvc
//@ComponentScan(basePackageClasses = {HomeController.class, ProdutoDAO.class, FileSaver.class})
@ComponentScan(basePackages="br.com.casadocodigo")
public class AppWebConfiguration extends WebMvcConfigurerAdapter{
	
	/*@Bean
	public InternalResourceViewResolver internalPathMethodNameResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}*/
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setExposedContextBeanNames("carrinhoCompras");
		registry.viewResolver(viewResolver);
		super.configureViewResolvers(registry);
	}
	
	
	@Bean
	public MessageSource messageSource(){
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("/WEB-INF/messages");
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setCacheSeconds(1);
		return messageSource;
	}
	
	@Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToLocalDateConverter("dd/MM/yyyy"));
        registry.addConverter(new LocalDateToStringConverter("dd/MM/yyyy"));
        //registry.addConverter(new LocalDateTimeConverter("yyyy-MM-dd'T'HH:mm:ss.SSS"));
    }
	
	@Bean
	public MultipartResolver multipartResolver(){
		return new StandardServletMultipartResolver();
	}

}
