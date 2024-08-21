package cn.yifan.ltzf.sdk;

import cn.yifan.ltzf.sdk.config.PaymentProperties;
import cn.yifan.ltzf.sdk.factory.PayFactory;
import cn.yifan.ltzf.sdk.payments.orderPay.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @FileName Application
 * @Description
 * @Author yifan
 * @date 2024-08-21 17:30
 **/

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
