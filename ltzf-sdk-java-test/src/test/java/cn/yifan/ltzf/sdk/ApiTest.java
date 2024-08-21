package cn.yifan.ltzf.sdk;

import cn.yifan.ltzf.sdk.config.PaymentProperties;
import cn.yifan.ltzf.sdk.factory.PayFactory;
import cn.yifan.ltzf.sdk.payments.nativePay.NativePayService;
import cn.yifan.ltzf.sdk.payments.nativePay.models.PrepayRequest;
import cn.yifan.ltzf.sdk.payments.nativePay.models.PrepayResponse;
import cn.yifan.ltzf.sdk.payments.orderPay.PayService;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.UUID;

/**
 * @FileName ApiTest
 * @Description
 * @Author yifan
 * @date 2024-08-21 11:55
 **/

@Slf4j
@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class ApiTest {

    @Autowired
    private PaymentProperties properties;

    @Autowired
    private PayFactory payFactory;

    private NativePayService nativePayService;

    @Before
    public void init() {
        nativePayService = payFactory.nativePayService();
    }

    @Test
    public void testPrepay() throws IOException {
        PrepayRequest request = new PrepayRequest();
        request.setMchId(properties.getMerchantId());
        request.setOutTradeNo(UUID.randomUUID().toString().replace("-", ""));
        request.setTotalFee("0.01");
        request.setBody("测试物品");
        request.setNotifyUrl("http://fjp4wv.natappfree.cc/wechat-pay/notify/pay");
        PrepayResponse response = nativePayService.prepay(request);

        log.info("创建微信支付订单成功, 订单信息: {}", JSON.toJSONString(response));

    }

}
