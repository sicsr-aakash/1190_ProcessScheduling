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

public class RRInfoActivity extends Activity {

	Button back;
	TextView info;
	String message;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rrinfo);
		
		back=(Button)findViewById(R.id.backRR);
		info=(TextView)findViewById(R.id.informationRR);
		
		message =" In RR Scheduling, the Process Scheduler assigns a fixed time unit (Quantum) per process, and cycles through them. \n"+
				 "\n RR Scheduling has balanced throughput between FCFS and SJF, shorter jobs are completed faster than in FCFS and longer processes are completed faster than in SJF. \n"+
				 "\n RR Scheduling has fastest average response time, waiting time is dependent on the number of processes in Job Queue. \n"+
				 "\n Because of high waiting times, deadlines are rarely met in a pure RR system. \n"+
				 "\n Starvation can never occur, since no priority is given. \n"+
				 "\n Order of time unit allocation is based upon process arrival time, similar to FCFS. \n"+
				 "\n RR Scheduling involves extensive overhead, especially with a small time unit. \n"+
				 "\n\n Terminologies - \n"+
				 "\n Burst Time : Time that is required to complete execution of particular task or process. \n"+
				 "\n Time Quantum : Also known as time slice, the amount of time for which a process uses the processor. \n"+
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
				
				Intent i = new Intent(getApplicationContext(),RRMenuActivity.class);
				startActivity(i);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_rrinfo, menu);
		return true;
	}

}
