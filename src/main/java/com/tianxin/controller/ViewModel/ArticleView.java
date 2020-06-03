package com.tianxin.controller.ViewModel;

/**
 * Author : tianxin
 * CreateTime : 2020/5/31 0031 17:27
 * param  :
 * retuen :
 * Description :
 */
public class ArticleView {

    private Integer id;

    private  String title;

    private  String tag;

    private  String classify;

    private  String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
