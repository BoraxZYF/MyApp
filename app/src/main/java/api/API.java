package api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by borax on 2017/1/18.
 */

public class API {


    //    public static final String BASE_URL = "http://192.168.1.103/index.php/default/";
//    public static final String BASE_URL = "http://tool.demo.sainti.net/a/";
//    public static final String BASE_URL = "http://app.shengchong.cn/appapi/";

    public static final String BASE_URL = "http://59.110.243.46/index.php/Index/";

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

}

