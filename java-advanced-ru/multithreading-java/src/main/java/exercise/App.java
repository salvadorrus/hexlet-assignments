package exercise;

import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN
    public static Map<String, Integer> getMinMax(int[] array) {
        MinThread minThread = new MinThread(array);
        MaxThread maxThread = new MaxThread(array);

        minThread.start();
        maxThread.start();

        try {
            minThread.join();
            maxThread.join();
        } catch (InterruptedException e) {
            LOGGER.log(Level.WARNING, "Thread interrupted", e);
        }

        return Map.of("min", minThread.getMin(), "max", maxThread.getMax());
    }
    // END
}
