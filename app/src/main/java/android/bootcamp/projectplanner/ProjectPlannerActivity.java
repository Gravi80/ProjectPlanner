package android.bootcamp.projectplanner;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class ProjectPlannerActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_project_planner); //looks in layout folder for given xml
//    parses Xml and creates View Heirarchy and creates View Object ( Button,Text )
  }

  public void calculate(View view) {
    TextView number_of_iterations = (TextView) findViewById(R.id.number_of_iterations);
    EditText iterationPoints = (EditText) findViewById(R.id.number_of_points);
    EditText iterationVelocity = (EditText) findViewById(R.id.velocity);

    float points = Float.parseFloat(iterationPoints.getText().toString());
    float velocity = Float.parseFloat(iterationVelocity.getText().toString());

    Float noOfIteration = points/velocity;
    number_of_iterations.setText(noOfIteration.toString());
//    number_of_iterations.setText(R.string.app_name);  to access string const
  }
}
