<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!--   -->
<!-- 页数 -->
<div class="message">
    共<i class="blue">${pagehelper.total}</i>条记录，当前显示第&nbsp;<i
        class="blue">${pagehelper.pageNum}/${pagehelper.pages}</i>&nbsp;页
</div>
<style type="text/css">

.pagination ul li{
cursor:pointer;
}

</style>



<div style="text-align:center;">
    <ul class="pagination">
        <!-- <li ><a href="#">&laquo;</a></li> -->
        <c:if test="${!pagehelper.isFirstPage}">
            <li ><a onclick="getUrl(${pagehelper.firstPage})">首页</a></li>
            <li><a onclick="getUrl(${pagehelper.prePage});">上一页</a></li>
        </c:if>
        <c:forEach items="${pagehelper.navigatepageNums}" var="navigatepageNum">

            <c:if test="${navigatepageNum==pagehelper.pageNum}">
                <li class="active"><a onclick="getUrl(${navigatepageNum})">${navigatepageNum}</a></li>
            </c:if>
            <c:if test="${navigatepageNum!=pagehelper.pageNum}">
                <li><a onclick="getUrl(${navigatepageNum})">${navigatepageNum}</a></li>
            </c:if>
        </c:forEach>
        <c:if test="${!pagehelper.isLastPage}">
            <li><a onclick="getUrl(${pagehelper.nextPage})">下一页</a></li>
            <li><a onclick="getUrl(${pagehelper.lastPage})">最后一页</a></li>
        </c:if>
        <!-- <li><a href="#">&raquo;</a></li> -->
    </ul>
</div>


<script>



function getUrl(number){
var href=window.location.href;
if(href.indexOf("?") >= 0 ) {
   if(href.indexOf("pageNo=") >= 0){
	href=href.replace("pageNo=${pagehelper.pageNum}", "pageNo="+number);
   }else{
        href=href+"&pageNo="+number;
   }
}else{
    href= href+"?pageNo="+number;
}
window.location.href=href;
}


</script>




