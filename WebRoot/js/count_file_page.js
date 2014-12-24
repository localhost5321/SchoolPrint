/**
 * 计算word文档的页数
 */

 function count_page(filePath){
	 var word_obj = new ActiveXObject('Word.Application');
	 word_obj.Document.Open("filePath");
	 return word_obj.ActiveDocument.ComputeStatistics(2);
 }
 
