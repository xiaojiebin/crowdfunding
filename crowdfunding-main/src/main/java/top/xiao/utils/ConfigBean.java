package top.xiao.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.util.Properties;

/**
 * @author 肖
 * @version 1.0
 * @Package top.xiao.utils
 * @data 2020/1/2 16:32
 */
@Configuration
public class ConfigBean {
    /**
     * FreeMarker视图解析器
     */
    @Bean
    public FreeMarkerViewResolver initFreeMarkerViewResolver() {
        FreeMarkerViewResolver freeMarkerViewResolver = new FreeMarkerViewResolver();
        freeMarkerViewResolver.setOrder(0);
        freeMarkerViewResolver.setSuffix(".html");
        freeMarkerViewResolver.setContentType("text/html;charset=utf-8");
        freeMarkerViewResolver.setViewClass(new FreeMarkerView().getClass());
        return freeMarkerViewResolver;
    }

    /**
     * 创建Freemarker
     */
    @Bean
    public FreeMarkerConfigurer initFreeMarkerConfigurer() {
        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
        String[] str = new String[]{"/WEB-INF/html/"};
        freeMarkerConfigurer.setTemplateLoaderPaths(str);
        freeMarkerConfigurer.setDefaultEncoding("UTF-8");
        Properties properties = new Properties();
        properties.setProperty("classic_compatible", "true");
        properties.setProperty("template_update_delay", "5");
        properties.setProperty("default_encoding", "UTF-8");
        properties.setProperty("locale", "UTF-8");
        properties.setProperty("datetime_format", "yyyy-MM-dd HH:mm:ss");
        properties.setProperty("time_format", "HH:mm:ss");
        properties.setProperty("number_format", "0.####");
        properties.setProperty("boolean_format", "true,false");
        properties.setProperty("whitespace_stripping", "true");
        properties.setProperty("url_escaping_charset", "UTF-8");
        freeMarkerConfigurer.setFreemarkerSettings(properties);
        return freeMarkerConfigurer;
    }
}
