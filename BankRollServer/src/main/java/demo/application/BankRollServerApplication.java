package demo.application;

import org.bytesoft.bytetcc.supports.springcloud.config.SpringCloudSecondaryConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;


//文件系统存储日志
@Import(SpringCloudSecondaryConfiguration.class)
@EnableAutoConfiguration(exclude = { MongoAutoConfiguration.class })
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@EnableFeignClients(basePackages = {
        "demo.business.feign"
})
@ComponentScan(basePackages = {
        "demo.business",
        "demo.config"
})
//@RibbonClients(defaultConfiguration = MyRobbin.class)
public class BankRollServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(BankRollServerApplication.class, args);
    }
}

