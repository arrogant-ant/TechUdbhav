package inc.iris.techudbhav;

/**
 * Created by Nischaypc on 4/4/2018.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MyCustomAdapterGallery extends RecyclerView.Adapter<MyCustomAdapterGallery.MyViewHolder> {

    private Context context;

    private ArrayList<InformationGallery> data;

    private LayoutInflater inflater;

    private int previousPosition = 0;

    public MyCustomAdapterGallery(Context context, ArrayList<InformationGallery> data) {

        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int position) {

        View view = inflater.inflate(R.layout.list_item_rowgallery, parent, false);

        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, final int position) {


        myViewHolder.imageView.setImageResource(data.get(position).imageId);

        if(position > previousPosition){ // We are scrolling DOWN

            AnimationUtilGallery.animate(myViewHolder, true);

        }else{ // We are scrolling UP

            AnimationUtilGallery.animate(myViewHolder, false);


        }

        previousPosition = position;


        final int currentPosition = position;
        final InformationGallery infoData = data.get(position);

        myViewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        myViewHolder.imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {


                return true;
            }


        });


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{


        ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);


            imageView = (ImageView) itemView.findViewById(R.id.img_row);

        }
    }

    // This removes the data from our Dataset and Updates the Recycler View.
    private void removeItem(InformationGallery infoData) {

        int currPosition = data.indexOf(infoData);
        data.remove(currPosition);
        notifyItemRemoved(currPosition);
    }

    // This method adds(duplicates) a Object (item ) to our Data set as well as Recycler View.
    private void addItem(int position, InformationGallery infoData) {

        data.add(position, infoData);
        notifyItemInserted(position);
    }
}
