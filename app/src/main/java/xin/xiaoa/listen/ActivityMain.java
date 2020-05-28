package xin.xiaoa.listen;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class ActivityMain extends AppCompatActivity implements ViewPager.OnPageChangeListener {


    View view;
    ViewPager viewPager;
    Context context;

    Button butList;
    Button butSearch;
    Button butUser;

    private List<Fragment> mFragmentList; //ViewPager的数据源


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        initButton();

        initViewPager();
    }

    public List<Fragment> getMList(){
        return mFragmentList;
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

        if(position == 0) butList.setBackgroundResource(R.drawable.main_button_background_select);
        else butList.setBackgroundResource(R.drawable.main_button_background_noselect);

        if(position == 1) butSearch.setBackgroundResource(R.drawable.main_button_background_select);
        else butSearch.setBackgroundResource(R.drawable.main_button_background_noselect);

        if(position == 2) butUser.setBackgroundResource(R.drawable.main_button_background_select);
        else butUser.setBackgroundResource(R.drawable.main_button_background_noselect);

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
