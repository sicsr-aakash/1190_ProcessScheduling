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

public class RoundRobinActivity extends Activity {

	ImageView blue,orange,red;
	Button start,finish;
	TranslateAnimation trans1,trans2,trans;
	TextView messages;
	String message;
	
	int finish1=0,finish2=0,finish3=0,next=0;

	float from1,from2,from3,to1,to2,to3;
	int counter, processBurstTime1,processBurstTime2,processBurstTime3,quantumValue,BT1,BT2,BT3,Q;
	int wait1,wait2,wait3;
	float avgW,avgTurnA;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_round_robin);

		counter = 0;
		
		Bundle extra = getIntent().getExtras();
		
		if(extra != null)
		{
			processBurstTime1 = extra.getInt("Burst1");
			processBurstTime2 = extra.getInt("Burst2");
			processBurstTime3 = extra.getInt("Burst3");
			quantumValue = extra.getInt("Quantum");
		}
		
		BT1=processBurstTime1;
		BT2=processBurstTime2;
		BT3=processBurstTime3;
		Q=quantumValue;
		
		blue = (ImageView)findViewById(R.id.blueRR);
		orange = (ImageView)findViewById(R.id.orangeRR);
		red = (ImageView)findViewById(R.id.redRR);
			
		start = (Button)findViewById(R.id.startRR);
		finish = (Button)findViewById(R.id.finishRR);
		messages = (TextView)findViewById(R.id.explainRR);
		
		finish.setVisibility(View.GONE);
		
		start.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				message =" 1. Time quantum given is  "+quantumValue+" "+"\n"+
						"\n 2. Processes in Process Queue run for "+quantumValue+" time quantum in the order of their arrival. \n"+
						"\n 3. On completion of Time Quantum the process is interrupted by the CPU scheduler. \n"+
						"\n 4. Now, the job queue is checked if there are any process.\n"+
						"\n 5. If any process remaining, scheduler picks process again and runs it for 2nd time quantum \n"+
						"\n 6. Same procedure is repeated till the execution time of each of the processes ends \n\n\n\n";

				messages.setMovementMethod(new ScrollingMovementMethod());
			
				messages.setText(message);
				
				float eachQuant =(33*(Q));
				
				if(counter == 0)
				{
					from1  = 0 ;
					if(BT1 >= Q)
					{	
						to1 = eachQuant;
					}
					else
					{
						to1 = (BT1)*33;
					}	
					
					from2  = 0 ;
					if(BT2 >= Q)
					{	
						to2 = eachQuant;
					}
					else
					{
						to2 = (BT2)*33;
					}
					
					from3  = 0 ;
					if(BT3 >= Q)
					{	
						to3 = eachQuant;
					}
					else
					{
						to3 = (BT3)*33;
					}	
				}
				
				
				trans = new TranslateAnimation(from1,to1, 0f, 0f);
				trans.setDuration(1500);
				trans.setFillAfter(true);
				trans.setAnimationListener(new AnimationListener() {
					
					@Override
					public void onAnimationStart(Animation animation) {
						
					}
					
					@Override
					public void onAnimationRepeat(Animation animation) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void onAnimationEnd(Animation animation) {
					
						if(BT1==0)
						{
							Toast.makeText(getApplicationContext(), "Process 1 Completed", Toast.LENGTH_LONG).show();
						}
					}
				});
				
				trans1 = new TranslateAnimation(from2 ,to2 , 0f,0f);
				trans1.setDuration(1500);
				if(BT1!=0)
				{	
					trans1.setStartOffset(2000);
				}
				trans1.setFillAfter(true);
				trans1.setAnimationListener(new AnimationListener() {
					
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
						
						if(BT2==0)
						{
							Toast.makeText(getApplicationContext(), "Process 2 Completed", Toast.LENGTH_LONG).show();
						}
					}
				});
				
				trans2 = new TranslateAnimation(from3 ,to3 , 0f,0f);
				trans2.setDuration(1500);
				if(BT1==0 && BT2==0)
				{
					
				}
				else if(BT1==0 || BT2==0)
				{
					trans2.setStartOffset(2000);
				}	
				else if(BT1!=0 && BT2 !=0)
				{	
					trans2.setStartOffset(4000);
				}
				trans2.setFillAfter(true);
				trans2.setAnimationListener(new AnimationListener() {
					
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
						
						if(BT3==0)
						{
							Toast.makeText(getApplicationContext(), "Process 3 Completed", Toast.LENGTH_LONG).show();		
						}
					}
				});
				
				if(BT1 > 0)
				{	
					blue.startAnimation(trans);
					next=next+Q;
					finish1=next;
				}
				
				if(BT2 > 0)
				{	
					orange.startAnimation(trans1);
					next=next+Q;
					finish2=next;
				}
				
				if(BT3 > 0)
				{	
					red.startAnimation(trans2);
					next=next+Q;
					finish3=next;
				}	
				

				counter++;
				
				BT1 = BT1 - Q;
				if(BT1 < 0){ BT1=0; }
				
				BT2 = BT2 - Q;
				if(BT2 < 0){ BT2=0; }
				
				BT3 = BT3 - Q;
				if(BT3 < 0){ BT3=0; }
				
				
				if((BT1+BT2+BT3) > 0)
				{	
					if(BT1 > 0)
					{
						if(BT1 >= Q)
						{	
							from1 = to1;
							to1 = to1 + eachQuant;
							start.setText("NEXT");
						}
						else
						{
							from1 = to1;
							to1 = to1 + ((BT1)*33);
							start.setText("NEXT");
						}	
					}
					
					if(BT2 > 0)
					{
						if(BT2 >= Q)
						{	
							from2 = to2;
							to2 = to2 + eachQuant;
							start.setText("NEXT");
						}
						else
						{
							from2 = to2;
							to2 = to2 + ((BT2)*33);
							start.setText("NEXT");
						}	
					}
					
					if(BT3 > 0)
					{
						if(BT3 >= Q)
						{	
							from3 = to3;
							to3 = to3 + eachQuant;
							start.setText("NEXT");
						}
						else
						{
							from3 = to3;
							to3 = to3 + ((BT3)*33);
							start.setText("NEXT");
						}	
					}
				}	
				else
				{	
					counter = 0;
					
					trans.reset();
					trans1.reset();
					trans2.reset();
					
					BT1=processBurstTime1;
					BT2=processBurstTime2;
					BT3=processBurstTime3;
					Q=quantumValue;
					
					wait1 = finish1-BT1;
					wait2 = finish2-BT2;
					wait3 = finish3-BT3;
					
					avgW=(wait1+wait2+wait3)/3.0f;
					
					avgTurnA=(finish1+finish2+finish3)/3.0f;
					
					
					Toast.makeText(getApplicationContext(), "Process Queue Empty", Toast.LENGTH_LONG).show();
							
					finish.setVisibility(View.VISIBLE);
					start.setVisibility(View.GONE);
				}
			
			}
		});
		
		finish.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			
				Intent i=new Intent(getApplicationContext(),RRresultsActivity.class);
				i.putExtra("avgW", avgW);
				i.putExtra("avgTurnA", avgTurnA);
				startActivity(i);
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_round_robin, menu);
		return true;
	}

}
