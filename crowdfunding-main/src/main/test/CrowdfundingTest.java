import lombok.SneakyThrows;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * @author 肖
 * @version 1.0
 * @Package PACKAGE_NAME
 * @data 2019/9/26 14:25
 */
public class CrowdfundingTest {

    private static int i;
    private static int b;
    private static int c;


    public static void main(String[] args) {

        ThreadLocal<Object> objectThreadLocal = new ThreadLocal<Object>();
        objectThreadLocal.set(new String());
    }
}
