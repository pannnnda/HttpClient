package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.SysBusiSystem;
import com.ruoyi.system.domain.SysInterface;
import com.ruoyi.system.service.ISysBusiSystemService;
import com.ruoyi.system.service.ISysInterfaceService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 业务系统信息操作处理
 * 
 * @author Bryant
 */
@Controller
@RequestMapping("/system/busiSystem")
public class SysBusiSystemController extends BaseController
{
    private String prefix = "system/busiSystem";

    @Autowired
    private ISysBusiSystemService postService;

    @Autowired
    private ISysInterfaceService interService;

    @RequiresPermissions("system:busiSystem:view")
    @GetMapping()
    public String operlog()
    {
        return prefix + "/busiSystem";
    }

    @RequiresPermissions("system:busiSystem:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysBusiSystem post)
    {
        startPage();
        List<SysBusiSystem> list = postService.selectBusiSystemList(post);
        return getDataTable(list);
    }

    @Log(title = "业务系统管理", businessType = BusinessType.EXPORT)
    @RequiresPermissions("system:busiSystem:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysBusiSystem post)
    {
        List<SysBusiSystem> list = postService.selectBusiSystemList(post);
        ExcelUtil<SysBusiSystem> util = new ExcelUtil<SysBusiSystem>(SysBusiSystem.class);
        return util.exportExcel(list, "业务系统数据");
    }

    @RequiresPermissions("system:busiSystem:remove")
    @Log(title = "业务系统管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        try
        {
            return toAjax(postService.deleteBusiSystemByIds(ids));
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }

    /**
     * 新增业务系统
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存业务系统
     */
    @RequiresPermissions("system:busiSystem:add")
    @Log(title = "业务系统管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated SysBusiSystem post)
    {
        if (UserConstants.BUSISYSTEM_NAME_NOT_UNIQUE.equals(postService.checkBusiSystemNameUnique(post)))
        {
            return error("新增业务系统'" + post.getBusiSystemName() + "'失败，业务系统名称已存在");
        }
        else if (UserConstants.BUSISYSTEM_CODE_NOT_UNIQUE.equals(postService.checkBusiSystemCodeUnique(post)))
        {
            return error("新增业务系统'" + post.getBusiSystemName() + "'失败，业务系统编码已存在");
        }
        SysInterface inter = new SysInterface();
        inter.setInterfaceId(post.getBusiSystemId());
        inter.setInterfaceName(post.getBusiSystemName());
        inter.setBusiSystemId((long) 0);
        inter.setBusiSystemName(post.getBusiSystemName());
        interService.insertSysInterface(inter);
        post.setCreateBy(getLoginName());
        return toAjax(postService.insertBusiSystem(post));
    }

    /**
     * 修改业务系统
     */
    @RequiresPermissions("system:busiSystem:edit")
    @GetMapping("/edit/{busiSystemId}")
    public String edit(@PathVariable("busiSystemId") Long postId, ModelMap mmap)
    {
        mmap.put("busiSystem", postService.selectBusiSystemById(postId));
        return prefix + "/edit";
    }

    /**
     * 修改保存业务系统
     */
    @RequiresPermissions("system:busiSystem:edit")
    @Log(title = "业务系统管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated SysBusiSystem post)
    {
        if (UserConstants.BUSISYSTEM_NAME_NOT_UNIQUE.equals(postService.checkBusiSystemNameUnique(post)))
        {
            return error("修改业务系统'" + post.getBusiSystemName() + "'失败，业务系统名称已存在");
        }
        else if (UserConstants.BUSISYSTEM_CODE_NOT_UNIQUE.equals(postService.checkBusiSystemCodeUnique(post)))
        {
            return error("修改业务系统'" + post.getBusiSystemName() + "'失败，业务系统编码已存在");
        }
        post.setUpdateBy(getLoginName());
        return toAjax(postService.updateBusiSystem(post));
    }

    /**
     * 校验业务系统名称
     */
    @PostMapping("/checkBusiSystemNameUnique")
    @ResponseBody
    public String checkBusiSystemNameUnique(SysBusiSystem post)
    {
        return postService.checkBusiSystemNameUnique(post);
    }

    /**
     * 校验业务系统编码
     */
    @PostMapping("/checkBusiSystemCodeUnique")
    @ResponseBody
    public String checkBusiSystemCodeUnique(SysBusiSystem post)
    {
        return postService.checkBusiSystemCodeUnique(post);
    }

    /**
     * 选择部门树
     *
     * @param deptId 部门ID
     * @param excludeId 排除ID
     */
    @GetMapping(value = { "/selectBusiSystemTree/{busiSystemId}", "/selectBusiSystemTree/{busiSystemId}/{excludeId}" })
    public String selectDeptTree(@PathVariable("busiSystemId") Long deptId,
                                 @PathVariable(value = "excludeId", required = false) String excludeId, ModelMap mmap)
    {
        mmap.put("dept", postService.selectBusiSystemById(deptId));
        mmap.put("excludeId", excludeId);
        return prefix + "/tree";
    }

    /**
     * 加载部门列表树
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData()
    {
        List<Ztree> ztrees = postService.selectBusiSystemTree(new SysBusiSystem());
        return ztrees;
    }

    /**
     * 加载部门列表树（排除下级）
     */
    @GetMapping("/treeData/{excludeId}")
    @ResponseBody
    public List<Ztree> treeDataExcludeChild(@PathVariable(value = "excludeId", required = false) Long excludeId)
    {
        SysBusiSystem dept = new SysBusiSystem();
        dept.setExcludeId(excludeId);
        List<Ztree> ztrees = postService.selectBusiSystemTreeExcludeChild(dept);
        return ztrees;
    }

}
