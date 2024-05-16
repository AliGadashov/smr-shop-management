package smr.shop.brand.service;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"smr.shop.brand.service.*", "smr.shop.libs.common.*"})
@EnableDiscoveryClient
public class CategoryBrandServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CategoryBrandServiceApplication.class, args);
    }
    // TODO Slug field generation fix
}