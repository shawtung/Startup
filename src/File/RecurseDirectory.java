package File;

import java.io.*;

/**
 * Created by Shaw on 2015/8/23.
 */
public class RecurseDirectory {
    public static void main(String[] args) {
        File f = new File("d:/JAVA/workspace");
        System.out.println(f.getName());
        tree(f, 1);
    }

    private static void tree(File f, int level) {
        String pre = "";
        for (int i = 0; i < level; i++) {
            pre += "    ";
        }
        File[] childs = f.listFiles();
        for (int i = 0; i < childs.length; i++) {
            System.out.println(pre + (childs[i].isDirectory() ? "\u2193" : "") + childs[i].getName());
            if (childs[i].isDirectory()) {
                tree(childs[i], level + 1);
            }

        }
    }
}
