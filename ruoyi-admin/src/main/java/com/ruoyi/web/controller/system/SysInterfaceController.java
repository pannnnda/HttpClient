package com.ruoyi.web.controller.system;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.SysInterface;
import com.ruoyi.system.service.ISysInterfaceService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.core.domain.Ztree;

/**
 * 接口树表Controller
 * 
 * @author ruoyi
 * @date 2022-01-10
 */
@Controller
@RequestMapping("/system/interface")
public class SysInterfaceController extends BaseController
{
    private String prefix = "system/interface";

    @Autowired
    private ISysInterfaceService sysInterfaceService;

    @RequiresPermissions("system:interface:view")
    @GetMapping()
    public String inter()
    {
        return prefix + "/interface";
    }

    /**
     * 查询接口树表树列表
     */
    @RequiresPermissions("system:interface:list")
    @PostMapping("/list")
    @ResponseBody
    public List<SysInterface> list(SysInterface sysInterface)
    {
        List<SysInterface> list = sysInterfaceService.selectSysInterfaceList(sysInterface);
        return list;
    }

    /**
     * 导出接口树表列表
     */
    @RequiresPermissions("system:interface:export")
    @Log(title = "接口树表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysInterface sysInterface)
    {
        List<SysInterface> list = sysInterfaceService.selectSysInterfaceList(sysInterface);
        ExcelUtil<SysInterface> util = new ExcelUtil<SysInterface>(SysInterface.class);
        return util.exportExcel(list, "接口树表数据");
    }

    /**
     * 新增接口树表
     */
    @GetMapping(value = { "/add/{interfaceId}", "/add/" })
    public String add(@PathVariable(value = "interfaceId", required = false) Long interfaceId, ModelMap mmap)
    {
        if (StringUtils.isNotNull(interfaceId))
        {
            mmap.put("sysInterface", sysInterfaceService.selectSysInterfaceByInterfaceId(interfaceId));
        }
        return prefix + "/add";
    }

    /**
     * 新增保存接口树表
     */
    @RequiresPermissions("system:interface:add")
    @Log(title = "接口树表", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysInterface sysInterface)
    {
        return toAjax(sysInterfaceService.insertSysInterface(sysInterface));
    }

    /**
     * 修改接口树表
     */
    @RequiresPermissions("system:interface:edit")
    @GetMapping("/edit/{interfaceId}")
    public String edit(@PathVariable("interfaceId") Long interfaceId, ModelMap mmap)
    {
        SysInterface sysInterface = sysInterfaceService.selectSysInterfaceByInterfaceId(interfaceId);
        mmap.put("sysInterface", sysInterface);
        return prefix + "/edit";
    }

    /**
     * 修改保存接口树表
     */
    @RequiresPermissions("system:interface:edit")
    @Log(title = "接口树表", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysInterface sysInterface)
    {
        return toAjax(sysInterfaceService.updateSysInterface(sysInterface));
    }

    /**
     * 删除
     */
    @RequiresPermissions("system:interface:remove")
    @Log(title = "接口树表", businessType = BusinessType.DELETE)
    @GetMapping("/remove/{interfaceId}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("interfaceId") Long interfaceId)
    {
        return toAjax(sysInterfaceService.deleteSysInterfaceByInterfaceId(interfaceId));
    }

    /**
     * 选择接口树表树
     */
    @GetMapping(value = { "/selectInterfaceTree/{interfaceId}", "/selectInterfaceTree/" })
    public String selectInterfaceTree(@PathVariable(value = "interfaceId", required = false) Long interfaceId, ModelMap mmap)
    {
        if (StringUtils.isNotNull(interfaceId))
        {
            mmap.put("sysInterface", sysInterfaceService.selectSysInterfaceByInterfaceId(interfaceId));
        }
        return prefix + "/tree";
    }

    /**
     * 加载接口树表树列表
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData()
    {
        List<Ztree> ztrees = sysInterfaceService.selectSysInterfaceTree();
        return ztrees;
    }
}
