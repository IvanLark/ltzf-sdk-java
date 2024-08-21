package cn.yifan.ltzf.sdk.payments.nativePay;

import cn.yifan.ltzf.sdk.factory.Config;
import cn.yifan.ltzf.sdk.payments.nativePay.models.PrepayRequest;
import cn.yifan.ltzf.sdk.payments.nativePay.models.PrepayResponse;
import cn.yifan.ltzf.sdk.payments.orderPay.PayService;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;

/**
 * @FileName NativePayService
 * @Description
 * @Author yifan
 * @date 2024-08-21 10:09
 **/
public class NativePayService extends PayService {

    private INativePrepayApi nativePrepayApi;

    public NativePayService(Config config, Retrofit retrofit) {
        super(config, retrofit);
        this.nativePrepayApi = retrofit.create(INativePrepayApi.class);
    }

    public PrepayResponse prepay(PrepayRequest request) throws IOException {
        Call<PrepayResponse> call = nativePrepayApi.prepay(
                request.getMchId(),
                request.getOutTradeNo(),
                request.getTotalFee(),
                request.getBody(),
                request.getTimestamp(),
                request.getNotifyUrl(),
                request.createSign(config.getPartnerKey())
        );
        Response<PrepayResponse> execute = call.execute();
        return execute.body();
    }

}
