package xin.xiaoa.listen;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewConfigurationCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class MusicPlayer implements ViewPager.OnPageChangeListener{
    View view;
    MainPlayerButton mainPlayerButton;


    int viewPagerNumber=0;

    private ViewPager viewPager;
    private List<Fragment> mFragmentList; //ViewPager的数据源
    Context context;
    private AppCompatActivity superActivity;

    public MusicPlayer(Context context,AppCompatActivity superActivity) {
        this.context = context;
        this.superActivity = superActivity;
        initViewPager();
        initMainPlayerButton();
    }

    private void initMainPlayerButton(){
        mainPlayerButton = superActivity.findViewById(R.id.main_player_button);


    }


    //初始化ViewPager
    @SuppressLint("ClickableViewAccessibility")
    private void initViewPager() {
        mFragmentList = new ArrayList<>();
        mFragmentList.add(new FragmentMusicPlayer(context,"0","随手纪念","单色凌"));
        mFragmentList.add(new FragmentMusicPlayer(context,"1","未成年","本兮的未成年中的一句歌词"));
        mFragmentList.add(new FragmentMusicPlayer(context,"2","杏花弦外雨","旧书翻入寻常调"));
        mFragmentList.add(new FragmentMusicPlayer(context,"3","Safe & Sound","When I said I'll never let you go "));
        mFragmentList.add(new FragmentMusicPlayer(context,"4","爱之光","青春期如花一般开放"));
        mFragmentList.add(new FragmentMusicPlayer(context,"5","山丘","想说却还没说的还很多"));
        mFragmentList.add(new FragmentMusicPlayer(context,"6","九张机","光阴如梭 一梭才去一梭痴"));

        ViewConfiguration configuration = ViewConfiguration.get(context);
        final int mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(configuration);

        viewPager = superActivity.findViewById(R.id.main_player_viewpager);

        viewPager.setOnTouchListener(new View.OnTouchListener() {
            int touchFlag = 0;
            float x = 0, y = 0;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        touchFlag = 0;
                        x = event.getX();
                        y = event.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        float xDiff = Math.abs(event.getX() - x);
                        float yDiff = Math.abs(event.getY() - y);
                        if (xDiff < mTouchSlop && xDiff >= yDiff)
                            touchFlag = 0;
                        else
                            touchFlag = -1;
                        break;
                    case MotionEvent.ACTION_UP:
                        if (touchFlag == 0) {

                            System.out.println("ViewPager点击事件"+viewPagerNumber);
                        }
                        break;
                }
                return false;
            }
        });
        viewPager.setOffscreenPageLimit(3);
        viewPager.addOnPageChangeListener(this);
        MainFragmentPagerAdapter mainAdapter = new MainFragmentPagerAdapter(superActivity.getSupportFragmentManager(), mFragmentList);
        viewPager.setAdapter(mainAdapter); //视图加载适配器

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

        System.out.println("ViewPager滑动事件"+position);
        viewPagerNumber = position;
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
