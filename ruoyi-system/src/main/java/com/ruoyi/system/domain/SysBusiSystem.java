package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.annotation.Excel.ColumnType;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 业务系统表 sys_busiSystem
 * 
 * @author ruoyi
 */
public class SysBusiSystem extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 业务系统序号 */
    @Excel(name = "业务系统序号", cellType = ColumnType.NUMERIC)
    private Long busiSystemId;

    /** 岗位编码 */
    @Excel(name = "业务系统编码")
    private String busiSystemCode;

    /** 岗位名称 */
    @Excel(name = "业务系统名称")
    private String busiSystemName;

    /** 岗位排序 */
    @Excel(name = "业务系统排序")
    private String busiSystemSort;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 用户是否存在此岗位标识 默认不存在 */
    private boolean flag = false;

    /** 排除编号 */
    private Long excludeId;

    public String getAncestors() {
        return ancestors;
    }

    public void setAncestors(String ancestors) {
        this.ancestors = ancestors;
    }

    /** 祖级列表 */
    private String ancestors;

    public Long getExcludeId() {
        return excludeId;
    }

    public void setExcludeId(Long excludeId) {
        this.excludeId = excludeId;
    }

    public Long getBusiSystemId() {
        return busiSystemId;
    }

    public void setBusiSystemId(Long busiSystemId) {
        this.busiSystemId = busiSystemId;
    }

    public String getBusiSystemCode() {
        return busiSystemCode;
    }

    public void setBusiSystemCode(String busiSystemCode) {
        this.busiSystemCode = busiSystemCode;
    }

    public String getBusiSystemName() {
        return busiSystemName;
    }

    public void setBusiSystemName(String busiSystemName) {
        this.busiSystemName = busiSystemName;
    }

    public String getBusiSystemSort() {
        return busiSystemSort;
    }

    public void setBusiSystemSort(String busiSystemSort) {
        this.busiSystemSort = busiSystemSort;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public boolean isFlag()
    {
        return flag;
    }

    public void setFlag(boolean flag)
    {
        this.flag = flag;
    }




    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("busiSystemId", getBusiSystemId())
            .append("busiSystemCode", getBusiSystemCode())
            .append("busiSystemName", getBusiSystemName())
            .append("busiSystemSort", getBusiSystemSort())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
                .append("ancestors", getAncestors())
            .toString();
    }
}
