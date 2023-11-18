package com.jane.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jane.shortlink.admin.dao.entity.GroupDO;
import com.jane.shortlink.admin.dto.req.ShortLinkGroupSaveReqDTO;

import java.util.List;

/**
 * _@Description: 短链接分组接口层
 */
public interface GroupService extends IService<GroupDO> {

    /**
     * 新增短链接分组
     * @param groupName 短链接分组名
     */
    void savaGroup(String groupName);

    /**
     * 查询用户短链接分组集合
     * @return 用户短链接分组集合
     */
    List<ShortLinkGroupSaveReqDTO> listGroup();
}
