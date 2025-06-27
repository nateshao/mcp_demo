import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

public class Processor {
    public static void main(String[] args) throws Exception {
        Map<Integer, String> channelData = new HashMap<>();
        channelData.put(1, "alpha");
        channelData.put(2, "bravo");
        channelData.put(3, "charlie");
        channelData.put(4, "delta");

        ExecutorService executor = Executors.newFixedThreadPool(4);
        CompletionService<String> completionService = new ExecutorCompletionService<>(executor);

        for (Map.Entry<Integer, String> entry : channelData.entrySet()) {
            int id = entry.getKey();
            String data = entry.getValue();
            completionService.submit(() -> {
                System.out.printf("Channel %d start processing %s\n", id, data);
                Thread.sleep(500 + id * 200);
                String result = String.format("Channel %d processed %s", id, data.toUpperCase());
                System.out.printf("Channel %d done\n", id);
                return result;
            });
        }
        executor.shutdown();
        System.out.println("\nAll results:");
        for (int i = 0; i < channelData.size(); i++) {
            Future<String> future = completionService.take();
            System.out.println(future.get());
        }
    }
} 