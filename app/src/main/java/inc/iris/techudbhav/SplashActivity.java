package inc.iris.techudbhav;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.VideoView;

import java.util.Timer;

public class SplashActivity extends AppCompatActivity {
    private final static String APP_PACKAGE = "inc.iris.techudbhav";
    private String path;
    private VideoView player;
    private Timer timeout;
    final long delay = 2500;//2.5 sec delay

    private static final String TAG = "SplashActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //  gifImageView=findViewById(R.id.gifImageView);

        playVideo();

    }

/*    private void parseVersion(String response) {
        try {
            JSONObject version = new JSONObject(response);
            int current_version = BuildConfig.VERSION_CODE;
            int min_version = version.getInt("min");
            final boolean cancelable = version.getBoolean("cancelable");
            Log.e("Splash", "min = " + min_version + " curr = " + current_version);

            if (min_version > current_version) {
                Log.e("Splash", "true");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        updateDialog(cancelable);
                    }
                });

            } else {
                Intent i = new Intent(getBaseContext(), Login.class);
                startActivity(i);

                //Remove activity
                finish();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void updateDialog(boolean cancelable) {
        Log.e("Splash", "update dialog, cancelable= " + cancelable);

        AlertDialog.Builder builder = new AlertDialog.Builder(SplashActivity.this);
        Log.e("Splash", "dialog builder");
        builder.setTitle("Update")
                .setMessage("'Tech Udbhav' has transformed to better")
                .setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + APP_PACKAGE)));
                    }
                })
                .setCancelable((cancelable))
                .setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialogInterface) {
                        Intent i = new Intent(getBaseContext(), Login.class);
                        startActivity(i);
                        //Remove activity
                        finish();

                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
        Log.e("Splash", "update dialog end");

    }*/


private void playVideo()
{
    player=findViewById(R.id.video_player);

    int i = (int) (Math.random() * 10) % 3;
    path="android.resource://inc.iris.techudbhav/";
    switch(i)

    {
        case 0:
            path = path + R.raw.splash_blue;
            break;
        case 1:
            path = path + R.raw.splash_red;
            break;
        case 2:
            path = path + R.raw.splash_green;
            break;
        default:
            path = path + R.raw.splash_blue;

    }

    Uri uri = Uri.parse(path);
    player.setVideoURI(uri);
    player.start();
    player.setOnCompletionListener(new MediaPlayer.OnCompletionListener()

    {
        @Override
        public void onCompletion (MediaPlayer mediaPlayer){
            SplashActivity.this.startActivity(new Intent(SplashActivity.this, Login.class));
            SplashActivity.this.finish();
        }
    });
}


}