package api;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by borax on 2017/1/18.
 */

public class API {


    //    public static final String BASE_URL = "http://192.168.1.103/index.php/default/";
//    public static final String BASE_URL = "http://tool.demo.sainti.net/a/";
//    public static final String BASE_URL = "http://app.shengchong.cn/appapi/";

//    public static final String BASE_URL = "http://59.110.243.46/index.php/Index/";

    public static final String BASE_URL = "http://192.168.1.64:8080/dagger-app/dagger-app/user/";

    public static final String CRASH_URL = "http://yufeiyjm.sinaapp.com/index.php/";

    public static final String PAY_URL = "http://www.yueban.cn/app_api_v2/index.php/";

    public static Retrofit RETROFIT = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static MPInterface SERVICE = RETROFIT.create(MPInterface.class);

    public static Retrofit CRASHRETROFIT = new Retrofit.Builder()
            .baseUrl(CRASH_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static CrashInterface CRASHSERVICE = CRASHRETROFIT.create(CrashInterface.class);

    public static OkHttpClient genericClient() {

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request()
                                .newBuilder()
                                .addHeader("Content-Type", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)")
                                .addHeader("Connection", "keep-Alive")
                                .addHeader("Accept", "*/*")
                                .addHeader("Content", "application/json")
                                .build();

                        return chain.proceed(request);
                    }
                }).build();

        return httpClient;
    }


}

