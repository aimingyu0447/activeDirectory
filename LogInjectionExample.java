import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogInjectionExample {
    private static final Logger logger = LoggerFactory.getLogger(LogInjectionExample.class);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入用户名: ");
        String username = scanner.nextLine();
        
        // 风险点：直接将用户输入拼接到日志中
        logger.info("用户登录: " + username);
        
        // 模拟业务逻辑
        if ("admin".equals(username)) {
            logger.info("管理员登录系统");
        } else {
            logger.info("普通用户登录系统");
        }
    }
}