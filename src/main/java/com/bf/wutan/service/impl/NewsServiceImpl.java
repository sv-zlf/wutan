package com.bf.wutan.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bf.wutan.entity.News;
import com.bf.wutan.mapper.NewsMapper;
import com.bf.wutan.service.NewsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bf.wutan.utils.DateUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  新闻动态服务实现类
 * </p>
 *
 * @author bf
 * @since 2022-04-19
 */
@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements NewsService {

    final NewsMapper newsMapper;

    public NewsServiceImpl(NewsMapper newsMapper) {
        this.newsMapper = newsMapper;
    }

    @Override
    public Boolean createNews(News news){
        news.setState(true);
        news.setUpdateTime(DateUtils.getCurrentTime());
        return  newsMapper.createNews(news);
    }

    @Override
    public Boolean deleteNewsByTitle(String title){
        return  newsMapper.deleteNewsByTitle(title);
    }


    @Override
    public Boolean updateNews(News news){
        news.setUpdateTime(DateUtils.getCurrentTime());
        return newsMapper.updateNews(news);
    }

    @Override
    public Boolean updateNewsStatus(String title){
        return newsMapper.updateNewsStatus(title);
    }

    @Override
    public IPage<News> getNews(Page<News> page){
        return newsMapper.getNews(page);
    }



    @Override
    public News selectNewsByTitle(String title){
        return newsMapper.setNewsByTitle(title);
    }


}
