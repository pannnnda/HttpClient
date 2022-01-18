package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 案例列表对象 sys_casearg
 * 
 * @author Bryant
 * @date 2021-12-21
 */
public class SysCasearg extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 接口详情ID */
    private Long caseId;

    /** 业务系统ID */
    @Excel(name = "业务系统ID")
    private String busisystemCode;

    /** 业务系统名称 */
    @Excel(name = "业务系统名称")
    private String busisystemName;

    /** 业务系统名称 */
    @Excel(name = "业务系统名称")
    private String interfaceName;

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    /** 案例名称 */
    @Excel(name = "案例名称")
    private String caseName;

    public void setCaseId(Long caseId) 
    {
        this.caseId = caseId;
    }

    public Long getCaseId() 
    {
        return caseId;
    }
    public void setBusisystemCode(String busisystemCode) 
    {
        this.busisystemCode = busisystemCode;
    }

    public String getBusisystemCode() 
    {
        return busisystemCode;
    }
    public void setBusisystemName(String busisystemName) 
    {
        this.busisystemName = busisystemName;
    }

    public String getBusisystemName() 
    {
        return busisystemName;
    }
    public void setCaseName(String caseName) 
    {
        this.caseName = caseName;
    }

    public String getCaseName() 
    {
        return caseName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("caseId", getCaseId())
            .append("busisystemCode", getBusisystemCode())
            .append("busisystemName", getBusisystemName())
            .append("caseName", getCaseName())
            .toString();
    }
}
