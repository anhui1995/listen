package xin.xiaoa.listen;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class ActivityMain extends AppCompatActivity implements ViewPager.OnPageChangeListener {


//    View viewMusicPlayer;
    ViewPager viewPager;
    Context context;

    TextView butList;
    TextView butSearch;
    TextView butUser;

//    private CircleProgress cnp_citcleNumberProgress;

    MusicPlayer musicPlayer;

    private List<Fragment> mFragmentList; //ViewPager的数据源

    private int progress=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        initButton();

        initViewPager();

        initMusicPlayer();


    }

    public List<Fragment> getMList(){
        return mFragmentList;
    }

    private void initMusicPlayer(){

        musicPlayer = new MusicPlayer(this,this);
    }
    private void initButton(){

        butList = findViewById(R.id.main_but_list);
        butSearch = findViewById(R.id.main_but_search);
        butUser = findViewById(R.id.main_but_user);

        butList.setOnClickListener(new MyButtonClickListener());
        butSearch.setOnClickListener(new MyButtonClickListener());
        butUser.setOnClickListener(new MyButtonClickListener());

    }


    //初始化ViewPager
    private void initViewPager() {
        mFragmentList = new ArrayList<>();
        mFragmentList.add(new FragmentList(this));
        mFragmentList.add(new FragmentSearch(this));
        mFragmentList.add(new FragmentUser(this));



        viewPager = findViewById(R.id.main_viewpager);
        viewPager.setOffscreenPageLimit(3);
        viewPager.addOnPageChangeListener(this);
        MainFragmentPagerAdapter mainAdapter = new MainFragmentPagerAdapter(getSupportFragmentManager(), mFragmentList);
        viewPager.setAdapter(mainAdapter); //视图加载适配器

        setButtonBackground(0);
    }


    void setButtonBackground(int position){

//        if(position == 0) butList.setBackgroundResource(R.drawable.main_button_background_select);
//        else butList.setBackgroundResource(R.drawable.main_button_background_noselect);
//
//        if(position == 1) butSearch.setBackgroundResource(R.drawable.main_button_background_select);
//        else butSearch.setBackgroundResource(R.drawable.main_button_background_noselect);
//
//        if(position == 2) butUser.setBackgroundResource(R.drawable.main_button_background_select);
//        else butUser.setBackgroundResource(R.drawable.main_button_background_noselect);


        if(position == 0) butList.setTextAppearance(this, R.style.main_text_select);
        else butList.setTextAppearance(this, R.style.main_text_noselect);

        if(position == 1) butSearch.setTextAppearance(this, R.style.main_text_select);
        else butSearch.setTextAppearance(this, R.style.main_text_noselect);

        if(position == 2) butUser.setTextAppearance(this, R.style.main_text_select);
        else butUser.setTextAppearance(this, R.style.main_text_noselect);

//        if(position == 1) butSearch.setTypeface(Typeface.defaultFromStyle(R.style.main_text_select));
//        else butSearch.setTypeface(Typeface.defaultFromStyle(R.style.main_text_noselect));
//
//        if(position == 2) butUser.setTypeface(Typeface.defaultFromStyle(R.style.main_text_select));
//        else butUser.setTypeface(Typeface.defaultFromStyle(R.style.main_text_noselect));


    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        //ViewPager滑动
        setButtonBackground(position);
        System.out.println("selectTab"+position);

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public void funButList(){
        viewPager.setCurrentItem(0);
        setButtonBackground(0);
    }
    public void funButSearch(){
        viewPager.setCurrentItem(1);
        setButtonBackground(1);
    }
    public void funButUser(){
        viewPager.setCurrentItem(2);
        setButtonBackground(2);
    }

    class MyButtonClickListener implements View.OnClickListener{

        @Override
        public void onClick(View arg0) {
            switch (arg0.getId()) {
                case R.id.main_but_list:
                    funButList();break;
                case R.id.main_but_search:
                    funButSearch();break;
                case R.id.main_but_user:
                    funButUser();break;
            }
        }
    }



}
