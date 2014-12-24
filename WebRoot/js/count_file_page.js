/**
 * 计算word文档的页数
 */

 function count_page(filePath){
	 var w=new ActiveXObject('Word.Application'); 
	 w.Documents.Open("filepath");
	 obj=w.visible=false; 
	 obj.Content;
	 return w.ActiveDocument.ComputeStatistics(2); 
 }
 
