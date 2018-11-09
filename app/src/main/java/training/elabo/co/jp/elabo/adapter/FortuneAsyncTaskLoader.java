package training.elabo.co.jp.elabo.adapter;

import android.os.AsyncTask;

import org.json.JSONObject;

/**
 * 別の処理の流れを作ってくれる為の処理をクラス化したもの
 * 通信処理などはこのクラスを呼び出してその中で行うのがルール
 */
public class FortuneAsyncTaskLoader extends AsyncTask<Void, Void, JSONObject> {

    public FortuneAsyncTaskLoader(){
        super();
    }
    @Override
    protected JSONObject doInBackground(Void... params) {
        return null;
    }
}
