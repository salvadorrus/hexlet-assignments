package exercise;

// BEGIN
public class MaxThread extends Thread {
    private int[] array;
    private int maxValue;

    public MaxThread(int[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        if (array.length == 0) {
            throw new IllegalArgumentException("Массив не должен быть пустым");
        }
        maxValue = array[0];
        for (int value : array) {
            if (value > maxValue) {
                maxValue = value;
            }
        }
        System.out.println("Максимальное значение: " + maxValue);
    }

    public int getMax() {
        return maxValue;
    }
}
// END
