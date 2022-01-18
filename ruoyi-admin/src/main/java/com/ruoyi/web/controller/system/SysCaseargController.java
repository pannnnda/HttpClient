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
import com.ruoyi.system.domain.SysCasearg;
import com.ruoyi.system.service.ISysCaseargService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 案例列表Controller
 * 
 * @author Bryant
 * @date 2021-12-21
 */
@Controller
@RequestMapping("/system/casearg")
public class SysCaseargController extends BaseController
{
    private String prefix = "system/casearg";

    @Autowired
    private ISysCaseargService sysCaseargService;

    @RequiresPermissions("system:casearg:view")
    @GetMapping()
    public String casearg()
    {
        return prefix + "/casearg";
    }

    /**
     * 查询案例列表列表
     */
    @RequiresPermissions("system:casearg:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysCasearg sysCasearg)
    {
        startPage();
        List<SysCasearg> list = sysCaseargService.selectSysCaseargList(sysCasearg);
        return getDataTable(list);
    }

    /**
     * 导出案例列表列表
     */
    @RequiresPermissions("system:casearg:export")
    @Log(title = "案例列表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysCasearg sysCasearg)
    {
        List<SysCasearg> list = sysCaseargService.selectSysCaseargList(sysCasearg);
        ExcelUtil<SysCasearg> util = new ExcelUtil<SysCasearg>(SysCasearg.class);
        return util.exportExcel(list, "案例列表数据");
    }

    /**
     * 新增案例列表
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存案例列表
     */
    @RequiresPermissions("system:casearg:add")
    @Log(title = "案例列表", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysCasearg sysCasearg)
    {
        return toAjax(sysCaseargService.insertSysCasearg(sysCasearg));
    }

    /**
     * 修改案例列表
     */
    @RequiresPermissions("system:casearg:edit")
    @GetMapping("/edit/{caseId}")
    public String edit(@PathVariable("caseId") Long caseId, ModelMap mmap)
    {
        SysCasearg sysCasearg = sysCaseargService.selectSysCaseargByCaseId(caseId);
        mmap.put("sysCasearg", sysCasearg);
        return prefix + "/edit";
    }

    /**
     * 修改保存案例列表
     */
    @RequiresPermissions("system:casearg:edit")
    @Log(title = "案例列表", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysCasearg sysCasearg)
    {
        return toAjax(sysCaseargService.updateSysCasearg(sysCasearg));
    }

    /**
     * 删除案例列表
     */
    @RequiresPermissions("system:casearg:remove")
    @Log(title = "案例列表", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysCaseargService.deleteSysCaseargByCaseIds(ids));
    }
}
