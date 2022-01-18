package com.ruoyi.web.controller.system;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.SysInterfacedetail;
import com.ruoyi.system.service.ISysInterfacedetailService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 接口详细信息Controller
 * 
 * @author Bryant
 * @date 2021-12-30
 */
@Controller
@RequestMapping("/system/interfacedetail")
public class SysInterfacedetailController extends BaseController
{
    private String prefix = "system/interfacedetail";

    @Autowired
    private ISysInterfacedetailService sysInterfacedetailService;

    @RequiresPermissions("system:interfacedetail:view")
    @GetMapping()
    public String interfacedetail(@RequestParam(required = false) String interfaceId,ModelMap modelMap)
    {
        modelMap.put("interfaceId",interfaceId);
        return prefix + "/interfacedetail";
    }

    /**
     * 查询接口详细信息列表
     */
    @RequiresPermissions("system:interfacedetail:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysInterfacedetail sysInterfacedetail)
    {
        startPage();
        System.out.println(sysInterfacedetail.getInterfaceId());
        List<SysInterfacedetail> list = sysInterfacedetailService.selectSysInterfacedetailList(sysInterfacedetail);
        return getDataTable(list);
    }

    /**
     * 导出接口详细信息列表
     */
    @RequiresPermissions("system:interfacedetail:export")
    @Log(title = "接口详细信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysInterfacedetail sysInterfacedetail)
    {
        List<SysInterfacedetail> list = sysInterfacedetailService.selectSysInterfacedetailList(sysInterfacedetail);
        ExcelUtil<SysInterfacedetail> util = new ExcelUtil<SysInterfacedetail>(SysInterfacedetail.class);
        return util.exportExcel(list, "接口详细信息数据");
    }

    /**
     * 新增接口详细信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存接口详细信息
     */
    @RequiresPermissions("system:interfacedetail:add")
    @Log(title = "接口详细信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysInterfacedetail sysInterfacedetail)
    {
        return toAjax(sysInterfacedetailService.insertSysInterfacedetail(sysInterfacedetail));
    }

    /**
     * 修改接口详细信息
     */
    @RequiresPermissions("system:interfacedetail:edit")
    @GetMapping("/edit/{sysInterfacedetailId}")
    public String edit(@PathVariable("sysInterfacedetailId") Long sysInterfacedetailId, ModelMap mmap)
    {
        SysInterfacedetail sysInterfacedetail = sysInterfacedetailService.selectSysInterfacedetailBySysInterfacedetailId(sysInterfacedetailId);
        mmap.put("sysInterfacedetail", sysInterfacedetail);
        return prefix + "/edit";
    }

    /**
     * 修改保存接口详细信息
     */
    @RequiresPermissions("system:interfacedetail:edit")
    @Log(title = "接口详细信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysInterfacedetail sysInterfacedetail)
    {
        return toAjax(sysInterfacedetailService.updateSysInterfacedetail(sysInterfacedetail));
    }

    /**
     * 删除接口详细信息
     */
    @RequiresPermissions("system:interfacedetail:remove")
    @Log(title = "接口详细信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysInterfacedetailService.deleteSysInterfacedetailBySysInterfacedetailIds(ids));
    }
}
