package cn.yifan.ltzf.sdk.payments.orderPay;

import cn.yifan.ltzf.sdk.payments.orderPay.models.GetPayOrderResponse;
import cn.yifan.ltzf.sdk.payments.orderPay.models.GetRefundOrderResponse;
import cn.yifan.ltzf.sdk.payments.orderPay.models.RefundOrderResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * @FileName OrderApi
 * @Description 订单相关api
 * @Author yifan
 * @date 2024-08-21 07:46
 **/
public interface IOrderApi {

    @FormUrlEncoded
    @POST("/api/wxpay/get_pay_order")
    @Headers("content-type: application/x-www-form-urlencoded")
    Call<GetPayOrderResponse> getPayOrder(
            @Field("mch_id") String mchId,
            @Field("out_trade_no") String outTradeNo,
            @Field("timestamp") String timestamp,
            @Field("sign") String sign
    );

    @FormUrlEncoded
    @POST("/api/wxpay/refund_order")
    Call<RefundOrderResponse> refundOrder(
            @Field("mch_id") String mchId,
            @Field("out_trade_no") String outTradeNo,
            @Field("out_refund_no") String outRefundNo,
            @Field("timestamp") String timestamp,
            @Field("refund_fee") String refundFee,
            @Field("refund_desc") String refundDesc,
            @Field("notify_url") String notifyUrl,
            @Field("sign") String sign
    );

    @FormUrlEncoded
    @POST("/api/wxpay/get_refund_order")
    @Headers("content-type: application/x-www-form-urlencoded")
    Call<GetRefundOrderResponse> getRefundOrder(
            @Field("mch_id") String mchId,
            @Field("out_refund_no") String outRefundNo,
            @Field("timestamp") String timestamp,
            @Field("sign") String sign
    );

}
