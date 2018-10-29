<%@ page isELIgnored="false" %>
<%@page import="org.springframework.web.servlet.support.RequestContextUtils"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<script type="text/javascript">
$(document).ready(function() {
	var table = $('#example').DataTable({
		"ordering": false
		
	});
    
	/*  $('#example tbody').on( 'click', 'tr', function () {
	    alert(table.row(this).data()[5]);
	   
	} ); */ 

	 $('#example tbody').on( 'click', 'td', function () {
	    var cell = table.cell( this ).node();
	    //cell.data( 'Test' ).draw();
	    
	    alert($(cell).prev().html('Test'));
	    
	    // note - call draw() to update the table's draw state with the new data
	} ); 
	
	var table = $('#example').DataTable();
	
    $('#example-select-all').on('click', function(){
        // Check/uncheck all checkboxes in the table
        var rows = table.rows({ 'search': 'applied' }).nodes();
        
        //alert($(this).parent().parent().parent().next().children().length);
        $('input[type="checkbox"]', $(this).parent().parent().parent().next()).prop('checked', this.checked);
        
        //$('input[type="checkbox"]', rows).prop('checked', this.checked);
     });
    
    $('.form_datetime').datetimepicker({
        weekStart: 1,
        autoclose: true,
        todayHighlight: true
    });
    $('.form_datetime').datetimepicker("setDate", new Date());
    
} );

var loginModal;

function openDialogue(){
	//alert($("#dateTimeStr").val());
	
	$("#timeStr").html($("#dateTimeStr").val());
	
	loginModal = $("#ex1").modal({
		  //escapeClose: false,
		  //clickClose: false,
		  //showClose: false
		});
	
}

function closeDialogue(){
	loginModal.modal('close');
	
}

</script>

<!-- Modal HTML embedded directly into document -->
	<div id="ex1" class="modal">
  	<form action="" id="ex2">
  <h3>Please login to continue</h3>
  <p><label>Time: </label><span id="timeStr"></span></p>
  <p><label>Username:</label><input type="text" /></p>
  <p><label>Password:</label><input type="password" /></p>
  <p><input type="submit" value="Login" />&nbsp;<input type="button" value="Close" onclick="javascript:closeDialogue();" /></p>
  <%-- <a href="#" rel="modal:close"><input type="button" value="Close" /></a> --%>
</form>
	</div>

		<div class="content">
<form action="">

            <h3>
                <span class="heading">
                    Create Event
                </span>
            </h3>
            <hr>
            <div class="row">
                <div class="col-lg-12">
                    <div class="block1">
                    
                        <div class="container-fluid">
                        
                        <div class="row">
  	<div class="col-3"><input type="text" id="text1" /></div>
  <div class="col-3">
  
	<!-- Link to open the modal -->
	<p><a href="javascript:openDialogue()" >Open Modal</a></p>
  
  </div>
  <div class="col-3">
                <div class="form-group">
                    <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy hh:ii">
                    	<input type="text" id="dateTimeStr" class="form-control"  />
                        <%-- <form:input path="searchDateTime" id="searchDateTime" cssClass="form-control" readonly="true"/> --%>
                        <span class="input-group-addon">
                            <i class="glyphicon-th far fa-calendar-alt" style="vertical-align:middle;font-size:230%;"></i>
                        </span>
                    </div>
                </div>
            </div>
  <div class="col-3"><input class="btn btn-primary" name="Search" type="button" value="Submit" onClick="doSubmit()"/></div>
                 
                
  
</div>
                        <br/>
						<table id="example" class="table table-striped table-bordered" style="width:100%">
        <thead>
            <tr>
            	<th><input name="select_all" value="1" id="example-select-all" type="checkbox" /></th>
                <th>Event Name</th>
                <th>Sport name</th>
                <th>location</th>
                <th>type Sport</th>
                <th>Start date</th>
                <th>End date</th>
                
                <th></th>
            </tr>
        </thead>
        <tbody>
            <tr>
            	<td><input type="checkbox" name="id[]" value="1"  /></td>
                <td>เล่นแบตกันเถอะ</td>
                <td>BADMINTON</td>
                <td>KMUTT</td>
                <td>2VS2</td>
                <td>2011/04/25</td>
                <td>2011/04/25</td>
            </tr>
             <tr>
            	<td><input type="checkbox" name="id[]" value="1"  /></td>
                <td>BasKetball kmutt</td>
                <td>BASKETBALL</td>
                <td>KMUTT</td>
                <td>5VS5</td>
                <td>2011/04/25</td>
                <td>2011/04/25</td>
            </tr>
            <tr>
            	<td><input type="checkbox" name="id[]" value="1"  /></td>
                <td>BasKetball kmutt</td>
                <td>BASKETBALL</td>
                <td>KMUTT</td>
                <td>5VS5</td>
                <td>2011/04/25</td>
                <td>2011/04/25</td>
            </tr>
            <tr>
            	<td><input type="checkbox" name="id[]" value="1"  /></td>
                <td>BasKetball kmutt</td>
                <td>BASKETBALL</td>
                <td>KMUTT</td>
                <td>5VS5</td>
                <td>2011/04/25</td>
                <td>2011/04/25</td>
            </tr>
             <tr>
            	<td><input type="checkbox" name="id[]" value="1"  /></td>
                <td>Tennis 2-2 </td>
                <td>TENNIS</td>
                <td>KMUTT</td>
                <td>2VS2</td>
                <td>2011/04/25</td>
                <td>2011/04/25</td>
            </tr>
              <tr>
            	<td><input type="checkbox" name="id[]" value="1"  /></td>
                <td>Tennis 2-2 </td>
                <td>TENNIS</td>
                <td>KMUTT</td>
                <td>2VS2</td>
                <td>2011/04/25</td>
                <td>2011/04/25</td>
            </tr>
             <tr>
            	<td><input type="checkbox" name="id[]" value="1"  /></td>
                <td>เล่นแบตกันเถอะ</td>
                <td>BADMINTON</td>
                <td>KMUTT</td>
                <td>2VS2</td>
                <td>2011/04/25</td>
                <td>2011/04/25</td>
            </tr>
             <tr>
            	<td><input type="checkbox" name="id[]" value="1"  /></td>
                <td>เล่นแบตกันเถอะ</td>
                <td>BADMINTON</td>
                <td>KMUTT</td>
                <td>2VS2</td>
                <td>2011/04/25</td>
                <td>2011/04/25</td>
            </tr>
             <tr>
            	<td><input type="checkbox" name="id[]" value="1"  /></td>
                <td>เล่นแบตกันเถอะ</td>
                <td>BADMINTON</td>
                <td>KMUTT</td>
                <td>2VS2</td>
                <td>2011/04/25</td>
                <td>2011/04/25</td>
            </tr>
             <tr>
            	<td><input type="checkbox" name="id[]" value="1"  /></td>
                <td>เล่นแบตกันเถอะ</td>
                <td>BADMINTON</td>
                <td>KMUTT</td>
                <td>2VS2</td>
                <td>2011/04/25</td>
                <td>2011/04/25</td>
            </tr>
             <tr>
            	<td><input type="checkbox" name="id[]" value="1"  /></td>
                <td>เล่นแบตกันเถอะ</td>
                <td>BADMINTON</td>
                <td>KMUTT</td>
                <td>2VS2</td>
                <td>2011/04/25</td>
                <td>2011/04/25</td>
            </tr>
             <tr>
            	<td><input type="checkbox" name="id[]" value="1"  /></td>
                <td>เล่นแบตกันเถอะ</td>
                <td>BADMINTON</td>
                <td>KMUTT</td>
                <td>2VS2</td>
                <td>2011/04/25</td>
                <td>2011/04/25</td>
            </tr>
             <tr>
            	<td><input type="checkbox" name="id[]" value="1"  /></td>
                <td>เล่นแบตกันเถอะ</td>
                <td>BADMINTON</td>
                <td>KMUTT</td>
                <td>2VS2</td>
                <td>2011/04/25</td>
                <td>2011/04/25</td>
            </tr> <tr>
            	<td><input type="checkbox" name="id[]" value="1"  /></td>
                <td>เล่นแบตกันเถอะ</td>
                <td>BADMINTON</td>
                <td>KMUTT</td>
                <td>2VS2</td>
                <td>2011/04/25</td>
                <td>2011/04/25</td>
            </tr>
             <tr>
            	<td><input type="checkbox" name="id[]" value="1"  /></td>
                <td>เล่นแบตกันเถอะ</td>
                <td>BADMINTON</td>
                <td>KMUTT</td>
                <td>2VS2</td>
                <td>2011/04/25</td>
                <td>2011/04/25</td>
            </tr>
             <tr>
            	<td><input type="checkbox" name="id[]" value="1"  /></td>
                <td>เล่นแบตกันเถอะ</td>
                <td>BADMINTON</td>
                <td>KMUTT</td>
                <td>2VS2</td>
                <td>2011/04/25</td>
                <td>2011/04/25</td>
            </tr>
             <tr>
            	<td><input type="checkbox" name="id[]" value="1"  /></td>
                <td>เล่นแบตกันเถอะ</td>
                <td>BADMINTON</td>
                <td>KMUTT</td>
                <td>2VS2</td>
                <td>2011/04/25</td>
                <td>2011/04/25</td>
            </tr>
             <tr>
            	<td><input type="checkbox" name="id[]" value="1"  /></td>
                <td>เล่นแบตกันเถอะ</td>
                <td>BADMINTON</td>
                <td>KMUTT</td>
                <td>2VS2</td>
                <td>2011/04/25</td>
                <td>2011/04/25</td>
            </tr>
             <tr>
            	<td><input type="checkbox" name="id[]" value="1"  /></td>
                <td>เล่นแบตกันเถอะ</td>
                <td>BADMINTON</td>
                <td>KMUTT</td>
                <td>2VS2</td>
                <td>2011/04/25</td>
                <td>2011/04/25</td>
            </tr>
            
            
            
            
        </tbody>
        <tfoot>
            <tr>
            	<th></th>
                <th>Event Name</th>
                <th>Sport type</th>
                <th>location</th>
                <th>type Sport</th>
                <th>Start date</th>
                <th>End date</th>
            </tr>
        </tfoot>
    </table>

                        </div>

                    </div>
                </div>
            </div>
            <br>
            <br>
              </form>
        </div>
      
