package com.service;

import com.exception.WebMessageException;
import com.model.RecordQuestion;
import com.model.bean.RecordQuestionBean;
import com.page.PageBean;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类名称：RecordQuestionService 类描述：笔录问题管理接口
 */
public interface RecordQuestionService {
	//添加
    void addBean(RecordQuestionBean recordQuestionBean) throws WebMessageException;
    //修改
    void updateBean(String id, RecordQuestionBean recordQuestionBean) throws WebMessageException;
	//删除
	void deleteBean(String id) throws WebMessageException;
	void deleteRecordQuestionBean(String id) throws WebMessageException;
	/**
	 * 通过Id查询Bean
	 */
	RecordQuestionBean findRecordQuestionBeanById(String id) throws WebMessageException;
	/**
	 * 条件查询：分页条件
	 * @param pageBean
	 * @param bean
	 * @return
	 */
	void pageQuery(PageBean<RecordQuestionBean> pageBean, RecordQuestionBean bean, String typeId);

	List<RecordQuestionBean> findDataByType(String type);

	List<RecordQuestionBean> findDataAll(RecordQuestionBean bean,String typeId);
}
