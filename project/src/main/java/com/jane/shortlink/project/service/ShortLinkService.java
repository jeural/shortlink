package com.jane.shortlink.project.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jane.shortlink.project.dao.entity.ShortLinkDO;
import com.jane.shortlink.project.dto.req.ShortLinkCreateReqDTO;
import com.jane.shortlink.project.dto.req.ShortLinkPageReqDTO;
import com.jane.shortlink.project.dto.resp.ShortLinkCreateRespDTO;
import com.jane.shortlink.project.dto.resp.ShortLinkGroupCountQueryRespDTO;
import com.jane.shortlink.project.dto.resp.ShortLinkPageRespDTO;

import java.util.List;

/**
 * _@Description: 短链接接口层
 */
public interface ShortLinkService extends IService<ShortLinkDO> {

    /**
     * 创建短链接
     * @param requestParam 创建短链接请求参数
     * @return 短链接创建信息
     */
    ShortLinkCreateRespDTO createShortLink(ShortLinkCreateReqDTO requestParam);

    /**
     * 短链接分页查询
     * @param requestParam 短链接分页查询请求参数
     * @return 短链接分页查询返回结果
     */
    IPage<ShortLinkPageRespDTO> pageShortLink(ShortLinkPageReqDTO requestParam);

    /**
     * 查询短链接分组内数量
     * @param requestParam 查询短链接分组内数量请求参数
     * @return 查询短链接分组内数量响应
     */
    List<ShortLinkGroupCountQueryRespDTO> listGroupShortLinkCount(List<String> requestParam);
}
