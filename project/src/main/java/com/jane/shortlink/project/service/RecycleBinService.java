package com.jane.shortlink.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jane.shortlink.project.dao.entity.ShortLinkDO;
import com.jane.shortlink.project.dto.req.RecycleBinSaveRepDTO;

/**
 * _@Description: 回收管理接口层
 */
public interface RecycleBinService extends IService<ShortLinkDO> {

    /**
     * 移至回收站
     * @param requestParam 回收站保存请求对象
     */
    public void saveRecycleBin(RecycleBinSaveRepDTO requestParam);
}
