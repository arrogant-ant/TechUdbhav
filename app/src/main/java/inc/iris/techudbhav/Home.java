package inc.iris.techudbhav;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;
import com.igalata.bubblepicker.BubblePickerListener;
import com.igalata.bubblepicker.model.PickerItem;
import com.igalata.bubblepicker.rendering.BubblePicker;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;

import inc.iris.techudbhav.logic.NavigationHelper;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    BubblePicker bubblePicker;
    String[] name={
            "Events",
            "Tech Udbhav",
            "Reach Us",
            "",
            "BIT Sindri",
            "",""

    };

    int[] images={

            R.drawable.gameothon,
            R.drawable.techudbhavabout,
            R.drawable.graffiti,
            R.drawable.gaming_icon,
            R.drawable.bitsindri,
            R.drawable.carousel_exhibit,
            R.drawable.groupdiscussion,
           // R.drawable.groupdiscussion,
            //R.drawable.groupdiscussion,
            //R.drawable.groupdiscussion


    };

    int[] colors={
            Color.parseColor("#E53935"),
            Color.parseColor("#1DE9B6"),
            Color.parseColor("#42A5F5"),
            Color.parseColor("#F06292"),
            Color.parseColor("#FF9800"),
            Color.parseColor("#EEFF41"),
            Color.parseColor("#00BCD4"),
           // Color.parseColor("#673AB7"),
            //Color.parseColor("#F06292"),
           // Color.parseColor("#F06292")

    };









    private static final String TAG = "Home";
    private CarouselView carouselView;
    private int[] carouselImages;
    NavigationView navigationView;
    View navHeader;
    TextView userTv;
    Button signOut;
    String arrayName[]={"Internet Of Things","Android App Development","Cyber Security","Robotics","Ethical Hacking"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setNavigationHeader();
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        /*CircleMenu circleMenu=(CircleMenu)findViewById(R.id.circle_Menu);
        circleMenu.setMainMenu(Color.parseColor("#F44336"),R.drawable.workshop_two,R.drawable.workshop)
                .addSubMenu(Color.parseColor("#00B0FF"),R.drawable.iotblack)
                .addSubMenu(Color.parseColor("#006064"),R.drawable.android_appy)
                .addSubMenu(Color.parseColor("#FF6F00"),R.drawable.cybersecurity)
                .addSubMenu(Color.parseColor("#00BFA5"),R.drawable.robothree)
                .addSubMenu(Color.parseColor("#FFCA28"),R.drawable.hacki)
                .setOnMenuSelectedListener(new OnMenuSelectedListener() {
                    @Override
                    public void onMenuSelected(int i) {
                        Toast.makeText(Home.this,"You selected"+arrayName[i],Toast.LENGTH_SHORT).show();
                    }
                });*/



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(this);

        //carouselSetup
        carouselSetup();




        //bubble picker
        bubblePicker=findViewById(R.id.picker);
        bubblePicker.setBubbleSize(80);

        ArrayList<PickerItem> listItems = new ArrayList<>();
        for(int i=0;i<name.length;i++){

            PickerItem item= new PickerItem(name[i],colors[i],Color.WHITE,getDrawable(images[i]));
            listItems.add(item);
        }
        bubblePicker.setItems(listItems);
        bubblePicker.setListener(new BubblePickerListener() {
            @Override
            public void onBubbleSelected(PickerItem pickerItem) {

                Toast.makeText(getApplicationContext(),""+pickerItem.getTitle()+" selected",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onBubbleDeselected(PickerItem pickerItem) {
                if (pickerItem.getTitle()=="Events"){
                    Intent i= new Intent(Home.this,EventsActivity.class);
                    startActivity(i);
                }
                // Toast.makeText(getApplicationContext(),""+pickerItem.getTitle()+" Deselected",Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        bubblePicker.onResume();
    }
    protected void onPause() {
        super.onPause();
        bubblePicker.onPause();
    }










    private void setNavigationHeader() {
        navigationView =findViewById(R.id.navigation);
        navHeader= navigationView.getHeaderView(0);
        userTv=navHeader.findViewById(R.id.username);
        String name=FirebaseAuth.getInstance().getCurrentUser().getDisplayName().split(" ")[0];
        Log.d(TAG, "onCreate: user"+FirebaseAuth.getInstance().getCurrentUser()+"  name "+name);
        if(name !=null && !TextUtils.isEmpty(name))
            userTv.setText(name);
        signOut=navHeader.findViewById(R.id.signOut_bt);
        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //todo user signout
                AuthUI.getInstance()
                        .signOut(Home.this)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            public void onComplete(@NonNull Task<Void> task) {
                                Toast.makeText(Home.this, "Sign Out Successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Home.this,Login.class));
                            }
                        });
            }
        });
    }

    private void carouselSetup() {
        carouselImages=new int[]{R.drawable.carousel1,
                R.drawable.carousel2,
                R.drawable.carousel3,
                R.drawable.carousel4,
                R.drawable.carousel5,
                R.drawable.carousel6};
        carouselView=findViewById(R.id.carousel);
        carouselView.setPageCount(carouselImages.length);
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(carouselImages[position]);
            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

       NavigationHelper.navigate(this,item);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;


    }







}
