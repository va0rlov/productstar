package service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class DataLoader {

    /**
     * Method loads data from the given URL and returns it as a string.
     * </p>
     * @param urlString the URL to load the data from
     * @return the loaded data as a string
     * @throws Exception if there is a problem loading the data
     */
    public static String loadDataFromUrl(String urlString) throws Exception {
        // Create the URL object from the given URL string
        URL url = new URL(urlString);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
            StringBuilder sb = new StringBuilder();
            String line;
            // Read the data line by line and append it to a StringBuilder
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
            // Return the loaded data as a string
            return sb.toString();
        }
    }
}