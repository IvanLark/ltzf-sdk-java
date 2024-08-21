package cn.yifan.ltzf.sdk.payments.orderPay.models;

import cn.yifan.ltzf.sdk.utils.SignUtils;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @FileName GetRefundOrderRequest
 * @Description
 * @Author yifan
 * @date 2024-08-21 09:15
 **/

@Data
public class GetRefundOrderRequest {

    @JsonProperty("mch_id")
    private String mchid;
    @JsonProperty("out_refund_no")
    private String outRefundNo;

    private String timestamp = String.valueOf(System.currentTimeMillis() / 1000);

    /** 创建签名 */
    public String createSign(String partnerKey) {
        Map<String, String> dataMap = new HashMap<>();
        dataMap.put("mch_id", getMchid());
        dataMap.put("out_refund_no", getOutRefundNo());
        dataMap.put("timestamp", getTimestamp());
        return SignUtils.createSign(dataMap, partnerKey);
    }

}
