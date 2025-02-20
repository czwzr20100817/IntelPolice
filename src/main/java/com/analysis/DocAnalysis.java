package com.analysis;

import com.analysis.mapper.InvolvedTempMapper;
import com.analysis.model.InvolvedTemp;
import com.sun.org.apache.bcel.internal.generic.I2F;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Service
public class DocAnalysis {

    @Autowired
    private InvolvedTempMapper involvedTempMapper;
    private Document document;


    /**
     * 获取配置文件的文本文本对象
     */
    {
        try {
            document = new SAXReader().read(this.getClass().getClassLoader().getResourceAsStream("doc.xml"));
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    /**
     * 1.取得文书对象集合
     * 2.遍历文书对象集合
     * 3.通过文书编号 docid 判断是否已解析且持久化,若已持久化则删除所有包含此 docid 的 InvolvedTemp
     * 4.通过文书对象的 getInvolvedTemps 获得解析完的 InvolvedTemp 对象集合
     * 5.遍历 InvolvedTemp 对象集合
     * 6.持久化 InvolvedTemp 对象
     * @param beans     文书对象集合
     * @param <T>
     */
    @Transactional
    public <T> void docAnalysis(List<T> beans,String tableName){
        List<InvolvedTemp> involvedTemps = new ArrayList<>();
        Method method = null;
        List<String> docIds = new ArrayList<>();
        try {

            //遍历文书对象,获取docId集合
            for (T bean:beans) {
                method = bean.getClass().getMethod("getDocid",null);
                docIds.add(method.invoke(bean,null).toString());
            }

            //判断是否超过999行,若超过则分段执行
            if (docIds.size()>999){
                int runTimes = docIds.size()/999+1;
                for (int i = 0; i < runTimes; i++) {
                    if (i==runTimes-1){
                        docIds = docIds.subList(i*999,docIds.size());
                    }else {
                        docIds = docIds.subList(i*999,(i+1)*999);
                    }
                    if (docIds.size()>0){
                        involvedTempMapper.deleteByObjids(docIds);
                    }
                }
            }else if (docIds.size()>0){
                involvedTempMapper.deleteByObjids(docIds);
            }

            //遍历文书对象,解析文书
            for (T bean:beans) {
                List<InvolvedTemp> list = this.getInvolvedTemps(bean,tableName);
                involvedTemps.addAll(list);
            }
            //持久化InvolvedTemp对象
            for (InvolvedTemp involvedTemp:involvedTemps) {
                involvedTempMapper.insertSelective(involvedTemp);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     *
     * @param object
     * @param tableName
     * @return
     * @throws Exception
     */
    public  InvolvedTemp getBaseInvolvedTemp(Object object,String tableName) throws Exception{
        InvolvedTemp involvedTemp = new InvolvedTemp();
        involvedTemp.setId(UUID.randomUUID().toString());

        Element doc = (Element) document.selectSingleNode("//docs/doc[@table='"+ tableName +"']");

        for (Iterator it = doc.elementIterator(); it.hasNext();) {

            Element element = (Element) it.next();
            Attribute involvedColumnAttr = element.attribute("involvedColumn");
            Attribute docColumnAttr = element.attribute("docColumn");
            Attribute typeAttr = element.attribute("type");


            String involvedColumn = null;
            String docColumn =null;
            Object objAttr=null;
            String type = null;
            Class clazz  =null;

            if (typeAttr!=null){
                type = typeAttr.getValue();
                clazz = Class.forName(type);
            }


            if (docColumnAttr != null){
                docColumn = docColumnAttr.getValue();
                objAttr = clazz.cast(object.getClass().getMethod("get"+docColumn).invoke(object));
            }else {
                objAttr = element.attribute("value").getValue();
            }

            if (involvedColumnAttr != null){
                involvedColumn = involvedColumnAttr.getValue();
                involvedTemp.getClass().getMethod("set"+involvedColumn,clazz).invoke(involvedTemp,objAttr);

            }

        }

        involvedTemp.setIsdelete("0");
        involvedTemp.setIssave("0");
        involvedTemp.setIssync("0");
        return involvedTemp;
    }


    /**
     * 解析文书
     * 根据18张数据表,整理为三种规则
     *
     * 规则一:A1-A5(编号),A6-A10(名称),...,A21-A25(备注)
     * 规则二:A1_1(编号),A1_1(名称),...,A1_5(备注)
     *       A2_1(编号),A2_2(名称),...,A2_5(备注)
     * 规则三:A1(编号),A2(名称),...,A5(备注)
     *       A6(编号),A7(名称),...,A10(备注)
     * 规则四:与规则三相似每段会跳过一个数字,不连续
     *
     *
     * @param object            文书对象
     * @param tableName         表名
     * @return
     * @throws Exception
     */
    public List<InvolvedTemp> getInvolvedTemps(Object object,String tableName) throws Exception{

        XmlAttr xmlAttr = this.parseXml(tableName);

        //读取配置文件,根据表名判断规则
        //更据不同规则调用不同的方法
        if (xmlAttr.getRule().equals("one")){
            return this.getInvolvedTempsByOne(object,tableName,xmlAttr);
        }else if(xmlAttr.getRule().equals("two")){
            return this.getInvolvedTempsByTwo(object,tableName,xmlAttr);
        }else if(xmlAttr.getRule().equals("three")){
            return this.getInvolvedTempsByThree(object,tableName,xmlAttr);
        }else if(xmlAttr.getRule().equals("four")){
            return this.getInvolvedTempsByFour(object,tableName,xmlAttr);
        }

        return null;
    }


    /**
     * 封装配置文件
     * @param tableName     表名
     * @return
     */
    private XmlAttr parseXml(String tableName){

        XmlAttr xmlAttr = new XmlAttr();
        Element doc = (Element) document.selectSingleNode("//docs/doc[@table='"+ tableName +"']");

        //规则:one,two,three,four
        Attribute ruleAttr = doc.attribute("rule");
        //每个文书对象最多包含多少个财物
        Attribute objNumsAttr = doc.attribute("objNums");
        //字段名开始的数据,规则二无效
        //如A1-A5(编号),A6-A10(名称),...,A21-A25(备注),startNum = 1
        //如A6-A10(编号),A11-A15(名称),...,A26-A30(备注),startNum = 6
        Attribute startNumsAttr = doc.attribute("startNum");
        //文书财物属性对应的InvolvedTemp属性
        Attribute involvedcolsAttr = doc.attribute("involvedcols");
        //字段名开头的字母
        Attribute prefixsAttr =  doc.attribute("prefix");
        //文书对象中,每个财物的属性数量
        Attribute attrNumsAttr =  doc.attribute("attrNums");
        //针对规则二
        //规则二:A1_1(编号),A1_1(名称),...,A1_5(备注)
        //      A2_1(编号),A2_2(名称),...,A2_5(备注)
        //prefixStartNums = 1
        //suffixStartNums = 1
        Attribute prefixStartNumsAttr =  doc.attribute("prefixStartNums");
        Attribute suffixStartNumsAttr =  doc.attribute("suffixStartNums");

        if (ruleAttr!=null){
            xmlAttr.setRule(ruleAttr.getValue());
        }

        if (objNumsAttr!=null){

            String[] objNumsStr = objNumsAttr.getValue().split(",");
            int[] objNums = new int[objNumsStr.length];
            for (int i = 0; i < objNumsStr.length; i++) {
                objNums[i] = Integer.parseInt(objNumsStr[i]);
            }
            xmlAttr.setObjNums(objNums);
        }

        if (startNumsAttr!=null){

            String[] startNumsStr = startNumsAttr.getValue().split(",");
            int[] startNums = new int[startNumsStr.length];
            for (int i = 0; i < startNumsStr.length; i++) {
                startNums[i] = Integer.parseInt(startNumsStr[i]);
            }
            xmlAttr.setStartNums(startNums);
        }

        if (involvedcolsAttr!=null){

            String[] involvedcols = involvedcolsAttr.getValue().split(",");
            xmlAttr.setInvolvedcols(involvedcols);
        }

        if (prefixsAttr!=null){
            String[] prefixs = prefixsAttr.getValue().split(",");
            xmlAttr.setPrefixs(prefixs);
        }

        if (attrNumsAttr!=null){
            int attrNums = Integer.parseInt(attrNumsAttr.getValue());
            xmlAttr.setAttrNums(attrNums);
        }

        if (prefixStartNumsAttr!=null){

            String[] prefixStartNumsStr = prefixStartNumsAttr.getValue().split(",");
            int[] prefixStartNums = new int[prefixStartNumsStr.length];
            for (int i = 0; i < prefixStartNumsStr.length; i++) {
                prefixStartNums[i] = Integer.parseInt(prefixStartNumsStr[i]);
            }
            xmlAttr.setPrefixStartNums(prefixStartNums);
        }

        if (suffixStartNumsAttr!=null){

            String[] suffixStartNumsStr = suffixStartNumsAttr.getValue().split(",");
            int[] suffixStartNums = new int[suffixStartNumsStr.length];
            for (int i = 0; i < suffixStartNumsStr.length; i++) {
                suffixStartNums[i] = Integer.parseInt(suffixStartNumsStr[i]);
            }
            xmlAttr.setSuffixStartNums(suffixStartNums);
        }

       return xmlAttr;
    }


    /**
     * 规则一:A1-A5(编号),A6-A10(名称),...,A21-A25(备注)
     * @param object        文书对象
     * @param tableName     表名
     * @param xmlAttr       配置文件对象
     * @return
     * @throws Exception
     */
    private List<InvolvedTemp>  getInvolvedTempsByOne(Object object,String tableName,XmlAttr xmlAttr) throws Exception{
        List<InvolvedTemp> involveds = new ArrayList<>();
        for (int i = 0; i < xmlAttr.getStartNums().length; i++) {
            int startNum = xmlAttr.getStartNums()[i];
            int objNum = xmlAttr.getObjNums()[i];
            String[] involvedcols = xmlAttr.getInvolvedcols();
            String prefix = xmlAttr.getPrefixs()[i];
            int attrNums = xmlAttr.getAttrNums();

            for (int j = startNum; j < objNum+startNum; j++) {
                InvolvedTemp involvedTemp = this.getBaseInvolvedTemp(object,tableName);
                int tmp=1;
                for (int k = 1; k < attrNums; k++) {
                    tmp=j+k*objNum;

                    Object param = object.getClass().getMethod("get"+prefix+tmp).invoke(object);
                    if(k==1 && param==null){
                        break;
                    }
                    involvedTemp.getClass().getMethod("set"+involvedcols[k-1],String.class).invoke(involvedTemp,param);
                }
                if (involvedTemp.getObjectname()!=null){
                    involveds.add(involvedTemp);
                }
            }

        }
        return involveds;
    }

    /**
     * 规则二:A1_1(编号),A1_1(名称),...,A1_5(备注)
     *       A2_1(编号),A2_2(名称),...,A2_5(备注)
     * @param object        文书对象
     * @param tableName     表名
     * @param xmlAttr       配置文件对象
     * @return
     * @throws Exception
     */
    private List<InvolvedTemp>  getInvolvedTempsByTwo(Object object,String tableName,XmlAttr xmlAttr) throws Exception{
        List<InvolvedTemp> involveds = new ArrayList<>();

        for (int i = 0; i < xmlAttr.getPrefixStartNums().length; i++) {
            int objNum = xmlAttr.getObjNums()[i];
            String[] involvedcols = xmlAttr.getInvolvedcols();
            String prefix = xmlAttr.getPrefixs()[i];
            int attrNums = xmlAttr.getAttrNums();
            int prefixStartNum = xmlAttr.getPrefixStartNums()[i];
            int suffixStartNum = xmlAttr.getSuffixStartNums()[i];

            for (int j = suffixStartNum; j < objNum+suffixStartNum; j++) {
                InvolvedTemp involvedTemp = this.getBaseInvolvedTemp(object,tableName);
                int tmp=0;
                for (int k = prefixStartNum+1; k < prefixStartNum+attrNums; k++) {
                    Object param = object.getClass().getMethod("get"+prefix+k+""+j).invoke(object);
                    if(k==prefixStartNum+1 && param==null){
                        break;
                    }
                    involvedTemp.getClass().getMethod("set"+involvedcols[tmp++],String.class).invoke(involvedTemp,param);
                }
                if (involvedTemp.getObjectname()!=null){
                    involveds.add(involvedTemp);
                }
            }

        }
        return involveds;
    }

    /**
     * 规则三:A1(编号),A2(名称),...,A5(备注)
     *      A6(编号),A7(名称),...,A10(备注)
     * @param object        文书对象
     * @param tableName     表名
     * @param xmlAttr       配置文件对象
     * @return
     * @throws Exception
     */
    private List<InvolvedTemp>  getInvolvedTempsByThree(Object object,String tableName,XmlAttr xmlAttr) throws Exception{
        List<InvolvedTemp> involveds = new ArrayList<>();
        for (int i = 0; i < xmlAttr.getStartNums().length; i++) {
            int startNum = xmlAttr.getStartNums()[i];
            int objNum = xmlAttr.getObjNums()[i];
            String[] involvedcols = xmlAttr.getInvolvedcols();
            String prefix = xmlAttr.getPrefixs()[i];
            int attrNums = xmlAttr.getAttrNums();

            int tmp=1;  //计数器
            InvolvedTemp involvedTemp = this.getBaseInvolvedTemp(object,tableName);
            for (int j = startNum; j < objNum*attrNums+startNum; j++) {
                Object param = null;

                try {
                    param = object.getClass().getMethod("get"+prefix+(j+1)).invoke(object);
                    involvedTemp.getClass().getMethod("set"+involvedcols[tmp-1],String.class).invoke(involvedTemp,param);
                }catch (NoSuchMethodException e){
                    if (e.toString().contains("get"+prefix+(j+1))){
                        System.out.println(tableName + " 表缺少"+prefix+(j+1) +"字段");
                    }
                }

                tmp++;
                if (tmp==attrNums){
                    if (involvedTemp.getObjectname()!=null){
                        involveds.add(involvedTemp);
                    }
                    tmp=1;
                    j++;
                    involvedTemp = this.getBaseInvolvedTemp(object,tableName);
                }
            }

        }
        return involveds;
    }

    /**
     * 规则四:与规则三相似每段会跳过一个数字,不连续
     * @param object        文书对象
     * @param tableName     表名
     * @param xmlAttr       配置文件对象
     * @return
     * @throws Exception
     */
    private List<InvolvedTemp>  getInvolvedTempsByFour(Object object,String tableName,XmlAttr xmlAttr) throws Exception{
        List<InvolvedTemp> involveds = new ArrayList<>();
        for (int i = 0; i < xmlAttr.getStartNums().length; i++) {
            int startNum = xmlAttr.getStartNums()[i];   //开始的数字A1则为1,B16_1则为16
            int objNum = xmlAttr.getObjNums()[i];       //每段包含的InvolvedTemp对象数量
            String[] involvedcols = xmlAttr.getInvolvedcols();  //需要解析写入的InvolvedTemp属性名
            String prefix = xmlAttr.getPrefixs()[i];    //字段名开头A1则为A,B_16则为B
            int attrNums = xmlAttr.getAttrNums();       //每段包含的InvolvedTemp属性数量

            int tmp=1;  //计数器
            InvolvedTemp involvedTemp = this.getBaseInvolvedTemp(object,tableName);
            for (int j = startNum; j < objNum*attrNums+startNum; j++) {
                Object param = object.getClass().getMethod("get"+prefix+(j+1)).invoke(object);
                involvedTemp.getClass().getMethod("set"+involvedcols[tmp-1],String.class).invoke(involvedTemp,param);
                tmp++;
                if (tmp==attrNums){
                    if (involvedTemp.getObjectname()!=null){
                        involveds.add(involvedTemp);
                    }
                    tmp=1;
                    j=j+2;
                    involvedTemp = this.getBaseInvolvedTemp(object,tableName);
                }
            }

        }
        return involveds;
    }

}
