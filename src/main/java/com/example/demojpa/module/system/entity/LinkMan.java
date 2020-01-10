package com.example.demojpa.module.system.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class LinkMan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lkmId;

    private String name;

    private String gender;

    private String phone;

    private String mobile;

    private String email;

    private String position;

    private String memo;

    /**
     * 配置联系人到客户的多对一关系
     * 使用注解形式配置多对一关系
     * 1.配置表关系
     *
     * @ManyToOne : 配置多对一关系
     * targetEntity ： 对方实体类字节码
     * 2.配置外键（中间表）
     * <p>
     * 配置外键的过程，配置到了多的一方，就会在多的一方维护外键
     */

    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn(name = "lkm_cust_id", referencedColumnName = "cust_id")
    private Customer customer;
}
