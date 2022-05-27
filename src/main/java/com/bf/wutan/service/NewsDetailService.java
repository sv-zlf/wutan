package com.bf.wutan.service;

import com.bf.wutan.entity.NewsDetail;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 
 * @since 2022-04-20
 */
public interface NewsDetailService extends IService<NewsDetail> {

    /**
     * 添加新闻动态详情
     *
     * @param newsDetail 新闻详情
     * @return 是否添加新闻动态详情
     */
    Boolean createNewsDetail(NewsDetail newsDetail);

    /**
     * 删除新闻动态详情
     *
     * @param title 新闻标题
     * @return 是否删除新闻动态详情
     */
    Boolean deleteNewsDetail(String title);

    /**
     * 更新新闻动态详情
     *
     * @param newsDetail 新闻动态详情
     * @return 是否更新新闻动态详情
     */
    Boolean updateNewsDetail(NewsDetail newsDetail);

    /**
     * 更新阅读量
     *
     * @param title 新闻标题
     * @return  是否更新阅读量
     */
    Boolean updateNewsDetailReadCountByTitle(String title);

    /**
     * 根据标题获取新闻动态详情
     *
     * @param title 新闻标题
     * @return 新闻动态详情
     */
    NewsDetail getNewsDetailByTitle(String title);

}
