package inc.iris.techudbhav;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class TechExpo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tech_expo);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void showDetails(View view) {
        Intent intent=new Intent(this,PdfViewer.class);
        String detailURL = "https://drive.google.com/file/d/1Ta9ldjnRMFdceyiuteYYv0vj7B5KVi3U/view?usp=sharing";
        intent.putExtra("url", detailURL);
        startActivity(intent);
    }
}
