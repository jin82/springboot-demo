package jin.study.movie.config;

import jin.study.movie.formatters.CustomerFormatter;
import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.util.concurrent.TimeUnit;

/**
 * \*
 * \* User: jin82
 * \* Date: 2016/08/31
 * \* Time: 16:02
 * \* Description:
 * \
 */
@Configuration
public class AppConfig extends WebMvcConfigurerAdapter{

	/**
	 * 得到用户真实IP拦截器
	 * @return
	 */
	@Bean
	public RemoteIpFilter remoteIpFilter(){
		return new RemoteIpFilter();
	}

	/**
	 * 国际化区域改变拦截器
	 * @return
	 */
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		return new LocaleChangeInterceptor();
	}

	/**
	 * 配置消息转换器(1)
	 * @return
	 */
	@Bean
	public ByteArrayHttpMessageConverter byteArrayHttpMessageConverter() {
		return new ByteArrayHttpMessageConverter();
	}

//  配置消息转换器(2)
//	扩展现有的消息转换器链表
//	@Override
//	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//		converters.add(new ByteArrayHttpMessageConverter());
//	}

//  配置消息转换器(3)
//	首先清空转换器列表，再加入自定义的转换器
//	@Override
//	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
//		converters.clear();
//		converters.add(new ByteArrayHttpMessageConverter());
//	}

	/**
	 * 添加拦截器
	 * @param registry
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
	}

	/**
	 * 添加Formatter
	 * @param registry
	 */
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addFormatter(new CustomerFormatter());
	}

	/**
	 * configurer.setUseSuffixPatternMatch(false)表示设计人员希望系统对外暴露的URL不会识别和匹配.*后缀
	 * configurer.setUseTrailingSlashMatch(true)表示系统不区分URL的最后一个字符是否是斜杠/
	 * @param configurer
	 */
//	@Override
//	public void configurePathMatch(PathMatchConfigurer configurer) {
//		configurer.setUseSuffixPatternMatch(false).
//				setUseTrailingSlashMatch(true);
//	}


	/**
	 * 假设我们需要通过URLhttp://localhost:8080/internal/application.properties对外暴露当前程序的配置
	 * @param registry
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/internal/**").
				addResourceLocations("classpath:/");
	}

	/**
	 * 设置session超时时间
	 * @return
	 */
	@Bean
	public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer(){
		return (configurableEmbeddedServletContainer)->
				configurableEmbeddedServletContainer.setSessionTimeout(1, TimeUnit.MINUTES)
		;
	}
}
