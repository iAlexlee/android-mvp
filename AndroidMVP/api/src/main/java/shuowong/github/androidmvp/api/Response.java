package shuowong.github.androidmvp.api;


/**
 * Created by WANGSHUO on 11/23/15.
 */
public class Response<T> {

    private String result;
    private String msg;
    private T obj;
    private T objs;

    public Response(String result, String msg) {
        this.result = result;
        this.msg = msg;
    }

    public boolean isSuccess() {
        return "200".equals(this.result);
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public T getObjs() {
        return objs;
    }

    public void setObjs(T objs) {
        this.objs = objs;
    }
}
