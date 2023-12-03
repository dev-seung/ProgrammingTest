package Test;

public class No2 {
    private int value;

    public No2() {
        this.value = 0;
    }

    public No2 add(int number) {
        this.value += number;
        return this;
    }

    public No2 subtract(int number) {
        this.value -= number;
        return this;
    }

    public int out() {
        return this.value;
    }

    public static void main(String[] args) {
    	No2 no2 = new No2();
        int result = no2.add(4).add(5).subtract(3).out();
        System.out.println(result);  
    }
}
