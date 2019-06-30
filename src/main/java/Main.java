
import parser.JacksonDataBind;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите слово на английском (для выхода нажмите q):");
        String text = "";
        while (true) {
            text = in.nextLine();
            if (text.equals("q")) {
                System.out.println("Вы вышли из программы!");
                return;
            }
            JacksonDataBind.parseJson("ru", text);
        }

    }
}
