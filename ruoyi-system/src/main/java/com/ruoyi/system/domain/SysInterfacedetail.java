package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 接口详细信息对象 sys_interfacedetail
 * 
 * @author Bryant
 * @date 2021-12-30
 */
public class SysInterfacedetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 接口详情ID */
    @Excel(name = "接口详情ID")
    private Long sysInterfacedetailId;

    /** 业务系统ID */
    @Excel(name = "业务系统ID")
    private String busiSystemCode;

    /** 接口ID */
    @Excel(name = "接口ID")
    private String interfaceId;

    /** 接口名称 */
    @Excel(name = "接口名称")
    private String interfaceName;

    /** 字段代码 */
    @Excel(name = "字段代码")
    private String code;

    /** 字段名称 */
    @Excel(name = "字段名称")
    private String codeName;

    /** 字段值 */
    @Excel(name = "字段值")
    private String value;

    /** 字段顺序 */
    @Excel(name = "字段顺序")
    private String indexNo;

    public void setSysInterfacedetailId(Long sysInterfacedetailId) 
    {
        this.sysInterfacedetailId = sysInterfacedetailId;
    }

    public Long getSysInterfacedetailId() 
    {
        return sysInterfacedetailId;
    }
    public void setBusiSystemCode(String busiSystemCode) 
    {
        this.busiSystemCode = busiSystemCode;
    }

    public String getBusiSystemCode() 
    {
        return busiSystemCode;
    }
    public void setInterfaceId(String interfaceId) 
    {
        this.interfaceId = interfaceId;
    }

    public String getInterfaceId() 
    {
        return interfaceId;
    }
    public void setInterfaceName(String interfaceName) 
    {
        this.interfaceName = interfaceName;
    }

    public String getInterfaceName() 
    {
        return interfaceName;
    }
    public void setCode(String code) 
    {
        this.code = code;
    }

    public String getCode() 
    {
        return code;
    }
    public void setCodeName(String codeName) 
    {
        this.codeName = codeName;
    }

    public String getCodeName() 
    {
        return codeName;
    }
    public void setValue(String value) 
    {
        this.value = value;
    }

    public String getValue() 
    {
        return value;
    }
    public void setIndexNo(String indexNo) 
    {
        this.indexNo = indexNo;
    }

    public String getIndexNo() 
    {
        return indexNo;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("sysInterfacedetailId", getSysInterfacedetailId())
            .append("busiSystemCode", getBusiSystemCode())
            .append("interfaceId", getInterfaceId())
            .append("interfaceName", getInterfaceName())
            .append("code", getCode())
            .append("codeName", getCodeName())
            .append("value", getValue())
            .append("indexNo", getIndexNo())
            .append("remark", getRemark())
            .toString();
    }
}
