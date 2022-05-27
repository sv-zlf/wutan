package com.bf.wutan.service.impl;

import com.bf.wutan.entity.NewsDetail;
import com.bf.wutan.mapper.NewsDetailMapper;
import com.bf.wutan.service.NewsDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author bf
 * @since 2022-04-20
 */
@Service
public class NewsDetailServiceImpl extends ServiceImpl<NewsDetailMapper, NewsDetail> implements NewsDetailService {

    final NewsDetailMapper newsDetailMapper;

    public NewsDetailServiceImpl(NewsDetailMapper newsDetailMapper) {
        this.newsDetailMapper = newsDetailMapper;
    }

    @Override
    public Boolean createNewsDetail(NewsDetail newsDetail){
        newsDetail.setReadCount(0);
        return newsDetailMapper.createNewsDetail(newsDetail);
    }

    @Override
    public Boolean deleteNewsDetail(String title){
        return newsDetailMapper.deleteNewsDetail(title);
    }

    @Override
    public Boolean updateNewsDetail(NewsDetail newsDetail){
        return newsDetailMapper.updateNewsDetail(newsDetail);
    }

    @Override
    public Boolean updateNewsDetailReadCountByTitle(String title){
        return newsDetailMapper.updateNewsDetailReadCountByTitle(title);
    }

    @Override
    public  NewsDetail getNewsDetailByTitle(String title){
        return newsDetailMapper.getNewsDetailByTitle(title);
    }


}
