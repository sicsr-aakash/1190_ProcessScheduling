package com.humaara.process_scheduling;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RRMenuActivity extends Activity {

	Button next, info;
	EditText burst1,burst2,burst3,quantum;
	int burstT1,burstT2,burstT3,QuanT;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rrmenu);
		
		burst1=(EditText)findViewById(R.id.burstTime1RR);
		burst2=(EditText)findViewById(R.id.burstTime2RR);
		burst3=(EditText)findViewById(R.id.burstTime3RR);
		quantum=(EditText)findViewById(R.id.quantum);
		
		next=(Button)findViewById(R.id.nextbtn);
		info=(Button)findViewById(R.id.infoRR);
		
		next.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			
				if(burst1.getText().toString().equals("") || burst2.getText().toString().equals("") || burst3.getText().toString().equals(""))
				{
					Toast.makeText(getApplicationContext(), "Enter All Values For Burst Time", Toast.LENGTH_LONG).show();
				}
				else if (quantum.getText().toString().equals("")) 
				{
					Toast.makeText(getApplicationContext(), "Enter Time Quantum", Toast.LENGTH_LONG).show();
				}
				else
				{	
					burstT1=Integer.parseInt(burst1.getText().toString());
					burstT2=Integer.parseInt(burst2.getText().toString());
					burstT3=Integer.parseInt(burst3.getText().toString());
					QuanT=Integer.parseInt(quantum.getText().toString());
				
					Toast.makeText(getApplicationContext(), "Assuming Arrival Time of All Processes is Same", Toast.LENGTH_LONG).show();
					
					Intent i=new Intent(getApplicationContext(),RoundRobinActivity.class);
					i.putExtra("Burst1", burstT1);
					i.putExtra("Burst2", burstT2);
					i.putExtra("Burst3", burstT3);
					i.putExtra("Quantum", QuanT);
					startActivity(i);
				}
			}
		});
		
		info.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent i = new Intent(getApplicationContext(),RRInfoActivity.class);
				startActivity(i);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_rrmenu, menu);
		return true;
	}

}
