package Firstproject.eshop.Dao;

import Firstproject.eshop.Model.OrderDetail;

public interface OrderDAO
{
	public boolean saveOrder(OrderDetail orderDetail);
	public boolean updateCart(String username, int orderId);

}
