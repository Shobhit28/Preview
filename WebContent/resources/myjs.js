/**
 * 
 */
$(document).ready(function(){
	
	$("#cross").click(function(){
		$(".op").css({"opacity":"1"});
		$(".op").css({"background-color":""});
		$("#view").css({"display":"none"});
		$("#cross").css({"display":"none"});
		$("#view").attr("src","");
	});
	$("#img_id").hide();
	$("#filepath").change(function(){
		 
		var x = document.getElementById("filepath").value;
		 var filename = x.replace(/^.*[\\\/]/, '');
		 var extension =filename.split(".")[1];
		 if(extension == "xls" || extension == "xlsx"){
			 $("#icon_id").html('<img id="penImage" style="width:100px;height:100px" src="resources/excel-icon.png"/> ');
		 }
		 else if(extension == "doc" || extension == "docx"){
			 $("#icon_id").html('<img id="penImage" style="width:100px;height:100px" src="resources/word-icon.png"/> ');
		 }
		 else if(extension == "pdf"){
			 $("#icon_id").html('<img id="penImage"  style="width:100px;height:100px" src="resources/pdf-icon.png"/> ');
		 }
		 $("#img_id").show();
	});
	$("#icon_id").click(function(){
		getpath();
	});
	function getpath() {
		$(".op").css({"opacity":"0.6"});
		$(".op").css({"background-color":"#2d2d2d"});
		$("#view").css({"display":"block"});
		$("#cross").css({"display":"block"});
		var x = document.getElementById("filepath").value;
		 var filename = x.replace(/^.*[\\\/]/, '');
		
		 var f = filename.replace(/\.[^/.]+$/, "");
	        pdf = f + ".pdf";
		 localStorage.setItem("pdf", pdf);
		$.ajax({
			url : "/Testing/convert.html",
			async : true,
			cache : false,
			type : "POST",

			data : ({
				file_name : filename
			}),
			success : function(data) {
				
		        //window.content.localStorage[p]=pdf;
		        //path = window.content.localStorage[p];
		        
	        onSuccess();

			},
			error : function() {

			}
		});
		
	}


function onSuccess(){
	var url = "http://localhost:8080/ViewerJS/#../Testing/"+localStorage.getItem("pdf");
	$("#view").attr("src",url);
//     window.location.href = "http://localhost:8080/ViewerJS/#../Testing/"+localStorage.getItem("pdf");
}
});
