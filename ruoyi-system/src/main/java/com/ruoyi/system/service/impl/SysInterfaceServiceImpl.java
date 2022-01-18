package com.ruoyi.system.service.impl;

import java.util.List;
import java.util.ArrayList;
import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysInterfaceMapper;
import com.ruoyi.system.domain.SysInterface;
import com.ruoyi.system.service.ISysInterfaceService;
import com.ruoyi.common.core.text.Convert;

/**
 * 接口树表Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-01-10
 */
@Service
public class SysInterfaceServiceImpl implements ISysInterfaceService 
{
    @Autowired
    private SysInterfaceMapper sysInterfaceMapper;

    /**
     * 查询接口树表
     * 
     * @param interfaceId 接口树表主键
     * @return 接口树表
     */
    @Override
    public SysInterface selectSysInterfaceByInterfaceId(Long interfaceId)
    {
        return sysInterfaceMapper.selectSysInterfaceByInterfaceId(interfaceId);
    }

    /**
     * 查询接口树表列表
     * 
     * @param sysInterface 接口树表
     * @return 接口树表
     */
    @Override
    public List<SysInterface> selectSysInterfaceList(SysInterface sysInterface)
    {
        return sysInterfaceMapper.selectSysInterfaceList(sysInterface);
    }

    /**
     * 新增接口树表
     * 
     * @param sysInterface 接口树表
     * @return 结果
     */
    @Override
    public int insertSysInterface(SysInterface sysInterface)
    {
        sysInterface.setCreateTime(DateUtils.getNowDate());
        return sysInterfaceMapper.insertSysInterface(sysInterface);
    }

    /**
     * 修改接口树表
     * 
     * @param sysInterface 接口树表
     * @return 结果
     */
    @Override
    public int updateSysInterface(SysInterface sysInterface)
    {
        sysInterface.setUpdateTime(DateUtils.getNowDate());
        return sysInterfaceMapper.updateSysInterface(sysInterface);
    }

    /**
     * 批量删除接口树表
     * 
     * @param interfaceIds 需要删除的接口树表主键
     * @return 结果
     */
    @Override
    public int deleteSysInterfaceByInterfaceIds(String interfaceIds)
    {
        return sysInterfaceMapper.deleteSysInterfaceByInterfaceIds(Convert.toStrArray(interfaceIds));
    }

    /**
     * 删除接口树表信息
     * 
     * @param interfaceId 接口树表主键
     * @return 结果
     */
    @Override
    public int deleteSysInterfaceByInterfaceId(Long interfaceId)
    {
        return sysInterfaceMapper.deleteSysInterfaceByInterfaceId(interfaceId);
    }

    /**
     * 查询接口树表树列表
     * 
     * @return 所有接口树表信息
     */
    @Override
    public List<Ztree> selectSysInterfaceTree()
    {
        List<SysInterface> sysInterfaceList = sysInterfaceMapper.selectSysInterfaceList(new SysInterface());
        List<Ztree> ztrees = new ArrayList<Ztree>();
        for (SysInterface sysInterface : sysInterfaceList)
        {
            Ztree ztree = new Ztree();
            ztree.setId(sysInterface.getInterfaceId());
            ztree.setpId(sysInterface.getBusiSystemId());
            ztree.setName(sysInterface.getInterfaceName());
            ztree.setTitle(sysInterface.getInterfaceName());
            ztrees.add(ztree);
        }
        return ztrees;
    }
}
