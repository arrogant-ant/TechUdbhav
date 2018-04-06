package inc.iris.techudbhav;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import inc.iris.techudbhav.logic.DeveloperPagerAdapter;

public class Developer extends AppCompatActivity {

    private ViewPager viewPager;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer);
        toolbar=findViewById(R.id.appbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Developers");
        setViewPager();
    }
    private void setViewPager() {
        DeveloperPagerAdapter pagerAdapter;
        Fragment tabs[]=new Fragment[]{new DeveloperSud(),new DeveloperNilay()};

        viewPager=findViewById(R.id.view_pager);
        pagerAdapter=new DeveloperPagerAdapter(getSupportFragmentManager(),tabs.length,tabs);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        viewPager.setPageMargin((int) (getResources().getDisplayMetrics().widthPixels * -0.3));
        viewPager.setOffscreenPageLimit(5);
        viewPager.setPageTransformer(true, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(View page, float position) {
                page.setScaleX(0.8f - Math.abs(position * 0.4f));
                page.setScaleY(0.8f - Math.abs(position * 0.6f));
                page.setAlpha(1.0f - Math.abs(position * 0.5f));
            }
        });

    }

}
