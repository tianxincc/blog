package com.tianxin.controller;

import com.tianxin.commontool.NowDate;
import com.tianxin.controller.ViewModel.ArticleView;
import com.tianxin.entity.Article;
import com.tianxin.entity.Log;
import com.tianxin.error.BusinesException;
import com.tianxin.response.CommonReturnType;
import com.tianxin.service.ArticleService;
import com.tianxin.service.model.ArticleModel;
import org.joda.time.format.DateTimeFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Author : tianxin
 * CreateTime : 2020/5/31 0031 17:27
 * param  :
 * retuen :
 * Description :
 */

@Controller("article")
@RequestMapping("/article")
@CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
public class ArticleController extends BaseController {

    @Autowired
    private ArticleService articleService;

    Logger log= LoggerFactory.getLogger(Logger.class);
    /**
     * Author : tianxin 
     * CreateTime : 2020/6/1 0001 22:16
     * param  : title  标题  tag  标签 classify 分类 content 内容
     * retuen :   success 或 fail
     * Description :
     */
    @RequestMapping(value = "/create",method = {RequestMethod.POST},consumes = CONTENT_TYPE_FROMED)
    @ResponseBody
    public CommonReturnType createArticle(@RequestParam("title") String title,
                                           @RequestParam("tag") String tag,
                                           @RequestParam("classify") String classify,
                                           @RequestParam("content") String content) throws BusinesException {
        log.info("开始记录日志");

        ArticleModel articleModel=new ArticleModel();
        articleModel.setTitle(title);
        articleModel.setTag(tag);
        articleModel.setClassify(classify);
        articleModel.setContent(content);

        ArticleModel itemModel1FromRetuen= articleService.createArticle(articleModel);

        ArticleView itemView=converViewFromModel(itemModel1FromRetuen);

        return CommonReturnType.create(itemView);
    }

    //文章详情浏览
    @RequestMapping(value = "/get",method = {RequestMethod.GET})
    @ResponseBody
    public ArticleView getArticle(@RequestParam("id") Integer id){
        ArticleModel articleModel=articleService.getArticleById(id);
        ArticleView articleView=new ArticleView();
        BeanUtils.copyProperties(articleView,articleModel);
        return articleView;
    }

    //文章列表浏览
    @RequestMapping(value = "/list",method = {RequestMethod.GET})
    @ResponseBody
    public List<ArticleView> articleList(){
        List<ArticleModel> articleModelList=articleService.ListArticle();

//       List<ArticleView> articleViewList=articleModelList.stream().map(ArticleModel->{
//            ArticleView articleView=new ArticleView();
//            BeanUtils.copyProperties(ArticleModel,articleModelList);
//            return  articleView;
//        }).collect(Collectors.toList());

        List<ArticleView> articleModelList1= articleModelList.stream().map(p->{
            ArticleView articleModel1=new ArticleView();
            BeanUtils.copyProperties(p,articleModel1);
            return  articleModel1;
        }).collect(Collectors.toList());

        return articleModelList1;
    }



    private  ArticleView converViewFromModel(ArticleModel articleModel){
        if(articleModel==null){
            return  null;
        }
        ArticleView articleView=new ArticleView();
        BeanUtils.copyProperties(articleView,articleView);
        return articleView;
    }


}
