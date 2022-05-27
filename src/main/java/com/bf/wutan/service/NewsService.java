package com.bf.wutan.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bf.wutan.entity.News;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  新闻动态服务类
 * </p>
 *
 * @author bf
 * @since 2022-04-19
 */
public interface NewsService extends IService<News> {


    /**
     * 添加新闻动态
     *
     * @param news 新闻动态
     * @return 是否添加新闻动态
     */
    Boolean createNews(News news);


    /**
     * 根据新闻标题删除新闻动态
     *
     * @param title 新闻标题
     * @return 是否删除新闻动态
     */
    Boolean deleteNewsByTitle(String title);


    /**
     * 更新新闻洞体啊
     *
     * @param news 新闻动态
     * @return 是否更新新闻动态
     */
    Boolean updateNews(News news);


    /**
     * 更新文章发布状态
     *
     * @param title 新闻标题
     * @return 是否更新发布状态
     */
    Boolean updateNewsStatus(String title);

    /**
     * 获取新闻动态列表
     *
     * @param page mybatis分页
     * @return 新闻动态列表
     */
    IPage<News> getNews(Page<News> page);

    /**
     * 根据新闻标题获取新闻动态
     *
     * @param title 新闻标题
     * @return 新闻动态
     */
    News selectNewsByTitle(String title);


}
