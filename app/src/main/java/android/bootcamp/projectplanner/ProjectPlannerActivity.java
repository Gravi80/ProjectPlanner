package android.bootcamp.projectplanner;

import android.app.Activity;
import android.bootcamp.projectplanner.repository.ProjectPlanRepository;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import static android.bootcamp.projectplanner.Constants.ADJUSTED_ITERATIONS;
import static android.bootcamp.projectplanner.Constants.ITERATIONS;


public class ProjectPlannerActivity extends Activity {

    private static final int BUFFER_ADJUST_REQUEST_CODE = 3239;
    private int CAPTURE_REQUEST_CODE = 12;
    private int bufferIteration;
    private int velocity;
    private int totalPoints;
    private ProjectPlanRepository projectPlanRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_planner);
    }

    public void calculate(View view) {
        totalPoints = readTextAsInteger(R.id.number_of_points);
        velocity = readTextAsInteger(R.id.velocity);
        int result = totalPoints / velocity;
        TextView resultView = (TextView) findViewById(R.id.number_of_iterations);
        String resultString = getString(R.string.number_of_iterations) + String.valueOf(result);
        resultView.setText(resultString);
        Intent resultIntent = new Intent(this, ResultActivity.class);
        resultIntent.putExtra(ITERATIONS, result);
        startActivityForResult(resultIntent, BUFFER_ADJUST_REQUEST_CODE);
    }

    private int readTextAsInteger(int resourceIdentifier) {
        return Integer.parseInt(((EditText) findViewById(resourceIdentifier)).getText().toString());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAPTURE_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                ImageView imageView = (ImageView) findViewById(R.id.imageView);
                Bitmap imageObject = (Bitmap)data.getExtras().get("data"); // gives u thumbNail of image
                imageView.setImageBitmap(imageObject);
            }
        } else {
            if (resultCode == RESULT_OK) {
                bufferIteration = data.getIntExtra(ADJUSTED_ITERATIONS, 0);
                String resultString = getString(R.string.adjusted_number_of_iterations) + String.valueOf(bufferIteration);
                ((TextView) findViewById(R.id.number_of_iterations)).setText(resultString);
            }
        }
    }

    public void capture(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        CAPTURE_REQUEST_CODE = 12;
        startActivityForResult(intent, CAPTURE_REQUEST_CODE);
    }

    public void Save(View view) {
        projectPlanRepository = new ProjectPlanRepository(this);
        projectPlanRepository.storePlan(totalPoints, velocity, bufferIteration);
    }
}
