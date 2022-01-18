package com.ruoyi.system.service;

import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.system.domain.SysBusiSystem;

import java.util.List;

/**
 * 业务系统信息 服务层
 * 
 * @author Bryant
 */
public interface ISysBusiSystemService
{
    /**
     * 查询业务系统信息集合
     * 
     * @param busiSystem 业务系统信息
     * @return 业务系统信息集合
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
     * @throws Exception 异常
     */
    public int deleteBusiSystemByIds(String ids) throws Exception;

    /**
     * 新增保存业务系统信息
     * 
     * @param busiSystem 业务系统信息
     * @return 结果
     */
    public int insertBusiSystem(SysBusiSystem busiSystem);

    /**
     * 修改保存业务系统信息
     * 
     * @param busiSystem 业务系统信息
     * @return 结果
     */
    public int updateBusiSystem(SysBusiSystem busiSystem);

    /**
     * 通过业务系统ID查询业务系统使用数量
     *
     * @param busiSystem 业务系统ID
     * @return 结果
     */
    public int countUserBusiSystemById(Long busiSystem);

    /**
     * 校验业务系统名称
     * 
     * @param busiSystem 业务系统信息
     * @return 结果
     */
    public String checkBusiSystemNameUnique(SysBusiSystem busiSystem);

    /**
     * 校验业务系统编码
     * 
     * @param busiSystem 业务系统信息
     * @return 结果
     */
    public String checkBusiSystemCodeUnique(SysBusiSystem busiSystem);

    /**
     * 查询业务系统管理树
     *
     * @param dept 部门信息
     * @return 所有部门信息
     */
    public List<Ztree> selectBusiSystemTree(SysBusiSystem dept);

    /**
     * 查询部门管理树（排除下级）
     *
     * @param dept 部门信息
     * @return 所有部门信息
     */
    public List<Ztree> selectBusiSystemTreeExcludeChild(SysBusiSystem dept);



}
