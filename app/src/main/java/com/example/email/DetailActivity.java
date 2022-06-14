package com.example.email;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView mIcon = findViewById(R.id.tvIcon);
        TextView mSender = findViewById(R.id.tvEmailSender);
        TextView mEmailTitle = findViewById(R.id.tvEmailTitle);
        TextView mEmailDetails = findViewById(R.id.tvEmailDetails);
        TextView mEmailTime = findViewById(R.id.tvEmailTime);
        ImageView mFavorite = findViewById(R.id.ivFavorite);

        Bundle mBundle = getIntent().getExtras();
        if (mBundle != null) {
            mIcon.setText(mBundle.getString("icon"));
            ((GradientDrawable) mIcon.getBackground()).setColor(mBundle.getInt("colorIcon"));
            mSender.setText(mBundle.getString("sender"));
            mEmailTitle.setText(mBundle.getString("title"));
            mEmailDetails.setText(mBundle.getString("details"));
            mEmailTime.setText(mBundle.getString("time"));
        }
        mFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mFavorite.getColorFilter() != null) {
                    mFavorite.clearColorFilter();
                } else {
                    mFavorite.setColorFilter(ContextCompat.getColor(DetailActivity.this,
                            R.color.colorOrange));
                }
            }
        });
    }
}