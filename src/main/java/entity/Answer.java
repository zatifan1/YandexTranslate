package entity;

public class Answer {
    int code;
    String lang;
    String[] text;

    public Answer() {
    }

    public Answer(int code, String lang, String[] text) {
        this.code = code;
        this.lang = lang;
        this.text = text;
    }

    public int getCode() {
        return code;
    }

    public String getLang() {
        return lang;
    }

    public String getText() {
        return text[0];
    }

    @Override
    public String toString() {
        return "Answer{" +
                "code=" + code +
                ", lang='" + lang + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
