package com.ruoyi.common.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.common.core.page.PageDomain;
import com.ruoyi.common.core.page.TableSupport;
import com.ruoyi.common.utils.sql.SqlUtil;

/**
 * 分页工具类
 *
 * @author ruoyi
 */
public class PageUtils {
    /**
     * 设置请求分页数据
     */
    public static IPage startPage() {
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();
        String orderBy = SqlUtil.escapeOrderBySql(pageDomain.getOrderBy());
//        Boolean reasonable = pageDomain.getReasonable();
        Page<?> page = new Page<>();
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        page.addOrder(new OrderItem(orderBy, pageDomain.getIsAsc().equals("asc")));
//        PageHelper.startPage(pageNum, pageSize, orderBy).setReasonable(reasonable);
        return page;
    }

//    /**
//     * 清理分页的线程变量
//     */
//    public static void clearPage() {
//        PageHelper.clearPage();
//    }
}
