package bitbois.com.a5x5stronklufts;

public class ExerciseBuilder {
    private String exerciseName;
    private double startingWeight, weightIncrement;
    private int exIndex;

    public ExerciseBuilder() {}

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

    public Exercise build() {
        Exercise ex = new Exercise();

        ex.setExerciseName(this.exerciseName);
        ex.setStartingWeight(this.startingWeight);
        ex.setWeightIncrement(this.weightIncrement);
        ex.setExIndex(this.exIndex);
        ex.calculateCurWeight();

        return ex;
    }





}
