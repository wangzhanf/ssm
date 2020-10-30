package vip.epss.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @创建人 epss[wangzhanf]
 * @创建时间 2020/10/29 0029
 * @描述
 */
public class FileUploadUtil {
    public static String up(MultipartFile file) {
        String path = "c:\\upload";
//        String path = request.getSession().getServletContext().getRealPath("/images/upload");
        String filename = UUID.randomUUID() + "-" + file.getOriginalFilename();
        File file1 = new File(path, filename);
        if (!file1.exists()) {
            file1.mkdirs();//迭代建立多级目录
        }
        try {
            file.transferTo(file1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "/upload/" + filename;//返回拼接后的字符串
    }
}
