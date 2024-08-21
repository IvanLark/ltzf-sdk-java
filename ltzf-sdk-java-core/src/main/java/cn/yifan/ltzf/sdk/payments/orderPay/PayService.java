package cn.yifan.ltzf.sdk.payments.orderPay;


import cn.yifan.ltzf.sdk.factory.Config;
import cn.yifan.ltzf.sdk.payments.orderPay.models.*;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;

/**
 * @FileName PayService
 * @Description 
 * @Author yifan
 * @date 2024-08-21 09:29
 **/
public abstract class PayService {

    protected Config config;

    protected IOrderApi orderApi;

    public PayService(Config config, Retrofit retrofit) {
        this.config = config;
        this.orderApi = retrofit.create(IOrderApi.class);
    }

    // 查询订单
    public GetPayOrderResponse getPayOrder(GetPayOrderRequest request) throws IOException {
        Call<GetPayOrderResponse> call = orderApi.getPayOrder(
                request.getMchid(),
                request.getOutTradeNo(),
                request.getTimestamp(),
                request.createSign(config.getPartnerKey())
        );

        Response<GetPayOrderResponse> execute = call.execute();
        return execute.body();
    }

    // 退款
    public RefundOrderResponse refundOrder(RefundOrderRequest request) throws IOException {
        Call<RefundOrderResponse> call = orderApi.refundOrder(
                request.getMchid(),
                request.getOutTradeNo(),
                request.getOutRefundNo(),
                request.getTimestamp(),
                request.getRefundFee(),
                request.getRefundDesc(),
                request.getNotifyUrl(),
                request.createSign(config.getPartnerKey())
        );
        Response<RefundOrderResponse> execute = call.execute();
        return execute.body();
    }

    // 查询退款
    public GetRefundOrderResponse getRefundOrder(GetRefundOrderRequest request) throws IOException {
        Call<GetRefundOrderResponse> call = orderApi.getRefundOrder(
                request.getMchid(),
                request.getOutRefundNo(),
                request.getTimestamp(),
                request.createSign(config.getPartnerKey())
        );
        Response<GetRefundOrderResponse> execute = call.execute();
        return execute.body();
    }

}
