package inc.iris.techudbhav;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import inc.iris.techudbhav.logic.RegistrationHelper;

public class MemeShow extends AppCompatActivity {

    private static final String TAG = "MemeShow";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meme_show);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void getDetails(View view) {
        Intent intent=new Intent(this,PdfViewer.class);
        String detailURL = "https://www.facebook.com/ietebits/photos/a.461625310646319.1073741826.461609930647857/1134508990024611/?type=3&theater";
        intent.putExtra("url", detailURL);
        startActivity(intent);

    }

    public void register(View view) {
        RegistrationHelper helper=new RegistrationHelper(this);
        helper.register(TAG);
    }
}
