package inc.iris.techudbhav;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;


public class Gallery extends AppCompatActivity {

    RecyclerView recyclerViewGallery;

    MyCustomAdapterGallery adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        recyclerViewGallery = (RecyclerView)findViewById(R.id.recycleView);
        adapter = new MyCustomAdapterGallery(this, DataGallery.getData());
        recyclerViewGallery.setAdapter(adapter);
        recyclerViewGallery.setLayoutManager(new LinearLayoutManager(this)); // Vertical Orientation By Default

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_maingallery,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id){

            case R.id.staggeredViewHorizontal:
                StaggeredGridLayoutManager mStaggeredHorizontalLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL); // (int spanCount, int orientation)
                recyclerViewGallery.setLayoutManager(mStaggeredHorizontalLayoutManager);
                break;
            case R.id.staggeredViewVertical:
                StaggeredGridLayoutManager mStaggeredVerticalLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL); // (int spanCount, int orientation)
                recyclerViewGallery.setLayoutManager(mStaggeredVerticalLayoutManager);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
