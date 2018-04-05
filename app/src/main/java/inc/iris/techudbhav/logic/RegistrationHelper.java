package inc.iris.techudbhav.logic;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Sud on 4/5/18.
 */

public class RegistrationHelper {
    public static void register(String eventName)
    {
        if(!isKYC())
            doKYC();
        
        DatabaseReference mDatabase= FirebaseDatabase.getInstance().getReference();
        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();

    }

    public static boolean isKYC() {
        return true;
    }
    private static void doKYC()
    {

    }
}
