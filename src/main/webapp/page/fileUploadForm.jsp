<%@ page isELIgnored="false" %>
<%@page import="org.springframework.web.servlet.support.RequestContextUtils"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container p-y-1">
  <div class="row m-b-1">
    <div class="col-sm-6 offset-sm-3">
      <form action="fileUploadController-singleFileUpload" method="post" enctype="multipart/form-data">
      <button type="button" class="btn btn-primary btn-block" onclick="document.getElementById('inputFile').click()">Add Image</button>
      <div class="form-group inputDnD">
        <label class="sr-only" for="inputFile">File Upload</label>
        <input type="file" class="form-control-file text-primary font-weight-bold" id="inputFile" name="file" accept="image/*" onchange="readUrl(this)" data-title="Drag and drop a file">
      	<button type="submit">Upload</button>
      </div>
      </form>
    </div>
  </div>
</div>
