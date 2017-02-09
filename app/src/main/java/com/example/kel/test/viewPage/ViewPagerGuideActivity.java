package com.example.kel.test.viewPage;

import java.util.ArrayList;
import java.util.List;

import com.example.kel.test.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;

/**
 * ViewPagerGuide
 *
 * @author zhangzhaolei
 */
public class ViewPagerGuideActivity extends FragmentActivity {
    private ViewPager mVPActivity;
    private FragmentGuide1 mFragmentGuide1;
    private FragmentGuide2 mFragmentGuide2;
    private FragmentGuide3 mFragmentGuide3;
    private List<Fragment> mListFragment = new ArrayList<Fragment>();
    private PagerAdapter mPgAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager_guide);
        initView();
    }

    private void initView() {
        mVPActivity = (ViewPager) findViewById(R.id.viewpager_guide);
        mFragmentGuide1 = new FragmentGuide1();
        mFragmentGuide2 = new FragmentGuide2();
        mFragmentGuide3 = new FragmentGuide3();
        mListFragment.add(mFragmentGuide1);
        mListFragment.add(mFragmentGuide2);
        mListFragment.add(mFragmentGuide3);
        mPgAdapter = new ViewPagerAdapter(getSupportFragmentManager(),
                mListFragment);
        mVPActivity.setAdapter(mPgAdapter);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            return true;
        }
        //return super.onKeyDown(keyCode, event);
        return false;
    }
}
