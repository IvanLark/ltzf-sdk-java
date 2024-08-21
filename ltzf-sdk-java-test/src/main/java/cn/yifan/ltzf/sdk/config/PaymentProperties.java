package cn.yifan.ltzf.sdk.config;

import lombok.Data;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * @FileName PaymentProperties
 * @Description
 * @Author yifan
 * @date 2024-08-21 08:17
 **/

@Data
@ConfigurationProperties(prefix = "ltzf")
public class PaymentProperties {

    // 接口BaseURL
    private String apiHost = "https://api.ltzf.cn";

    // 开发者ID
    private String appId = "";

    // 商户号ID
    private String merchantId;

    // 商户秘钥
    private String partnerKey;

    private long connectTimeout = 60;

    private long writeTimeout = 60;

    private long readTimeout = 60;

    // 日志等级
    private HttpLoggingInterceptor.Level logLevel = HttpLoggingInterceptor.Level.HEADERS;

}
