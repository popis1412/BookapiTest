package googleapi;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

// Google 도서 정보 출력
public class Example {

    public static void main(String[] args) {
        // 검색에 사용할 키워드
        String keyword = "자바 프로그래밍";

        //Google Books API를 통한 도서 검색 및 정보 출력
        try {
            searchAndPrintBookInfo(keyword);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void searchAndPrintBookInfo(String keyword) throws Exception {
        try {
            // Google Books API 키
            String apiKey = "AIzaSyCe5TjaCqJZUmhBjd2vz_1dryEFBozx74U";

            // API 요청 URL 생성
            String encodedSearchTerm = URLEncoder.encode(keyword, "UTF-8");
            String apiUrl = "https://www.googleapis.com/books/v1/volumes?q=" + encodedSearchTerm + "&orderBy=newest&key=" + apiKey;

            // API 요청 보내기
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // 응답 읽기
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();
            
            // 도서 정보 출력
            //System.out.println("도서 정보 검색 결과:\n" + response.toString());
            
            // JSON 응답을 깔끔하게 출력하기
            JSONObject jsonObject = new JSONObject(response.toString());
            // 깔끔하게 출력
            System.out.println(jsonObject.toString(2)); // 2는 들여쓰기 수

        } catch (Exception e) {
            throw e; // 예외를 호출자로 전파
        }
    }
}
