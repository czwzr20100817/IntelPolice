package com.service.mapper;

import com.exception.WebMessageException;
import com.model.Archive;
import com.model.bean.ArchiveBean;
import com.model.mapper.ArchiveMapper;
import com.page.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArchiveBeanMapper extends ArchiveMapper {
	//查询分页数据
	List<ArchiveBean> selectData(@Param("entity") ArchiveBean bean, @Param("pageBean") PageBean<Archive> pageBean);
	//查询分页数据量
	int selectTotal(@Param("entity") ArchiveBean bean);
	//查询分页数据
	List<ArchiveBean> selectDataEqCaseId(@Param("entity") ArchiveBean bean, @Param("pageBean") PageBean<Archive> pageBean,@Param("caseid")String caseid);
	//查询分页数据量
	int selectTotalEqCaseId(@Param("entity") ArchiveBean bean,@Param("caseid")String caseid);

	List<ArchiveBean> selectDataAllEqCaseId(@Param("caseid")String caseid);

	//查询分页数据当天是否存入
	List<ArchiveBean> selectCruDayData(@Param("entity") ArchiveBean bean, @Param("pageBean") PageBean<Archive> pageBean);

}
