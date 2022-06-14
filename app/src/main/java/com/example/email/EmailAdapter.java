package com.example.email;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Random;

public class EmailAdapter extends RecyclerView.Adapter<EmailAdapter.EmailViewHolder>{
    private List<EmailData> mEmailData;
    private Context mContext;

    public EmailAdapter(Context mContext, List mEmailData) {
        this.mEmailData = mEmailData;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public EmailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mail_item,
                parent, false);
        return new EmailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmailViewHolder holder, int position) {
        Random mRandom = new Random();
        int color = Color.argb(255, mRandom.nextInt(256), mRandom.nextInt(256), mRandom.nextInt(256));
        ((GradientDrawable) holder.mIcon.getBackground()).setColor(color);
        holder.mIcon.setText(mEmailData.get(position).getmSender().substring(0, 1));
        holder.mSender.setText(mEmailData.get(position).getmSender());
        holder.mEmailTitle.setText(mEmailData.get(position).getmTitle());
        holder.mEmailDetails.setText(mEmailData.get(position).getmDetails());
        holder.mEmailTime.setText(mEmailData.get(position).getmTime());
        holder.mFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.mFavorite.getColorFilter() != null) {
                    holder.mFavorite.clearColorFilter();
                } else {
                    holder.mFavorite.setColorFilter(ContextCompat.getColor(mContext,
                            R.color.colorOrange));
                }
            }
        });
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(mContext, DetailActivity.class);
                mIntent.putExtra("sender", holder.mSender.getText().toString());
                mIntent.putExtra("title", holder.mEmailTitle.getText().toString());
                mIntent.putExtra("details", holder.mEmailDetails.getText().toString());
                mIntent.putExtra("time", holder.mEmailTime.getText().toString());
                mIntent.putExtra("icon", holder.mIcon.getText().toString());
                mIntent.putExtra("colorIcon", color);
                mContext.startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mEmailData.size();
    }

    class EmailViewHolder extends RecyclerView.ViewHolder {
        TextView mIcon;
        TextView mSender;
        TextView mEmailTitle;
        TextView mEmailDetails;
        TextView mEmailTime;
        ImageView mFavorite;
        View view;

        public EmailViewHolder(@NonNull View itemView) {
            super(itemView);

            view = itemView;
            mIcon = itemView.findViewById(R.id.tvIcon);
            mSender = itemView.findViewById(R.id.tvEmailSender);
            mEmailTitle = itemView.findViewById(R.id.tvEmailTitle);
            mEmailDetails = itemView.findViewById(R.id.tvEmailDetails);
            mEmailTime = itemView.findViewById(R.id.tvEmailTime);
            mFavorite = itemView.findViewById(R.id.ivFavorite);
        }
    }
}
