package com.geekster.restaurantManagement.services;



import com.geekster.restaurantManagement.modules.*;
import com.geekster.restaurantManagement.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    IOrderRepository iOrderRepository;
    @Autowired
    private IFoodRepository iFoodRepository;
    @Autowired
    private IRestaurantRepository iRestaurantRepository;

    @Autowired
    private IAuthenticationRepository authenticationRepo;
    @Autowired
    private ICustomerRepository customerRepo;
    public String addOrder(OrderFood orderFood) {
        Long foodId = orderFood.getFoods().getFoodsID();
        Long restaurantId = orderFood.getRestaurant().getRestaurantID();
        Foods foodsObj = iFoodRepository.findById(foodId).get();
        Restaurant restaurantObj = iRestaurantRepository.findById(restaurantId).get();

        orderFood.setFoods(foodsObj);
        orderFood.setRestaurant(restaurantObj);

        iOrderRepository.save(orderFood);

        return "Ordered Successfully!!";
    }

    public boolean check(String emailId, String token) {
        if(emailId == null || token == null){
            throw new IllegalStateException("Please fill EmailId or Token!!");
        }
        try {
            String customerEmail = customerRepo.findFirstByCustomerEmailId(emailId).getCustomerEmailId();
            String authenticationToken = authenticationRepo.findFirstByAuthenticationToken(token).getAuthenticationToken();

            return customerEmail.equals(emailId) && authenticationToken.equals((token));
        }catch (Exception e){
            throw new IllegalStateException("Wrong EmailId Or Password!!");
        }

    }


    public Iterable<OrderFood> getAllOrderdFood() {
        return iOrderRepository.findAll();
    }
}
