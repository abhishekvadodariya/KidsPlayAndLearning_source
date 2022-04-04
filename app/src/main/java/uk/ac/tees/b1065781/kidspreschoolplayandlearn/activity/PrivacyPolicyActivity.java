package uk.ac.tees.b1065781.kidspreschoolplayandlearn.activity;

import android.content.Context;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import uk.ac.tees.b1065781.kidspreschoolplayandlearn.R;


public class PrivacyPolicyActivity extends AppCompatActivity {

    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_policy);
        getSupportActionBar().hide();
        context=this;
        initDefine();
    }

    WebView webView;
    private void initDefine() {
        webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new MyBrowser());
        webView.loadUrl("https://kidspreschoolsplayandlearn.blogspot.com/2022/03/privacy-policy.html");
    }


    class MyBrowser extends WebViewClient{

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(request.getUrl().toString());
            return true;
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    public void onClickBack(View view) {
        finish();
    }
}
