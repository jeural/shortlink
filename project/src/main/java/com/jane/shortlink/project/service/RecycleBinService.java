package com.jane.shortlink.project.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jane.shortlink.project.dao.entity.ShortLinkDO;
import com.jane.shortlink.project.dto.req.RecycleBinRecoverRepDTO;
import com.jane.shortlink.project.dto.req.RecycleBinSaveRepDTO;
import com.jane.shortlink.project.dto.req.ShortLinkRecycleBinPageReqDTO;
import com.jane.shortlink.project.dto.resp.ShortLinkPageRespDTO;

/**
 * _@Description: 回收管理接口层
 */
public interface RecycleBinService extends IService<ShortLinkDO> {

    /**
     * 移至回收站
     * @param requestParam 回收站保存请求对象
     */
    void saveRecycleBin(RecycleBinSaveRepDTO requestParam);

    /**
     * 回收站分页查询
     * @param requestParam 回收站分页查询请求参数
     * @return 回收站分页查询返回结果
     */
    IPage<ShortLinkPageRespDTO> pageShortLink(ShortLinkRecycleBinPageReqDTO requestParam);

    /**
     * 恢复回收站短链接
     * @param requestParam 回收站短链接恢复请求对象
     */
   void recoverRecycleBin(RecycleBinRecoverRepDTO requestParam);
}
