package demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import tk.mybatis.spring.annotation.MapperScan;
/**
 * Created by Administrator
 * on 2018/1/30.
 */
@Configuration
//配置文件中的配置不生效改在这里用编码的方式额皮质
@MapperScan(
        value = "tk.mybatis.mapper.annotation",
        properties = {
                "mappers=mybaties.mapper.BusiMapper,mybaties.mapper.InfoMapper",
                "notEmpty=true",
                "identity=MYSQL"
        },
        basePackages = {"" +
                //"mybaties.mapper",
                "demo.business.mapper"
        }
)
/*
@ComponentScan(basePackages = {
        "com.yinhetianze.common.business",
        "com.yinhetianze.security",
        "com.yinhetianze.business"
})
*/
//@ServletComponentScan("com.yinhetianze.web")
// core包中的内置实现，基础框架使用时可以使用，也可以自己实现接口定制
public class ComponentsConfig
{

    /*
    @Bean
    public FilterRegistrationBean filterRegistrationBean()
    {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();

        CustomAccessLimitFilter filter = new CustomAccessLimitFilter();

        filterRegistrationBean.setFilter(filter);
        filterRegistrationBean.setAsyncSupported(true);
        return filterRegistrationBean;
    }
    */

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        //.allowedOrigins("http://localhost:8848")
                        .allowedMethods("PUT", "DELETE","GET","POST","OPTIONS")
                        .allowedHeaders("*")
                        /*.exposedHeaders("access-control-allow-headers",
                                "access-control-allow-methods",
                                "access-control-allow-origin",
                                "access-control-max-age",
                                "X-Frame-Options")
                        */
                        .allowCredentials(false).maxAge(3600);
            }
        };

    }
    /*
    @Bean
    public ServletRegistrationBean dispatcherServlet() {
        ServletRegistrationBean registration = new ServletRegistrationBean(
                new DispatcherServlet(), "/");
        registration.setAsyncSupported(true);
        return registration;
    }
    */
}
