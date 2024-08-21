package cn.yifan.ltzf.sdk.controller;

import cn.yifan.ltzf.sdk.models.PayNotifyRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @FileName WeChatPayController
 * @Description
 * @Author yifan
 * @date 2024-08-21 17:07
 **/


@Slf4j
@RestController
@RequestMapping("/wechat-pay/notify")
public class WeChatPayController {

    @PostMapping("/pay")
    public ResponseEntity<String> payNotify(
            // TODO 修改
            @ModelAttribute PayNotifyRequest request
    ) {
        try {
            log.info("成功收到支付回调, 支付时间: {}, 支付费用: {}, 订单号: {}, 支付用户openid: {}", request.getSuccess_time(), request.getTotal_fee(), request.getOut_trade_no(), request.getOpenid());
            return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("FAIL", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

/*
*
*
            @RequestParam String code,
            @RequestParam String timestamp,
            @RequestParam String mch_id,
            @RequestParam String order_no,
            @RequestParam String out_trade_no,
            @RequestParam String pay_no,
            @RequestParam String total_fee,
            @RequestParam String sign,
            @RequestParam String pay_channel,
            @RequestParam String trade_type,
            @RequestParam String success_time,
            @RequestParam String attach,
            @RequestParam String openid
* */