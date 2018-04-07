package inc.iris.techudbhav;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.AuthUI.IdpConfig;
import com.firebase.ui.auth.ErrorCodes;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.gms.common.Scopes;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Login extends AppCompatActivity {
    private static final String TAG = "Login";
    private static final int RC_SIGN_IN = 100;

    View mRootView;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        mRootView = findViewById(R.id.root);
        signIn();


    }

    public void signIn() {
        startActivityForResult(
                AuthUI.getInstance().createSignInIntentBuilder()
                        .setAvailableProviders(getSelectedProviders())
                        .setTheme(R.style.LoginTheme)
                        .build(),
                RC_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            handleSignInResponse(resultCode, data);
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        FirebaseAuth auth = FirebaseAuth.getInstance();
        if (auth.getCurrentUser() != null) {
            startSignedInActivity(null);
            finish();
        }
    }

    private void handleSignInResponse(int resultCode, Intent data) {
        IdpResponse response = IdpResponse.fromResultIntent(data);

        // Successfully signed in
        if (resultCode == RESULT_OK) {
            startSignedInActivity(response);
            finish();
        } else {
            // Sign in failed
            if (response == null) {
                // User pressed back button
                showSnackbar(R.string.sign_in_cancelled);
                return;
            }

            if (response.getError().getErrorCode() == ErrorCodes.NO_NETWORK) {
                showSnackbar(R.string.no_internet_connection);
                return;
            }

            showSnackbar(R.string.unknown_error);
            Log.e(TAG, "Sign-in error: ", response.getError());
        }
    }

    private void startSignedInActivity(IdpResponse response) {
        Log.d(TAG, "startSignedInActivity: " + response);
        startActivity(new Intent().setClass(this, Home.class)
                .putExtra("idpResponse", response));
    }


    private List<IdpConfig> getSelectedProviders() {
        List<IdpConfig> selectedProviders = new ArrayList<>();

        selectedProviders.add(
                new IdpConfig.GoogleBuilder().setScopes(getGoogleScopes()).build());
        selectedProviders.add(new IdpConfig.EmailBuilder()
                .setRequireName(true)
                .setAllowNewAccounts(true)
                .build());

        selectedProviders.add(new IdpConfig.PhoneBuilder().build());

        return selectedProviders;
    }


    private List<String> getGoogleScopes() {
        List<String> result = new ArrayList<>();

        result.add("https://www.googleapis.com/auth/youtube.readonly");

        result.add(Scopes.DRIVE_FILE);

        return result;
    }


    private void showSnackbar(@StringRes int errorMessageRes) {
        Snackbar.make(mRootView, errorMessageRes, Snackbar.LENGTH_LONG).show();
    }
}
