package com.humaara.process_scheduling;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class RRresultsActivity extends Activity {

	Button back;
	TextView avgW,avgTurnA;
	float wait,TurnA;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rrresults);
		
		back = (Button)findViewById(R.id.backbtn);
		avgW = (TextView)findViewById(R.id.WaitRR);
		avgTurnA = (TextView)findViewById(R.id.TurnARR);
		
		Bundle extra = getIntent().getExtras();
		
		if(extra != null)
		{
			wait = extra.getFloat("avgW");
			TurnA = extra.getFloat("avgTurnA");
		}
		
		avgW.setText(wait+"");
		avgTurnA.setText(TurnA+"");
		
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			
				Intent i = new Intent(getApplicationContext(),MenuActivity.class);
				startActivity(i);
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_rrresults, menu);
		return true;
	}

}
