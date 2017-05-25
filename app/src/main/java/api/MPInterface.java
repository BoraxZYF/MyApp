package api;

import com.borax.myapp.activity.encrypt.BaseBean;

import java.util.Map;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Created by borax on 2017/1/18.
 */

public interface MPInterface {

    @GET("{url}")
    Call<BaseBean> getData(@Path("url") String url);

    @FormUrlEncoded
    @POST("{url}")
    Call<BaseBean> postData(@Path("url") String url, @Field("data") String data);

    @Streaming
    @GET
    Call<ResponseBody> updateVersion(@Url String fileurl);

    @GET("wx")
    Call<BaseBean> getTest();

    @Multipart
    @POST("UploadFile")
    Call<BaseBean> postUploadPic(@PartMap Map<String, RequestBody> params);

}
