package com.utils;

import com.analysis.BpipUnitAnalysis;
import com.analysis.DocAnalysis;
import com.analysis.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jws.WebService;
import java.util.List;

@WebService(targetNamespace = "ws.utils.com")
public class WebServiceAnalysis {

    @Autowired
    private BpipUnitAnalysis bpipUnitAnalysis;

    @Autowired
    private DocAnalysis docAnalysis;

    @Autowired
    private JsjqdMapper jsjqdMapper;
    @Autowired
    private XsXz002Mapper xsXz002Mapper;
    @Autowired
    private Xs050Mapper xs050Mapper;
    @Autowired
    private Xs052Mapper xs052Mapper;
    @Autowired
    private Xs054Mapper xs054Mapper;
    @Autowired
    private Xs055Mapper xs055Mapper;
    @Autowired
    private Xs059Mapper xs059Mapper;
    @Autowired
    private Xz016Mapper xz016Mapper;
    @Autowired
    private Xz045Mapper xz045Mapper;
    @Autowired
    private ZjbqjdsMapper zjbqjdsMapper;

    @Autowired
    private CfqdMapper cfqdMapper;
    @Autowired
    private DjbcqdMapper djbcqdMapper;
    @Autowired
    private KyjdsMapper kyjdsMapper;
    @Autowired
    private KyqdMapper kyqdMapper;
    @Autowired
    private Xz0021Mapper xz0021Mapper;

    @Autowired
    private Xz0013Mapper xz0013Mapper;
    @Autowired
    private Xz0014Mapper xz0014Mapper;

    @Autowired
    private Xz0024Mapper xz0024Mapper;


    /**
     * DS服务端通过WebService调用
     * @param areaId            行政区划分的代码
     * @param startDate         hck_gxsj 开始时间
     * @param endDate           hck_gxsj 截止时间
     * @throws Exception
     */
    public void doAnalysisBpipUnit(String areaId,String startDate,String endDate) throws Exception{
        bpipUnitAnalysis.doAnalysis(areaId,startDate,endDate);
    }

    /**
     * DS服务端通过WebService调用
     * @param startDate         hck_gxsj 开始时间
     * @param endDate           hck_gxsj 截止时间
     * @throws Exception
     */
    public void doAnalysisDoc(String startDate,String endDate) throws Exception{

        List list = jsjqdMapper.selectByDate(startDate,endDate);

        if (list!=null && list.size()>0){
            docAnalysis.docAnalysis(list,"DOC_JSJQD_NEW");
        }

        list = xsXz002Mapper.selectByDate(startDate,endDate);

        if (list!=null && list.size()>0){
            docAnalysis.docAnalysis(list,"DOC_XS_XZ_002_NEW");
        }

        list = xs050Mapper.selectByDate(startDate,endDate);

        if (list!=null && list.size()>0){
            docAnalysis.docAnalysis(list,"DOC_XS050_NEW");
        }

        list = xs052Mapper.selectByDate(startDate,endDate);

        if (list!=null && list.size()>0){
            docAnalysis.docAnalysis(list,"DOC_XS052_NEW");
        }

        list = xs054Mapper.selectByDate(startDate,endDate);

        if (list!=null && list.size()>0){
            docAnalysis.docAnalysis(list,"DOC_XS054");
        }

        list = xs055Mapper.selectByDate(startDate,endDate);

        if (list!=null && list.size()>0){
            docAnalysis.docAnalysis(list,"DOC_XS055_NEW");
        }

        list = xs059Mapper.selectByDate(startDate,endDate);

        if (list!=null && list.size()>0){
            docAnalysis.docAnalysis(list,"DOC_XS059_NEW");
        }

        list = xz016Mapper.selectByDate(startDate,endDate);

        if (list!=null && list.size()>0){
            docAnalysis.docAnalysis(list,"DOC_XZ016");
        }

        list = xz045Mapper.selectByDate(startDate,endDate);

        if (list!=null && list.size()>0){
            docAnalysis.docAnalysis(list,"DOC_XZ045_NEW");
        }

        list = zjbqjdsMapper.selectByDate(startDate,endDate);

        if (list!=null && list.size()>0){
            docAnalysis.docAnalysis(list,"DOC_ZJBQJDS_NEW");
        }

        list = cfqdMapper.selectByDate(startDate,endDate);

        if (list!=null && list.size()>0){
            docAnalysis.docAnalysis(list,"DOC_CFQD_NEW");
        }

        list = djbcqdMapper.selectByDate(startDate,endDate);

        if (list!=null && list.size()>0){
            docAnalysis.docAnalysis(list,"DOC_DJBCQD_NEW");
        }

        list = kyjdsMapper.selectByDate(startDate,endDate);

        if (list!=null && list.size()>0){
            docAnalysis.docAnalysis(list,"DOC_KYJDS_NEW");
        }

        list = kyqdMapper.selectByDate(startDate,endDate);

        if (list!=null && list.size()>0){
            docAnalysis.docAnalysis(list,"DOC_KYQD_NEW");
        }

        list = xz0021Mapper.selectByDate(startDate,endDate);

        if (list!=null && list.size()>0){
            docAnalysis.docAnalysis(list,"DOC_XZ0021_NEW");
        }

        list = xz0013Mapper.selectByDate(startDate,endDate);

        if (list!=null && list.size()>0){
            docAnalysis.docAnalysis(list,"DOC_XZ0013_NEW");
        }

        list = xz0014Mapper.selectByDate(startDate,endDate);

        if (list!=null && list.size()>0){
            docAnalysis.docAnalysis(list,"DOC_XZ0014_NEW");
        }

        list = xz0024Mapper.selectByDate(startDate,endDate);

        if (list!=null && list.size()>0){
            docAnalysis.docAnalysis(list,"DOC_XZ0024_NEW");
        }
    }

}
