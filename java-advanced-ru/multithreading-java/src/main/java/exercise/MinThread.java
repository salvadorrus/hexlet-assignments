package exercise;

// BEGIN
public class MinThread extends Thread {

    private  int[] array;
    private  int minValue;

    public MinThread(int[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        if (array.length == 0) {
            throw new IllegalArgumentException("Массив не должен быть пустым");
        }
        minValue = array[0];
        for (int value : array) {
            if (value < minValue) {
                minValue = value;
            }
        }
        System.out.println("Минимальное значение: " + minValue);
    }

    public  int getMin() {
        return minValue;
    }
}
// END
