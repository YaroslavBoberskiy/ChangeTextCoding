import java.io.File;

public class Demo {

    public static void main(String[] args) {

        File file = new File("C:\\Users\\YB\\Desktop\\test.txt");
        CodingConverter cc = new CodingConverter();
        cc.changeEncoding(file, "windows-1251", "UTF-8");

    }
}
