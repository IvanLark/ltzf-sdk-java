package cn.yifan.ltzf.sdk.payments.nativePay.models;

import cn.yifan.ltzf.sdk.utils.SignUtils;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @FileName PrepayRequest
 * @Description
 * @Author yifan
 * @date 2024-08-21 07:45
 **/

@Data
public class PrepayRequest {

    // 商户号
    @JsonProperty("mch_id")
    private String mchId;

    // 商户订单号，只能是数字、大小写字母_-且在同一个商户号下唯一。
    @JsonProperty("out_trade_no")
    private String outTradeNo;

    // 支付金额
    @JsonProperty("total_fee")
    private String totalFee;

    // 商品描述
    @JsonProperty("body")
    private String body;

    // 当前时间戳
    @JsonProperty("timestamp")
    private String timestamp = String.valueOf(System.currentTimeMillis() / 1000);

    // 支付通知地址，通知URL必须为直接可访问的URL，不允许携带查询串，要求必须为http或https地址。
    @JsonProperty("notify_url")
    private String notifyUrl;

    // 签名
    public String createSign(String partnerKey) {
        Map<String, String> params = new HashMap<>();
        params.put("mch_id", getMchId());
        params.put("out_trade_no", getOutTradeNo());
        params.put("total_fee", getTotalFee());
        params.put("body", getBody());
        params.put("timestamp", getTimestamp());
        params.put("notify_url", getNotifyUrl());
        return SignUtils.createSign(params, partnerKey);
    }

}
