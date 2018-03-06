package inc.iris.techudbhav;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Sud on 2/27/18.
 */

public final class NavigationHelper {
    public static void navigate(Context context,int resID)
    {
        Activity activity=(Activity)context;
        switch (resID)
        {
            case R.id.nav_event:
                Intent eventsIntent=new Intent(context,EventsActivity.class);
                eventsIntent.putExtra(TechEvent.EVENT_NAME,"CodeWar");
                activity.startActivity(eventsIntent);
                activity.finish();
                break;
            case R.id.nav_home:
                context.startActivity(new Intent(context,Home.class));
                activity.finish();
                break;
        }
    }
}
