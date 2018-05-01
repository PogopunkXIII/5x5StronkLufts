package bitbois.com.a5x5stronklufts;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import static android.app.PendingIntent.getActivity;

public class MainActivity extends AppCompatActivity {
    MainActivityPresenter map;
    TextView lift1Name, lift1SetReps, lift1Weight;
    TextView lift2Name, lift2SetReps, lift2Weight;
    TextView lift3Name, lift3SetReps, lift3Weight;
    ImageButton lift1Complete, lift2Complete, lift3Complete;
    ImageButton lift1Reset, lift2Reset, lift3Reset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.lift1Name    = findViewById(R.id.lift1Name);
        this.lift1SetReps = findViewById(R.id.lift1SetReps);
        this.lift1Weight  = findViewById(R.id.lift1Weight);

        this.lift2Name    = findViewById(R.id.lift2Name);
        this.lift2SetReps = findViewById(R.id.lift2SetReps);
        this.lift2Weight = findViewById(R.id.lift2Weight);

        this.lift3Name    = findViewById(R.id.lift3Name);
        this.lift3SetReps = findViewById(R.id.lift3SetReps);
        this.lift3Weight  = findViewById(R.id.lift3Weight);

        this.lift1Complete = findViewById(R.id.lift1Complete);
        this.lift2Complete = findViewById(R.id.lift2Complete);
        this.lift3Complete = findViewById(R.id.lift3Complete);

        this.lift1Reset = findViewById(R.id.lift1Reset);
        this.lift2Reset = findViewById(R.id.lift2Reset);
        this.lift3Reset = findViewById(R.id.lift3Reset);

        map = new MainActivityPresenter(this, this.getPreferences(this.MODE_PRIVATE));
        int i = 0;
    }

    public void liftCompleted(View v) {
        switch(v.getId()){
            case R.id.lift1Complete:
                this.map.indexLift(0);
                this.lift1Complete.setBackgroundColor(0xFF66BB6A);
                break;
            case R.id.lift2Complete:
                this.map.indexLift(1);
                this.lift2Complete.setBackgroundColor(0xFF66BB6A);
                break;
            case R.id.lift3Complete:
                this.map.indexLift(2);
                this.lift3Complete.setBackgroundColor(0xFF66BB6A);
                break;
        }
    }

    public void liftDetails(View v) {
        switch(v.getId()){
            case R.id.lift1Deets:
                this.map.showLiftDeets(0);
                break;
            case R.id.lift2Deets:
                this.map.showLiftDeets(1);
                break;
            case R.id.lift3Deets:
                this.map.showLiftDeets(2);
                break;
        }
    }

    public void liftReset(View v) {
        switch(v.getId()){
            case R.id.lift1Reset:
                this.map.resetLift(0);
                this.lift1Reset.setBackgroundColor(0xFFEF5350);
                break;
            case R.id.lift2Reset:
                this.map.resetLift(1);
                this.lift2Reset.setBackgroundColor(0xFFEF5350);
                break;
            case R.id.lift3Reset:
                this.map.resetLift(2);
                this.lift3Reset.setBackgroundColor(0xFFEF5350);
                break;
        }
    }

    public void nextWorkout(View v) {
        this.lift1Complete.setBackgroundColor(Color.LTGRAY);
        this.lift2Complete.setBackgroundColor(Color.LTGRAY);
        this.lift3Complete.setBackgroundColor(Color.LTGRAY);
        this.lift1Reset.setBackgroundColor(Color.LTGRAY);
        this.lift2Reset.setBackgroundColor(Color.LTGRAY);
        this.lift3Reset.setBackgroundColor(Color.LTGRAY);
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
