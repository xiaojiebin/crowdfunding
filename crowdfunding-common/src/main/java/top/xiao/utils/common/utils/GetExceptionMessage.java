package top.xiao.utils.common.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 肖
 * @version 1.0
 * @Package top.xiao.utils.common.utils
 * @data 2020/2/25 15:23
 */
public class GetExceptionMessage {


    public static Map<String, Object> getMessage(Exception e) {
        Map map = new HashMap();
        map.put("异常类型", getExceptionType(e));
        map.put("异常信息", getExceptionMessage(e));
        map.put("异常跟踪栈", getExceptionSrintStackTrace(e));
        return map;
    }

    public static Throwable getExceptionType(Exception e) {
        return e;
    }

    public static String getExceptionMessage(Exception e) {
        return e.getMessage();
    }

    public static String getExceptionSrintStackTrace(Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        return sw.toString();
    }
}
