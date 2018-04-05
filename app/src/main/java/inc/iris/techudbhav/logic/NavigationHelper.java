package inc.iris.techudbhav.logic;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;

import inc.iris.techudbhav.BITSindri;
import inc.iris.techudbhav.CampusAmbassador;
import inc.iris.techudbhav.Developer;
import inc.iris.techudbhav.EventsActivity;
import inc.iris.techudbhav.Gallery;
import inc.iris.techudbhav.Home;
import inc.iris.techudbhav.R;
import inc.iris.techudbhav.Registration;
import inc.iris.techudbhav.Schedule;
import inc.iris.techudbhav.Sponsors;
import inc.iris.techudbhav.Team;
import inc.iris.techudbhav.TechUdbhav;
import inc.iris.techudbhav.Workshops;

/**
 * Created by Sud on 4/5/18.
 */

public class NavigationHelper {
    public static void navigate(Context mContext, MenuItem item) {
        Intent intent;
        int id = item.getItemId();
        switch (id) {

            case R.id.nav_developer:
                intent = new Intent(mContext, Developer.class);
                break;
            case R.id.nav_gallery:
                intent = new Intent(mContext, Gallery.class);
                break;
            case R.id.nav_reg:
                intent = new Intent(mContext, Registration.class);
                break;
            case R.id.nav_schedule:
                intent = new Intent(mContext, Schedule.class);
                break;
            case R.id.nav_sponsors:
                intent = new Intent(mContext, Sponsors.class);
                break;
            case R.id.nav_workshops:
                intent = new Intent(mContext, Workshops.class);
                break;
            case R.id.nav_techudbhav:
                intent = new Intent(mContext, TechUdbhav.class);
                break;
            case R.id.nav_ambassador:
                intent=new Intent(mContext, CampusAmbassador.class);
                break;
            case R.id.nav_bit:
                intent = new Intent(mContext, BITSindri.class);
                break;
            case R.id.nav_team:
                intent = new Intent(mContext, Team.class);
                break;
            case R.id.nav_event:
                intent = new Intent(mContext, EventsActivity.class);
                break;
            case R.id.nav_home:
                intent = new Intent(mContext, Home.class);
                break;
            default:
                intent = new Intent(mContext, Home.class);
        }
        mContext.startActivity(intent);
    }
}
