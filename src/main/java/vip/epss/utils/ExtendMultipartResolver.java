package vip.epss.utils;

import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.servlet.ServletRequestContext;
import org.springframework.http.HttpMethod;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;

/**
 * @创建人 epss[wangzhanf]
 * @创建时间 2020/10/27 0027
 * @描述    默认情况下 restful风格不能通过put上传文件,所以自定义解析器处理,需要在配置文件中注入该bean
 * 本例中是在springmvc.xml文件中配置文件解析器
 */
public class ExtendMultipartResolver extends CommonsMultipartResolver {
    @Override
    public boolean isMultipart(HttpServletRequest request) {
        return (request != null && isMultipartContent(request));
    }
    public static final boolean isMultipartContent(HttpServletRequest request) {
        HttpMethod httpMethod = HttpMethod.valueOf(request.getMethod());
        if (HttpMethod.POST != httpMethod && HttpMethod.PUT != httpMethod) {
            return false;
        }
        return FileUploadBase.isMultipartContent(new ServletRequestContext(request));
    }

}
