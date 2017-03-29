package api;

import com.borax.myapp.activity.encrypt.AesUtil;
import com.orhanobut.logger.Logger;

/**
 * Created by borax on 2017/1/19.
 */

public class RequestManager {

    public static void doGet(String url, SaintiCallback saintiCallback) {
        API.SERVICE.getData(url).enqueue(saintiCallback);
    }

    public static void doPost(String url, JsonParams jsonParams, SaintiCallback saintiCallback) {

        String json = "";

        try {
            json = AesUtil.encrypt(jsonParams.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        Logger.d(json);

        API.SERVICE.postData(url, json).enqueue(saintiCallback);
    }

}
