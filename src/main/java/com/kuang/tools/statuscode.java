package com.kuang.tools;

public class statuscode {
    /*是否成功*/
    private boolean success;
    /*    状态码

        200 – 服务器成功返回网页
        201（已创建）
        请求成功并且服务器创建了新的资源。
        204（无内容）
        服务器成功处理了请求，但没有返回任何内容。
        4xx（请求错误）
        这些状态码表示请求可能出错，妨碍了服务器的处理。
        404（未找到）
        服务器找不到请求的网页。例如，对于服务器上不存在的网页经常会返回此代码。
        404（未找到）
        服务器找不到请求的网页。例如，对于服务器上不存在的网页经常会返回此代码。
         */
    private Integer code;
    /*附加信息*/
    private String statusmsg;

    @Override
    public String toString() {
        return "statuscode{" +
                "success=" + success +
                ", status='" + code + '\'' +
                ", statusmsg='" + statusmsg + '\'' +
                '}';
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getStatusmsg() {
        return statusmsg;
    }

    public void setStatusmsg(String statusmsg) {
        this.statusmsg = statusmsg;
    }

    public statuscode() {
    }

    public statuscode(boolean success, Integer code, String statusmsg) {
        this.success = success;
        this.code = code;
        this.statusmsg = statusmsg;
    }
}
