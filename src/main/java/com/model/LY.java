package com.model;

import java.util.Date;

/**
 * 录音单表
 */
public class LY {
    private String lybh;

    private String dhlx;

    private String dhhm;

    private String zxh;

    private String czybh;

    private Date lykssj;

    private Date lyjssj;

    private String jjdbh;

    private String bcdhhm;

    private String bjhm;

    private String xzqhdm;

    private Date rksjc;

    private Date gxsjc;

    private String lyfw;

    private String ssxt;

    private Date hckRksj;

    private Date hckGxsj;

    public String getLybh() {
        return lybh;
    }

    public void setLybh(String lybh) {
        this.lybh = lybh == null ? null : lybh.trim();
    }

    public String getDhlx() {
        return dhlx;
    }

    public void setDhlx(String dhlx) {
        this.dhlx = dhlx == null ? null : dhlx.trim();
    }

    public String getDhhm() {
        return dhhm;
    }

    public void setDhhm(String dhhm) {
        this.dhhm = dhhm == null ? null : dhhm.trim();
    }

    public String getZxh() {
        return zxh;
    }

    public void setZxh(String zxh) {
        this.zxh = zxh == null ? null : zxh.trim();
    }

    public String getCzybh() {
        return czybh;
    }

    public void setCzybh(String czybh) {
        this.czybh = czybh == null ? null : czybh.trim();
    }

    public Date getLykssj() {
        return lykssj;
    }

    public void setLykssj(Date lykssj) {
        this.lykssj = lykssj;
    }

    public Date getLyjssj() {
        return lyjssj;
    }

    public void setLyjssj(Date lyjssj) {
        this.lyjssj = lyjssj;
    }

    public String getJjdbh() {
        return jjdbh;
    }

    public void setJjdbh(String jjdbh) {
        this.jjdbh = jjdbh == null ? null : jjdbh.trim();
    }

    public String getBcdhhm() {
        return bcdhhm;
    }

    public void setBcdhhm(String bcdhhm) {
        this.bcdhhm = bcdhhm == null ? null : bcdhhm.trim();
    }

    public String getBjhm() {
        return bjhm;
    }

    public void setBjhm(String bjhm) {
        this.bjhm = bjhm == null ? null : bjhm.trim();
    }

    public String getXzqhdm() {
        return xzqhdm;
    }

    public void setXzqhdm(String xzqhdm) {
        this.xzqhdm = xzqhdm == null ? null : xzqhdm.trim();
    }

    public Date getRksjc() {
        return rksjc;
    }

    public void setRksjc(Date rksjc) {
        this.rksjc = rksjc;
    }

    public Date getGxsjc() {
        return gxsjc;
    }

    public void setGxsjc(Date gxsjc) {
        this.gxsjc = gxsjc;
    }

    public String getLyfw() {
        return lyfw;
    }

    public void setLyfw(String lyfw) {
        this.lyfw = lyfw == null ? null : lyfw.trim();
    }

    public String getSsxt() {
        return ssxt;
    }

    public void setSsxt(String ssxt) {
        this.ssxt = ssxt == null ? null : ssxt.trim();
    }

    public Date getHckRksj() {
        return hckRksj;
    }

    public void setHckRksj(Date hckRksj) {
        this.hckRksj = hckRksj;
    }

    public Date getHckGxsj() {
        return hckGxsj;
    }

    public void setHckGxsj(Date hckGxsj) {
        this.hckGxsj = hckGxsj;
    }
}