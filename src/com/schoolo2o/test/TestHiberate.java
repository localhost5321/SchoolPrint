package com.schoolo2o.test;

import java.util.Iterator;
import java.util.List;

import com.schoolo2o.dao.ShopinfoDao;
import com.schoolo2o.dao.impl.ShopInfoDaoImpl;
import com.schoolo2o.pojo.Priceinfo;
import com.schoolo2o.pojo.ShopComment;
import com.schoolo2o.pojo.Shopinfo;

public class TestHiberate {
	private ShopinfoDao shopInfo = null;

	public ShopinfoDao getShopInfo() {
		return shopInfo;
	}

	public void setShopInfo(ShopinfoDao shopInfo) {
		this.shopInfo = shopInfo;
	}

	public void TestAdd(Shopinfo shop) {
		if (shopInfo.add(shop)) {
			System.out.println("添加成功");
		} else {
			System.out.println("添加失败");
		}
	}
	public void TestDelete(Shopinfo shop){  //需要主键用来删除
		if(shopInfo.deleteShop(shop)){
			System.out.println("删除成功");
		}else{
			System.out.println("删除失败");
		}
	}
	public void TestUpdate(Shopinfo shop){
		if(shopInfo.update(shop)){
			System.out.println("更新成功");
		}else{
			System.out.println("更新失败");
		}
	}
	public void TestSearchShop(){
		List<Shopinfo> list = shopInfo.searchShop();
		Iterator<Shopinfo> it = list.iterator();
		while(it.hasNext()){
			Shopinfo sh = it.next();
			System.out.println(sh.getShopName());
		}
	}
	public void TestSearch(String name){
		Shopinfo shop = shopInfo.search(name);
		if(shop == null){
			System.out.println("找不到用户");
		}
		else{
			System.out.println("用户为:"  + shop.getShopNick());
		}
	}
	public void  testAddComment(ShopComment comment, String name){
		if (shopInfo.addComment(comment,name)){
			System.out.println("添加评论成功");
		}else{
			System.out.println("添加评论失败");
		}
	}
	public void testSearchComment(String shopName){
		List<ShopComment> commentList = shopInfo.getComments(shopName);
		Iterator<ShopComment> it = commentList.iterator();
		while(it.hasNext()){
			ShopComment comment = it.next();
			System.out.println(comment.getCommentContent());
		}
	}
	public void testUpdateComment(ShopComment comment, String name){
		if(shopInfo.updateComment(comment , name)){
			System.out.println("更新成功");
		}else{
			System.out.println("更新失败");
		}
	}
	public void testDeleteComment(Long commentId){
		if(shopInfo.daleteComment(commentId)){
			System.out.println("删除成功");
		}else{
			System.out.println("删除失败");
		}
	}
	public void testAddPriceType(Priceinfo priceinfo, String shopName){
		if(shopInfo.addTypePrice(priceinfo, shopName)){
			System.out.println("类型添加成功");
		}else{
			System.out.println("类型添加失败");
		}
	}
	public void testgetTypePrice(String shopName){
		List<Priceinfo> priceList= shopInfo.getTypePrice(shopName);
		Iterator<Priceinfo> it = priceList.iterator();
		while(it.hasNext()){
			Priceinfo pf = it.next();
			System.out.println(pf.getPrintType());
		}
	}
	public void testUpdateTypePrice();
}
