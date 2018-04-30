package bitbois.com.a5x5stronklufts;

public class Weights {
    private double weight, remainderWeight;
    private int num45s, num25s, num10s, num5s, num2point5s;

    public Weights(){
        this.weight = 0.0;
        this.num45s = 0;
        this.num25s = 0;
        this.num10s = 0;
        this.num5s = 0;
        this.num2point5s = 0;
    }

    public Weights(double weight){
        this.setWeight(weight);
    }

    private void findDistribution(double weight) {

        double tempWeight = this.getWeight()-45.0;

        while(tempWeight > 0) {

            if(tempWeight > 90.0) {
                tempWeight -= 90.0;
                num45s += 2;
            }
            else if(tempWeight > 50.0) {
                tempWeight -= 50.0;
                num25s += 2;
            }
            else if(tempWeight > 20.0) {
                tempWeight -= 20.0;
                num10s += 2;
            }
            else if(tempWeight > 10.0) {
                tempWeight -= 10.0;
                num5s += 2;
            }
            else if(tempWeight > 5.0) {
                tempWeight -= 5.0;
                num2point5s += 2;
            }
            else {
                this.setRemainderWeight(tempWeight);
                break;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder weightString = new StringBuilder();

        weightString.append("Total Weight: " + Double.toString(roundToHalf(weight)));

        if(this.getWeight() > 45.0) {
            weightString.append("\n1 Standard 45lbs Barbell with:");
        }

        if(this.getNum45s() > 0) {
            weightString.append("\n\tNumber of  45s on each side: " + Double.toString(num45s));
        }

        if(this.getNum25s() > 0) {
            weightString.append("\n\tNumber of  25s: " + Double.toString(num25s));
        }

        if(this.getNum10s() > 0) {
            weightString.append("\n\tNumber of  10s: " + Double.toString(num10s));
        }

        if(this.getNum5s() > 0) {
            weightString.append("\n\tNumber of   5s: " + Double.toString(num5s));
        }

        if(this.getNum2point5s() > 0) {
            weightString.append("\n\tNumber of 2.5s: " + Double.toString(num2point5s));
        }

        if(this.getRemainderWeight() > 0.0) {
            weightString.append("\n\t  Extra weight not on bar: " + Double.toString(roundToHalf(remainderWeight)));
        }

        return  weightString.toString();
    }

    private double roundToHalf(double val) {
        return Math.round(val * 2) / 2.0;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;

        this.findDistribution(weight);
    }

    public int getNum45s() {
        return num45s;
    }

    public void setNum45s(int num45s) {
        this.num45s = num45s;
    }

    public int getNum25s() {
        return num25s;
    }

    public void setNum25s(int num25s) {
        this.num25s = num25s;
    }

    public int getNum10s() {
        return num10s;
    }

    public void setNum10s(int num10s) {
        this.num10s = num10s;
    }

    public int getNum5s() {
        return num5s;
    }

    public void setNum5s(int num5s) {
        this.num5s = num5s;
    }

    public int getNum2point5s() {
        return num2point5s;
    }

    public void setNum2point5s(int num2point5s) {
        this.num2point5s = num2point5s;
    }

    public double getRemainderWeight() {
        return remainderWeight;
    }

    public void setRemainderWeight(double remainderWeight) {
        this.remainderWeight = remainderWeight;
    }
}
