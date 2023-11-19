package com.jane.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jane.shortlink.admin.dao.entity.GroupDO;
import com.jane.shortlink.admin.dto.req.ShortLinkGroupSaveReqDTO;
import com.jane.shortlink.admin.dto.req.ShortLinkGroupSortReqDTO;
import com.jane.shortlink.admin.dto.req.ShortLinkGroupUpdateReqDTO;

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

    /**
     * 修改短链接分组
     * @param requestParam 修改短链接分组参数
     */
    void updateGroup(ShortLinkGroupUpdateReqDTO requestParam);

    /**
     * 删除短链接分组
     * @param gid 短链接分组标识
     */
    void deleteGroup(String gid);

    /**
     *  短链接分组排序
     * @param requestParam 短链接分组排序参数
     */
    void sortOrder(List<ShortLinkGroupSortReqDTO> requestParam);
}
