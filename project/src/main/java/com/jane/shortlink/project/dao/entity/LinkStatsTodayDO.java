package com.jane.shortlink.project.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.jane.shortlink.project.common.database.BaseDO;
import lombok.Data;

import java.util.Date;

/**
 * _@Description: 短链接今日统计实体
 */
@Data
@TableName("t_link_stats_today")
public class LinkStatsTodayDO extends BaseDO {

    /**
     * ID
     */
    private Long id;

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 短链接
     */
    private String fullShortUrl;

    /**
     * 日期
     */
    private Date date;

    /**
     * 今日pv
     */
    private Integer todayPv;

    /**
     * 今日uv
     */
    private Integer todayUv;

    /**
     * 今日ip数
     */
    private Integer todayIpCount;
}
