package training.elabo.co.jp.elabo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SampleResultViewActivity extends AppCompatActivity {

    private String mContentText;
    private String mRankValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_activity_result);

        String signText;

        /**
         * TextViewの呼び出し
         */
        TextView ContentTextView = (TextView) findViewById(R.id.result_content);
        TextView RankTextView = (TextView) findViewById(R.id.result_rank);
        TextView SignTextView = (TextView) findViewById(R.id.result_sign);
        TextView itemValueView = (TextView) findViewById(R.id.result_item_value);
        TextView colorValueView = (TextView) findViewById(R.id.result_color_value);


        /**
         * これは番外編機能
         * ☆の表示を作ってくれてます
         */
        RatingBar ratingValueTotal = (RatingBar) findViewById(R.id.result_total_value);
        RatingBar ratingValueLove = (RatingBar) findViewById(R.id.result_love_value);
        RatingBar ratingValueMoney = (RatingBar) findViewById(R.id.result_money_value);
        RatingBar ratingValueJob = (RatingBar) findViewById(R.id.result_job_value);


        final DateFormat df = new SimpleDateFormat("MM/dd");
        final Date date = new Date(System.currentTimeMillis());

        ratingValueTotal.setRating(Float.valueOf(getIntent().getStringExtra("total")));
        ratingValueLove.setRating(Float.valueOf(getIntent().getStringExtra("love")));
        ratingValueMoney.setRating(Float.valueOf(getIntent().getStringExtra("money")));
        ratingValueJob.setRating(Float.valueOf(getIntent().getStringExtra("job")));


        mContentText = getIntent().getStringExtra("content");
        mRankValue = getIntent().getStringExtra("rank");
        signText = getIntent().getStringExtra("sign");

        ContentTextView.setText(mContentText);
        RankTextView.setText(getString(R.string.result_rank,mRankValue));
        SignTextView.setText(getString(R.string.result_sign,signText,df.format(date)));
        colorValueView.setText(getIntent().getStringExtra("color"));
        itemValueView.setText(getIntent().getStringExtra("item"));
        setThumbnailView(signText);
    }


    /**
     * signの値に合わせて表示する画像の切り替え
     * @param sign
     */
    private void setThumbnailView(String sign) {
        ImageView thumbnailView = (ImageView) findViewById(R.id.thumbIcon);

        if (sign.equals("牡羊座")){
            thumbnailView.setBackgroundResource(R.drawable.thumb_aries);
        } else if (sign.equals("牡牛座")) {
            thumbnailView.setBackgroundResource(R.drawable.thumb_taurus);
        } else if (sign.equals("双子座")) {
            thumbnailView.setBackgroundResource(R.drawable.thumb_gemini);
        } else if (sign.equals("蟹座")) {
            thumbnailView.setBackgroundResource(R.drawable.thumb_cancer);
        } else if (sign.equals("獅子座")) {
            thumbnailView.setBackgroundResource(R.drawable.thumb_leo);
        } else if (sign.equals("乙女座")) {
            thumbnailView.setBackgroundResource(R.drawable.thumb_virgo);
        } else if (sign.equals("天秤座")) {
            thumbnailView.setBackgroundResource(R.drawable.thumb_libra);
        } else if (sign.equals("蠍座")) {
            thumbnailView.setBackgroundResource(R.drawable.thumb_scorpio);
        } else if (sign.equals("射手座")) {
            thumbnailView.setBackgroundResource(R.drawable.thumb_sagittarius);
        } else if (sign.equals("山羊座")) {
            thumbnailView.setBackgroundResource(R.drawable.thumb_capricorn);
        } else if (sign.equals("水瓶座")) {
            thumbnailView.setBackgroundResource(R.drawable.thumb_aqarius);
        } else if (sign.equals("魚座")) {
            thumbnailView.setBackgroundResource(R.drawable.thumb_pices);
        }
    }

}
