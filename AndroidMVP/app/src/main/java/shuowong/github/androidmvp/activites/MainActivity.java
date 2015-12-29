package shuowong.github.androidmvp.activites;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.githang.viewpagerindicator.IconPagerAdapter;
import com.githang.viewpagerindicator.IconTabPageIndicator;

import java.util.ArrayList;
import java.util.List;

import shuowong.github.androidmvp.R;
import shuowong.github.androidmvp.fragments.BaseTabFragment;
import shuowong.github.androidmvp.fragments.MessageTabFragment;
import shuowong.github.androidmvp.fragments.MyTabFragment;
import shuowong.github.androidmvp.fragments.WorkTabFragment;


/**
 * Created by WANGSHUO on 12/28/15.
 */
public class MainActivity extends FragmentActivity {

    private ViewPager mViewPager;
    private IconTabPageIndicator mIndicator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mIndicator = (IconTabPageIndicator) findViewById(R.id.indicator);

        List<BaseTabFragment> fragments = initFragments();
        FragmentAdapter adapter = new FragmentAdapter(fragments, getSupportFragmentManager());
        mViewPager.setAdapter(adapter);
        mIndicator.setViewPager(mViewPager);
    }

    private List<BaseTabFragment> initFragments() {
        List<BaseTabFragment> fragments = new ArrayList<BaseTabFragment>();

        BaseTabFragment userFragment = new WorkTabFragment();
        userFragment.setTitle("工作");
        userFragment.setIconId(R.drawable.tab_user_selector);
        fragments.add(userFragment);

        BaseTabFragment noteFragment = new MessageTabFragment();
        noteFragment.setTitle("消息");
        noteFragment.setIconId(R.drawable.tab_record_selector);
        fragments.add(noteFragment);

        BaseTabFragment contactFragment = new MyTabFragment();
        contactFragment.setTitle("我的");
        contactFragment.setIconId(R.drawable.tab_user_selector);
        fragments.add(contactFragment);

        return fragments;
    }

    class FragmentAdapter extends FragmentPagerAdapter implements IconPagerAdapter {
        private List<BaseTabFragment> mFragments;

        public FragmentAdapter(List<BaseTabFragment> fragments, FragmentManager fm) {
            super(fm);
            mFragments = fragments;
        }

        @Override
        public Fragment getItem(int i) {
            return mFragments.get(i);
        }

        @Override
        public int getIconResId(int index) {
            return mFragments.get(index).getIconId();
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragments.get(position).getTitle();
        }
    }
}
