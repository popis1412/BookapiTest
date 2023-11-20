package openaiapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.search.bproject.SearchController;


// open ai api 챗gpt와 상호작용
public class Example {
	private static final Logger LOGGER = LoggerFactory.getLogger(Example.class);
    public static void main(String[] args) {
        // Set ChatGPT endpoint and API key
        String endpoint = "https://api.openai.com/v1/chat/completions";
        String apiKey = "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";
        
        // Prompt user for input string
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter your message: ");
            String input = reader.readLine();
            
            // Send input to ChatGPT API and display response
            String response = ChatBot.sendQuery(input, endpoint, apiKey);
            LOGGER.info("Response: {}", response);
            System.out.println(response.replace("\\n\\n", "\n").replace("\"", ""));
        } catch (IOException e) {
            LOGGER.error("Error reading input: {}", e.getMessage());
        } catch (JSONException e) {
            LOGGER.error("Error parsing API response: {}", e.getMessage());
        } catch (Exception e) {
            LOGGER.error("Unexpected error: {}", e.getMessage());
        }
    }
}

