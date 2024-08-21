package cn.yifan.ltzf.sdk.factory;


import cn.yifan.ltzf.sdk.payments.appPay.AppPayService;
import cn.yifan.ltzf.sdk.payments.h5Pay.H5PayService;
import cn.yifan.ltzf.sdk.payments.nativePay.NativePayService;
import retrofit2.Retrofit;

/**
 * @FileName PayFactory
 * @Description
 * @Author yifan
 * @date 2024-08-21 15:18
 **/
public class PayFactory {

    private final Config config;

    private final Retrofit retrofit;

    public PayFactory(Config config, Retrofit retrofit) {
        this.config = config;
        this.retrofit = retrofit;
    }

    public NativePayService nativePayService() {
        return new NativePayService(config, retrofit);
    }

    public H5PayService h5PayService() {
        return null;
    }

    public AppPayService appPayService() {
        return null;
    }

}
