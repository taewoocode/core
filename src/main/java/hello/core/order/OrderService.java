package hello.core.order;

public interface OrderService {

    Order createOrder(Long memberId, String itemName, int itemPrice); // parameter로 넘긴다.
}
