package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysInterfacedetail;

/**
 * 接口详细信息Mapper接口
 * 
 * @author Bryant
 * @date 2021-12-30
 */
public interface SysInterfacedetailMapper 
{
    /**
     * 查询接口详细信息
     * 
     * @param sysInterfacedetailId 接口详细信息主键
     * @return 接口详细信息
     */
    public SysInterfacedetail selectSysInterfacedetailBySysInterfacedetailId(Long sysInterfacedetailId);

    /**
     * 查询接口详细信息列表
     * 
     * @param sysInterfacedetail 接口详细信息
     * @return 接口详细信息集合
     */
    public List<SysInterfacedetail> selectSysInterfacedetailList(SysInterfacedetail sysInterfacedetail);

    /**
     * 新增接口详细信息
     * 
     * @param sysInterfacedetail 接口详细信息
     * @return 结果
     */
    public int insertSysInterfacedetail(SysInterfacedetail sysInterfacedetail);

    /**
     * 修改接口详细信息
     * 
     * @param sysInterfacedetail 接口详细信息
     * @return 结果
     */
    public int updateSysInterfacedetail(SysInterfacedetail sysInterfacedetail);

    /**
     * 删除接口详细信息
     * 
     * @param sysInterfacedetailId 接口详细信息主键
     * @return 结果
     */
    public int deleteSysInterfacedetailBySysInterfacedetailId(Long sysInterfacedetailId);

    /**
     * 批量删除接口详细信息
     * 
     * @param sysInterfacedetailIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysInterfacedetailBySysInterfacedetailIds(String[] sysInterfacedetailIds);
}
