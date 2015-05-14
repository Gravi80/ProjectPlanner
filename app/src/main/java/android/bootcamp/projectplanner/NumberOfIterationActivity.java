package android.bootcamp.projectplanner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class NumberOfIterationActivity extends Activity {

    private Float total_number_of_iterations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e("NumberOfIteratActivity", "onCreate");    
        super.onCreate(savedInstanceState);
        setContentView(R.layout.number_of_iterations);

        TextView numbersOfIterations = (TextView) findViewById(R.id.number_of_iterations);

        Intent intent = getIntent();
        total_number_of_iterations = intent.getFloatExtra("total_number_of_iterations", 0.0f);
        numbersOfIterations.setText(getString(R.string.iteration_needed)+ total_number_of_iterations);
    }

    public void calculateWithBuffer(View view) {
        EditText iteration_buffer = (EditText) findViewById(R.id.buffer);

        Float buffer = Float.parseFloat(iteration_buffer.getText().toString());

        Intent intent = new Intent();
        intent.putExtra("iterations_with_buffer", buffer+total_number_of_iterations);
        setResult(RESULT_OK, intent);
        finish(); // destroys the activity
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("NumberOfIteratActivity", "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("NumberOfIteratActivity","onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("NumberOfIteratActivity","onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("NumberOfIteratActivity","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("NumberOfIteratActivity", "onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("NumberOfIteratActivity", "onPause");
    }

}
