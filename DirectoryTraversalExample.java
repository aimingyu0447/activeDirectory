import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class DirectoryTraversalExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入要读取的文件名: ");
        String fileName = scanner.nextLine();

        // 风险点：直接使用用户输入构建文件路径
        File file = new File("/var/www/files/", fileName);

        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] data = new byte[(int) file.length()];
            fis.read(data);
            String content = new String(data, "UTF-8");
            System.out.println("文件内容: " + content);
        } catch (IOException e) {
            System.out.println("读取文件失败: " + e.getMessage());
        }
    }
}