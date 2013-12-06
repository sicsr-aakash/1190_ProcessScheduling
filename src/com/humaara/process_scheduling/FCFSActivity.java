package com.humaara.process_scheduling;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class FCFSActivity extends Activity {

	float arrivalTime1,arrivalTime2,arrivalTime3;
	float burstTime1,burstTime2,burstTime3;
	ImageView process0,process1,process2;
	ImageView processArrow1,processArrow2,processArrow3;	
	float from,to;
	Button finish,start;
	TextView messages;
	String message;
	
    String[] p_name;
    float[] arrival_time;
    float[] burst_time;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fcfs);
		
		process0=(ImageView)findViewById(R.id.blue);
		process1=(ImageView)findViewById(R.id.orange);
		process2=(ImageView)findViewById(R.id.red);
		finish=(Button)findViewById(R.id.finish);
		start=(Button)findViewById(R.id.start);
		messages=(TextView)findViewById(R.id.explain);
		
		Bundle extra = getIntent().getExtras();
		
		if(extra != null)
		{
			arrivalTime1=extra.getFloat("arrivalTime1");
			arrivalTime2=extra.getFloat("arrivalTime2");
			arrivalTime3=extra.getFloat("arrivalTime3");
			burstTime1=extra.getFloat("burstTime1");
			burstTime2=extra.getFloat("burstTime2");
			burstTime3=extra.getFloat("burstTime3");
		}
		
		finish.setVisibility(View.GONE);
		
		finish.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent i = new Intent(getApplicationContext(),MenuActivity.class);
				startActivity(i);
				
			}
		});
	
		
		start.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			
		//Toast.makeText(getApplicationContext(),arrivalTime1+" "+arrivalTime2+" "+arrivalTime3,  Toast.LENGTH_LONG).show();
		//Toast.makeText(getApplicationContext(),burstTime1+" "+burstTime2+" "+burstTime3,  Toast.LENGTH_LONG).show();
		
		message =" 1. Sequence of CPU allocation to the process is decided on the basis on their arrival time.\n"+
				"\n 2. If the arrival time is same then the process with the shorter job is allocated CPU first. \n"+
				"\n 3. Once a process is allocated CPU time, it continues till completion of the process execution time and then the next process get CPU time. \n\n\n\n";

		messages.setMovementMethod(new ScrollingMovementMethod());
	
		messages.setText(message);
		
		String[] p_name={"P0","P1","P2"};
		float[] arrival_time={arrivalTime1,arrivalTime2,arrivalTime3};
		float[] burst_time={burstTime1,burstTime2,burstTime3};
		
		SJF sjf= new SJF(p_name,arrival_time,burst_time);
		
		sjf.setSequence();
		p_name = sjf.getProcessSeq();
		arrival_time = sjf.getArrivalSeq();
		burst_time = sjf.getBurstSeq();
		
//		Toast.makeText(getApplicationContext(),p_name[0]+" "+p_name[1]+" "+p_name[2],  Toast.LENGTH_SHORT).show();
//		Toast.makeText(getApplicationContext(),arrival_time[0]+" "+arrival_time[1]+" "+arrival_time[2],  Toast.LENGTH_LONG).show();
//		Toast.makeText(getApplicationContext(),burst_time[0]+" "+burst_time[1]+" "+burst_time[2],  Toast.LENGTH_LONG).show();
		
		if(p_name[0].equals("P0") && p_name[1].equals("P1") && p_name[2].equals("P2"))
		{
			int offset0 = 000;
			int offset1 = 3000;
			int offset2 = 6000;
			
			float from0 = 33*arrival_time[0];
			float to0 = 33*arrival_time[0]+33*burst_time[0];
			
			float from1 = to0;
			float to1 = from1 + 33*burst_time[1];
			
			float from2 = to1;
			float to2 = from2 + 33*burst_time[2];
			
			moveP0(from0,to0,offset0);
			moveP1(from1,to1,offset1);
			moveP2(from2,to2,offset2);
		}
		
		if(p_name[0].equals("P0") && p_name[1].equals("P2") && p_name[2].equals("P1"))
		{
			int offset0 = 000;
			int offset1 = 6000;
			int offset2 = 3000;
			

			float from0 = 33*arrival_time[0];
			float to0 = 33*arrival_time[0]+33*burst_time[0];
			
			//Toast.makeText(getApplicationContext(),from0/33+" "+to0/33,  Toast.LENGTH_LONG).show();
			
			float from2 = to0;
			float to2 = from2 + (33*burst_time[1]);
			
			//Toast.makeText(getApplicationContext(),"Burst time of 2:"+burst_time[2],  Toast.LENGTH_LONG).show();
			
			float from1 = to2;
			float to1 = from1 + 33*burst_time[2];
			
			//Toast.makeText(getApplicationContext(),from1/33+" "+to1/33,  Toast.LENGTH_LONG).show();
			moveP0(from0,to0,offset0);
			moveP2(from2,to2,offset2);
			moveP1(from1,to1,offset1);
		}
		
		if(p_name[0].equals("P1") && p_name[1].equals("P0") && p_name[2].equals("P2"))
		{
			
			int offset0 = 3000;
			int offset1 = 000;
			int offset2 = 6000;
			
			float from1 = 33*arrival_time[0];
			float to1 = from1 + 33*burst_time[0];
			
			
			float from0 = to1;
			float to0 = from0 +33*burst_time[1];
			
			//Toast.makeText(getApplicationContext(),from0/33+" "+to0/33,  Toast.LENGTH_LONG).show();
			
			float from2 = to0;
			float to2 = from2 + (33*burst_time[2]);
			
			//Toast.makeText(getApplicationContext(),"Burst time of 2:"+burst_time[2],  Toast.LENGTH_LONG).show();
			
			
			
			moveP1(from1,to1,offset1);
			moveP0(from0,to0,offset0);
			moveP2(from2,to2,offset2);
		}
		
		if(p_name[0].equals("P1") && p_name[1].equals("P2") && p_name[2].equals("P0"))
		{
			int offset0 = 6000;
			int offset1 = 000;
			int offset2 = 3000;
			
			float from1 = 33*arrival_time[0];
			float to1 = from1 + 33*burst_time[0];
			
			float from2 = to1;
			float to2 = from2 + (33*burst_time[1]);
			
			float from0 = to2;
			float to0 = from0 +33*burst_time[2];
			
			//Toast.makeText(getApplicationContext(),from0/33+" "+to0/33,  Toast.LENGTH_LONG).show();
			
			
			
			moveP1(from1,to1,offset1);
			moveP2(from2,to2,offset2);
			moveP0(from0,to0,offset0);
		}
		
		if(p_name[0].equals("P2") && p_name[1].equals("P0") && p_name[2].equals("P1"))
		{
			int offset0 = 3000;
			int offset1 = 6000;
			int offset2 = 000;
			
			float from2 = 33*arrival_time[0];
			float to2 = from2 + 33*burst_time[0];
			
			float from0 = to2;
			float to0 = from0 + (33*burst_time[1]);
			
			float from1 = to0;
			float to1 = from1 +33*burst_time[2];
			
			moveP2(from2,to2,offset2);
			moveP0(from0,to0,offset0);
			moveP1(from1,to1,offset1);
		}
		
		if(p_name[0].equals("P2") && p_name[1].equals("P1") && p_name[2].equals("P0"))
		{
			int offset0 = 6000;
			int offset1 = 3000;
			int offset2 = 000;
			
			float from2 = 33*arrival_time[0];
			float to2 = from2 + 33*burst_time[0];
			
			float from1 = to2;
			float to1 = from1 + (33*burst_time[1]);
			
			float from0 = to1;
			float to0 = from0 +33*burst_time[2];
			
			moveP2(from2,to2,offset2);
			moveP1(from1,to1,offset1);
			moveP0(from0,to0,offset0);
		}

		finish.setVisibility(View.VISIBLE);
		start.setVisibility(View.GONE);
		}
	});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_fcfs, menu);
		return true;
	}
	
	public void moveP0(float from,float to,int offset)
	{
		TranslateAnimation p0Trans = new TranslateAnimation(from,to,0,0);
		p0Trans.setDuration(3000);
		p0Trans.setFillAfter(true);
		p0Trans.setStartOffset(offset);
		p0Trans.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationRepeat(Animation arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationEnd(Animation arg0) {
				// TODO Auto-generated method stub
			
				Toast.makeText(getApplicationContext(), "Process 1 Completed", Toast.LENGTH_LONG).show();
			}
		});
		process0.startAnimation(p0Trans);
		
	}
	
	public void moveP1(float from,float to,int offset)
	{
		TranslateAnimation p1Trans = new TranslateAnimation(from,to,0,0);
		p1Trans.setDuration(3000);
		p1Trans.setStartOffset(offset);
		p1Trans.setFillAfter(true);
		p1Trans.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationRepeat(Animation arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationEnd(Animation arg0) {
				// TODO Auto-generated method stub
				
				Toast.makeText(getApplicationContext(), "Process 2 Completed", Toast.LENGTH_LONG).show();
			}
		});
		process1.startAnimation(p1Trans);
	}
	
	public void moveP2(float from,float to,int offset)
	{
		TranslateAnimation p2Trans = new TranslateAnimation(from,to,0,0);
		p2Trans.setDuration(3000);
		p2Trans.setStartOffset(offset);
		p2Trans.setFillAfter(true);
		p2Trans.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationRepeat(Animation arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationEnd(Animation arg0) {
				// TODO Auto-generated method stub
				
				Toast.makeText(getApplicationContext(), "Process 3 Completed", Toast.LENGTH_LONG).show();
			}
		});
		process2.startAnimation(p2Trans);
	
	}

}
