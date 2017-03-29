package api;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by borax on 2017/1/20.
 */

public class JsonParams {

    public final JSONObject params = new JSONObject();

    public JsonParams(){

    }

    public void put(String key, String value){
        if(key != null && value != null){
            try {
                params.put(key,value);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public JsonParams remove(String key){
        params.remove(key);
        return this;
    }

    public JSONObject toJson(){
        return params;
    }

    public String toString(){
        return params.toString();
    }

}
