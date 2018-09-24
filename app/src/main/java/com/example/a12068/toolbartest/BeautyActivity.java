package com.example.a12068.toolbartest;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class BeautyActivity extends AppCompatActivity {

    public static final String BEAUTY_NAME = "beauty_name";

    public static final String BEAUTY_IMAGES_ID = "beauty_images_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beauty);

        Intent intent = getIntent();
        String beautyName = intent.getStringExtra(BEAUTY_NAME);
        int beautyImageId = intent.getIntExtra(BEAUTY_IMAGES_ID,0);
        Toolbar toolbar = findViewById(R.id.toolbar);
        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(
                R.id.collapsing_toolbar
        );
        ImageView beautyImagesView = findViewById(R.id.beauty_image_view);
        TextView beautyContentText = findViewById(R.id.beauty_content_text);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbarLayout.setTitle(beautyName);
        Glide.with(this).load(beautyImageId).into(beautyImagesView);
        String beautyContent = generateBeautyContent(beautyName);
        beautyContentText.setText(beautyContent);
    }

    private String generateBeautyContent(String beautyName) {
        StringBuilder beautyContent = new StringBuilder();
        for (int i = 0; i < 500 ; i++) {
            beautyContent.append("This is"+beautyName);
        }
        return beautyContent.toString();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
