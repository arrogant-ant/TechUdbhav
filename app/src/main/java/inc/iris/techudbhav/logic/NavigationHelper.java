package inc.iris.techudbhav.logic;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.view.MenuItem;

import inc.iris.techudbhav.BITSindri;
import inc.iris.techudbhav.CampusAmbassador;
import inc.iris.techudbhav.Developer;
import inc.iris.techudbhav.EventsActivity;
import inc.iris.techudbhav.Gallery;
import inc.iris.techudbhav.Home;
import inc.iris.techudbhav.R;
import inc.iris.techudbhav.Schedule;
import inc.iris.techudbhav.Sponsors;
import inc.iris.techudbhav.Team;
import inc.iris.techudbhav.TechUdbhav;

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
            case R.id.nav_schedule:
                intent = new Intent(mContext, Schedule.class);
                break;
            case R.id.nav_sponsors:
                intent = new Intent(mContext, Sponsors.class);
                break;
            case R.id.nav_techudbhav:
                intent = new Intent(mContext, TechUdbhav.class);
                break;
            case R.id.nav_ambassador:
                intent = new Intent(mContext, CampusAmbassador.class);
                break;
            case R.id.nav_bit:
                intent = new Intent(mContext, BITSindri.class);
                break;
            /*case R.id.nav_team:
                intent = new Intent(mContext, Team.class);
                break;*/
            case R.id.nav_event:
                intent = new Intent(mContext, EventsActivity.class);
                break;
            case R.id.nav_home:
                intent = new Intent(mContext, Home.class);
                break;
            case R.id.nav_rate_us:
                showRateDialog(mContext);
                intent = null;
                break;
            default:
                intent = new Intent(mContext, Home.class);
        }
        if(intent!=null)
            mContext.startActivity(intent);
    }

    private static void showRateDialog(final Context context) {

        final Dialog dialog = new Dialog(context);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        String msg = "If you are enjoying using Tech Udbhav please take a moment to rate us. \nThanks for the support!";
        builder.setTitle("Rate Us")
                .setMessage(msg)
                .setCancelable(true)
                .setPositiveButton("Rate Now", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=inc.iris.techudbhav")));

                        dialog.dismiss();

                    }
                })
                .setNegativeButton("No, Thanks", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialog.dismiss();

                    }
                });

        builder.create();
        builder.show();
    }
}
