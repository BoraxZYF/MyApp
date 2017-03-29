package api;

import com.borax.myapp.activity.caughtcrash.CrashBean;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by borax on 2017/2/17.
 */

public interface CrashInterface {

    @FormUrlEncoded
    @POST("/")
    Call<CrashBean> postData(@Field("a") String type, @Field("sql") String data);

}
