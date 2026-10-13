import java.io.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Analytics {

    public Analytics() {
    }

    // function which runs whenever an option is pressed in the program
    public void buttonPressed(String fileNameForPresses, String fileNameForTimestamps) {

        int tally=0;
        // gets the number of how many times a button has been pressed and increments by one
        try (BufferedReader reader = new BufferedReader(new FileReader(fileNameForPresses))) {
            tally = Integer.parseInt(reader.readLine());
            tally++;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // writes the new number of presses back into the file
        try (FileWriter writer = new FileWriter(fileNameForPresses, false)) {
            String tallyWrite = String.valueOf(tally);
            writer.write(tallyWrite);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // adds the timestamp for when the button was pressed into the timestamp file for the button
        try (FileWriter myWriter = new FileWriter(fileNameForTimestamps, true)) {
            LocalTime time = LocalTime.now();
            myWriter.write(time + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // the method used to display all the analytics in the admin menu
    public void viewAnalytics(String buttonPressesFile, String timestampsFile, String nameOfButton) {
        // the total number of times a page was viewed
        try (BufferedReader reader = new BufferedReader(new FileReader(buttonPressesFile))) {
            int numberOfPresses = Integer.parseInt(reader.readLine());
            System.out.println(nameOfButton + " was viewed: " + numberOfPresses + " times.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(timestampsFile))) {
            String line;
            List<String> hours = new ArrayList<>();
            int maxFrequency = 0;
            int modalHour = 0;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(":");
                if (row.length >= 3) {
                    String hour = row[0];
                    hours.add(hour);
                }
                // calculates the mode of the times at which a button was used
                Map<Integer, Integer> frequencyMap = new HashMap<>();
                // Count frequencies
                for (String number : hours) {
                    frequencyMap.put(Integer.valueOf(number), frequencyMap.getOrDefault(number, 0) + 1);
                }
                maxFrequency = 0;
                for (int freq : frequencyMap.values()) {
                    if (freq > maxFrequency) {
                        maxFrequency = freq;
                    }
                }
                for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
                    if (entry.getValue() == maxFrequency) {
                        modalHour = entry.getKey();
                    }
                }
            }
            System.out.println(nameOfButton + " was viewed mostly around: " + modalHour + ":00\n");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}