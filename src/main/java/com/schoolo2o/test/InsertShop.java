package com.schoolo2o.test;


import com.schoolo2o.dao.ShopinfoDao;
import com.schoolo2o.dao.impl.ShopInfoDaoImpl;
import com.schoolo2o.pojo.Shopinfo;

public class InsertShop {
	 ShopinfoDao shopDao;
	
		public static void main(String[] args) {
			
		//ShopinfoDao shopDao=new ShopInfoDaoImpl();
		Shopinfo shop=new Shopinfo();
		shop.setShopName("红尘打印店");
		shop.setShopAddress(" 红尘桥东110号");
		shop.setDelivery(1.0);
		shop.setShopNick("打印青春");
		shop.setShopDesc("本店致力于为南华学子带来不一样的服务");
		shop.setShopPhone("15573407442");
		shop.setShopPwd("124326478");
		//shopDao.add(shop);

	}

}
