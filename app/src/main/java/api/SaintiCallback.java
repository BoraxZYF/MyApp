package api;

import com.borax.myapp.activity.encrypt.AesUtil;
import com.borax.myapp.activity.encrypt.BaseBean;
import com.orhanobut.logger.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by borax on 2017/1/19.
 */

public abstract class SaintiCallback implements Callback {

    @Override
    public void onResponse(Call call, Response response) {

        if (response.body() == null) {
            fail("NetWork Error");
            return;
        }

        BaseBean data = (BaseBean) response.body();
        Logger.d(data.getData());

        if(data.getResult().equals("1")){
            String json = "";

            try {
                //解密
                json = AesUtil.desEncrypt(data.getData());
            } catch (Exception e) {
                e.printStackTrace();
            }

            //返回json
            success(json);
        }else{
            fail(data.getMsg());
        }

    }

    @Override
    public void onFailure(Call call, Throwable t) {

        Logger.d(t.getMessage());
        fail("NetWork Error");

    }

    public abstract void success(String json);

    public abstract void fail(String str);

}
