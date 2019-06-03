package Firstproject.eshop.Dao;

import Firstproject.eshop.Model.OrderDetail;

public interface OrderDAO
{
	public boolean paymentProcess(OrderDetail orderDetail);
	public boolean updateCartItemsStatus(String username,int orderId);

}
