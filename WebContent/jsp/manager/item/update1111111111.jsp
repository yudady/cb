<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
  <head>
  <script type="text/javascript" src='<c:url value="/js/jquery/jquery-1.8.3.min.js"/>'></script>
<%--
<script type="text/javascript" src='<c:url value="/js//jquery/jwysiwyg/jquery-1.3.2.js"/>'></script>
 --%>
<script type="text/javascript" src='<c:url value="/js//jquery/jwysiwyg/jquery.wysiwyg.js"/>'></script>
<link type="text/css" rel="stylesheet" href='<c:url value="/js/jquery/jwysiwyg/jquery.wysiwyg.css"/>'/>

    <script type="text/javascript">
      $(document).ready(function() {
    	  $('#wysiwyg').wysiwyg();
      });
    </script>
  </head>
  <body>
    <textarea name="wysiwyg" id="wysiwyg" rows="5" cols="47"></textarea>
  </body>
</html>