package com.humaara.process_scheduling;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class FCFSInfoActivity extends Activity {

	Button back;
	TextView info;
	String message;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fcfsinfo);
		
		back=(Button)findViewById(R.id.backFCFS);
		info=(TextView)findViewById(R.id.informationFCFS);
		
		message =" In FCFS Scheduling, Scheduling overhead is minimal since content switches only occur upon process termination and no reorganization of the process queue is required. \n"+
				 "\n Throughput can be low, since long processes can hog the CPU.\n"+
				 "\n Turnaround time, waiting time and response time can be low for the same reason. \n"+
				 "\n No prioritization occurs, thus this system has trouble meeting process deadlines. \n"+
				 "\n The lack of prioritization does permit every process to eventually complete, hence no starvation. \n"+
				 "\n\n Terminologies - \n"+
				 "\n Burst Time : Time that is required to complete execution of particular task or process. \n"+
				 "\n Response time : amount of time it takes from when a request was submitted until the first response is produced. \n"+
				 "\n Turnaround Time : Total time between submission of a process and its completion. \n"+
				 "\n Waiting Time : It is the time for which the process remains in the ready queue. \n"+
				 "\n\n Formula - \n"+
				 "\n 1. Waiting Time = Finish Time - Arrival Time - Execution Time\n"+
				 "\n 2. Turnaround Time = Finish Time - Time of Submission of the Process\n";
				
		info.setMovementMethod(new ScrollingMovementMethod());
		info.setText(message);
	
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent i = new Intent(getApplicationContext(),FCFSMenuActivity.class);
				startActivity(i);
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_fcfsinfo, menu);
		return true;
	}

}
