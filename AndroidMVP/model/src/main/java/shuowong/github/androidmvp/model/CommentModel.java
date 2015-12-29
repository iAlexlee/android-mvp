package shuowong.github.androidmvp.model;

/**
 * Created by WANGSHUO on 12/8/15.
 */
public class CommentModel {

    /**
     * id : 1
     * body : some comment
     * postId : 1
     */

    private int id;
    private String body;
    private int postId;

    public CommentModel(int id, String body, int postId) {
        this.id = id;
        this.body = body;
        this.postId = postId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public int getPostId() {
        return postId;
    }
}
