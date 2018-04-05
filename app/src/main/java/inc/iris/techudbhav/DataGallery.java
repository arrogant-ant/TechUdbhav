package inc.iris.techudbhav;

/**
 * Created by Nischaypc on 4/4/2018.
 */
import java.util.ArrayList;


public class DataGallery {


    public static ArrayList<InformationGallery> getData() {

        ArrayList<InformationGallery> data = new ArrayList<>();

        int[] images = {
                R.drawable.a,
                R.drawable.b,
                R.drawable.c,
                R.drawable.d,
                R.drawable.e,
                R.drawable.f,
                R.drawable.g,

                R.drawable.h,
                R.drawable.i,
                R.drawable.j,
                R.drawable.k,
                R.drawable.l,

                R.drawable.m,

                R.drawable.o,

        };



        for (int i = 0; i < images.length; i++) {

            InformationGallery current = new InformationGallery();

            current.imageId = images[i];

            data.add(current);
        }

        return data;
    }

}
