package com.example.email;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<EmailData> emailData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailData = new ArrayList<>();

        EmailData mEmail1= new EmailData("Sam", "Weekend adventure",
                "Let's go fishing with John and others. We will do some barbecue and have so much fun",
                "10:42am");
        emailData.add(mEmail1);
        EmailData mEmail2 = new EmailData("Facebook", "James, you have 1 new notification",
                "A lot has happened on Facebook since",
                "16:04pm");
        emailData.add(mEmail2);
        EmailData mEmail3 = new EmailData("Google+", "Top suggested Google+ pages for you",
                "Top suggested Google+ pages for you",
                "18:44pm");
        emailData.add(mEmail3);
        EmailData mEmail4 = new EmailData("Twitter", "Follow T-Mobile, Samsung Mobile U",
                "James, some people you may know",
                "20:04pm");
        emailData.add(mEmail4);
        EmailData mEmail5 = new EmailData("Pinterest Weekly", "Pins you’ll love!",
                "Have you seen these Pins yet? Pinterest",
                "09:04am");
        emailData.add(mEmail5);
        EmailData mEmail6 = new EmailData("Josh", "Going lunch", "Don't forget our lunch at 3PM in Pizza hut",
                "01:04am");
        emailData.add(mEmail6);

        mRecyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(MainActivity.this,
                LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(MainActivity.this,
                DividerItemDecoration.VERTICAL));
        EmailAdapter mMailAdapter = new EmailAdapter(MainActivity.this, emailData);
        mRecyclerView.setAdapter(mMailAdapter);
    }
}