package com.tianxin.service.model;

import org.hibernate.validator.constraints.NotBlank;


public class ArticleModel {

    private Integer id;

    @NotBlank(message = "文章标题不能为空")
    private String title;

    @NotBlank(message = "请选择文章标题")
    private String tag;

    @NotBlank(message = "请选择文章分类")
    private String classify;

    @NotBlank(message = "请输入文章内容")
    private String content;

    private String createtime;

    private Integer checkstatus;

    private String pageview;

    private String recommend;

    private String url;

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

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public Integer getCheckstatus() {
        return checkstatus;
    }

    public void setCheckstatus(Integer checkstatus) {
        this.checkstatus = checkstatus;
    }

    public String getPageview() {
        return pageview;
    }

    public void setPageview(String pageview) {
        this.pageview = pageview;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
