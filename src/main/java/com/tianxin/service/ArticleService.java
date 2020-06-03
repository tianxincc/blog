package com.tianxin.service;

import com.tianxin.error.BusinesException;
import com.tianxin.service.model.ArticleModel;

import java.util.List;

public interface ArticleService{

    //文章创建
    ArticleModel createArticle(ArticleModel articleModel) throws BusinesException;

    //文章浏览
    List<ArticleModel> ListArticle();

    //详情浏览
    ArticleModel getArticleById(Integer id);

}
