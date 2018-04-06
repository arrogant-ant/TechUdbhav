package inc.iris.techudbhav;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DeveloperSud extends Fragment {


    private ImageView fb, mail, github, linkedIn, dp;
    private TextView name,batch;
    private final String fbURI = "https://www.facebook.com/sudhanshuambastha";
    private final String linkedInURI = "www.linkedin.com/in/sudhanshu-ambastha";
    private final String githubURI = "https://github.com/s-ambastha";

    public DeveloperSud() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_developer_sud, container, false);
        dp=view.findViewById(R.id.dp);
        dp.setImageResource(R.drawable.sud);
        fb = view.findViewById(R.id.fb);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(fbURI)));
            }
        });
        mail = view.findViewById(R.id.mail);
        mail.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Intent email = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:sudhanshuambastha@live.com"));
                                        email.putExtra(Intent.EXTRA_SUBJECT, "Reply From Tech Udbhav User");
                                        getActivity().startActivity(email);
                                    }
                                }
        );

        linkedIn=view.findViewById(R.id.linked_in);
        linkedIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(linkedInURI)));
            }
        });
        github=view.findViewById(R.id.github);
        github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(githubURI)));
            }
        });
        name=view.findViewById(R.id.name);
        batch=view.findViewById(R.id.batch);
        name.setText("Sudhanshu Kr Ambastha");
        batch.setText("2014-2018");

        return view;
    }

}
