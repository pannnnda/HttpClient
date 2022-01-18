package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysCase;

/**
 * 案例信息Mapper接口
 * 
 * @author Bryant
 * @date 2021-12-20
 */
public interface SysCaseMapper 
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
     * 删除案例信息
     * 
     * @param caseId 案例信息主键
     * @return 结果
     */
    public int deleteSysCaseByCaseId(Long caseId);

    /**
     * 批量删除案例信息
     * 
     * @param caseIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysCaseByCaseIds(String[] caseIds);

//    /**
//     * 查询报文信息列表
//     *
//     * @param caseName 案例信息
//     * @return 案例信息集合
//     */
    public List<SysCase> sendCaseByCaseName(String caseName);
}
