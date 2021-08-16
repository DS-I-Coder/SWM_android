package com.duksung.studywithme.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.http.SslError;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.PermissionRequest;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import com.duksung.studywithme.R;
import com.duksung.studywithme.common.Common;
import com.duksung.studywithme.model.TestModel;
import com.duksung.studywithme.retrofit.RetrofitHelper;
import com.duksung.studywithme.retrofit.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TestAActivity extends AppCompatActivity {

    WebView layout_webview;
    private static String url = Common.BASE_SERVER_URL + "/a1575f4a-0fff-4165-a26b-99803c29a609";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_a);





        layout_webview = findViewById(R.id.layout_webview);

        WebSettings settings = layout_webview.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);

        layout_webview.setWebViewClient(new WebViewClient() {

            @Override
            public void onReceivedSslError(WebView view, final SslErrorHandler handler, SslError error) {

            }
        });

        layout_webview.setWebChromeClient(new WebChromeClient(){

        });

        layout_webview.setWebContentsDebuggingEnabled(true);
        layout_webview.loadUrl("http://192.168.0.21:3000/a1575f4a-0fff-4165-a26b-99803c29a609");
    }
}
