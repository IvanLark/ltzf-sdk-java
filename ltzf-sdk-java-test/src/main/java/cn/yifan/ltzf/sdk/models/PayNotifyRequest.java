package cn.yifan.ltzf.sdk.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @FileName PayNotifyRequest
 * @Description
 * @Author yifan
 * @date 2024-08-21 17:39
 **/

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PayNotifyRequest {

    private String code;

    private String timestamp;

    private String mch_id;

    private String order_no;

    private String out_trade_no;

    private String pay_no;

    private String total_fee;

    private String sign;

    private String pay_channel;

    private String trade_type;

    private String success_time;

    private String attach;

    private String openid;

}
