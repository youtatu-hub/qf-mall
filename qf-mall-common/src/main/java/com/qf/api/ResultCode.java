package com.qf.api;

/**
 * @author youta
 * @version v1.0
 * @project qf-mall
 * @package com.qf.api
 * @company 千锋教育
 * @date 2024/7/2 22:40
 * 枚举了一些常用API操作码
 */
public enum ResultCode implements IErrorCode{
    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    VALIDATE_FAILED(404, "参数检验失败"),
    UNAUTHORIZED(401, "暂未登录或session已经过期"),
    FORBIDDEN(403, "没有相关权限"),
    UNKNOWN(99999, "未知异常，请稍后再试！");
    private long code;
    private String message;

    private ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
