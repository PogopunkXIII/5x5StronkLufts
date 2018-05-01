package bitbois.com.a5x5stronklufts;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivityPresenter {
    MainActivity mainActivity;
    SharedPreferences spref;
    boolean isWorkoutA = true;
    Trainee trainee;
    ArrayList<Exercise> curWorkout;


    public MainActivityPresenter(MainActivity context, SharedPreferences sp) {
        this.mainActivity = context;
        this.spref = sp;

        this.trainee = new Trainee();

        this.loadTrainee();
        this.setCurWorkout();
        this.updateUI();
    }

    private void updateUI() {
        this.updateLift1UI(curWorkout.get(0));
        this.updateLift2UI(curWorkout.get(1));
        this.updateLift3UI(curWorkout.get(2));
    }

    private void setCurWorkout() {
        if(isWorkoutA) {
            this.curWorkout = trainee.getWorkoutA();
        }
        else {
            this.curWorkout = trainee.getWorkoutB();
        }
    }

    private void updateLift1UI(Exercise e) {
        mainActivity.updateLift1UI(e.getExerciseName(), e.getSetRepString(), Double.toString(e.getCurWeight().getWeight()));
    }

    private void updateLift2UI(Exercise e) {
        mainActivity.updateLift2UI(e.getExerciseName(), e.getSetRepString(), Double.toString(e.getCurWeight().getWeight()));
    }

    private void updateLift3UI(Exercise e) {
        mainActivity.updateLift3UI(e.getExerciseName(), e.getSetRepString(), Double.toString(e.getCurWeight().getWeight()));
    }


    public void indexLift(int lift) {
        switch(lift) {
            case 0:
                trainee.setSquatIndex(trainee.getSquatIndex() + 1);
                break;
            case 1:
                if(isWorkoutA)
                    trainee.setBenchPressIndex(trainee.getBenchPressIndex() + 1);
                else
                    trainee.setOverheadPressIndex(trainee.getOverheadPressIndex() + 1);
                break;
            case 2:
                if(isWorkoutA)
                    trainee.setRowIndex(trainee.getRowIndex() + 1);
                else
                    trainee.setDeadliftIndex(trainee.getDeadliftIndex() + 1);
                break;
        }

    }

    public void nextWorkout() {
        this.toggleIsWorkoutA();
        this.updateUI();
    }

    private void toggleIsWorkoutA() {
        this.isWorkoutA = !this.isWorkoutA;
        this.setCurWorkout();
    }

    public void showLiftDeets(int lift) {
        this.showDetails(lift);
    }

    public void resetLift(int lift) {
        switch(lift) {
            case 0:
                trainee.setSquatIndex(0);
                break;
            case 1:
                if(isWorkoutA)
                    trainee.setBenchPressIndex(0);
                else
                    trainee.setOverheadPressIndex(0);
                break;
            case 2:
                if(isWorkoutA)
                    trainee.setRowIndex(0);
                else
                    trainee.setDeadliftIndex(0);
                break;
        }
    }

    private void showDetails(int i) {
        AlertDialog dialog = new AlertDialog.Builder(mainActivity).create();
        dialog.setTitle("Weight Details");
        dialog.setMessage(curWorkout.get(i).getCurWeight().toString());

        dialog.setButton("Continue..", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {}
        });

        dialog.show();
    }

    public void loadTrainee() {
        ArrayList<Integer> indexes = new ArrayList<>();

        indexes.add(spref.getInt(mainActivity.getString(R.string.squat_index),0));
        indexes.add(spref.getInt(mainActivity.getString(R.string.bench_press_index),0));
        indexes.add(spref.getInt(mainActivity.getString(R.string.barbell_row_index),0));
        indexes.add(spref.getInt(mainActivity.getString(R.string.overhead_press_index),0));
        indexes.add(spref.getInt(mainActivity.getString(R.string.deadlift_index),0));

        this.isWorkoutA = spref.getBoolean(mainActivity.getString(R.string.is_workout_a_index), true);

        trainee.setIndexes(indexes);
    }

    public void storeTrainee() {
        SharedPreferences.Editor editor = spref.edit();
        ArrayList<Integer> indexes = trainee.getIndexes();

        editor.putInt(mainActivity.getString(R.string.squat_index), indexes.get(0).intValue());
        editor.putInt(mainActivity.getString(R.string.bench_press_index), indexes.get(1).intValue());
        editor.putInt(mainActivity.getString(R.string.barbell_row_index), indexes.get(2).intValue());
        editor.putInt(mainActivity.getString(R.string.overhead_press_index), indexes.get(3).intValue());
        editor.putInt(mainActivity.getString(R.string.deadlift_index), indexes.get(4).intValue());
        editor.putBoolean(mainActivity.getString(R.string.is_workout_a_index), this.isWorkoutA);

        editor.commit();
    }
}
