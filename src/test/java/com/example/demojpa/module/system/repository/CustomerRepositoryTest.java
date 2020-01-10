package com.example.demojpa.module.system.repository;

import com.example.demojpa.module.system.entity.Customer;
import com.example.demojpa.module.system.entity.LinkMan;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private LinkManRepository linkManRepository;

    /**
     * 保存一个客户，保存一个联系人
     */
    @Test
    public void testAdd() {
        Customer customer = new Customer();
        customer.setName("百度");
        LinkMan linkMan = new LinkMan();
        linkMan.setName("linan");

        linkMan.setCustomer(customer);
        customer.getLinkMans().add(linkMan);


        /**
         * 级联添加：保存一个客户的同时，保存客户的所有联系人
         * 需要在操作主体的实体类上，配置 cascade 属性
         */
        customerRepository.save(customer);
    }

}
