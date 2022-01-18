package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.TreeEntity;

/**
 * 接口树表对象 sys_interface
 * 
 * @author ruoyi
 * @date 2022-01-10
 */
public class SysInterface extends TreeEntity
{
    private static final long serialVersionUID = 1L;

    /** 接口详情ID */
    private Long interfaceId;

    /** 业务系统ID */
    @Excel(name = "业务系统ID")
    private Long busiSystemId;

    /** 业务系统名称 */
    @Excel(name = "业务系统名称")
    private String busiSystemName;

    /** 接口名称 */
    @Excel(name = "接口名称")
    private String interfaceName;

    /** 交易码 */
    @Excel(name = "交易码")
    private String transCode;

    /** 报文类型 */
    @Excel(name = "报文类型")
    private String messageType;

    /** 备注 */
    @Excel(name = "备注")
    private String status;

    /** 接口环境 */
    @Excel(name = "接口环境")
    private String interfaceEnv;

    public String getLinkType() {
        return linkType;
    }

    public void setLinkType(String linkType) {
        this.linkType = linkType;
    }

    /** 链接类型 */
    @Excel(name = "通讯类型")
    private String linkType;

    /** 链接类型 */
    @Excel(name = "链接类型")
    private String connectType;

    public void setInterfaceId(Long interfaceId) 
    {
        this.interfaceId = interfaceId;
    }

    public Long getInterfaceId() 
    {
        return interfaceId;
    }
    public void setBusiSystemId(Long busiSystemId)
    {
        this.busiSystemId = busiSystemId;
    }

    public Long getBusiSystemId()
    {
        return busiSystemId;
    }
    public void setBusiSystemName(String busiSystemName) 
    {
        this.busiSystemName = busiSystemName;
    }

    public String getBusiSystemName() 
    {
        return busiSystemName;
    }
    public void setInterfaceName(String interfaceName) 
    {
        this.interfaceName = interfaceName;
    }

    public String getInterfaceName() 
    {
        return interfaceName;
    }
    public void setTransCode(String transCode) 
    {
        this.transCode = transCode;
    }

    public String getTransCode() 
    {
        return transCode;
    }
    public void setMessageType(String messageType) 
    {
        this.messageType = messageType;
    }

    public String getMessageType() 
    {
        return messageType;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setInterfaceEnv(String interfaceEnv) 
    {
        this.interfaceEnv = interfaceEnv;
    }

    public String getInterfaceEnv() 
    {
        return interfaceEnv;
    }
    public void setConnectType(String connectType) 
    {
        this.connectType = connectType;
    }

    public String getConnectType() 
    {
        return connectType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("interfaceId", getInterfaceId())
            .append("busiSystemId", getBusiSystemId())
            .append("busiSystemName", getBusiSystemName())
            .append("interfaceName", getInterfaceName())
            .append("transCode", getTransCode())
            .append("messageType", getMessageType())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("interfaceEnv", getInterfaceEnv())
            .append("connectType", getConnectType())
            .toString();
    }
}
