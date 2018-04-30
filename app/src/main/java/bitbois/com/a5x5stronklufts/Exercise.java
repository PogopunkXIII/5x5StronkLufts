package bitbois.com.a5x5stronklufts;

public class Exercise {
    private double startingWeight, weightIncrement;
    private int exIndex;
    private String exerciseName;
    private Weights curWeight;

    public Exercise() {

    }

    public void calculateCurWeight() {
        double weight = this.getStartingWeight() + (this.getExIndex() * this.getWeightIncrement());

        Weights tempWeights = new Weights(weight);

        this.setCurWeight(tempWeights);
    }

    public String getWeightDetails() {
        return this.getCurWeight().toString();
    }

    @Override
    public String toString() {
        return "";
    }

    public double getStartingWeight() {
        return startingWeight;
    }

    public void setStartingWeight(double startingWeight) {
        this.startingWeight = startingWeight;
    }

    public double getWeightIncrement() {
        return weightIncrement;
    }

    public void setWeightIncrement(double weightIncrement) {
        this.weightIncrement = weightIncrement;
    }

    public int getExIndex() {
        return exIndex;
    }

    public void setExIndex(int exIndex) {
        this.exIndex = exIndex;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public Weights getCurWeight() {
        return curWeight;
    }

    public void setCurWeight(Weights curWeight) {
        this.curWeight = curWeight;
    }
}
