package kr.search.bproject;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import openaiapi.ChatBot;



public class SearchController implements Initializable {
    
	@FXML
    private TextField textField1;
    @FXML
    private TextField textField2;
    @FXML
    private TextField textField3;
    @FXML
    private Label message;
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // UI 초기화 로직 추가
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
    }

    public String getMessage() {
        // Get values from text fields
        String keyword = textField1.getText();
        String program = textField2.getText();
        String level = textField3.getText();
        
        String word1 = "인 국내도서를 추천해줘.";

        // Create and display the message
        String message = "키워드: " + keyword + "\n언어: " + program + "\n난이도: " + level + word1;
        System.out.println(message);
		return message;
    }

    @FXML
    private void processInput() {
        
        // Get message from SearchController
        String input = getMessage();

        // Set ChatGPT endpoint and API key
        String endpoint = "https://api.openai.com/v1/chat/completions";
        String apiKey = "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";

        // Send input to ChatGPT API and display response
        String response = ChatBot.sendQuery(input, endpoint, apiKey);
        System.out.println(response.replace("\\n\\n", "\n").replace("\"", ""));
        
        // 깔끔하게 label에 있는 텍스트를 자동으로 줄 바꿈
        message.setWrapText(true);
        message.setText(response.replace("\\n\\n", "\n").replace("\"", ""));
    }
	
}