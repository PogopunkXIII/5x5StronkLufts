package bitbois.com.a5x5stronklufts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    MainActivityPresenter map;
    TextView lift1Name, lift1SetReps, lift1Weight;
    TextView lift2Name, lift2SetReps, lift2Weight;
    TextView lift3Name, lift3SetReps, lift3Weight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        map = new MainActivityPresenter(this);

        map.loadTrainee();

        this.lift1Name    = (TextView)findViewById(R.id.lift1Name);
        this.lift1SetReps = (TextView)findViewById(R.id.lift1SetReps);
        this.lift1Weight  = (TextView)findViewById(R.id.lift1Weight);

        this.lift2Name    = (TextView)findViewById(R.id.lift2Name);
        this.lift2SetReps = (TextView)findViewById(R.id.lift2SetReps);
        this.lift2SetReps = (TextView)findViewById(R.id.lift2Weight);

        this.lift3Name    = (TextView)findViewById(R.id.lift3Name);
        this.lift3SetReps = (TextView)findViewById(R.id.lift3SetReps);
        this.lift3Weight  = (TextView)findViewById(R.id.lift3Weight);
    }

    public void liftCompleted(View v) {
        switch(v.getId()){
            case R.id.lift1Complete:
                this.map.indexLift1();
                break;
            case R.id.lift2Complete:
                this.map.indexLift2();
                break;
            case R.id.lift3Complete:
                this.map.indexLift3();
                break;
        }
    }

    public void liftDetails(View v) {
        switch(v.getId()){
            case R.id.lift1Deets:
                this.map.showLift1Deets();
                break;
            case R.id.lift2Deets:
                this.map.showLift2Deets();
                break;
            case R.id.lift3Deets:
                this.map.showLift3Deets();
                break;
        }
    }

    public void nextWorkout(View v) {
        this.map.nextWorkout();
    }

    public void updateLift1UI(String name, String setReps, String weight) {
        this.lift1Name.setText(name);
        this.lift1SetReps.setText(setReps);
        this.lift1Weight.setText(weight);
    }

    public void updateLift2UI(String name, String setReps, String weight) {
        this.lift2Name.setText(name);
        this.lift2SetReps.setText(setReps);
        this.lift2Weight.setText(weight);
    }

    public void updateLift3UI(String name, String setReps, String weight) {
        this.lift3Name.setText(name);
        this.lift3SetReps.setText(setReps);
        this.lift3Weight.setText(weight);
    }

    @Override
    public void onDestroy() {
        this.map.storeTrainee();

        super.onDestroy();
    }
}
