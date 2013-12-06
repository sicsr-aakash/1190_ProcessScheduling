package com.humaara.process_scheduling;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

public class LoadingActivity extends Activity {

	ImageView image;
	TextView process,scheduling;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_loading);
		
		image = (ImageView)findViewById(R.id.loading_logo);
        process = (TextView)findViewById(R.id.process);
		
		AnimationSet s = new AnimationSet(false);
		TranslateAnimation a = new TranslateAnimation(-350f,0f,0f,0f);
		a.setDuration(4000);
		a.setFillAfter(true);
		
		AlphaAnimation alpha = new AlphaAnimation(0, 1);
		alpha.setDuration(3000);
		
		RotateAnimation r = new RotateAnimation(0f,-360f,20,20);
		r.setDuration(4000);
		r.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				AlphaAnimation alpha1 = new AlphaAnimation(0,1);
				process.startAnimation(alpha1);	
			}
		});
		
		s.addAnimation(alpha);
		s.addAnimation(a);
		s.addAnimation(r);
		
		image.startAnimation(s);
		
		s.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Intent i = new Intent(getApplicationContext(), MainActivity.class);
			    startActivity(i);
			    overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
			    finish();
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_loading, menu);
		return true;
	}

}
