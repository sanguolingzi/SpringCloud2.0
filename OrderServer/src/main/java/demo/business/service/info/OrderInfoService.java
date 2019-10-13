package demo.business.service.info;

import model.order.OrderModel;

public interface OrderInfoService
{
    OrderModel getOrderInfo(String orderId);


    /**
     * 测试链路调用
     * @param orderId
     * @return
     */
    OrderModel getOrderInfoForTestSleuth(String orderId);
}