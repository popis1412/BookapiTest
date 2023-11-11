package APITest;

//네이버 검색 API 예제 - Book 검색
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class BookTest {
	 public static void main(String[] args) {
	        String clientId = "dX3yYbRpltPmZoxcZy0B"; //애플리케이션 클라이언트 아이디
	        String clientSecret = "UiAXgujGS0"; //애플리케이션 클라이언트 시크릿


	        try {
	            String text = URLEncoder.encode("이것이 자바다", "UTF-8"); // ""안에 내가 검색하고 싶은 도서 이름
	            String apiURL = "https://openapi.naver.com/v1/search/book.json?query="+ text;
	            URL url = new URL(apiURL);
	            HttpURLConnection con = (HttpURLConnection)url.openConnection();
	            con.setRequestMethod("GET");
	            con.setRequestProperty("X-Naver-Client-Id", clientId);
	            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
	            int responseCode = con.getResponseCode();
	            BufferedReader br;
	            if(responseCode==200) { // 정상 호출
	                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	            } else {  // 에러 발생
	                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	            }
	            String inputLine;
	            StringBuffer response = new StringBuffer();
	            while ((inputLine = br.readLine()) != null) {
	                response.append(inputLine);
	            }
	            br.close();
	            System.out.println(response.toString());	          
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	    }
}
