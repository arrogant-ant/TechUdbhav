package inc.iris.techudbhav;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sud on 2/27/18.
 */

class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {


    private final LayoutInflater inflater;
    private List<TechEvent> events;
    private Context context;

    CustomAdapter(Context context, List<TechEvent> events)
    {

        this.context=context;
        inflater= LayoutInflater.from(context);
        this.events=events;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.event_row,parent,false);
        ViewHolder viewHolder=new ViewHolder(context,view);
        return viewHolder ;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.name_tx.setText(events.get(position).getName());
        holder.img.setImageResource(events.get(position).getImgRes());

    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView img;
        TextView name_tx;
        Context context;
        public ViewHolder(Context context,View itemView) {
            super(itemView);
            this.context=context;
            itemView.setOnClickListener(this);
            img=itemView.findViewById(R.id.event_img);
            name_tx=itemView.findViewById(R.id.event_row_name);
        }

        @Override
        public void onClick(View view) {
            TechEvent event=events.get(getAdapterPosition());
            Intent intent=new Intent(context,EventsActivity.class);
            intent.putExtra(TechEvent.EVENT_NAME,event.getName());
            intent.putExtra(TechEvent.EVENT_PRIZE,event.getPrize());
            intent.putExtra(TechEvent.EVENT_IMG,event.getImgRes());
            Activity activity=(Activity)context;
            activity.startActivity(intent);
            activity.finish();

        }
    }
}
