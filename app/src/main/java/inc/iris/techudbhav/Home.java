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
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import inc.iris.techudbhav.logic.NavigationHelper;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

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




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(this);

        //carouselSetup
        carouselSetup();
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
