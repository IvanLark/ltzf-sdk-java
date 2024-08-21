package cn.yifan.ltzf.sdk.factory;

import lombok.Builder;
import lombok.Data;

/**
 * @FileName Config
 * @Description
 * @Author yifan
 * @date 2024-08-21 16:45
 **/
@Data
@Builder
public class Config {

    // 开发者ID
    // private final String appId;

    // 商户号ID
    // private final String merchantId;

    // 商户秘钥
    private String partnerKey;

}
