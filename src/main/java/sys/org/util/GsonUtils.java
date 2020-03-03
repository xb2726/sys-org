package sys.org.util;

import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 27267
 */
public class GsonUtils {
    //写数据库数据到前端
    public static void printData(HttpServletResponse response, Object data) {
        Gson gson = new Gson();
        String jsonData = gson.toJson(data);
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        try {
            response.getWriter().print(jsonData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//读前端传过来的数据
    public static <T> T wrapFromRequest(HttpServletRequest request, Class<T> clazz) {
        try {
            String json = IOUtils.toString(request.getInputStream(), "utf-8");
            Gson gson = new Gson();
            T t = gson.fromJson(json, clazz);
            return t;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
