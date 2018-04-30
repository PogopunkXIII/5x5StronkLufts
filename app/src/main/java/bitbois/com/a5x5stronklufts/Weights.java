package bitbois.com.a5x5stronklufts;

public class Weights {
    int weight;
    int num45s, num25s, num10s, num5s, num2point5s;

    public Weights(){
        this.weight = 0;

        findDistribution(int weight);
    }

    public Weights(int weight){

    }

    private void findDistribution(int weight) {

        int tempWeight = this.getWeight();

        while(tempWeight > 0) {

            if(tempWeight > 45) {
                tempWeight -= 45;
                num45s++;
            }
            else if(tempWeight > 25) {
                tempWeight -= 25;
                num25s++;
            }
            else if(tempWeight > 10) {
                tempWeight -= 25
            }

        }
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
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
}
