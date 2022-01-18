package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysInterface;

/**
 * 接口树表Mapper接口
 * 
 * @author ruoyi
 * @date 2022-01-10
 */
public interface SysInterfaceMapper 
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
     * 删除接口树表
     * 
     * @param interfaceId 接口树表主键
     * @return 结果
     */
    public int deleteSysInterfaceByInterfaceId(Long interfaceId);

    /**
     * 批量删除接口树表
     * 
     * @param interfaceIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysInterfaceByInterfaceIds(String[] interfaceIds);
}
