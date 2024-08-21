package cn.yifan.ltzf.sdk.payments.nativePay;

import cn.yifan.ltzf.sdk.payments.nativePay.models.PrepayResponse;
import retrofit2.Call;
import retrofit2.http.*;

/**
 * @FileName INativePrepayApi
 * @Description 扫码预支付api
 * @Author yifan
 * @date 2024-08-21 07:45
 **/
public interface INativePrepayApi {

    @POST("/api/wxpay/native")
    @FormUrlEncoded
    @Headers("content-type: application/x-www-form-urlencoded")
    public Call<PrepayResponse> prepay(@Field("mch_id") String mchId,
                                       @Field("out_trade_no") String outTradeNo,
                                       @Field("total_fee") String totalFee,
                                       @Field("body") String body,
                                       @Field("timestamp") String timestamp,
                                       @Field("notify_url") String notifyUrl,
                                       @Field("sign") String sign
    );

}
