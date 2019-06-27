package com.bitcamp.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.bitcamp.web.common.util.PageProxy;
import com.bitcamp.web.common.util.Printer;
import com.bitcamp.web.domain.CustomerDTO;
import com.bitcamp.web.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * CustomerController
 */
// @Controller soap방식
@RestController // controller 자식 : 기능 추가될 수록 자식.
@RequestMapping("/customers")
public class CustomerController {
    @Autowired CustomerService customerService;
    @Autowired CustomerDTO customer;
    @Autowired Printer p;
    @Autowired PageProxy pxy;
    
    // @PostMapping("")
    // public HashMap<String,Object> join(@RequestBody CustomerDTO param){ //json과 호환(hashmap)
    //     System.out.println("=======Post mapping========");
    //     System.out.println(param.getCustomerId());
    //     System.out.println(param.getPassword());
    //     System.out.println(param.getCustomerName());
    //     customerService.addCustomer(param);
    //     HashMap<String, Object> map = new HashMap<>();
    //     map.put("result", "SUCCESS");
    //     return map;
    // }
    @PostMapping("")
    public HashMap<String,Object> join(@RequestBody CustomerDTO param){ //json과 호환(hashmap)
        HashMap<String, Object> map = new HashMap<>();
        p.accept("POST 진입");
        map.put("result", "SUCCESS");
        return map;
    }
   
    @GetMapping("/page/{pageNum}")
    public HashMap<String,Object> list(@PathVariable String pageNum){
        
        //totalCount, page_num, page_size, block_size
        HashMap<String, Object> map = new HashMap<>();
        map.put("totalCount", customerService.countAll());
        map.put("page_num", pageNum);
        map.put("page_size", "5");
        map.put("block_size", "5");
        pxy.execute(map);
        map.put("list", customerService.findCustomers(pxy));
        map.put("pxy", pxy);
    
        return map;
    }

    @GetMapping("/count")
    public String index() {
        System.out.println("CustomerController count() 경로입니다.");
        int count = customerService.countAll();
        p.accept("람다가 출력한 고객의 총인원 : " +count); 
        //System.out.println("고객의 총인원 : " +count);
        return "100";
    }
 
    @GetMapping("/{customerId}/{password}") // annotation ,메소드에 대한 기능정의
    public CustomerDTO login(@PathVariable("customerId")String id, //객체가 반환값으로(RESRful 방식)
                        @PathVariable("password") String pass){  //메소드 선언(declaration) -> notation

        customer.setCustomerId(id);//메소드가 끝난다. bit01을 필드에 옮기고 사라진다.
        customer.setPassword(pass);// 힙에 있는 dto 인스턴스
        return customerService.login(customer);
    }


    @GetMapping("/{customerId}")
    public CustomerDTO getCustomer(@PathVariable String customerId) {
        HashMap<String, Object> map = new HashMap<>();
        p.accept("Get 진입 "+ customerId);
        customer.setCustomerId("hong");
        return customer;
//        return customerService.findCustomerByCustomerId(customerId);
    }

    @PutMapping("/{customerId}")
    public HashMap<String,Object> updateCustomer(@PathVariable String customerId) {
        
        HashMap<String,Object> map = new HashMap<>();
        p.accept("Put 진입:" +customerId);
        map.put("result","SUCCESS");
        return map;
    }

    @DeleteMapping("/{customerId}")
    public HashMap<String,Object> deleteCustomer(@PathVariable String customerId) {
        HashMap<String, Object> map = new HashMap<>();
        p.accept("DELETE 진입: "+customerId);
        customer.setCustomerId(customerId);
        map.put("result","SUCCESS");
        return map;
    }

}