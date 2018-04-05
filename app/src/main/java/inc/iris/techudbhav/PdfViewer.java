package inc.iris.techudbhav;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;


public class PdfViewer extends AppCompatActivity {
    private WebView webView;
    private Toolbar toolbar;
    private String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_viewer);
        webView=findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        url=getIntent().getExtras().getString("url","https://drive.google.com/file/d/1Ta9ldjnRMFdceyiuteYYv0vj7B5KVi3U/view?usp=sharing");
        webView.loadUrl(url);


    }
}
