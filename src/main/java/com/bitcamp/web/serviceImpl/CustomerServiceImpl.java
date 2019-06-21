package com.bitcamp.web.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.bitcamp.web.common.util.PageProxy;
import com.bitcamp.web.domain.CustomerDTO;

import com.bitcamp.web.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * CustomerServiceImp
 */
@Service
public class CustomerServiceImpl implements CustomerService {
     
  
    @Override
    public void addCustomer(CustomerDTO customer) {
        
    }
 
    @Override
    public List<CustomerDTO> findCustomers(PageProxy pxy) {
        List<CustomerDTO> x = new ArrayList();
        return x;
    }

    @Override
    public List<CustomerDTO> findCustomersByOption(CustomerDTO option) {
        List<CustomerDTO> x = new ArrayList();
        return x;
    }

    @Override
    public CustomerDTO findCustomerByCustomerId(String customerId) {
        CustomerDTO dto = new CustomerDTO();
        return dto;
    }

    @Override
    public int updateCustomer(CustomerDTO customer) {
 //       int res = customerMapper.updateCustomer(customer);
        int res =1;
        if (res == 1) {
            System.out.println("서비스 수정 성공");
        } else {
            System.out.println("서비스 수정 실패");
        }
        return 1;
    }

    @Override
    public void deleteCustomer(CustomerDTO customer) {
 //       customerMapper.deleteCustomer(customer);
    }

    @Override
    public int countAll() {
        return 1;
    }

    @Override
    public CustomerDTO login(CustomerDTO customer) { // 값이 아니라 인스턴스
        System.out.println("컨트롤러에서 넘어온 name: "+customer.getCustomerId());
        System.out.println("컨트롤러에서 넘어온 pass: "+customer.getPassword());
        CustomerDTO dto = new CustomerDTO();
        return dto;
    }

}