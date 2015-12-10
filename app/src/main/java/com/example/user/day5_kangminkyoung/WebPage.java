package com.example.user.day5_kangminkyoung;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class WebPage extends LinearLayout{

    Context mContext;
    private WebView webView;
    private Button moveButton;
    private EditText urlInput;

    public WebPage(Context context) {
        super(context);
        init(context);
    }

    public WebPage(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(final Context context) {
        mContext = context;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.web_pager, this, true);

        webView = (WebView) findViewById(R.id.webView);
        urlInput = (EditText) findViewById(R.id.urlInput);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());

        moveButton = (Button) findViewById(R.id.moveButton);
        moveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                webView.loadUrl(urlInput.getText().toString());
                InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(urlInput.getWindowToken(), 0);
            }
        });
    }

    public void seturlInput(String urlStr) {
        urlInput.setText(urlStr);
    }
}

