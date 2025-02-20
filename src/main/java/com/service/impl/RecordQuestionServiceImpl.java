package com.service.impl;

import com.constant.WebExceptionConstant;
import com.exception.WebMessageException;
import com.model.RecordQuestion;
import com.model.bean.RecordQuestionBean;
import com.page.PageBean;
import com.service.RecordQuestionService;
import com.service.mapper.RecordQuestionBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;
import com.utils.ServiceUtils;

import java.util.ArrayList;
import java.util.List;
@Service("recordQuestionService") // 声明是业务层的组件
public class RecordQuestionServiceImpl implements RecordQuestionService {
    @Autowired
    private RecordQuestionBeanMapper recordQuestionBeanMapper;

    @Override
    public void addBean(RecordQuestionBean recordQuestionBean) throws WebMessageException {
        if (recordQuestionBean == null) {
            throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
        }
        // 添加主键值,, 临时使用uuid,截取20 位
        recordQuestionBean.setId(ServiceUtils.generatePrimaryKey());
        // 校验Bean
        validateBean(recordQuestionBean);
        RecordQuestion recordQuestion = new RecordQuestion();
        // 复制Bean 到model
        try {
            ServiceUtils.copyProperties(recordQuestion, recordQuestionBean);
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
        }
        try{
            recordQuestionBeanMapper.insertSelective(recordQuestionBean);
        }catch (Exception e){e.printStackTrace();}
    }

    @Override
    public void updateBean(String id, RecordQuestionBean recordQuestionBean) throws WebMessageException {
        if (recordQuestionBean == null) {
            throw new WebMessageException(WebExceptionConstant.OBJ_NONE);
        }
        // 校验bean
        validateBean(recordQuestionBean);
        RecordQuestion recordQuestion = new RecordQuestion();
        try {
            ServiceUtils.copyProperties(recordQuestion, recordQuestionBean);
        } catch (Exception e) {
            throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
        }
        recordQuestionBeanMapper.updateByPrimaryKeySelective(recordQuestion);
    }

    @Override
    public void deleteBean(String id) throws WebMessageException {
        if (StringUtils.isEmpty(id)) {
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
        recordQuestionBeanMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteRecordQuestionBean(String id) throws WebMessageException {
        if (StringUtils.isEmpty(id)) {
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
        recordQuestionBeanMapper.deleteByPrimaryKey(id);
    }

    @Override
    public RecordQuestionBean findRecordQuestionBeanById(String id) throws WebMessageException {
        if (StringUtils.isEmpty(id)) {
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
        // 查询对象
        RecordQuestion recordQuestion = recordQuestionBeanMapper.selectByPrimaryKey(id);
        if (recordQuestion != null) {
            RecordQuestionBean recordQuestionBean = new RecordQuestionBean();
            try {
                ServiceUtils.copyProperties(recordQuestionBean, recordQuestion);
            } catch (Exception e) {
                throw new WebMessageException(WebExceptionConstant.PARAMES_COPY_ERROR);
            }
            return recordQuestionBean;
        }
        return null;
    }

    @Override
    public void pageQuery(PageBean<RecordQuestionBean> pageBean, RecordQuestionBean bean, String typeId) {
        int total = 0;
        try{
            total = recordQuestionBeanMapper.selectTotal(bean, typeId);
        }catch (Exception e){
            e.printStackTrace();
        }

        List<RecordQuestionBean> recordQuestionBeanList = new ArrayList<RecordQuestionBean>();
        if (total > 0) {
            try{
                recordQuestionBeanList = recordQuestionBeanMapper.selectData(bean, pageBean, typeId);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        pageBean.setTotal(total);
        pageBean.setRows(recordQuestionBeanList);
    }

    @Override
    public List<RecordQuestionBean> findDataByType(String type) {
        return recordQuestionBeanMapper.selectDataByType(type);
    }

    @Override
    public List<RecordQuestionBean> findDataAll(RecordQuestionBean bean, String typeId) {
        return recordQuestionBeanMapper.selectDataAll(bean,typeId );
    }

    /**
     * 校验 bean 对象
     *
     * @param bean
     * @throws Exception
     *             校验异常
     */
    private void validateBean(RecordQuestionBean bean) throws WebMessageException {
        if (StringUtils.isEmpty(bean.getId())) {
            throw new WebMessageException(WebExceptionConstant.ID_IS_NONE);
        }
    }
}
