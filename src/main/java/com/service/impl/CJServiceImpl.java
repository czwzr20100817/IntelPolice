package com.service.impl;

import com.constant.WebExceptionConstant;
import com.exception.WebMessageException;
import com.model.CJ;
import com.model.bean.CJBean;
import com.page.PageBean;
import com.service.CJService;
import com.service.mapper.CJBeanMapper;
import com.utils.ServiceUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名称：CJServiceImpl 类描述：接警单操作业务逻辑接口实现
 */
@Service("cjService") // 声明是业务层的组件
// @Transactional//对类中所有方法采用默认的事务管理
public class CJServiceImpl implements CJService {
    @Autowired
    private CJBeanMapper cjBeanMapper;

    @Override
    public void addBean(CJBean cjBean) throws WebMessageException {
        if (cjBean == null) {
            throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
        }
        // 添加主键值,, 临时使用uuid,截取20 位
        cjBean.setCjdbh(ServiceUtils.generatePrimaryKey());
        // 校验Bean
        validateBean(cjBean);
        CJ cj = new CJ();
        // 复制Bean 到model
        try {
            ServiceUtils.copyProperties(cj, cjBean);
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
        }
        cjBeanMapper.insertSelective(cjBean);
    }

    @Override
    public void updateBean(String cjdbh, CJBean cjBean) throws WebMessageException {
        if (cjBean == null) {
            throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
        }
        //校验bean
        validateBean(cjBean);
        CJ cj = new CJ();
        try {
            ServiceUtils.copyProperties(cj, cjBean);
        } catch (Exception e) {
            throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
        }
        cjBeanMapper.updateByPrimaryKeySelective(cj);
    }

    @Override
    public void deleteBean(String cjdbh) throws WebMessageException {
        if (StringUtils.isEmpty(cjdbh)) {
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
        cjBeanMapper.deleteByPrimaryKey(cjdbh);
    }

    @Override
    public CJBean findCJByCjdbh(String cjdbh) throws WebMessageException {
        if (StringUtils.isEmpty(cjdbh)) {
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
        //查询对象
        CJBean cjBean = cjBeanMapper.selectCJEqCjdbh(cjdbh);
        if (cjBean != null) {
            return cjBean;
        }
        return null;
    }

    @Override
    public void pageQuery(PageBean<CJ> pageBean, CJBean bean) {
        int total = cjBeanMapper.selectTotal(bean);
        List<CJBean> cjBeanList = new ArrayList<CJBean>();
        if (total > 0) {
            cjBeanList = cjBeanMapper.selectData(bean, pageBean);
        }
        pageBean.setTotal(total);
        pageBean.setRows(cjBeanList);
    }

    @Override
    public void pageQueryByTimeout(PageBean<CJ> pageBean, CJBean bean) {
        try {
            int total = cjBeanMapper.selectTimeoutTotal(bean);
            List<CJBean> cjBeanList = new ArrayList<CJBean>();
            if (total > 0) {
                cjBeanList = cjBeanMapper.selectTimeoutData(bean, pageBean);
            }
            pageBean.setTotal(total);
            pageBean.setRows(cjBeanList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public CJBean findCJAndJJById(String cjdbh) throws WebMessageException {
        if (StringUtils.isEmpty(cjdbh)) {
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
        //查询对象
        CJBean cjBean = cjBeanMapper.selectCJEqCjdbh(cjdbh);
        if (cjBean != null) {
            return cjBean;
        }
        return null;
    }

    @Override
    public void pageQueryFeedbacks(PageBean<CJ> pageBean, CJBean bean) {
        try {
            int total = cjBeanMapper.selectFeedbacksTotal(bean);
            List<CJBean> cjBeanList = new ArrayList<CJBean>();
            if (total > 0) {
                cjBeanList = cjBeanMapper.selectFeedbacksData(bean, pageBean);
            }
            pageBean.setTotal(total);
            pageBean.setRows(cjBeanList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void pageQueryCsWla(PageBean<CJ> pageBean, CJBean bean) {
        try {
            int total = cjBeanMapper.selectTimeoutWlaTotal(bean);
            List<CJBean> cjBeanList = new ArrayList<CJBean>();
            if (total > 0) {
                cjBeanList = cjBeanMapper.selectTimeoutWlaData(bean, pageBean);
            }
            pageBean.setTotal(total);
            pageBean.setRows(cjBeanList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void pageQueryCsLa(PageBean<CJ> pageBean, CJBean bean) {
        try {
            int total = cjBeanMapper.selectTimeoutLaTotal(bean);
            List<CJBean> cjBeanList = new ArrayList<CJBean>();
            if (total > 0) {
                cjBeanList = cjBeanMapper.selectTimeoutLaData(bean, pageBean);
            }
            pageBean.setTotal(total);
            pageBean.setRows(cjBeanList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public CJBean findCJByJjdbh(String jjdbh) throws WebMessageException {
        if (StringUtils.isEmpty(jjdbh)) {
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
        //查询对象
        CJBean cjBean = cjBeanMapper.selectCJEqjjdbh(jjdbh);
        if (cjBean != null) {
            return cjBean;
        }
        return null;
    }

    @Override
    public void pageQueryNotView(PageBean<CJ> pageBean, CJ bean) {

        int total = cjBeanMapper.selectNotViewTotal();
        List<CJ> list = cjBeanMapper.selectNotView(pageBean, bean);
        pageBean.setTotal(total);
        pageBean.setRows(list);
    }

    @Override
    public void pageQueryCorrelateView(PageBean<CJ> pageBean, CJ bean) {

        int total = cjBeanMapper.selectCorrelateViewTotal();
        List<CJ> list = cjBeanMapper.selectCorrelateView(pageBean, bean);

        pageBean.setTotal(total);
        pageBean.setRows(list);

    }

    /**
     * 校验  bean 对象
     *
     * @param bean
     * @throws Exception 校验异常
     */
    private void validateBean(CJBean bean) throws WebMessageException {
        if (StringUtils.isEmpty(bean.getCjdbh())) {
            throw new WebMessageException(WebExceptionConstant.CJ_CJDBH_IS_NONE);
        }
    }
}