<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/common_prefix.jsp" %>
<div class="bjui-pageContent tableContent">
    <%@ include file="/WEB-INF/views/common/_page_left_involved.jsp" %>
    <div style="overflow:hidden;">
        <div style="overflow:hidden;">
            <fieldset style="height:100%;">
                <div id="layout-01" style="height:94%; overflow:hidden;">
                    <div class="bjui-pageHeader">
                        <form id="${searchFormId}" data-toggle="ajaxsearch"
                              action="${root}<%=Url.getUrl(Url.INVOLVED_INFOS_PAGE_SHOW)%>" method="post">
                            <div class="bjui-searchBar">
                                <input name="parentId" id="parentId" type="hidden">
                                <label for="name" class="control-label">名称：</label>
                                <input name="name" id="name" placeholder="请输入名称" style="width: 200px;"
                                       value="${searchObj.cwmc}">
                                <input name="cwflCode" id="cwflCode" type="hidden" value="${searchObj.cwflCode}">
                                <button type="button" class="showMoreSearch" data-toggle="moresearch"
                                        data-name="custom">
                                    <i class="fa fa-angle-double-down"></i>
                                </button>
                                <%-- <div class="bjui-moreSearch">
                                   <label for="media_jlsj" class="control-label" style="margin-top: 5px;margin-left: 0px;padding-left: 0px;width:80px;">记录时间：</label>
                                   <input type="text" id="media_jlsj" name="jlsj" data-rule="required"
                                          data-toggle="datepicker" placeholder="请输入到期时间" data-pattern="yyyy-MM-dd HH:mm:ss"
                                          value="<hs:datefmt value="${searchObj.jlsj}" type="dateTimeSecPattern"/>" />
                                   <label for="media_dqsj" class="control-label" style="margin-top: 5px;margin-left: 0px;padding-left: 0px;width:80px;">到期时间：</label>
                                   <input type="text" id="media_dqsj" name="dqsj" data-rule="required"
                                          data-toggle="datepicker" placeholder="请输入到期时间" data-pattern="yyyy-MM-dd HH:mm:ss"
                                          value="<hs:datefmt value="${searchObj.dqsj}" type="dateTimeSecPattern"/>" />
                                 </div>--%>
                                <button type="submit" class="btn-blue" data-icon="search" id="query_base_show">查询
                                </button>
                                <a class="btn btn-orange reset" href="javascript:;" data-toggle="reloadsearch"
                                   data-clear-query="true" data-icon="undo">清空查询</a>


                                <div class="pull-right">
                                    <a href="${root}<%=Url.getUrl(Url.INVOLVED_INFOS_ADD_SHOW)%>" class="btn btn-blue"
                                       data-toggle="dialog" data-mask="true" data-width="500" data-height="500"
                                       data-title="新增">新增</a>
                                </div>
                            </div>
                        </form>
                    </div>
                    <table class="table table-bordered table-hover table-striped table-top data_table table_center"
                           data-selected-multi="true" style="font-size:14px;">
                        <thead>
                        <tr class="line_top">
                            <th>操作</th>
                            <th>财物编码</th>
                            <th>财物名称</th>
                            <th>登记时间</th>
                            <th>财物分类</th>
                            <th>财物物主</th>
                            <th>财物是否涉案</th>
                            <th>未处理原因</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${list}" var="item">
                            <tr>
                                <td class="option">
                                    <a href="${root}<%=Url.getUrl(Url.INVOLVED_INFOS_DETAIL_SHOW)%>?id=${item.id}"
                                       class="btn btn-green" data-toggle="dialog" data-mask="true" data-width="600"
                                       data-height="500" data-confirm-msg="详情">详情</a>
                                    <a href="${root}<%=Url.getUrl(Url.INVOLVED_INFOS_UPDATE_SHOW)%>?id=${item.id}"
                                       class="btn btn-blue" data-toggle="dialog" data-mask="true" data-width="600"
                                       data-height="500" data-confirm-msg="编辑">编辑</a>
                                    <a href="${root}<%=Url.getUrl(Url.INVOLVED_INFOS_DELETE_SUBMIT)%>?id=${item.id}"
                                       class="btn btn-red" data-toggle="doajax" data-confirm-msg="确定要删除吗？">删除</a>
                                        <%--<a href="${root}<%=Url.getUrl(Url.INVOLVED_KEEP_TASK_START_SHOW)%>?involvedId=${item.id}"--%>
                                        <%--class="btn btn-orange" data-toggle="dialog" data-mask="true" data-width="600"--%>
                                        <%--data-height="500" data-confirm-msg="申请保管">申请保管</a>--%>
                                </td>
                                <td title="${item.cwbm}"><hs:out value="${item.cwbm}" length="5"/></td>
                                <td title="${item.cwmc}"><hs:out value="${item.cwmc}"/></td>
                                <td><hs:datefmt value="${item.djsj}" stringDatePatten="dateTimeFormat"/></td>
                                <td title="${item.cwflCode}"><hs:involvedType value="${item.cwflCode}"/></td>
                                <td title="${item.cwwz}"><hs:out value="${item.cwwz}"/></td>
                                <td title="${item.isSa}" align="center"><hs:out value="${item.isSa eq '0' ? '否':'是'}"/></td>
                                <td title="${item.approveState}" align="center">
                                    <c:choose>
                                        <c:when test="${item.approveState=='1'}">
                                            正在保管流程中
                                        </c:when>
                                        <c:when test="${item.disposeState=='1'}">
                                            正在处置流程中
                                        </c:when>
                                    </c:choose>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <%@ include file="/WEB-INF/views/common/_page_footer.jsp" %>
                </div>
            </fieldset>
        </div>
    </div>
</div>