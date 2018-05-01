package bitbois.com.a5x5stronklufts;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;

public class MainActivityPresenter {
    boolean isWorkoutA = true;
    Trainee trainee;
    ArrayList<Exercise> curWorkout;
    Context mainActivity;
    SharedPreferences spref;

    public MainActivityPresenter(Context context, SharedPreferences sp) {
        this.mainActivity = context;
        this.spref = sp;

        this.trainee = new Trainee();
    }


    public void indexLift1() {
        if(isWorkoutA) {

        }
        else {

        }
    }

    public void indexLift2() {
        if(isWorkoutA) {

        }
        else {

        }
    }

    public void indexLift3() {
        if(isWorkoutA) {

        }
        else {

        }
    }

    public void nextWorkout() {
        if(isWorkoutA) {

        }
        else {

        }
    }

    public void showLift1Deets() {
        if(isWorkoutA) {

        }
        else {

        }
    }

    public void showLift2Deets() {
        if(isWorkoutA) {

        }
        else {

        }
    }

    public void showLift3Deets() {
        if(isWorkoutA) {

        }
        else {

        }
    }

    public void loadTrainee() {

    }

    public void storeTrainee() {
        SharedPreferences.Editor editor = spref.edit();
        ArrayList<Integer> indexes = trainee.getIndexes();

        editor.putInt(getString(R.string.squat_index), indexes.get(0).intValue());





        editor.commit();
    }
}
