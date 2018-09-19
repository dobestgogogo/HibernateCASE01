package com.tjx;

import com.tjx.pojo.EbookCategoryEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;


public class Test {

    private SessionFactory sessionFactory;//创建session
    private Session session;//实施持久化操作关键API
    private Transaction transaction;//事务控制

    @Before
    public void before(){
        Configuration con = new Configuration().configure();//加载hibernate配置文件
        sessionFactory = con.buildSessionFactory();//创建sessionFactory工厂
        session = sessionFactory.getCurrentSession();//openSession(); 推荐前者
        transaction = session.beginTransaction();//开启事务
    }
    @After
    public void after(){
        transaction.commit();
        //session.close();
        //sessionFactory.close();
    }

    /**
     * 添加 和 查询
     */
    @org.junit.Test
    public void saveAndSelect(){
        /*EbookCategoryEntity ece = new EbookCategoryEntity();
        ece.setId((int)68);
        ece.setName("天生我才");
        session.save(ece);*/
        /**
         * get:如果查询的主键Id不存在，返回Null
         * load:如果查询的主键Id不存在，则抛出异常
         */
        EbookCategoryEntity a = (EbookCategoryEntity) session.get(EbookCategoryEntity.class, 100);
        //EbookCategoryEntity a = (EbookCategoryEntity) session.load(EbookCategoryEntity.class, 100);
        System.out.println(a);
    }

    /**
     * 修改
     */
    @org.junit.Test
    public void modify(){
        //对象处于持久状态
        EbookCategoryEntity ece = (EbookCategoryEntity) session.load(EbookCategoryEntity.class, 67);
        //修改后，信息和之前不同，此时对象成为"脏对象"
        ece.setName("帮");
        //session.merge(ece);
        System.out.println(ece);
    }

    /**
     * 删除
     */
    @org.junit.Test
    public void delete(){
        EbookCategoryEntity ece = (EbookCategoryEntity) session.load(EbookCategoryEntity.class,66);
        session.delete(ece);
    }




}
