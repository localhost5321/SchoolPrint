package com.schoolo2o.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.schoolo2o.pojo.ShopComment;
import com.schoolo2o.pojo.Shopinfo;
import com.schoolo2o.pojo.send.ShopCommentSend;
import com.schoolo2o.pojo.send.ShopinfoSend;
/**
 * 将一个Shopinfo类型的 list 转化为 shopinfoSend类型的list
 * @author herozhao
 *
 */
public class ListChange {
	public static List<ShopinfoSend>  ParaseShops(List <Shopinfo>list){
		List<ShopinfoSend> li=new ArrayList();
		Iterator it=list.iterator();
		while(it.hasNext()){
			Shopinfo sf=(Shopinfo)it.next();
			ShopinfoSend sfs=new ShopinfoSend(sf);
			System.out.println(sfs.getShopPhone());
			li.add(sfs);
		}
		return li;
	}
	/**
	 * 将一个ShopComment类型的 list 转化为 ShopCommentSend类型的list
	 * @param list
	 * @return
	 */
	public static List<ShopCommentSend>  ParaseComments(List <ShopComment>list){
		List<ShopCommentSend> li=new ArrayList();
		Iterator it=list.iterator();
		while(it.hasNext()){
			ShopComment sc=(ShopComment)it.next();
			ShopCommentSend scs=new ShopCommentSend(sc);
			li.add(scs);
		}
		return li;
	}

}
