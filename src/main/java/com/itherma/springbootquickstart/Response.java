package com.itherma.springbootquickstart;

public class Response<T>{
    private T data;
    private boolean success;//表示请求是否成功
    private String errorMsg;
//  新建一个返回成功的方法
    public static <k> Response<k> newSuccess(k data){
        Response<k> response = new Response<>();
        response.setData(data);
        response.setSuccess(true);
        return response;
    }
//    新建一个返回失败的方法
    public static Response<Void> newFail(String errorMsg){
        Response<Void> response = new Response<>();
        response.setErrorMsg(errorMsg);
        response.setSuccess(false);
        return response;
    }
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
