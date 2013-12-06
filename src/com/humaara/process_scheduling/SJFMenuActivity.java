package com.humaara.process_scheduling;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SJFMenuActivity extends Activity {

	Button next,info;
	EditText arrivalTime1,arrivalTime2,arrivalTime3,burstTime1,burstTime2,burstTime3;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sjfmenu);
		
		next=(Button)findViewById(R.id.nextbtnSJF);
		info=(Button)findViewById(R.id.infoSJF);
		burstTime1=(EditText)findViewById(R.id.burstTimeSJF1);
		burstTime2=(EditText)findViewById(R.id.burstTimeSJF2);
		burstTime3=(EditText)findViewById(R.id.burstTimeSJF3);
		
		arrivalTime1 = (EditText)findViewById(R.id.arrivalTimeSJF1);
		arrivalTime2=(EditText)findViewById(R.id.arrivalTimeSJF2);
		arrivalTime3=(EditText)findViewById(R.id.arrivalTimeSJF3);
		
		next.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				if(arrivalTime1.getText().toString().equals("") || arrivalTime2.getText().toString().equals("") || arrivalTime3.getText().toString().equals(""))
				{
							Toast.makeText(getApplicationContext(), "Enter all values for arrival time", Toast.LENGTH_LONG).show();
				}
				else if(burstTime1.getText().toString().equals("") || burstTime2.getText().toString().equals("") || burstTime3.getText().toString().equals(""))
				{
							Toast.makeText(getApplicationContext(), "Enter all values for burst time", Toast.LENGTH_LONG).show();
				}
				else
				{
				float arrivalTime11 = Float.parseFloat(arrivalTime1.getText().toString());
				float arrivalTime22 = Float.parseFloat(arrivalTime2.getText().toString());
				float arrivalTime33 = Float.parseFloat(arrivalTime3.getText().toString());
				
				float burstTime11 = Float.parseFloat(burstTime1.getText().toString());
				float burstTime22 = Float.parseFloat(burstTime2.getText().toString());
				float burstTime33 = Float.parseFloat(burstTime3.getText().toString()); 
				
				//Toast.makeText(getApplicationContext(),burstTime11+" "+burstTime22+" "+burstTime33,  Toast.LENGTH_LONG).show();
				
				//String[] p_name = {"PO","P1","P2"};
				float[] arrival_time = {arrivalTime11,arrivalTime22,arrivalTime33};
		        float[] burst_time = {burstTime11,burstTime22,burstTime33};
		        
				Intent i = new Intent(getApplicationContext(),SJFActivity.class);
				i.putExtra("arrivalTime1",arrivalTime11 );
				i.putExtra("arrivalTime2",arrivalTime22 );
				i.putExtra("arrivalTime3",arrivalTime33 );
				i.putExtra("burstTime1", burstTime11);
				i.putExtra("burstTime2", burstTime22);
				i.putExtra("burstTime3", burstTime33);
				startActivity(i);
				}
			}
		});
		
		info.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent i = new Intent(getApplicationContext(),SJFInfoActivity.class);
				startActivity(i);
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_sjfmenu, menu);
		return true;
	}

}
