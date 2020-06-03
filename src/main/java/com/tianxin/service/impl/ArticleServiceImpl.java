package com.tianxin.service.impl;

import com.alibaba.druid.sql.visitor.functions.Now;
import com.tianxin.commontool.NowDate;
import com.tianxin.dao.ArticleMapper;
import com.tianxin.entity.Article;
import com.tianxin.error.BusinesException;
import com.tianxin.error.EmBusinesError;
import com.tianxin.service.ArticleService;
import com.tianxin.service.model.ArticleModel;
import com.tianxin.validator.ValidationResult;
import com.tianxin.validator.ValidatorImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ValidatorImpl validator;

    @Autowired
    private  ArticleMapper articleMapper;


    @Override
    @Transactional
    public ArticleModel createArticle(ArticleModel articleModel) throws BusinesException {
        if(articleModel == null){
            throw  new BusinesException(EmBusinesError.PARAMETRT_VALIDATION_ERROR);
        }

        //校验入参
        ValidationResult result=validator.validate(articleModel);
        if(result.isHasErrors()){
            throw  new  BusinesException(EmBusinesError.PARAMETRT_VALIDATION_ERROR,result.getError());
        }
        Article article=ConveArticleModelToArticle(articleModel);

        //articleMapper.insertSelective(article);

        articleMapper.insert(article);

        return articleModel;
    }

    @Override
    public List<ArticleModel> ListArticle() {
        List<Article> articleModel= articleMapper.ListArticle();

        List<ArticleModel> articleModelList= articleModel.stream().map(Article->{
            ArticleModel articleModel1=new ArticleModel();
            BeanUtils.copyProperties(Article,articleModel1);
            return  articleModel1;
        }).collect(Collectors.toList());
        return articleModelList;
    }

    @Override
    public ArticleModel getArticleById(Integer id) {
        Article article=articleMapper.selectByPrimaryKey(id);
        if(article==null){
            return null;
        }
        ArticleModel articleModel=new ArticleModel();
        BeanUtils.copyProperties(articleModel,article);
        return articleModel;
    }


    private Article ConveArticleModelToArticle(ArticleModel articleModel){
        if(articleModel==null){
            return  null;
        }
        Article article=new Article();
        BeanUtils.copyProperties(articleModel,article);
        article.setCreatetime(NowDate.NowDateTime());
        return  article;
    }



}
