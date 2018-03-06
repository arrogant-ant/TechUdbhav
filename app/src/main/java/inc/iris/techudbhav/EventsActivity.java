package inc.iris.techudbhav;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class EventsActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    private ImageView eventImg;
    private TextView eventName;
    private TextView eventPrize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.events_nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //set detail card
        setDetail();

        //Recycle view
        setRecyclerView();
    }

    private void setDetail() {
        eventImg = findViewById(R.id.event_img);
        eventName = findViewById(R.id.event_title);
        eventPrize = findViewById(R.id.event_prize);
        Bundle extra = getIntent().getExtras();
        eventImg.setImageResource(extra.getInt(TechEvent.EVENT_IMG, R.drawable.ic_developer));
        eventName.setText(extra.getString(TechEvent.EVENT_NAME, "Code War"));
        eventPrize.setText(extra.getString(TechEvent.EVENT_PRIZE, "12,000"));
    }

    /**
     * Recycler view setup
     */

    private void setRecyclerView() {
        recyclerView = findViewById(R.id.events_recycler);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new CustomAdapter(EventsActivity.this, getEventData()));

    }

    private List<TechEvent> getEventData() {
        List<TechEvent> events = new ArrayList<>();
        TechEvent event;
        String[] name = {"Mr. & Miss Technocrat", "Byte The Bits"
                , "Insight", "Geek-O-Mania"
                , "Industrial Problem Solution", "People's Voice"
                , "Tech Expo", "Graffiti"
                , "Game-O-Thon","Soccer Bot"};
        String[] prize = {"10,000", "12,100", "10,000", "12,100", "10,000"};
        int[] imgId = {R.drawable.ic_ambassador, R.drawable.ic_college, R.drawable.ic_developer, R.drawable.carousel1, R.drawable.carousel2};
        for (int i = 0; i < name.length; i++) {
            event = new TechEvent(name[i], prize[i], imgId[i]);
            events.add(event);
        }
        return events;
    }

    /**
     * Navigation actions
     */
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
        getMenuInflater().inflate(R.menu.events, menu);
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
        NavigationHelper.navigate(EventsActivity.this, id);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
