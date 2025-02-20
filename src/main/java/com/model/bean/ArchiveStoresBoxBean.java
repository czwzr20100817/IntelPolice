package com.model.bean;

import com.model.ArchiveStoresBox;

import java.util.Date;
import java.util.List;

public class ArchiveStoresBoxBean extends ArchiveStoresBox {
    private ArchiveCaseBean archiveCaseBean;//关联

    private ArchiveBean archiveBean;//卷宗信息

    private List<ArchiveCaseBean> archiveCaseBeanList;//卷宗关联信息jihe

    private CriminalBean criminalBean;

    public ArchiveCaseBean getArchiveCaseBean() {
        return archiveCaseBean;
    }

    public void setArchiveCaseBean(ArchiveCaseBean archiveCaseBean) {
        this.archiveCaseBean = archiveCaseBean;
    }

    public ArchiveBean getArchiveBean() {
        return archiveBean;
    }

    public void setArchiveBean(ArchiveBean archiveBean) {
        this.archiveBean = archiveBean;
    }

    public CriminalBean getCriminalBean() {
        return criminalBean;
    }

    public void setCriminalBean(CriminalBean criminalBean) {
        this.criminalBean = criminalBean;
    }

    public List<ArchiveCaseBean> getArchiveCaseBeanList() {
        return archiveCaseBeanList;
    }

    public void setArchiveCaseBeanList(List<ArchiveCaseBean> archiveCaseBeanList) {
        this.archiveCaseBeanList = archiveCaseBeanList;
    }
}