import java.io.*;
import java.nio.charset.Charset;

public class CodingConverter {

    BufferedReader bufferedInputStream;
    BufferedWriter bufferedOutputStream;
    int BUFFER_SIZE = 256;

    public void changeEncoding (File file, String currentEncoding, String convertedEncoding) {

        if (file.isFile() && file.exists() && checkCharsetName(currentEncoding) == true && checkCharsetName(convertedEncoding) == true) {

            try {
                File currFile = new File(file.getPath());

                bufferedInputStream = new BufferedReader(new InputStreamReader(new FileInputStream(currFile), currentEncoding), BUFFER_SIZE);

                String str;
                StringBuilder strb = new StringBuilder();
                while ((str = bufferedInputStream.readLine()) != null) {
                    System.out.println(str);
                    strb.append(str);
                }

                bufferedInputStream.close();

                bufferedOutputStream = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(currFile), convertedEncoding), BUFFER_SIZE);
                bufferedOutputStream.write(strb.toString());

                bufferedOutputStream.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean checkCharsetName (String encoding) {

        boolean check = false;

        Object[] CHARSETS = Charset.availableCharsets().values().toArray();

        for (int i = 0; i < CHARSETS.length; i ++) {
            if(CHARSETS[i].toString().equals(encoding)) {
                check = true;
            }
        }
        return check;
    }

}
