package inc.iris.techudbhav;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private CarouselView carouselView;
    private int[] carouselImages;
    String arrayName[]={"Internet Of Things","Android App Development","Cyber Security","Robotics","Ethical Hacking"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
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

        NavigationView navigationView = (NavigationView) findViewById(R.id.events_nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //carouselSetup
        carouselSetup();
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
        int id = item.getItemId();
        if(id == R.id.nav_developer){
            Intent dev=new Intent(Home.this,Developer.class);
            startActivity(dev);
        }
        else if(id == R.id.nav_gallery){
            Intent gall=new Intent(Home.this,Gallery.class);
            startActivity(gall);
        }
        else if(id == R.id.nav_reg){
            Intent reg=new Intent(Home.this,Registration.class);
            startActivity(reg);
        }
        else if(id == R.id.nav_schedule){
            Intent sch=new Intent(Home.this,Schedule.class);
            startActivity(sch);
        }
        else if(id == R.id.nav_sponsors){
            Intent spon=new Intent(Home.this,Sponsors.class);
            startActivity(spon);
        }
        else if(id == R.id.nav_workshops){
            Intent wsp=new Intent(Home.this,Workshops.class);
            startActivity(wsp);
        }
        else if(id == R.id.nav_techudbhav){
            Intent tu=new Intent(Home.this,TechUdbhav.class);
            startActivity(tu);
        }
        else if(id == R.id.nav_ambassador){
            Intent ca=new Intent(Home.this,CampusAmbassador.class);
            startActivity(ca);
        }
        else if(id == R.id.nav_bit){
            Intent bs=new Intent(Home.this,BITSindri.class);
            startActivity(bs);
        }
        else if(id == R.id.nav_team){
            Intent t=new Intent(Home.this,Team.class);
            startActivity(t);
        }
        NavigationHelper.navigate(Home.this,id);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;


    }


}
