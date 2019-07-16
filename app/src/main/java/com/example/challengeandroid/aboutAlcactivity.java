package com.example.challengeandroid;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;

public class aboutAlcactivity extends AppCompatActivity {
    private WebView webView;
    private ImageButton imageButton;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_alc);

        //connecting the variables
        webView = findViewById(R.id.webview);
        WebSettings webSettings = webView.getSettings();
        //settings for the webview
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setAllowContentAccess(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);

        progressDialog = new ProgressDialog(aboutAlcactivity.this);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                //dismisses the dialog when webview is done loading
                if(progressDialog.isShowing()){
                    progressDialog.dismiss();
                }
            }
        });
        //set dialog message
        progressDialog.setMessage("Loading... Please wait.");
        //will not cancel if you touch the screen when loading
        progressDialog.setCanceledOnTouchOutside(false);

        progressDialog.show();

        //loads the url
        webView.loadUrl("https://andela.com/alc/");

        imageButton = findViewById(R.id.backpress);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }
}
