package api;

/**
 * Created by borax on 2017/1/19.
 */

public class SaintiClient {

    public static void doGet(String url, SaintiCallback saintiCallback) {
        RequestManager.doGet(url, saintiCallback);
    }

    public static void doPost(String url, JsonParams jsonParams, SaintiCallback saintiCallback) {
        RequestManager.doPost(url, jsonParams, saintiCallback);

    }


}
