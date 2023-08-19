package id.grocery.tunas.order;

import java.util.List;

public class OrderData {
    private OrderRepository.IOrderData transaction;
    private List<OrderDetailRepository.IOrderItems> detailTransaction;

    public OrderData(OrderRepository.IOrderData transaction, List<OrderDetailRepository.IOrderItems> detailTransaction) {
        this.transaction = transaction;
        this.detailTransaction = detailTransaction;
    }

    public OrderData() {
    }

    public OrderRepository.IOrderData getTransaction() {
        return transaction;
    }

    public void setTransaction(OrderRepository.IOrderData transaction) {
        this.transaction = transaction;
    }

    public List<OrderDetailRepository.IOrderItems> getDetailTransaction() {
        return detailTransaction;
    }

    public void setDetailTransaction(List<OrderDetailRepository.IOrderItems> detailTransaction) {
        this.detailTransaction = detailTransaction;
    }
}
