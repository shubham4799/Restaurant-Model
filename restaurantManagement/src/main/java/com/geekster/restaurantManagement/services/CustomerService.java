package com.geekster.restaurantManagement.services;



import com.geekster.restaurantManagement.dto.SignInInputData;
import com.geekster.restaurantManagement.dto.SignInOutputData;
import com.geekster.restaurantManagement.dto.SignUpInputData;
import com.geekster.restaurantManagement.dto.SignUpOutputData;
import com.geekster.restaurantManagement.modules.Authentication;
import com.geekster.restaurantManagement.modules.Customer;
import com.geekster.restaurantManagement.repository.IAuthenticationRepository;

import com.geekster.restaurantManagement.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class CustomerService {
    @Autowired
    ICustomerRepository iCustomerRepository;
    @Autowired
    IAuthenticationRepository iAuthenticationRepository;

    public SignUpOutputData signup(SignUpInputData signUpInputData) {

        Customer customerObj = iCustomerRepository.findFirstByCustomerEmailId(signUpInputData.getUserEmailId());

        if(customerObj !=null){
            throw new IllegalStateException("Email all ready Exist!!");
        }
        String encryptedPassword;
        try {
            encryptedPassword = encryptPassword(signUpInputData.getUserPassword());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        Customer customer = new Customer(signUpInputData.getUserEmailId() , encryptedPassword , signUpInputData.getUserFirstName() , signUpInputData.getUserLastName() , signUpInputData.getUserAddress() , signUpInputData.getUserMobileNumber());
        iCustomerRepository.save(customer);

        Authentication authentication = new Authentication(customer);
        iAuthenticationRepository.save(authentication);
        // iCustomerRepository.save(Customer);
        return new SignUpOutputData("SignUp Successfully Created" ,"Now You can SignIn");

    }

    private String encryptPassword(String userPassword) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(userPassword.getBytes());
        byte[] password = md5.digest();
        String stPassword = new String(password);
        return stPassword;

    }

    public SignInOutputData signin(SignInInputData signInInputData) {
        Customer customerObj = iCustomerRepository.findFirstByCustomerEmailId(signInInputData.getUserEmailId());
        if(customerObj ==null){
            throw new IllegalStateException("Sorry!! Email Not  Found!!");
        }
        String encryptedPassword;
        try {
            encryptedPassword = encryptPassword(signInInputData.getPassword());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        if(!encryptedPassword.equals(customerObj.getCustomerPassword())){
            throw new IllegalStateException("Sorry!! Wrong password!!");
        }
        // Authentication authentication = new Authentication(CustomerObj);
//        Authentication authentication = new Authentication(CustomerObj);
//        iAuthenticationRepository.save(authentication);

        Authentication authenticationObj = iAuthenticationRepository.findByCustomer(customerObj);

        return new SignInOutputData("Congratulation SignIn Successful!!",authenticationObj.getAuthenticationToken());
    }
}
