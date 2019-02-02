package com.example.cheng.tripactionscc.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.cheng.tripactionscc.R;

public class DetailActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle extras = getIntent().getExtras();
        final String url = extras.getString("url"),headLine = extras.getString("headLine"),
                webUrl = extras.getString("webUrl");

        ImageView imageView = findViewById(R.id.large_image);
        Glide.with(this).load(url).into(imageView);

        TextView textView = findViewById(R.id.text_view_detail);
        textView.setText(headLine);

        Button share = findViewById(R.id.share);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = webUrl;
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Shared Article");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));
            }
        });
    }
}
