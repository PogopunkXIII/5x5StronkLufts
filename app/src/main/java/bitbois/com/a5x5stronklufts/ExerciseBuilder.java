package bitbois.com.a5x5stronklufts;

public class ExerciseBuilder {
    private String exerciseName, setReps;
    private double startingWeight, weightIncrement;
    private int exIndex;

    public ExerciseBuilder name(String name) {
        this.exerciseName = name;

        return this;
    }

    public ExerciseBuilder startWeight(double startWeight) {
        this.startingWeight = startWeight;

        return this;
    }

    public ExerciseBuilder weightInc(double weightInc) {
        this.weightIncrement = weightInc;

        return this;
    }

    public ExerciseBuilder index(int i) {
        this.exIndex = i;

        return this;
    }

    public ExerciseBuilder setReps(String setReps) {
        this.setReps = setReps;

        return this;
    }

    public Exercise build() {
        Exercise ex = new Exercise();

        ex.setExerciseName(this.exerciseName);
        ex.setSetRepString(this.setReps);
        ex.setStartingWeight(this.startingWeight);
        ex.setWeightIncrement(this.weightIncrement);
        ex.setExIndex(this.exIndex);
        ex.calculateCurWeight();

        return ex;
    }





}
