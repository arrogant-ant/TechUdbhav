package inc.iris.techudbhav;


import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FooterFragment extends Fragment {

    ImageView fb,mail,youtube;
    private final String youtubeID="N0LEm_gcIFA&t=18s";
    private final String fbURI="https://www.facebook.com/TechUdbhav";

    public FooterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_footer, container, false);
        fb=view.findViewById(R.id.fb);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(fbURI)));
            }
        });
        mail=view.findViewById(R.id.mail);
        mail.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Intent email=new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:ietebits@gmail.com"));
                                        email.putExtra(Intent.EXTRA_SUBJECT, "Report from app");
                                        getActivity().startActivity(email);
                                    }
                                }
        );

        youtube=view.findViewById(R.id.youtube);
        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v="+youtubeID)));

            }
        });
        return view;
    }

}
