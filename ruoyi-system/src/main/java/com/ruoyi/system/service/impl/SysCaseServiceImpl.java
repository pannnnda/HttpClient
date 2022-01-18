package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysCaseMapper;
import com.ruoyi.system.domain.SysCase;
import com.ruoyi.system.service.ISysCaseService;
import com.ruoyi.common.core.text.Convert;

/**
 * 案例信息Service业务层处理
 * 
 * @author Bryant
 * @date 2021-12-20
 */
@Service
public class SysCaseServiceImpl implements ISysCaseService 
{
    @Autowired
    private SysCaseMapper sysCaseMapper;

    /**
     * 查询案例信息
     * 
     * @param caseId 案例信息主键
     * @return 案例信息
     */
    @Override
    public SysCase selectSysCaseByCaseId(Long caseId)
    {
        return sysCaseMapper.selectSysCaseByCaseId(caseId);
    }

    /**
     * 查询案例信息列表
     * 
     * @param sysCase 案例信息
     * @return 案例信息
     */
    @Override
    public List<SysCase> selectSysCaseList(SysCase sysCase)
    {
        return sysCaseMapper.selectSysCaseList(sysCase);
    }

    /**
     * 根据caseName查询案例信息列表
     *
     * @param caseName 案例信息
     * @return 案例信息
     */
    @Override
    public List<SysCase> selectSysCaseNameList(String caseName)
    {
        return sysCaseMapper.selectSysCaseNameList(caseName);
    }

    /**
     * 新增案例信息
     * 
     * @param sysCase 案例信息
     * @return 结果
     */
    @Override
    public int insertSysCase(SysCase sysCase)
    {
        return sysCaseMapper.insertSysCase(sysCase);
    }

    /**
     * 修改案例信息
     * 
     * @param sysCase 案例信息
     * @return 结果
     */
    @Override
    public int updateSysCase(SysCase sysCase)
    {
        return sysCaseMapper.updateSysCase(sysCase);
    }

    /**
     * 批量删除案例信息
     * 
     * @param caseIds 需要删除的案例信息主键
     * @return 结果
     */
    @Override
    public int deleteSysCaseByCaseIds(String caseIds)
    {
        return sysCaseMapper.deleteSysCaseByCaseIds(Convert.toStrArray(caseIds));
    }

    /**
     * 删除案例信息信息
     * 
     * @param caseId 案例信息主键
     * @return 结果
     */
    @Override
    public int deleteSysCaseByCaseId(Long caseId)
    {
        return sysCaseMapper.deleteSysCaseByCaseId(caseId);
    }

    /**
     * 发送案例信息信息
     *
     * @param caseName 案例信息主键
     * @return 结果
     */
    public List<SysCase> sendCaseByCaseName(String caseName){
        List<SysCase> list = sysCaseMapper.sendCaseByCaseName(caseName);
        return list;
    };
}
