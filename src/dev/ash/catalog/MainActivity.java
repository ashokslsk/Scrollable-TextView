package dev.ash.catalog;


import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView output;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
//		Initialize the TextView for vertical scrolling
		output = (TextView) findViewById(R.id.textView);
		output.setMovementMethod(new ScrollingMovementMethod());
		
		for (int i = 0; i < 100; i++) {
			updateDisplay("Ash test"+i); 
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == R.id.action_do_task) {
		ashTask	task = new ashTask();
		task.execute("Ashu 1","Ashu 2 ","Ashu 3");
		}
		return false;
	}

	protected void updateDisplay(String message) {
		output.append(message + "\n");
	}
	
	private class ashTask extends AsyncTask<String, String, String>{

		@Override
		protected void onPreExecute() {
		updateDisplay("Ash task Starting");
		}
		
		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			return "Ash Task Completed  ";
		}
		
		@Override
		protected void onPostExecute(String result) {
			updateDisplay(result);
		}
		
	}

}