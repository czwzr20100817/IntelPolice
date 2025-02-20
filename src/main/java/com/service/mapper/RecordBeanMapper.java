package com.service.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model.Record;
import com.model.bean.RecordBean;
import com.model.mapper.RecordMapper;
import com.page.PageBean;

public interface RecordBeanMapper extends RecordMapper {
	// 查询分页数据
	List<RecordBean> selectData(@Param("entity") RecordBean bean, @Param("pageBean") PageBean<Record> pageBean);

	// 查询分页数据量
	int selectTotal(@Param("entity") RecordBean bean);

	List<RecordBean> selectDataAllEqCaseId(@Param("caseid")String caseid);

}
