package cn.yifan.ltzf.sdk.payments.orderPay.models;

import cn.yifan.ltzf.sdk.utils.SignUtils;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @FileName GetPayOrderRequest
 * @Description
 * @Author yifan
 * @date 2024-08-21 09:14
 **/

@Data
public class GetPayOrderRequest {

    /** 商户号 */
    private String mchid;
    /** 商户订单号 */
    private String outTradeNo;
    /** 当前时间戳 */
    private final String timestamp = String.valueOf(System.currentTimeMillis() / 1000);

    /** 创建签名 */
    public String createSign(String partnerKey) {
        Map<String, String> dataMap = new HashMap<>();
        dataMap.put("mch_id", getMchid());
        dataMap.put("out_trade_no", getOutTradeNo());
        dataMap.put("timestamp", getTimestamp());
        return SignUtils.createSign(dataMap, partnerKey);
    }

}
