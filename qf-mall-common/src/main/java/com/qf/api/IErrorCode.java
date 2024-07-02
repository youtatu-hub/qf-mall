package com.qf.api;

/**
 * @author youta
 * @version v1.0
 * @project qf-mall
 * @package com.qf.api
 * @company 千锋教育
 * @date 2024/7/2 22:40
 * 封装API的错误码
 */
public interface IErrorCode {
    long getCode();

    String getMessage();
}
