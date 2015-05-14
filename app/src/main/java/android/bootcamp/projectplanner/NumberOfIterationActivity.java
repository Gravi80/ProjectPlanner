package android.bootcamp.projectplanner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class NumberOfIterationActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.number_of_iterations);

        TextView numbersOfIterations = (TextView) findViewById(R.id.number_of_iterations);

        Intent intent = getIntent();
        numbersOfIterations.setText(getString(R.string.iteration_needed)+intent.getFloatExtra("total_number_of_iterations",0.0f));
    }
}
