package training.elabo.co.jp.elabo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import training.elabo.co.jp.elabo.adapter.FortuneAsyncTaskLoader;
import training.elabo.co.jp.elabo.adapter.FortuneMenuGridAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = (GridView)findViewById(R.id.menu_gridview);
        gridView.setAdapter(new FortuneMenuGridAdapter(this));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                executeFortuneResult(getApplicationContext(),position);
            }
        });
    }

    private static void executeFortuneResult(final Context context, final int position) {
        new FortuneAsyncTaskLoader() {
            @Override
            protected JSONObject doInBackground(Void... params) {
                JSONObject fortuneObject = null;

                try {
                    String result = run("http://api.jugemkey.jp/api/horoscope/free");
                    Log.d("fortune",result);

                } catch(IOException e) {
                    e.printStackTrace();
                }
                return fortuneObject;
            }

            @Override
            protected void onPostExecute(JSONObject json) {
                //ボタンを押した時に処理をするところ

                //Intent作成、SecondActivity画面へ移動するため
                Intent intent  = new Intent(context,ResultActivity.class);

                //作成したIntentへ不可情報をつける場合に使う
                //キー値と渡したい情報を入れる
                //キー値=情報を取り出す為の合言葉。移動先で情報を引き出す時に使う
                intent.putExtra("キー値","渡したい情報");

                //作成したIntent情報を元に画面を起動
                context.startActivity(intent);
            }
        }.execute();
    }


    /**
     * OkHttpを使った通信処理
     * urlを渡し、レスポンスを返却する処理となっています。
     * @param url
     * @return String
     * @throws IOException
     */
    public static String run(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }
}
