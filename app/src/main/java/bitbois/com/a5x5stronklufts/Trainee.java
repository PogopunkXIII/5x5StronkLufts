package bitbois.com.a5x5stronklufts;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Trainee {
    private ArrayList<Exercise> workoutA, workoutB;
    private int squatIndex, benchPressIndex, rowIndex, overheadPressIndex, deadliftIndex;

    public Trainee(ArrayList<Integer> indexes) {
        this.squatIndex         = indexes.get(0).intValue();
        this.benchPressIndex    = indexes.get(1).intValue();
        this.rowIndex           = indexes.get(2).intValue();
        this.overheadPressIndex = indexes.get(3).intValue();
        this.deadliftIndex      = indexes.get(4).intValue();

        buildWorkouts();
    }

    public Trainee() {
        this.squatIndex         = 0;
        this.benchPressIndex    = 0;
        this.rowIndex           = 0;
        this.overheadPressIndex = 0;
        this.deadliftIndex      = 0;

        buildWorkouts();
    }

    private void buildWorkouts() {
        //Workout A Build
        this.workoutA = new ArrayList<Exercise>();

        //this exercise gets it's own special local variable because it
        //  is the only exercise that is in both workouts
        Exercise squats = new ExerciseBuilder()
                .name("Squats")
                .setReps("5x5")
                .startWeight(45.0)
                .weightInc(5.0)
                .index(squatIndex)
                .build();

        this.workoutA.add(squats);

        this.workoutA.add(new ExerciseBuilder()
                .name("Bench Press")
                .setReps("5x5")
                .startWeight(45.0)
                .weightInc(5.0)
                .index(benchPressIndex)
                .build());

        this.workoutA.add(new ExerciseBuilder()
                .name("Barbell Row")
                .setReps("5x5")
                .startWeight(65.0)
                .weightInc(5.0)
                .index(rowIndex)
                .build());

        //Workout B building
        this.workoutB = new ArrayList<Exercise>();

        //using the same reference to the squats exercise from above
        this.workoutB.add(squats);

        this.workoutB.add(new ExerciseBuilder()
                .name("Overhead Press")
                .setReps("5x5")
                .startWeight(45.0)
                .weightInc(5.0)
                .index(overheadPressIndex)
                .build());

        this.workoutB.add(new ExerciseBuilder()
                .name("Deadlift")
                .setReps("1x5")
                .startWeight(95.0)
                .weightInc(10.0)
                .index(deadliftIndex)
                .build());
    }

    public ArrayList<Integer> getIndexes() {
        ArrayList<Integer> indexes = new ArrayList<Integer>();

        indexes.add(new Integer(squatIndex));
        indexes.add(new Integer(benchPressIndex));
        indexes.add(new Integer(rowIndex));
        indexes.add(new Integer(overheadPressIndex));
        indexes.add(new Integer(deadliftIndex));

        return indexes;
    }

    public ArrayList<Exercise> getWorkoutA() {
        return workoutA;
    }

    public ArrayList<Exercise> getWorkoutB() {
        return workoutB;
    }

    public int getSquatIndex() {
        return squatIndex;
    }

    public void setSquatIndex(int squatIndex) {
        this.squatIndex = squatIndex;
        workoutA.get(0).setExIndex(squatIndex);
        workoutA.get(0).calculateCurWeight();
        workoutB.get(0).setExIndex(squatIndex);
        workoutB.get(0).calculateCurWeight();
    }

    public int getBenchPressIndex() {
        return benchPressIndex;
    }

    public void setBenchPressIndex(int benchPressIndex) {
        this.benchPressIndex = benchPressIndex;
        workoutA.get(1).setExIndex(benchPressIndex);
        workoutA.get(1).calculateCurWeight();
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(int rowIndex) {
        this.rowIndex = rowIndex;
        workoutA.get(2).setExIndex(rowIndex);
        workoutA.get(2).calculateCurWeight();
    }

    public int getOverheadPressIndex() {
        return overheadPressIndex;
    }

    public void setOverheadPressIndex(int overheadPressIndex) {
        this.overheadPressIndex = overheadPressIndex;
        workoutB.get(1).setExIndex(overheadPressIndex);
        workoutB.get(1).calculateCurWeight();
    }

    public int getDeadliftIndex() {
        return deadliftIndex;
    }

    public void setDeadliftIndex(int deadliftIndex) {
        this.deadliftIndex = deadliftIndex;
        workoutB.get(2).setExIndex(deadliftIndex);
        workoutB.get(2).calculateCurWeight();
    }

    public void setIndexes(ArrayList<Integer> indexes) {
        this.setSquatIndex(indexes.get(0).intValue());
        this.setBenchPressIndex(indexes.get(1).intValue());
        this.setRowIndex(indexes.get(2).intValue());
        this.setOverheadPressIndex(indexes.get(3).intValue());
        this.setDeadliftIndex(indexes.get(4).intValue());
    }
}
