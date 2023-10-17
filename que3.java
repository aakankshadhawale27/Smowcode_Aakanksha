import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;

public class que3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path to the input data file (e.g., data.txt):");
        String inputFilePath = scanner.nextLine();

        System.out.println("Enter the input keys in sequential order (comma-separated, e.g., 5,7,10,23):");
        String keysInput = scanner.nextLine();
        List<Integer> inputKeys = Arrays.stream(keysInput.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
            String line;
            Map<Integer, String[]> uniqueStringsCount = new HashMap<>();

            while ((line = reader.readLine()) != null) {
                // Split the line into key-value pairs
                // Example: 1=abc;2=def;3=ghi

                String[] keyValuePairs = line.split(";");

                // For each key-value pair, split it into key and value
                // Example: 1=abc

                for (String keyValuePair : keyValuePairs) {
                    String[] keyValue = keyValuePair.split("=");

                    // If the key is one of the keys we're looking for, add the value to the map

                    int key = Integer.parseInt(keyValue[0]);
                    String value = keyValue[1];

                    if (inputKeys.contains(key)) {
                        if (uniqueStringsCount.containsKey(key)) {
                            String[] uniqueStrings = uniqueStringsCount.get(key);
                            String[] newUniqueStrings = new String[uniqueStrings.length + 1];
                            System.arraycopy(uniqueStrings, 0, newUniqueStrings, 0, uniqueStrings.length);
                            newUniqueStrings[uniqueStrings.length] = value;
                            uniqueStringsCount.put(key, newUniqueStrings);
                        } else {
                            uniqueStringsCount.put(key, new String[] { value });
                        }
                    }
                }
            }

            for (Entry<Integer, String[]> entry : uniqueStringsCount.entrySet()) {

                String[] uniqueStrings = entry.getValue();

                String concatenatedString = String.join("|", uniqueStrings);

                System.out.println("Concatenated String: " + concatenatedString + ", Count: "
                        + uniqueStrings.length);
            }

            // System.out.println(uniqueStringsCount.size());

            reader.close();
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}