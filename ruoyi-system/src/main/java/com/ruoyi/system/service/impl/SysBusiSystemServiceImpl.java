package com.ruoyi.system.service.impl;

import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.SysBusiSystem;

import com.ruoyi.system.mapper.SysBusiSystemMapper;


import com.ruoyi.system.service.ISysBusiSystemService;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 业务系统信息 服务层处理
 * 
 * @author Bryant
 */
@Service
public class SysBusiSystemServiceImpl implements ISysBusiSystemService
{
    @Autowired
    private SysBusiSystemMapper busiSystemMapper;

//    @Autowired
//    private SysUserPostMapper userPostMapper;

    /**
     * 查询业务系统信息集合
     * 
     * @param busiSystem 业务系统信息
     * @return 业务系统信息集合
     */
    @Override
    public List<SysBusiSystem> selectBusiSystemList(SysBusiSystem busiSystem)
    {
        return busiSystemMapper.selectBusiSystemList(busiSystem);
    }

    /**
     * 查询所有业务系统
     * 
     * @return 业务系统列表
     */
    @Override
    public List<SysBusiSystem> selectBusiSystemAll()
    {
        return busiSystemMapper.selectBusiSystemAll();
    }

    /**
     * 根据用户ID查询业务系统
     * 
     * @param userId 用户ID
     * @return 业务系统列表
     */
    @Override
    public List<SysBusiSystem> selectBusiSystemByUserId(Long userId)
    {
        List<SysBusiSystem> userBusiSystem = busiSystemMapper.selectBusiSystemByUserId(userId);
        List<SysBusiSystem> userBusiSystems = busiSystemMapper.selectBusiSystemAll();
        for (SysBusiSystem post : userBusiSystems)
        {
            for (SysBusiSystem userRole : userBusiSystem)
            {
                if (post.getBusiSystemId().longValue() == userRole.getBusiSystemId().longValue())
                {
                    post.setFlag(true);
                    break;
                }
            }
        }
        return userBusiSystems;
    }

    /**
     * 通过业务系统ID查询业务系统信息
     * 
     * @param busiSystemId 业务系统ID
     * @return 角色对象信息
     */
    @Override
    public SysBusiSystem selectBusiSystemById(Long busiSystemId)
    {
        return busiSystemMapper.selectBusiSystemById(busiSystemId);
    }

    /**
     * 批量删除业务系统信息
     * 
     * @param ids 需要删除的数据ID
     * @throws Exception
     */
    @Override
    public int deleteBusiSystemByIds(String ids)
    {
        Long[] postIds = Convert.toLongArray(ids);
        for (Long postId : postIds)
        {
            SysBusiSystem post = selectBusiSystemById(postId);
            if (countUserBusiSystemById(postId) > 0)
            {
                throw new ServiceException(String.format("%1$s已分配,不能删除", post.getBusiSystemName()));
            }
        }
        return busiSystemMapper.deleteBusiSystemByIds(postIds);
    }

    /**
     * 新增保存业务系统信息
     * 
     * @param post 业务系统信息
     * @return 结果
     */
    @Override
    public int insertBusiSystem(SysBusiSystem post)
    {
        return busiSystemMapper.insertBusiSystem(post);
    }

    /**
     * 修改保存业务系统信息
     * 
     * @param post 业务系统信息
     * @return 结果
     */
    @Override
    public int updateBusiSystem(SysBusiSystem post)
    {
        return busiSystemMapper.updateBusiSystem(post);
    }

    @Override
    public int countUserBusiSystemById(Long busiSystem) {
        return 0;
    }

//    /**
//     * 通过业务系统ID查询业务系统使用数量
//     *
//     * @param postId 业务系统ID
//     * @return 结果
//     */
//    @Override
//    public int countUserBusiSystemById(Long postId)
//    {
//        return userPostMapper.countUserPostById(postId);
//    }

    /**
     * 校验业务系统名称是否唯一
     * 
     * @param post 业务系统信息
     * @return 结果
     */
    @Override
    public String checkBusiSystemNameUnique(SysBusiSystem post)
    {
        Long postId = StringUtils.isNull(post.getBusiSystemId()) ? -1L : post.getBusiSystemId();
        SysBusiSystem info = busiSystemMapper.checkBusiSystemNameUnique(post.getBusiSystemName());
        if (StringUtils.isNotNull(info) && info.getBusiSystemId().longValue() != postId.longValue())
        {
            return UserConstants.BUSISYSTEM_NAME_NOT_UNIQUE;
        }
        return UserConstants.BUSISYSTEM_NAME_UNIQUE;
    }

    /**
     * 校验业务系统编码是否唯一
     * 
     * @param post 业务系统信息
     * @return 结果
     */
    @Override
    public String checkBusiSystemCodeUnique(SysBusiSystem post)
    {
        Long postId = StringUtils.isNull(post.getBusiSystemId()) ? -1L : post.getBusiSystemId();
        SysBusiSystem info = busiSystemMapper.checkBusiSystemCodeUnique(post.getBusiSystemCode());
        if (StringUtils.isNotNull(info) && info.getBusiSystemId().longValue() != postId.longValue())
        {
            return UserConstants.BUSISYSTEM_CODE_NOT_UNIQUE;
        }
        return UserConstants.BUSISYSTEM_CODE_UNIQUE;
    }

    /**
     * 查询业务系统管理树
     *
     * @param dept 业务系统信息
     * @return 所有业务系统信息
     */
    @Override
    @DataScope(deptAlias = "d")
    public List<Ztree> selectBusiSystemTree(SysBusiSystem dept)
    {
        List<SysBusiSystem> deptList = busiSystemMapper.selectBusiSystemList(dept);
        List<Ztree> ztrees = initZtree(deptList);
        return ztrees;
    }

    /**
     * 查询部门管理树（排除下级）
     *
     * @param dept 部门ID
     * @return 所有部门信息
     */
    @Override
    @DataScope(deptAlias = "d")
    public List<Ztree> selectBusiSystemTreeExcludeChild(SysBusiSystem dept)
    {
        Long excludeId = dept.getExcludeId();
        List<SysBusiSystem> deptList = busiSystemMapper.selectBusiSystemList(dept);
        Iterator<SysBusiSystem> it = deptList.iterator();
        while (it.hasNext())
        {
            SysBusiSystem d = (SysBusiSystem) it.next();
            if (d.getBusiSystemId().intValue() == excludeId
                    || ArrayUtils.contains(StringUtils.split(d.getAncestors(), ","), excludeId + ""))
            {
                it.remove();
            }
        }
        List<Ztree> ztrees = initZtree(deptList);
        return ztrees;
    }

    /**
     * 对象转业务系统树
     *
     * @param deptList 部门列表
     * @return 树结构列表
     */
    public List<Ztree> initZtree(List<SysBusiSystem> deptList)
    {
        return initZtree(deptList, null);
    }

    /**
     * 对象转部门树
     *
     * @param deptList 部门列表
     * @param roleDeptList 角色已存在菜单列表
     * @return 树结构列表
     */
    public List<Ztree> initZtree(List<SysBusiSystem> deptList, List<String> roleDeptList)
    {

        List<Ztree> ztrees = new ArrayList<Ztree>();
        boolean isCheck = StringUtils.isNotNull(roleDeptList);
        for (SysBusiSystem dept : deptList)
        {
            if (UserConstants.DEPT_NORMAL.equals(dept.getStatus()))
            {
                Ztree ztree = new Ztree();
                ztree.setId(dept.getBusiSystemId());
                ztree.setName(dept.getBusiSystemName());
                ztree.setTitle(dept.getBusiSystemName());
                if (isCheck)
                {
                }
                ztrees.add(ztree);
            }
        }
        return ztrees;
    }
}
