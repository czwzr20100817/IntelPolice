package com.model;

import java.util.Date;

public class ArchiveStoresBox {
    private String id;

    private String archiveStoresId;

    private String code;

    private String userId;

    private String remark;

    private Date addTime;

    private Date editTime;

    private String boxUser;//使用者ID

    private String boxCode;//箱子编码


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getArchiveStoresId() {
        return archiveStoresId;
    }

    public void setArchiveStoresId(String archiveStoresId) {
        this.archiveStoresId = archiveStoresId == null ? null : archiveStoresId.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getEditTime() {
        return editTime;
    }

    public void setEditTime(Date editTime) {
        this.editTime = editTime;
    }

    public String getBoxUser() {
        return boxUser;
    }

    public void setBoxUser(String boxUser) {
        this.boxUser = boxUser;
    }

    public String getBoxCode() {
        return boxCode;
    }

    public void setBoxCode(String boxCode) {
        this.boxCode = boxCode;
    }
}