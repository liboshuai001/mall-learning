package asia.rtx3090.mall.tiny.common.api;

/**
 * @Auther: Bernardo
 * @Date: 2022/5/22 17:05
 * @Description: 通用返回对象
 */
public class CommonResult<T> {
    private long code;
    private String message;
    private T data;

    protected CommonResult() {
    }

    protected CommonResult(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 成功返回结果
     *
     * @param data 后端将要返回的数据
     * @param <T>  泛型
     * @return 带有http code message 和data的功返回结果
     */
    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    /**
     * 成功返回结果
     *
     * @param message 自定义的ResultMessage提示信息
     * @param data    后端将要返回的数据
     * @param <T>     泛型
     * @return 带有http code message 和data的功返回结果
     */
    public static <T> CommonResult<T> success(String message, T data) {
        return new CommonResult<>(ResultCode.SUCCESS.getCode(), message, data);
    }

    /**
     * 失败返回结果
     *
     * @param errorCode ResultCode对象
     * @param <T>       泛型
     * @return 带有http code message 和data的失败返回结果
     */
    public static <T> CommonResult<T> failed(IErrorCode errorCode) {
        return new CommonResult<>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    /**
     * 失败返回结果
     *
     * @param message 自定义的错误提示信息
     * @param <T>     泛型
     * @return 带有http code message 和data的失败返回结果
     */
    public static <T> CommonResult<T> failed(String message) {
        return new CommonResult<>(ResultCode.FAILED.getCode(), message, null);
    }

    /**
     * 失败返回结果
     *
     * @param <T> 泛型
     * @return 带有http code message 和data的失败返回结果
     */
    public static <T> CommonResult<T> failed() {
        return failed(ResultCode.FAILED);
    }

    /**
     * 参数验证失败返回结果
     *
     * @param <T> 泛型
     * @return 带有http code message 和data的参数验证失败返回结果
     */
    public static <T> CommonResult<T> validateFailed() {
        return failed(ResultCode.VALIDATE_FAILED);
    }

    /**
     * 参数验证失败返回结果
     *
     * @param message 自定义参数验证失败提示信息
     * @param <T>     泛型
     * @return 带有http code message 和data的参数验证失败返回结果
     */
    public static <T> CommonResult<T> validateFiled(String message) {
        return new CommonResult<>(ResultCode.VALIDATE_FAILED.getCode(), message, null);
    }

    /**
     * 未登录返回结果
     *
     * @param data 后端将要返回的数据
     * @param <T>  泛型
     * @return 带有http code message 和data的未登录失败返回结果
     */
    public static <T> CommonResult<T> unauthorized(T data) {
        return new CommonResult<>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), data);
    }

    /**
     * 未授权返回结果
     *
     * @param data 后端将要返回的数据
     * @param <T> 泛型
     * @return 带有http code message 和data的授权失败返回结果
     */
    public static <T> CommonResult<T> forbidden(T data) {
        return new CommonResult<>(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(), data);
    }

    // setter and getter

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
