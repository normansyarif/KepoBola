package com.miku.kepobola;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.webkit.WebView;

public class ContentActivity extends AppCompatActivity {

    WebView myBrowser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getIntent().getStringExtra("titleContent"));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        initWebview();
    }

    private void initWebview() {
        myBrowser = findViewById(R.id.mybrowser);
        myBrowser.getSettings().setJavaScriptEnabled(true);
        myBrowser.getSettings().setBuiltInZoomControls(true);
        myBrowser.getSettings().setDisplayZoomControls(false);
        myBrowser.loadUrl("file:///android_asset/" + getIntent().getStringExtra("fileContent"));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
