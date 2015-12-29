package shuowong.github.androidmvp.model;

/**
 * Created by WANGSHUO on 12/4/15.
 */
public class PostsModel {

    /**
     * id : 1
     * title : json-server
     * author : typicode
     */

    private int id;
    private String title;
    private String author;

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}
