package android.bootcamp.projectplanner;

import android.app.Activity;
import android.content.Intent;
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
    EditText iterationPoints = (EditText) findViewById(R.id.number_of_points);
    EditText iterationVelocity = (EditText) findViewById(R.id.velocity);

    float points = Float.parseFloat(iterationPoints.getText().toString());
    float velocity = Float.parseFloat(iterationVelocity.getText().toString());
    Float noOfIteration = points/velocity;

    Intent intent = new Intent(this, NumberOfIterationActivity.class);
    intent.putExtra("total_number_of_iterations",noOfIteration);
    startActivity(intent);
    //Project Planner Activity will go in stop state
  }
}
