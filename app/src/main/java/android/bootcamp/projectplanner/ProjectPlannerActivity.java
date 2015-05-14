package android.bootcamp.projectplanner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
    intent.putExtra("total_number_of_iterations", noOfIteration);
    startActivityForResult(intent, 1);
    //Project Planner Activity will go in stop state
  }

  public void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (requestCode==1){
      if(resultCode==RESULT_OK){
        TextView buffer_view = (TextView) findViewById(R.id.iterations_with_buffer);
        buffer_view.setText(getString(R.string.calculate_with_buffer) + data.getFloatExtra("iterations_with_buffer",0.0f));
      }
    }
  }

  @Override
  protected void onStart() {
    super.onStart();
    Log.e("ProjectPlannerActivity","onStart");
  }

  @Override
  protected void onRestart() {
    super.onRestart();
    Log.e("ProjectPlannerActivity","onRestart");
  }

  @Override
  protected void onResume() {
    super.onResume();
    Log.e("ProjectPlannerActivity","onResume");
  }

  @Override
  protected void onStop() {
    super.onStop();
    Log.e("ProjectPlannerActivity","onStop");
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    Log.e("ProjectPlannerActivity","onDestroy");
  }

  @Override
  protected void onPause() {
    super.onPause();
    Log.e("ProjectPlannerActivity","onPause");
  }
}
