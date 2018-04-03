package inc.iris.techudbhav;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;

public class Workshops extends AppCompatActivity {

    String arrayName[]={"Internet Of Things","Android App Development","Cyber Security","Robotics","Ethical Hacking"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workshops);

        CircleMenu circleMenu=(CircleMenu)findViewById(R.id.circle_Menu);
        circleMenu.setMainMenu(Color.parseColor("#F44336"),R.drawable.workshop_two,R.drawable.workshop)
                .addSubMenu(Color.parseColor("#00B0FF"),R.drawable.iotblack)
                .addSubMenu(Color.parseColor("#006064"),R.drawable.android_appy)
                .addSubMenu(Color.parseColor("#FF6F00"),R.drawable.cybersecurity)
                .addSubMenu(Color.parseColor("#00BFA5"),R.drawable.robothree)
                .addSubMenu(Color.parseColor("#FFCA28"),R.drawable.hacki)
                .setOnMenuSelectedListener(new OnMenuSelectedListener() {
                    @Override
                    public void onMenuSelected(int i) {
                        Toast.makeText(Workshops.this,"You selected"+arrayName[i],Toast.LENGTH_SHORT).show();
                    }
                });


    }
}

