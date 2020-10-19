package vip.epss.exception;

/**
 * @创建人 epss[wangzhanf]
 * @创建时间 2020/10/18 0018
 * @描述
 */
public class CustomException extends Exception {
    public String message;

    public CustomException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
