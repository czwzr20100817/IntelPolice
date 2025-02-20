package com.conn;

import com.constant.CommonConstant;
import com.model.DataSyncTask;
import com.task.AllTask;
import com.utils.*;
import com.utils.ws.Exception_Exception;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/**
 * Created by tl on 2018/5/21 0021.
 * 文书
 */
public class DocConnection implements Runnable{
    private static Logger logger = Logger.getLogger(DocConnection.class);
    @Override
    public void run() {
        try {
            doSynchronized();
        } catch (Exception e) {
            logger.debug("出错", e);
        }
    }
    private AllTask allTask = new AllTask();
    private synchronized void doSynchronized() throws Exception{
        //源数据库
        Connection sourceConn = DbUtils.getConnection("dbDoc");
        //目标数据
        Connection targetConn =  DbUtils.getConnection("dbTarget");

        String sync_all = PropertiesUtils.getConfigForPropertiesNameAndKey(CommonConstant.SYNC_ALL,"System");
        try {
            DataSyncTask dataSyncTask = null;
            Date execDate = null;
            String dateStrat = null;
            String dateEnd = null;
            try {
                dataSyncTask = LogUtils.findDataSyncTaskBySyncvalue(CommonConstant.SYSNC_DOC, CommonConstant.DATAENDTIME_DOC);
                dateStrat = dataSyncTask.getDatestarttime();
                dateEnd = dataSyncTask.getDataendtime();

                //转换时间
                execDate = DateUtils.stringToDate( dataSyncTask.getSyncdate(), DateUtils.DEFAULT_DATE_PATTERN);
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("出错", e);
                return;
            }
            try {
                if (dataSyncTask.getSynctype().equals(CommonConstant.SYNCTYPE) && DateUtils.isBeforeNow(new Timestamp(execDate.getTime()))) {
                    Date startDate = new Date();
                    int doc_aq_001_count = 0;
                    int doc_cfqd_new_count = 0;
                    int doc_djbcqd_new_count = 0;
                    int doc_jsjqd_new_count = 0;

                    int doc_kyjds_new_count = 0;
                    int doc_kyqd_new_count = 0;
                    int doc_xs_dqzjtzs2012_new_count = 0;
                    int doc_xs_xz_002_new_count = 0;

                    int doc_xs001_new_count = 0;
                    int doc_xs003_count = 0;
                    int doc_xs047_new_count = 0;
                    int doc_xs050_new_count = 0;

                    int doc_xs052_new_count = 0;
                    int doc_xs054_count = 0;
                    int doc_xs055_new_count = 0;
                    int doc_xs059_new_count = 0;

                    int doc_xs110_count = 0;
                    int doc_xs112_count = 0;
                    int doc_xs147_count = 0;
                    int doc_xs148_count = 0;

                    int doc_xs164_count = 0;
                    int doc_xsxz001_new_count = 0;
                    int doc_xszjtzs_new_count = 0;
                    int doc_xz0013_new_count = 0;

                    int doc_xz0014_new_count = 0;
                    int doc_xz016_count = 0;
                    int doc_xz0021_new_count = 0;
                    int doc_xz0024_new_count = 0;

                    int doc_xz045_new_count = 0;
                    int doc_zjbqjds_new_count = 0;

                    //设置不自动提交
                    sourceConn.setAutoCommit(false);
                    targetConn.setAutoCommit(false);
                    String propertiesName = "configDoc";
                    logger.debug("------------------------开始备份doc_aq_001数据"+DateUtils.getCurrentDateTime()+"-------------------------");
                    doc_aq_001_count = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"doc_aq_001", propertiesName);
                    logger.debug("------------------------备份doc_aq_001结束"+DateUtils.getCurrentDateTime()+"------------------------------");

                    logger.debug("------------------------开始备份doc_cfqd_new数据"+DateUtils.getCurrentDateTime()+"-------------------------");
                    doc_cfqd_new_count = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"doc_cfqd_new", propertiesName);
                    logger.debug("------------------------备份doc_cfqd_new结束"+DateUtils.getCurrentDateTime()+"------------------------------");

                    logger.debug("------------------------开始备份doc_djbcqd_new数据"+DateUtils.getCurrentDateTime()+"-------------------------");
                    doc_djbcqd_new_count = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"doc_djbcqd_new", propertiesName);
                    logger.debug("------------------------备份doc_djbcqd_new结束"+DateUtils.getCurrentDateTime()+"------------------------------");

                    logger.debug("------------------------开始备份doc_jsjqd_new数据"+DateUtils.getCurrentDateTime()+"-------------------------");
                    doc_jsjqd_new_count = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"doc_jsjqd_new", propertiesName);
                    logger.debug("------------------------备份doc_jsjqd_new结束"+DateUtils.getCurrentDateTime()+"------------------------------");

                    //----------------------------------------------
                    logger.debug("------------------------开始备份doc_kyjds_new数据"+DateUtils.getCurrentDateTime()+"-------------------------");
                    doc_kyjds_new_count = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"doc_kyjds_new", propertiesName);
                    logger.debug("------------------------备份doc_kyjds_new结束"+DateUtils.getCurrentDateTime()+"------------------------------");

                    logger.debug("------------------------开始备份doc_kyqd_new数据"+DateUtils.getCurrentDateTime()+"-------------------------");
                    doc_kyqd_new_count = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"doc_kyqd_new", propertiesName);
                    logger.debug("------------------------备份doc_kyqd_new结束"+DateUtils.getCurrentDateTime()+"------------------------------");

                    logger.debug("------------------------开始备份doc_xs_dqzjtzs2012_new数据"+DateUtils.getCurrentDateTime()+"-------------------------");
                    doc_xs_dqzjtzs2012_new_count = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"doc_xs_dqzjtzs2012_new", propertiesName);
                    logger.debug("------------------------备份doc_xs_dqzjtzs2012_new结束"+DateUtils.getCurrentDateTime()+"------------------------------");

                    logger.debug("------------------------开始备份doc_xs_xz_002_new数据"+DateUtils.getCurrentDateTime()+"-------------------------");
                    doc_xs_xz_002_new_count = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"doc_xs_xz_002_new", propertiesName);
                    logger.debug("------------------------备份doc_xs_xz_002_new结束"+DateUtils.getCurrentDateTime()+"------------------------------");

                    //----------------------------------------------
                    logger.debug("------------------------开始备份doc_xs001_new数据"+DateUtils.getCurrentDateTime()+"-------------------------");
                    doc_xs001_new_count = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"doc_xs001_new", propertiesName);
                    logger.debug("------------------------备份doc_xs001_new结束"+DateUtils.getCurrentDateTime()+"------------------------------");

                    logger.debug("------------------------开始备份doc_xs003数据"+DateUtils.getCurrentDateTime()+"-------------------------");
                    doc_xs003_count = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"doc_xs003", propertiesName);
                    logger.debug("------------------------备份doc_xs003结束"+DateUtils.getCurrentDateTime()+"------------------------------");

                    logger.debug("------------------------开始备份doc_xs047_new数据"+DateUtils.getCurrentDateTime()+"-------------------------");
                    doc_xs047_new_count = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"doc_xs047_new", propertiesName);
                    logger.debug("------------------------备份doc_xs047_new结束"+DateUtils.getCurrentDateTime()+"------------------------------");

                    logger.debug("------------------------开始备份doc_xs050_new数据"+DateUtils.getCurrentDateTime()+"-------------------------");
                    doc_xs050_new_count = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"doc_xs050_new", propertiesName);
                    logger.debug("------------------------备份doc_xs050_new结束"+DateUtils.getCurrentDateTime()+"------------------------------");

                    //----------------------------------------------
                    logger.debug("------------------------开始备份doc_xs052_new数据"+DateUtils.getCurrentDateTime()+"-------------------------");
                    doc_xs052_new_count = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"doc_xs052_new", propertiesName);
                    logger.debug("------------------------备份doc_xs052_new结束"+DateUtils.getCurrentDateTime()+"------------------------------");

                    logger.debug("------------------------开始备份doc_xs054数据"+DateUtils.getCurrentDateTime()+"-------------------------");
                    doc_xs054_count = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"doc_xs054", propertiesName);
                    logger.debug("------------------------备份doc_xs054结束"+DateUtils.getCurrentDateTime()+"------------------------------");

                    logger.debug("------------------------开始备份doc_xs055_new数据"+DateUtils.getCurrentDateTime()+"-------------------------");
                    doc_xs055_new_count = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"doc_xs055_new", propertiesName);
                    logger.debug("------------------------备份doc_xs055_new结束"+DateUtils.getCurrentDateTime()+"------------------------------");

                    logger.debug("------------------------开始备份doc_xs059_new数据"+DateUtils.getCurrentDateTime()+"-------------------------");
                    doc_xs059_new_count = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"doc_xs059_new", propertiesName);
                    logger.debug("------------------------备份doc_xs059_new结束"+DateUtils.getCurrentDateTime()+"------------------------------");

                    //----------------------------------------------
                    logger.debug("------------------------开始备份doc_xs110数据"+DateUtils.getCurrentDateTime()+"-------------------------");
                    doc_xs110_count = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"doc_xs110", propertiesName);
                    logger.debug("------------------------备份doc_xs110结束"+DateUtils.getCurrentDateTime()+"------------------------------");

                    logger.debug("------------------------开始备份doc_xs112数据"+DateUtils.getCurrentDateTime()+"-------------------------");
                    doc_xs112_count = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"doc_xs112", propertiesName);
                    logger.debug("------------------------备份doc_xs112结束"+DateUtils.getCurrentDateTime()+"------------------------------");

                    logger.debug("------------------------开始备份doc_xs147数据"+DateUtils.getCurrentDateTime()+"-------------------------");
                    doc_xs147_count = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"doc_xs147", propertiesName);
                    logger.debug("------------------------备份doc_xs147结束"+DateUtils.getCurrentDateTime()+"------------------------------");

                    logger.debug("------------------------开始备份doc_xs148数据"+DateUtils.getCurrentDateTime()+"-------------------------");
                    doc_xs148_count = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"doc_xs148", propertiesName);
                    logger.debug("------------------------备份doc_xs148结束"+DateUtils.getCurrentDateTime()+"------------------------------");

                    //----------------------------------------------
                    logger.debug("------------------------开始备份doc_xs164数据"+DateUtils.getCurrentDateTime()+"-------------------------");
                    doc_xs164_count = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"doc_xs164", propertiesName);
                    logger.debug("------------------------备份doc_xs164结束"+DateUtils.getCurrentDateTime()+"------------------------------");

                    logger.debug("------------------------开始备份doc_xsxz001_new数据"+DateUtils.getCurrentDateTime()+"-------------------------");
                    doc_xsxz001_new_count = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"doc_xsxz001_new", propertiesName);
                    logger.debug("------------------------备份doc_xsxz001_new结束"+DateUtils.getCurrentDateTime()+"------------------------------");

                    logger.debug("------------------------开始备份doc_xszjtzs_new数据"+DateUtils.getCurrentDateTime()+"-------------------------");
                    doc_xszjtzs_new_count = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"doc_xszjtzs_new", propertiesName);
                    logger.debug("------------------------备份doc_xszjtzs_new结束"+DateUtils.getCurrentDateTime()+"------------------------------");

                    logger.debug("------------------------开始备份doc_xz0013_new数据"+DateUtils.getCurrentDateTime()+"-------------------------");
                    doc_xz0013_new_count = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"doc_xz0013_new", propertiesName);
                    logger.debug("------------------------备份doc_xz0013_new结束"+DateUtils.getCurrentDateTime()+"------------------------------");

                    //----------------------------------------------
                    logger.debug("------------------------开始备份doc_xz0014_new数据"+DateUtils.getCurrentDateTime()+"-------------------------");
                    doc_xz0014_new_count = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"doc_xz0014_new", propertiesName);
                    logger.debug("------------------------备份doc_xz0014_new结束"+DateUtils.getCurrentDateTime()+"------------------------------");

                    logger.debug("------------------------开始备份doc_xz016数据"+DateUtils.getCurrentDateTime()+"-------------------------");
                    doc_xz016_count = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"doc_xz016", propertiesName);
                    logger.debug("------------------------备份doc_xz016结束"+DateUtils.getCurrentDateTime()+"------------------------------");

                    logger.debug("------------------------开始备份doc_xz0021_new数据"+DateUtils.getCurrentDateTime()+"-------------------------");
                    doc_xz0021_new_count = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"doc_xz0021_new", propertiesName);
                    logger.debug("------------------------备份doc_xz0021_new结束"+DateUtils.getCurrentDateTime()+"------------------------------");

                    logger.debug("------------------------开始备份doc_xz0024_new数据"+DateUtils.getCurrentDateTime()+"-------------------------");
                    doc_xz0024_new_count = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"doc_xz0024_new", propertiesName);
                    logger.debug("------------------------备份doc_xz0024_new结束"+DateUtils.getCurrentDateTime()+"------------------------------");

                    logger.debug("------------------------开始备份doc_xz045_new数据"+DateUtils.getCurrentDateTime()+"-------------------------");
                    doc_xz045_new_count = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"doc_xz045_new", propertiesName);
                    logger.debug("------------------------备份doc_xz045_new结束"+DateUtils.getCurrentDateTime()+"------------------------------");

                    logger.debug("------------------------开始备份doc_zjbqjds_new数据"+DateUtils.getCurrentDateTime()+"-------------------------");
                    doc_zjbqjds_new_count = allTask.doCopyData(sourceConn, targetConn, dateStrat, dateEnd,"doc_zjbqjds_new", propertiesName);
                    logger.debug("------------------------备份doc_zjbqjds_new结束"+DateUtils.getCurrentDateTime()+"------------------------------");


                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("doc_aq_001:" + doc_aq_001_count);
                    stringBuilder.append("&#&doc_cfqd_new:" + doc_cfqd_new_count);
                    stringBuilder.append("&#&doc_djbcqd_new:" + doc_djbcqd_new_count);
                    stringBuilder.append("&#&doc_jsjqd_new:" + doc_jsjqd_new_count);

                    stringBuilder.append("&#&doc_kyjds_new:" + doc_kyjds_new_count);
                    stringBuilder.append("&#&doc_kyqd_new:" + doc_kyqd_new_count);
                    stringBuilder.append("&#&doc_xs_dqzjtzs2012_new:" + doc_xs_dqzjtzs2012_new_count);
                    stringBuilder.append("&#&doc_xs_xz_002_new:" + doc_xs_xz_002_new_count);

                    stringBuilder.append("&#&doc_xs001_new:" + doc_xs001_new_count);
                    stringBuilder.append("&#&doc_xs003:" + doc_xs003_count);
                    stringBuilder.append("&#&doc_xs047_new:" + doc_xs047_new_count);
                    stringBuilder.append("&#&doc_xs050_new:" + doc_xs050_new_count);

                    stringBuilder.append("&#&doc_xs052_new:" + doc_xs052_new_count);
                    stringBuilder.append("&#&doc_xs054:" + doc_xs054_count);
                    stringBuilder.append("&#&doc_xs055_new:" + doc_xs055_new_count);
                    stringBuilder.append("&#&doc_xs059_new:" + doc_xs059_new_count);

                    stringBuilder.append("&#&doc_xs110:" + doc_xs110_count);
                    stringBuilder.append("&#&doc_xs112:" + doc_xs112_count);
                    stringBuilder.append("&#&doc_xs147:" + doc_xs147_count);
                    stringBuilder.append("&#&doc_xs148:" + doc_xs148_count);

                    stringBuilder.append("&#&doc_xs164:" + doc_xs164_count);
                    stringBuilder.append("&#&doc_xsxz001_new:" + doc_xsxz001_new_count);
                    stringBuilder.append("&#&doc_xszjtzs_new:" + doc_xszjtzs_new_count);
                    stringBuilder.append("&#&doc_xz0013_new:" + doc_xz0013_new_count);

                    stringBuilder.append("&#&doc_xz0014_new:" + doc_xz0014_new_count);
                    stringBuilder.append("&#&doc_xz016:" + doc_xz016_count);
                    stringBuilder.append("&#&doc_xz0021_new:" + doc_xz0021_new_count);
                    stringBuilder.append("&#&doc_xz0024_new:" + doc_xz0024_new_count);

                    stringBuilder.append("&#&doc_xz045_new_count:" + doc_xz045_new_count);
                    stringBuilder.append("&#&doc_zjbqjds_new_count:" + doc_zjbqjds_new_count);

                    //记录日志
                    LogUtils.updateDataSyncLog( dataSyncTask.getId(), new Date(), doc_aq_001_count, "1", stringBuilder.toString(), startDate);
                    //生成下一次执行时间
                    LogUtils.insertDateSyncLog(
                            UUID.randomUUID().toString(),
                            LogUtils.addDate(execDate),
                            DateUtils.stringToDate(dateEnd, DateUtils.DEFAULT_DATE_PATTERN),
                            CommonConstant.SYNCTYPE,
                            "文书",
                            CommonConstant.SYSNC_DOC);
                    //提交
                    sourceConn.commit();
                    targetConn.commit();

                    if (sync_all.equals("1")){
                        dateStrat = "";
                        dateEnd = "";
                    }

                    final String dateStratS = dateStrat;
                    final String dateEndS = dateEnd;

                    Thread th = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                WebServiceUtils.getWebServiceAnalysis().doAnalysisDoc(dateStratS, dateEndS);
                            } catch (Exception_Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                    th.start();
                }

            } catch (Exception e) {
                e.printStackTrace();
                logger.error("出错", e);
                try {
                    logger.debug("sourceConn回滚");
                    sourceConn.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                try {
                    logger.debug("targetConn回滚");
                    targetConn.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }finally {
            //释放连接
            DbUtils.close(sourceConn);
            DbUtils.close(targetConn);
        }
    }
}
