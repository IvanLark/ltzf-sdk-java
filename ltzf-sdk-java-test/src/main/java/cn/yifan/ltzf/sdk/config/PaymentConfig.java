package cn.yifan.ltzf.sdk.config;

import cn.yifan.ltzf.sdk.factory.Config;
import cn.yifan.ltzf.sdk.factory.PayFactory;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.concurrent.TimeUnit;

/**
 * @FileName PaymentConfig
 * @Description
 * @Author yifan
 * @date 2024-08-21 08:17
 **/

@Slf4j
@Configuration
@EnableConfigurationProperties(PaymentProperties.class)
public class PaymentConfig {

    @Bean
    public OkHttpClient okHttpClient(PaymentProperties paymentProperties) {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(paymentProperties.getLogLevel());
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .connectTimeout(paymentProperties.getConnectTimeout(), TimeUnit.SECONDS)
                .readTimeout(paymentProperties.getReadTimeout(), TimeUnit.SECONDS)
                .writeTimeout(paymentProperties.getWriteTimeout(), TimeUnit.SECONDS)
                .build();
        log.info("注册OKHttpClient成功");
        return client;
    }

    @Bean
    public Retrofit retrofit(PaymentProperties paymentProperties, OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(paymentProperties.getApiHost())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create())
                .client(okHttpClient)
                .build();
        log.info("注册Retrofit成功");
        return retrofit;
    }

    @Bean
    public PayFactory payFactory(PaymentProperties paymentProperties, Retrofit retrofit) {
        Config config = Config.builder()
                .partnerKey(paymentProperties.getPartnerKey())
                .build();
        log.info("注册PayFactory成功");
        return new PayFactory(config, retrofit);
    }

}
