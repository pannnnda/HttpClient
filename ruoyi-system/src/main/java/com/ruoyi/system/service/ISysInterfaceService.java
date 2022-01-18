package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysInterface;
import com.ruoyi.common.core.domain.Ztree;

/**
 * 接口树表Service接口
 * 
 * @author ruoyi
 * @date 2022-01-10
 */
public interface ISysInterfaceService 
{
    /**
     * 查询接口树表
     * 
     * @param interfaceId 接口树表主键
     * @return 接口树表
     */
    public SysInterface selectSysInterfaceByInterfaceId(Long interfaceId);

    /**
     * 查询接口树表列表
     * 
     * @param sysInterface 接口树表
     * @return 接口树表集合
     */
    public List<SysInterface> selectSysInterfaceList(SysInterface sysInterface);

    /**
     * 新增接口树表
     * 
     * @param sysInterface 接口树表
     * @return 结果
     */
    public int insertSysInterface(SysInterface sysInterface);

    /**
     * 修改接口树表
     * 
     * @param sysInterface 接口树表
     * @return 结果
     */
    public int updateSysInterface(SysInterface sysInterface);

    /**
     * 批量删除接口树表
     * 
     * @param interfaceIds 需要删除的接口树表主键集合
     * @return 结果
     */
    public int deleteSysInterfaceByInterfaceIds(String interfaceIds);

    /**
     * 删除接口树表信息
     * 
     * @param interfaceId 接口树表主键
     * @return 结果
     */
    public int deleteSysInterfaceByInterfaceId(Long interfaceId);

    /**
     * 查询接口树表树列表
     * 
     * @return 所有接口树表信息
     */
    public List<Ztree> selectSysInterfaceTree();
}
