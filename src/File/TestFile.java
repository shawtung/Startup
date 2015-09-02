package File;

import java.io.*;

public class TestFile {
    public static void main(String[] args) {
        String separator = File.separator;
        String filename = "";
//        String directory = "mydir1" + separator + "";
//        String directory = "mydir1/mydir2";
        String directory = "mydir1\\mydir3";
        File f = new File(directory, filename);
        if (f.exists()) {
            System.out.println("�ļ�����" + f.getAbsolutePath());
            System.out.println("�ļ���С��" + f.length());
        }else{
            f.getParentFile().mkdirs();
            try{
                f.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
