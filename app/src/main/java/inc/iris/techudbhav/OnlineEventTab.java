package inc.iris.techudbhav;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import inc.iris.techudbhav.logic.EventInterface;


/**
 * A simple {@link Fragment} subclass.
 */
public class OnlineEventTab extends Fragment implements EventInterface {


    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ImageView eventImg;
    private TextView eventName;
    private TextView eventPrize;
    private CardView detailCard;
    private TechEvent showcased;

    public OnlineEventTab() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_offline_events, container, false);
        setRecyclerView(view);

        showcased=new TechEvent("eKryptics","10,000",R.drawable.puzzlelogo,"inc.iris.techudbhav.MrMissTechnocratActivity");
        detailCard=view.findViewById(R.id.detail_card);
        detailCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    startActivity(new Intent(getActivity(), Class.forName(showcased.getClassname())));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        //set details
        eventImg = view.findViewById(R.id.event_img);
        eventName = view.findViewById(R.id.event_title);
        eventPrize = view.findViewById(R.id.event_prize);
        setDetail(showcased);
        return view;
    }
    @Override
    public void setDetail(TechEvent event) {
        eventImg.setImageResource(event.getImgRes());
        eventName.setText(event.getName());
        eventPrize.setText(event.getPrize());
        showcased=event;

    }

    /**
     * Recycler view setup
     */

    private void setRecyclerView(View view) {
        recyclerView = view.findViewById(R.id.events_recycler);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new CustomAdapter(getActivity(), getEventData(),this));

    }

    private List<TechEvent> getEventData() {
        List<TechEvent> events = new ArrayList<>();
        TechEvent event;
        String[] name = {"eKryptics", "Graffiti"
                , "Meme Show"};
        String[] classname={"EKryptics", "Grafitti"
                , "MemeShow"};
        String packageName="inc.iris.techudbhav";

        //TODO update prize and images accordingly

        String[] prize = {"Event Over", "₹ 3000", "Exciting Prizes"};
        int[] imgId = {R.drawable.puzzlelogo, R.drawable.graffiti_icon, R.drawable.memeshowone};
        for (int i = 0; i < name.length; i++) {
            event = new TechEvent(name[i], prize[i], imgId[i],packageName+"."+classname[i]);
            events.add(event);
        }
        return events;
    }



}