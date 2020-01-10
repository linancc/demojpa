package com.example.demojpa.module.system.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id")
    private Long custId;

    private String address;

    private String industry;

    private String level;

    private String name;

    private String phone;

    private String source;

    // 配置客户和联系人之间的关系（一对多关系）
    /**
     * 使用注解形式配置多表关系
     * 1.声明关系
     *
     * @OneToMany : 配置一对多关系
     * targetEntity ： 对方对象的字节码对象
     * 2.配置外键（中间表）
     * @JoinColumn : 配置外键
     * name ： 外键字段名称
     * referencedColumnName ： 参照的主键字段名称
     * <p>
     * 在客户实体类上（一的一方）添加了外键的配置，所以对于客户而言，也具备了维护外键的作用
     */
//    @OneToMany(targetEntity = LinkMan.class)
//    @JoinColumn(name = "lkm_cust_id", referencedColumnName = "cust_id")
    /**
     * 放弃外键维护
     * mappedBy : 对方配置关系的属性名称
     */
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<LinkMan> linkMans = new HashSet<>();
}
