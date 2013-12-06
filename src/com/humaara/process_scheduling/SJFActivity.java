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

public class SJFActivity extends Activity {

	float arrivalTime1,arrivalTime2,arrivalTime3;
	float burstTime1,burstTime2,burstTime3;
	ImageView process0,process1,process2;
	String message;
	TextView messages;
	float from,to;
	Button finish,start;
		
    String[] p_name;
    float[] arrival_time;
    float[] burst_time;
     
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sjf);
		
		process0=(ImageView)findViewById(R.id.blueSJF);
		process1=(ImageView)findViewById(R.id.orangeSJF);
		process2=(ImageView)findViewById(R.id.redSJF);
		
		messages=(TextView)findViewById(R.id.explainSJF);
		finish=(Button)findViewById(R.id.finishSJF);
		start=(Button)findViewById(R.id.startSJF);
		
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
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
		message =" 1. Sequence of CPU allocation to the process is decided on the basis on their burst time.\n"+
				"\n 2. If the burst time is same then the process which came earlier in the process queue is allocated CPU time . \n"+
				"\n 3. Once a process is allocated CPU time, it continues till completion of the process execution time and then the next process get CPU time. \n\n\n\n";

		messages.setMovementMethod(new ScrollingMovementMethod());
	
		messages.setText(message);
	
		//Toast.makeText(getApplicationContext(),arrivalTime1+" "+arrivalTime2+" "+arrivalTime3,  Toast.LENGTH_LONG).show();
		//Toast.makeText(getApplicationContext(),burstTime1+" "+burstTime2+" "+burstTime3,  Toast.LENGTH_LONG).show();
		
		String[] p_name={"P0","P1","P2"};
		float[] arrival_time={arrivalTime1,arrivalTime2,arrivalTime3};
		float[] burst_time={burstTime1,burstTime2,burstTime3};
		
		SJF sjf= new SJF(p_name,arrival_time,burst_time);
		
		sjf.setSequence();
		p_name = sjf.getProcessSeq();
		arrival_time = sjf.getArrivalSeq();
		burst_time = sjf.getBurstSeq();
		
//		Toast.makeText(getApplicationContext(),arrival_time[0]+" "+arrival_time[1]+" "+arrival_time[2],  Toast.LENGTH_LONG).show();
		
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
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_sjf, menu);
		return true;
	}

}
