package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysInterfacedetailMapper;
import com.ruoyi.system.domain.SysInterfacedetail;
import com.ruoyi.system.service.ISysInterfacedetailService;
import com.ruoyi.common.core.text.Convert;

/**
 * 接口详细信息Service业务层处理
 * 
 * @author Bryant
 * @date 2021-12-30
 */
@Service
public class SysInterfacedetailServiceImpl implements ISysInterfacedetailService 
{
    @Autowired
    private SysInterfacedetailMapper sysInterfacedetailMapper;

    /**
     * 查询接口详细信息
     * 
     * @param sysInterfacedetailId 接口详细信息主键
     * @return 接口详细信息
     */
    @Override
    public SysInterfacedetail selectSysInterfacedetailBySysInterfacedetailId(Long sysInterfacedetailId)
    {
        return sysInterfacedetailMapper.selectSysInterfacedetailBySysInterfacedetailId(sysInterfacedetailId);
    }

    /**
     * 查询接口详细信息列表
     * 
     * @param sysInterfacedetail 接口详细信息
     * @return 接口详细信息
     */
    @Override
    public List<SysInterfacedetail> selectSysInterfacedetailList(SysInterfacedetail sysInterfacedetail)
    {
        return sysInterfacedetailMapper.selectSysInterfacedetailList(sysInterfacedetail);
    }

    /**
     * 新增接口详细信息
     * 
     * @param sysInterfacedetail 接口详细信息
     * @return 结果
     */
    @Override
    public int insertSysInterfacedetail(SysInterfacedetail sysInterfacedetail)
    {
        return sysInterfacedetailMapper.insertSysInterfacedetail(sysInterfacedetail);
    }

    /**
     * 修改接口详细信息
     * 
     * @param sysInterfacedetail 接口详细信息
     * @return 结果
     */
    @Override
    public int updateSysInterfacedetail(SysInterfacedetail sysInterfacedetail)
    {
        return sysInterfacedetailMapper.updateSysInterfacedetail(sysInterfacedetail);
    }

    /**
     * 批量删除接口详细信息
     * 
     * @param sysInterfacedetailIds 需要删除的接口详细信息主键
     * @return 结果
     */
    @Override
    public int deleteSysInterfacedetailBySysInterfacedetailIds(String sysInterfacedetailIds)
    {
        return sysInterfacedetailMapper.deleteSysInterfacedetailBySysInterfacedetailIds(Convert.toStrArray(sysInterfacedetailIds));
    }

    /**
     * 删除接口详细信息信息
     * 
     * @param sysInterfacedetailId 接口详细信息主键
     * @return 结果
     */
    @Override
    public int deleteSysInterfacedetailBySysInterfacedetailId(Long sysInterfacedetailId)
    {
        return sysInterfacedetailMapper.deleteSysInterfacedetailBySysInterfacedetailId(sysInterfacedetailId);
    }
}
