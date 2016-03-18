package com.example.weixintab;

import java.util.ArrayList;
import java.util.List;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends Activity implements OnClickListener{

	private ViewPager mViewPager;
	private PagerAdapter mAdapter;
	private List<View> mViews = new ArrayList<View>();
	//Tab
	private LinearLayout mTabWeixin;
	private LinearLayout mTabFrd;
	private LinearLayout mTabAddress;
	private LinearLayout mTabSettings;
	
	private ImageButton mWinxin_btn;
	private ImageButton mFrd_btn;
	private ImageButton mAddress_btn;
	private ImageButton mSettings_btn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		ActionBar actionBar = getActionBar();
		actionBar.hide();
		setContentView(R.layout.activity_main);
		
		initView();
		initEvents();
	}

	private void initEvents() {
		// TODO Auto-generated method stub
		mTabWeixin.setOnClickListener(this);
		mTabFrd.setOnClickListener(this);
		mTabAddress.setOnClickListener(this);
		mTabSettings.setOnClickListener(this);
		
		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				int currentItem = mViewPager.getCurrentItem();
				switch (currentItem) {
				case 0:
					mWinxin_btn.setImageResource(R.drawable.tab_weixin_pressed);
					break;
				case 1:
					mFrd_btn.setImageResource(R.drawable.tab_find_frd_pressed);
					break;
				case 2:
					mAddress_btn.setImageResource(R.drawable.tab_address_pressed);
					break;
				case 3:
					mSettings_btn.setImageResource(R.drawable.tab_settings_pressed);
					break;
				}
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	private void initView() {
		// TODO Auto-generated method stub
		mViewPager = (ViewPager) findViewById(R.id.id_viewpager);
		
		mTabWeixin = (LinearLayout) findViewById(R.id.id_tab_weixin);
		mTabFrd= (LinearLayout) findViewById(R.id.id_tab_frd);
		mTabAddress = (LinearLayout) findViewById(R.id.id_tab_address);
		mTabSettings = (LinearLayout) findViewById(R.id.id_tab_settings);
		
		mWinxin_btn = (ImageButton) findViewById(R.id.id_tab_weixin_image);
		mFrd_btn= (ImageButton) findViewById(R.id.id_tab_frd_image);
		mAddress_btn = (ImageButton) findViewById(R.id.id_tab_address_image);
		mSettings_btn = (ImageButton) findViewById(R.id.id_tab_settings_image);
		
		LayoutInflater mInflater = LayoutInflater.from(this);
		View tab01 = mInflater.inflate(R.layout.tab01, null);
		View tab02 = mInflater.inflate(R.layout.tab02, null);
		View tab03 = mInflater.inflate(R.layout.tab03, null);
		View tab04 = mInflater.inflate(R.layout.tab04, null);
		mViews.add(tab01);
		mViews.add(tab02);
		mViews.add(tab03);
		mViews.add(tab04);
		
		mAdapter = new PagerAdapter() {
			
			@Override
			public void destroyItem(ViewGroup container, int position,
					Object object) {
				// TODO Auto-generated method stub
				View view = mViews.get(position);
				container.removeView(view);
			}

			@Override
			public Object instantiateItem(ViewGroup container, int position) {
				// TODO Auto-generated method stub
				View view = mViews.get(position);
				container.addView(view);
				return view;
			}

			@Override
			public boolean isViewFromObject(View arg0, Object arg1) {
				// TODO Auto-generated method stub
				return arg0 == arg1;
			}
			
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return mViews.size();
			}
		};
		
		mViewPager.setAdapter(mAdapter);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		resetImg();
		switch (v.getId()) {
		case R.id.id_tab_weixin:
			mViewPager.setCurrentItem(0);
			mWinxin_btn.setImageResource(R.drawable.tab_weixin_pressed);
			break;
		case R.id.id_tab_frd:
			mViewPager.setCurrentItem(1);
			mFrd_btn.setImageResource(R.drawable.tab_find_frd_pressed);
			break;
		case R.id.id_tab_address:
			mViewPager.setCurrentItem(2);
			mAddress_btn.setImageResource(R.drawable.tab_address_pressed);
			break;
		case R.id.id_tab_settings:
			mViewPager.setCurrentItem(3);
			mSettings_btn.setImageResource(R.drawable.tab_settings_pressed);
			break;
		}
	}

//	
//	将所有图片切换为暗色
	
	private void resetImg() {
		// TODO Auto-generated method stub
		mWinxin_btn.setImageResource(R.drawable.tab_weixin_normal);
		mFrd_btn.setImageResource(R.drawable.tab_find_frd_normal);
		mAddress_btn.setImageResource(R.drawable.tab_address_normal);
		mSettings_btn.setImageResource(R.drawable.tab_settings_normal);
	}

	
}
