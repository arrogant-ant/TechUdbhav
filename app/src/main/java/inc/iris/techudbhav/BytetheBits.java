package inc.iris.techudbhav;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import inc.iris.techudbhav.logic.RegistrationHelper;

public class BytetheBits extends AppCompatActivity {

    private static final String TAG = "BytetheBits";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bytethe_bits);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void getDetails(View view) {
        Intent intent=new Intent(this,PdfViewer.class);
        String detailURL = "https://drive.google.com/file/d/1TUuIV5vP579C4yXoOG6wB1cxFfUNr_G-/view?usp=sharing";
        intent.putExtra("url", detailURL);
        startActivity(intent);

    }

    public void register(View view) {
        RegistrationHelper helper=new RegistrationHelper(this);
        helper.register(TAG);
        Toast.makeText(this, "Successfully registered", Toast.LENGTH_SHORT).show();
    }
}
