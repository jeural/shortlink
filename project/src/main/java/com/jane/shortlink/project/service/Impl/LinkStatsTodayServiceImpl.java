package com.jane.shortlink.project.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jane.shortlink.project.dao.entity.LinkStatsTodayDO;
import com.jane.shortlink.project.dao.mapper.LinkStatsTodayMapper;
import com.jane.shortlink.project.service.LinkStatsTodayService;
import org.springframework.stereotype.Service;

/**
 * _@Description: 短链接今日统计接口实现层
 */
@Service
public class LinkStatsTodayServiceImpl extends ServiceImpl<LinkStatsTodayMapper, LinkStatsTodayDO> implements LinkStatsTodayService {
}