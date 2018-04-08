package inc.iris.techudbhav.logic;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import inc.iris.techudbhav.R;

/**
 * Created by Sud on 4/5/18.
 */

public class RegistrationHelper {
    private Context mContext;
    DatabaseReference mDatabase;
    FirebaseUser user;
    String userID;
    static String name="Tech Udbhav";
    private String eventName;
    private static final String TAG = "RegistrationHelper";

    public RegistrationHelper(Context mContext) {
        this.mContext = mContext;
        mDatabase = FirebaseDatabase.getInstance().getReference();
        user = FirebaseAuth.getInstance().getCurrentUser();
        userID = user.getUid();
    }

    public void register(String eventName) {
        this.eventName=eventName;
        KYC();
        Log.d(TAG, "register: ");



    }
    private void showSuccessDialog()
    {
        mDatabase.child("registration").child(userID).child(eventName).push().setValue("registered");
        final AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setTitle("Registration success")
                .setMessage("\nThanks for registering.\n\tSee you soon")
                .setCancelable(true);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void KYC() {
        DatabaseReference mParticipantReference = FirebaseDatabase.getInstance().getReference()
                .child("users").child(userID);

        ValueEventListener participantListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.getValue() == null || dataSnapshot.getChildren() == null) {
                    //Key does not exist
                    Log.d(TAG, "onDataChange: " + dataSnapshot);
                    doKYC();
                }
                else
                {
                   showSuccessDialog();

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        };
        mParticipantReference.addListenerForSingleValueEvent(participantListener);

    }

    private void doKYC() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.activity_registration, null);
        builder.setView(view)
                .setCancelable(true);

        final AlertDialog dialog = builder.create();
        dialog.show();
        final EditText nameET, collegeET, phET, emailET, rollET;
        Button submitBT;

        nameET = view.findViewById(R.id.name);
        collegeET = view.findViewById(R.id.college);
        phET = view.findViewById(R.id.ph);
        emailET = view.findViewById(R.id.email);
        rollET = view.findViewById(R.id.roll);
        submitBT = view.findViewById(R.id.submit_button);
        submitBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name, college, ph, email, roll;
                name = nameET.getText().toString();
                college = collegeET.getText().toString();
                ph = phET.getText().toString();
                email = emailET.getText().toString();
                roll = rollET.getText().toString();
                //validation rules
                if (TextUtils.isEmpty(name))
                    Toast.makeText(mContext, "Please enter your name", Toast.LENGTH_SHORT).show();
                else if (TextUtils.isEmpty(college))
                    Toast.makeText(mContext, "Please enter your college name", Toast.LENGTH_SHORT).show();
                else if (TextUtils.isEmpty(roll))
                    Toast.makeText(mContext, "Please enter your roll number", Toast.LENGTH_SHORT).show();
                else if (ph.length() != 10)
                    Toast.makeText(mContext, "Please enter valid mobile number ", Toast.LENGTH_SHORT).show();
                else if (!email.contains("@"))
                    Toast.makeText(mContext, "Please enter valid email id", Toast.LENGTH_SHORT).show();

                    //todo write data to firebase
                else {
                    Participant participant = new Participant(name, roll, college, ph, email);
                    writeNewParticipant(participant);
                    dialog.dismiss();
                    showSuccessDialog();

                }
            }
        });
    }

    private void writeNewParticipant(Participant participant) {
        Log.d(TAG, "writeNewParticipant: ");
        mDatabase.child("users").child(userID).setValue(participant);
        mDatabase.child("registration").child(userID).setValue(participant);

    }

    public  String getParticipantName() {
        DatabaseReference mParticipantNameReference = FirebaseDatabase.getInstance().getReference()
                .child("users").child(userID);

        ValueEventListener participantListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.getValue() == null || dataSnapshot.getChildren() == null) {
                    //Key does not exist
                    Log.d(TAG, "onDataChange: " + dataSnapshot);
                    String user_name = FirebaseAuth.getInstance().getCurrentUser().getDisplayName();
                    if (user_name != null)
                        name = user_name;


                } else {
                    Participant participant = dataSnapshot.getValue(Participant.class);
                    name=participant.getName();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        };
        mParticipantNameReference.addListenerForSingleValueEvent(participantListener);
        return name;

    }
}
