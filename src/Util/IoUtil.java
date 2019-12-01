package Util;

import java.io.*;

public class IoUtil {

    public static void  main(String[] args){
        try {
            System.out.println(readFile("D:\\decrypt.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 根据系统自动修改斜杆和反斜杠
    public static String RepalceSeparator(String s) {
        return s.replace("\\", File.separator).replace("/", File.separator);
    }

    public static String readFile(String path) throws IOException {
        path = RepalceSeparator(path);
        File file = new File(path);
        FileReader fReader = null;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            fReader = new FileReader(file);
            char[] buf = new char[1024 * 10];
            int temp = 0;
            while ((temp = fReader.read(buf)) > 0) {
                stringBuffer.append(new String(buf, 0, temp));
            }
            return stringBuffer.toString();
        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException e) {
            throw e;
        } finally {
            fReader.close();
        }
    }

    public static void writeFile(String path, String s) throws Exception {
        path = RepalceSeparator(path);
        File file = new File(path);
        if (!file.exists()) {
            creatFile(path);
        }
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file, true);
            fileWriter.write(s);

        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            fileWriter.close();
        }
    }


    /**
     * 通过改变文件路径来移动文件
     *
     * @param fromPath 源路径+文件名
     * @param toPath   新路径（没有文件名）
     * @throws Exception
     */

    public static void changeFilePath(String fromPath, String toPath) throws Exception {
        try {
            toPath = toPath + "\\";
            File fromfile = new File(RepalceSeparator(fromPath));
            File tofile = new File(RepalceSeparator(toPath) + fromfile.getName());

            if (fromfile.renameTo(tofile)) {
                // do nothing
            } else {
                throw new Exception("文件移动失败");
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static void creatFolder(String folderPath) throws Exception {
        try {
            File filePath = new File(folderPath);
            if (!filePath.exists()) {
                if (filePath.mkdirs()) {
                } else {
                    throw new Exception("新建文件夹失败");
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }


    public static void creatFileOnly(String filePath) throws Exception {
        try {
            File fileName = new File(filePath);
            if (!fileName.exists()) {
                if (fileName.createNewFile()) {
                } else {
                    throw new Exception("新建文件失败");
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }


    public static void delFile(String filePath) throws Exception {
        try {
            File file = new File(filePath);
            if (file.delete()) {

            } else {
                throw new Exception("删除文件失败");
            }
        } catch (Exception e) {
            throw e;
        }
    }


    public static void creatFile(String filePath) throws Exception {
        try {
            if (filePath.lastIndexOf(File.separator) < 0) {
                throw new Exception("文件路径不正确");
            }
            String FolderPath = filePath.substring(0, filePath.lastIndexOf(File.separator));
            File Folder = new File(FolderPath);
            if (Folder.exists()) {
                creatFileOnly(filePath);
            } else {
                creatFolder(FolderPath);
                creatFileOnly(filePath);
            }
        } catch (Exception e) {
            throw e;
        }
    }

}
