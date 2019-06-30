package parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Answer;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.net.URLEncoder;

public class JacksonDataBind {
    public static void parseJson(String lang, String input) throws IOException {
        Answer answer;

        try {
            String urlStr =
                    "https://translate.yandex.net/api/v1.5/tr.json/translate?key=trnsl.1.1.20190627T150446Z.d8ea63a46c3c496b.cff740270062cded48ff7c743443044fdef50484";
            URL urlObj = new URL(urlStr);
            HttpsURLConnection connection = (HttpsURLConnection) urlObj.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            DataOutputStream dataOutputStream = new DataOutputStream(connection.getOutputStream());
            dataOutputStream.writeBytes("text=" + URLEncoder.encode(input, "UTF-8") + "&lang=" + lang);

            InputStream response = connection.getInputStream();
            String json = new java.util.Scanner(response).nextLine();

            StringReader reader = new StringReader(json);
            ObjectMapper objectMapper = new ObjectMapper();
            answer = objectMapper.readValue(reader,Answer.class);

            if (answer.getCode() == 200) {
                System.out.println(answer.getText());
            }else
                System.out.println("Что-то пошло не так");
        }catch (Exception e){
            System.out.println("Возможны неполадки в интернет соединении!");
        }
    }
}