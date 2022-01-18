package com.ruoyi.web.controller.system;

import java.util.*;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.EncryptionDecrypt.SHA256Util;
import com.ruoyi.common.utils.http.HttpUtils;
import com.ruoyi.system.domain.SysInterface;
import com.ruoyi.system.service.ISysInterfaceService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.SysCase;
import com.ruoyi.system.service.ISysCaseService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;


/**
 * 案例信息Controller
 *
 * @author Bryant
 * @date 2021-12-20
 */
@Controller
@RequestMapping("/system/case")
public class SysCaseController extends BaseController {
    private String prefix = "system/case";

    @Autowired
    private ISysCaseService sysCaseService;

    @Autowired
    private ISysInterfaceService sysInterfaceService;

    @RequiresPermissions("system:case:view")
    @GetMapping()
    public String testCase(@RequestParam(required = false) String caseName, ModelMap modelMap) {
        modelMap.put("caseName", caseName);
        return prefix + "/case";
    }

    /**
     * 查询案例信息列表
     */
    @RequiresPermissions("system:case:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysCase sysCase) {
        startPage();
        System.out.println(sysCase.getCaseName());
        List<SysCase> list = sysCaseService.selectSysCaseList(sysCase);
//        for (SysCase casemap:list){
//            System.out.println(casemap.getCaseId());
//        }
        return getDataTable(list);
    }

    /**
     * 导出案例信息列表
     */
    @RequiresPermissions("system:case:export")
    @Log(title = "案例信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysCase sysCase) {
        List<SysCase> list = sysCaseService.selectSysCaseList(sysCase);
        ExcelUtil<SysCase> util = new ExcelUtil<SysCase>(SysCase.class);
        return util.exportExcel(list, "案例信息数据");
    }

    /**
     * 新增案例信息
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存案例信息
     */
    @RequiresPermissions("system:case:add")
    @Log(title = "案例信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysCase sysCase) {
        return toAjax(sysCaseService.insertSysCase(sysCase));
    }

    /**
     * 修改案例信息
     */
    @RequiresPermissions("system:case:edit")
    @GetMapping("/edit/{caseId}")
    public String edit(@PathVariable("caseId") Long caseId, ModelMap mmap) {
        SysCase sysCase = sysCaseService.selectSysCaseByCaseId(caseId);
        mmap.put("sysCase", sysCase);
        return prefix + "/edit";
    }

    /**
     * 修改保存案例信息
     */
    @RequiresPermissions("system:case:edit")
    @Log(title = "案例信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysCase sysCase) {
        return toAjax(sysCaseService.updateSysCase(sysCase));
    }

    /**
     * 删除案例信息
     */
    @RequiresPermissions("system:case:remove")
    @Log(title = "案例信息", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(sysCaseService.deleteSysCaseByCaseIds(ids));
    }


    /**
     * 发送案例信息
     */
    @RequiresPermissions("system:case:sendCase")
    @GetMapping("/sendCase/{caseName}")
    public String sendCase(@PathVariable("caseName") String caseName, ModelMap modelMap) {

        List<SysCase> sysCases = sysCaseService.sendCaseByCaseName(caseName);
        Long ids = Long.valueOf(0);

        Map<String, Object> map = new HashMap<>();
        for (SysCase syscase : sysCases) {
            ids = syscase.getInterfaceId();
            map.put(syscase.getCode(), syscase.getValue());
        }
        //根据接口ID获取环境参数：
        SysInterface sysInterface = sysInterfaceService.selectSysInterfaceByInterfaceId(ids);
        //获取地址
        String interfaceEnv = sysInterface.getInterfaceEnv();
        //获取链接
        String transCode = sysInterface.getTransCode();
        //获取报文类型
        String messageType = sysInterface.getMessageType();
        //获取链接类型
        String connectType = sysInterface.getConnectType();
        //获取应答数据
        String responseData = null;
        if (connectType.equalsIgnoreCase("get")) {
            String param = null ;
            for (String key : map.keySet()){
                param = key + "=" + map.get(key) + "&";
            }
            param =param.substring(0,param.length()-1);
            responseData = HttpUtils.sendGet(interfaceEnv+transCode,param);
            System.out.println(responseData);
        } else if (connectType.equalsIgnoreCase("POST")) {
            String secret = "S5xFnUK4KXZkn04dLXaWK8dnvZWsr0pH";
            String FinSign = SHA256Util.generateSign(map,secret);
            map.put("sign", FinSign);
            JSONObject json = new JSONObject(map);
            String param = json.toString();
            System.out.println(param);
            responseData = HttpUtils.sendPost(interfaceEnv+transCode, param);
        }
        Map<String,Object> resMap = JSONObject.parseObject(responseData);
        modelMap.put("sysCases", resMap);
        return prefix + "/send_case";
    }
}
