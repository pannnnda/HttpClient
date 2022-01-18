package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysCaseargMapper;
import com.ruoyi.system.domain.SysCasearg;
import com.ruoyi.system.service.ISysCaseargService;
import com.ruoyi.common.core.text.Convert;

/**
 * 案例列表Service业务层处理
 * 
 * @author Bryant
 * @date 2021-12-21
 */
@Service
public class SysCaseargServiceImpl implements ISysCaseargService 
{
    @Autowired
    private SysCaseargMapper sysCaseargMapper;

    /**
     * 查询案例列表
     * 
     * @param caseId 案例列表主键
     * @return 案例列表
     */
    @Override
    public SysCasearg selectSysCaseargByCaseId(Long caseId)
    {
        return sysCaseargMapper.selectSysCaseargByCaseId(caseId);
    }

    /**
     * 查询案例列表列表
     * 
     * @param sysCasearg 案例列表
     * @return 案例列表
     */
    @Override
    public List<SysCasearg> selectSysCaseargList(SysCasearg sysCasearg)
    {
        return sysCaseargMapper.selectSysCaseargList(sysCasearg);
    }

    /**
     * 新增案例列表
     * 
     * @param sysCasearg 案例列表
     * @return 结果
     */
    @Override
    public int insertSysCasearg(SysCasearg sysCasearg)
    {
        return sysCaseargMapper.insertSysCasearg(sysCasearg);
    }

    /**
     * 修改案例列表
     * 
     * @param sysCasearg 案例列表
     * @return 结果
     */
    @Override
    public int updateSysCasearg(SysCasearg sysCasearg)
    {
        return sysCaseargMapper.updateSysCasearg(sysCasearg);
    }

    /**
     * 批量删除案例列表
     * 
     * @param caseIds 需要删除的案例列表主键
     * @return 结果
     */
    @Override
    public int deleteSysCaseargByCaseIds(String caseIds)
    {
        return sysCaseargMapper.deleteSysCaseargByCaseIds(Convert.toStrArray(caseIds));
    }

    /**
     * 删除案例列表信息
     * 
     * @param caseId 案例列表主键
     * @return 结果
     */
    @Override
    public int deleteSysCaseargByCaseId(Long caseId)
    {
        return sysCaseargMapper.deleteSysCaseargByCaseId(caseId);
    }
}
