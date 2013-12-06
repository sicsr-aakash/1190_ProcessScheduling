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

public class SJFInfoActivity extends Activity {

	Button back;
	TextView info;
	String message;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sjfinfo);
		
		back=(Button)findViewById(R.id.backSJF);
		info=(TextView)findViewById(R.id.informationSJF);
		
		message =" In SJF Scheduling, the scheduler arranges processes with the least estimated process time remaining to be next in the queue. This requires advanced knowledge of estimations about the time required for a process to complete. \n"+
				 "\n If a shorter process arrives during another process execution, the currently running process may be interrupted, dividing that process into two separate computing blocks. This creates excess overhead through additional context switching. \n"+
				 "\n The scheduler must also place each incoming process into a specific place in the queue, creating additional overheads. \n"+
				 "\n Designed for maximum throughput in most scenarios. \n"+
				 "\n Waiting time and response time increase as the process computational requirements increase. \n"+
				 "\n Since Turnaround time is based on waiting time plus processing time, longer processes are significantly affected by this. \n"+
				 "\n Overall waiting time is smaller than FIFO, however since no process has to wait for the termination of the longest process. \n"+
				 "\n No particular attention is given to deadlines, the programmer can only attempt to make processes with deadlines as short as possible. \n"+
				 "\n Starvation is possible, especially in a busy system with many small processes being run. \n"+
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
				
				Intent i = new Intent(getApplicationContext(),SJFMenuActivity.class);
				startActivity(i);
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_sjfinfo, menu);
		return true;
	}

}
