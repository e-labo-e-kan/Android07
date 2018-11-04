package training.elabo.co.jp.elabo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import training.elabo.co.jp.elabo.R;

public class FortuneMenuGridAdapter extends BaseAdapter{
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private String[] mGridTitleArray = {
            "おひつじ座", "おうし座", "ふたご座", "かに座",
            "しし座", "おとめ座", "てんびん座", "さそり座",
            "いて座","やぎ座","みずがめ座","うお座"
    };

    private Integer[] mHueIdArray = {
            R.drawable.thumb_aries,
            R.drawable.thumb_taurus,
            R.drawable.thumb_gemini,
            R.drawable.thumb_cancer,
            R.drawable.thumb_leo,
            R.drawable.thumb_virgo,
            R.drawable.thumb_libra,
            R.drawable.thumb_scorpio,
            R.drawable.thumb_sagittarius,
            R.drawable.thumb_capricorn,
            R.drawable.thumb_aqarius,
            R.drawable.thumb_pices,
    };

    private static class ViewHolder {
        public ImageView thumbImageView;
        public TextView thumbTextView;
    }

    public FortuneMenuGridAdapter(Context context) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return mGridTitleArray.length;
    }

    public Object getItem(int position) {
        return mGridTitleArray[position];
    }

    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.activity_grid_container, null);
            holder = new ViewHolder();
            holder.thumbImageView = (ImageView)convertView.findViewById(R.id.grid_imageview);
            holder.thumbTextView = (TextView)convertView.findViewById(R.id.grid_textview);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }

        holder.thumbImageView.setImageResource(mHueIdArray[position]);
        holder.thumbTextView.setText(mGridTitleArray[position]);
        return convertView;
    }
}
