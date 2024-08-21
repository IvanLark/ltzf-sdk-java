package cn.yifan.ltzf.sdk.payments.nativePay.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @FileName PrepayResponse
 * @Description
 * @Author yifan
 * @date 2024-08-21 07:46
 **/

@lombok.Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PrepayResponse {

    // 返回状态，枚举值：0：成功, 1：失败
    private Long code;

    // 返回数据
    private Data data;

    // 消息
    private String msg;

    // 唯一请求ID，每次请求都会返回
    @JsonProperty("request_id")
    private String requestId;

    @lombok.Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Data {

        // 微信原生支付链接，此URL用于生成支付二维码，然后提供给用户扫码支付。
        @JsonProperty("code_url")
        private String codeUrl;

        // 蓝兔支付生成的二维码链接地址
        @JsonProperty("QRcode_url")
        private String qrcodeUrl;

    }

}
