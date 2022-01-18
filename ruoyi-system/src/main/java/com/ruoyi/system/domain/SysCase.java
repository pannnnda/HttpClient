package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 案例信息对象 sys_case
 * 
 * @author Bryant
 * @date 2021-12-20
 */
public class SysCase extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 案例ID */
    private Long caseId;

    /** 接口ID */
    @Excel(name = "接口ID")
    private Long interfaceId;

    /** 业务系统代码 */
    @Excel(name = "业务系统代码")
    private Long busisystemCode;

    /** 字段名称 */
    @Excel(name = "字段名称")
    private String code;

    /** 字段名称 */
    @Excel(name = "字段名称")
    private String name;

    /** 字段值 */
    @Excel(name = "字段值")
    private String value;

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    /** 案例名称值 */
    @Excel(name = "字段值")
    private String caseName;

//    public SysCase(Long caseId,Long interfaceId,Long busisystemCode,String code,String name,String value,String caseName){
//        this.caseId=caseId;
//        this.interfaceId = interfaceId;
//        this.busisystemCode = busisystemCode;
//        this.code = code;
//        this.name = name;
//        this.value =value;
//        this.caseName = caseName;
//
//    }





    public void setCaseId(Long caseId) 
    {
        this.caseId = caseId;
    }

    public Long getCaseId() 
    {
        return caseId;
    }
    public void setInterfaceId(Long interfaceId) 
    {
        this.interfaceId = interfaceId;
    }

    public Long getInterfaceId() 
    {
        return interfaceId;
    }
    public void setBusisystemCode(Long busisystemCode) 
    {
        this.busisystemCode = busisystemCode;
    }

    public Long getBusisystemCode() 
    {
        return busisystemCode;
    }
    public void setCode(String code) 
    {
        this.code = code;
    }

    public String getCode() 
    {
        return code;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setValue(String value) 
    {
        this.value = value;
    }

    public String getValue() 
    {
        return value;
    }


}
