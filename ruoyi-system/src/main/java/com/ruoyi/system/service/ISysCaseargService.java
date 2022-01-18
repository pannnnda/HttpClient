package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysCasearg;

/**
 * 案例列表Service接口
 * 
 * @author Bryant
 * @date 2021-12-21
 */
public interface ISysCaseargService 
{
    /**
     * 查询案例列表
     * 
     * @param caseId 案例列表主键
     * @return 案例列表
     */
    public SysCasearg selectSysCaseargByCaseId(Long caseId);

    /**
     * 查询案例列表列表
     * 
     * @param sysCasearg 案例列表
     * @return 案例列表集合
     */
    public List<SysCasearg> selectSysCaseargList(SysCasearg sysCasearg);

    /**
     * 新增案例列表
     * 
     * @param sysCasearg 案例列表
     * @return 结果
     */
    public int insertSysCasearg(SysCasearg sysCasearg);

    /**
     * 修改案例列表
     * 
     * @param sysCasearg 案例列表
     * @return 结果
     */
    public int updateSysCasearg(SysCasearg sysCasearg);

    /**
     * 批量删除案例列表
     * 
     * @param caseIds 需要删除的案例列表主键集合
     * @return 结果
     */
    public int deleteSysCaseargByCaseIds(String caseIds);

    /**
     * 删除案例列表信息
     * 
     * @param caseId 案例列表主键
     * @return 结果
     */
    public int deleteSysCaseargByCaseId(Long caseId);


}
