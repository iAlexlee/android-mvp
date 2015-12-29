package shuowong.github.androidmvp.api;


import java.util.List;

/**
 * Created by WANGSHUO on 11/23/15.
 */
public class APIResponse<T> {

    /**
     * result : {"code":0,"msg":"success"}
     * objs : [{"id":1,"title":"json-server","author":"typicode"},{"id":2,"title":"json-server2","author":"typicode2"}]
     */

    private DataEntity<T> data;

    public void setData(DataEntity data) {
        this.data = data;
    }

    public DataEntity getData() {
        return data;
    }

    public static class DataEntity<T> {

        private ResultEntity result;
        private List<T> objs;

        public void setResult(ResultEntity result) {
            this.result = result;
        }

        public void setObjs(List<T> objs) {
            this.objs = objs;
        }

        public ResultEntity getResult() {
            return result;
        }

        public List<T> getObjs() {
            return objs;
        }

        public static class ResultEntity {
            private int code;
            private String msg;

            public void setCode(int code) {
                this.code = code;
            }

            public void setMsg(String msg) {
                this.msg = msg;
            }

            public int getCode() {
                return code;
            }

            public String getMsg() {
                return msg;
            }
        }

    }
}
