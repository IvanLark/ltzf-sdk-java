package cn.yifan.ltzf.sdk.payments.orderPay.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @FileName RefundOrderResponse
 * @Description
 * @Author yifan
 * @date 2024-08-21 09:15
 **/

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RefundOrderResponse {

    private Long code;
    private Data data;
    private String msg;
    @JsonProperty("request_id")
    private String requestId;

    @lombok.Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Data {
        @JsonProperty("mch_id")
        private String mchId;
        @JsonProperty("out_trade_no")
        private String outTradeNo;
        @JsonProperty("out_refund_no")
        private String outRefundNo;
        @JsonProperty("order_no")
        private String orderNo;
        @JsonProperty("pay_refund_no")
        private String payRefundNo;
    }

}
