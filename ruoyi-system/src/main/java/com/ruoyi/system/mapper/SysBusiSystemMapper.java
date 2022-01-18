package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.SysBusiSystem;
import java.util.List;

/**
 * 业务系统信息 数据层
 *
 * @author Bryant
 */
public interface SysBusiSystemMapper
{
    /**
     * 查询业务系统数据集合
     *
     * @param busiSystem 业务系统信息
     * @return 业务系统数据集合
     */
    public List<SysBusiSystem> selectBusiSystemList(SysBusiSystem busiSystem);

    /**
     * 查询所有业务系统
     *
     * @return 业务系统列表
     */
    public List<SysBusiSystem> selectBusiSystemAll();

    /**
     * 根据用户ID查询业务系统
     *
     * @param userId 用户ID
     * @return 业务系统列表
     */
    public List<SysBusiSystem> selectBusiSystemByUserId(Long userId);

    /**
     * 通过业务系统ID查询业务系统信息
     *
     * @param busiSystemId 业务系统ID
     * @return 角色对象信息
     */
    public SysBusiSystem selectBusiSystemById(Long busiSystemId);

    /**
     * 批量删除业务系统信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusiSystemByIds(Long[] ids);

    /**
     * 修改业务系统信息
     *
     * @param busiSystem 业务系统信息
     * @return 结果
     */
    public int updateBusiSystem(SysBusiSystem busiSystem);

    /**
     * 新增业务系统信息
     *
     * @param busiSystem 业务系统信息
     * @return 结果
     */
    public int insertBusiSystem(SysBusiSystem busiSystem);

    /**
     * 校验业务系统名称
     *
     * @param busiSystemName 业务系统名称
     * @return 结果
     */
    public SysBusiSystem checkBusiSystemNameUnique(String busiSystemName);

    /**
     * 校验业务系统编码
     *
     * @param busiSystemCode 业务系统编码
     * @return 结果
     */
    public SysBusiSystem checkBusiSystemCodeUnique(String busiSystemCode);
}
