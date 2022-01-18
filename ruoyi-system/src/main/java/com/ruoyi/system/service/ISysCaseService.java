package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysCase;

/**
 * 案例信息Service接口
 * 
 * @author Bryant
 * @date 2021-12-20
 */
public interface ISysCaseService 
{
    /**
     * 查询案例信息
     * 
     * @param caseId 案例信息主键
     * @return 案例信息
     */
    public SysCase selectSysCaseByCaseId(Long caseId);

    /**
     * 查询案例信息列表
     * 
     * @param sysCase 案例信息
     * @return 案例信息集合
     */
    public List<SysCase> selectSysCaseList(SysCase sysCase);

    /**
     * 根据caseName查询案例信息列表
     *
     * @param caseName 案例信息
     * @return 案例信息集合
     */
    public List<SysCase> selectSysCaseNameList(String caseName);

    /**
     * 新增案例信息
     * 
     * @param sysCase 案例信息
     * @return 结果
     */
    public int insertSysCase(SysCase sysCase);

    /**
     * 修改案例信息
     * 
     * @param sysCase 案例信息
     * @return 结果
     */
    public int updateSysCase(SysCase sysCase);

    /**
     * 批量删除案例信息
     * 
     * @param caseIds 需要删除的案例信息主键集合
     * @return 结果
     */
    public int deleteSysCaseByCaseIds(String caseIds);

    /**
     * 删除案例信息信息
     * 
     * @param caseId 案例信息主键
     * @return 结果
     */
    public int deleteSysCaseByCaseId(Long caseId);

    /**
     * 发送案例信息信息
     *
     * @param caseId 案例信息主键
     * @return 结果
     */
    public List<SysCase> sendCaseByCaseName(String caseId);
}
