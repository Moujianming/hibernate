package com.how2java.test;
 import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.how2java.pojo.Category;
import com.how2java.pojo.Product;
import com.how2java.pojo.User;
public class TestHibernate {
    public static void main(String[] args) {
 
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
 
        Session s = sf.openSession();
        s.beginTransaction();
 
        /*for(int i=0;i<10;i++)
        {
        	 Product p = new Product();
             p.setName("iphone"+i);
             p.setPrice(i);
             s.save(p);
        }*/
        //获取对象
       /* Product p = (Product)s.get(Product.class, 6);
        System.out.println(p.getName());*/
        //删除对象
        /*Product p =  (Product)s.get(Product.class, 6);
        s.delete(p);*/
        //修改对象
        /*Product p = (Product)s.get(Product.class, 5);
        System.out.println(p.getName());
        p.setName("iphone X");
        s.update(p);*/
       // 查询HQL,hibernate自带的查询语句
       /*Query q = s.createQuery("from Product p where p.name like ?");
        q.setString(0, "%iphone1%");
        List<Product> ps = q.list();
        for(int i =0;i<ps.size();i++)
        {
        	
        	System.out.println(ps.get(i).getName());
        }*/
        //使用Criteria查询
        /*Criteria c = s.createCriteria(Product.class);
        c.add(Restrictions.like("name", "%iphone%"));
        List<Product> ps = c.list();
        for(int i =0;i<ps.size();i++)
        {
        	System.out.println(ps.get(i).getName());
        }*/
        //通过标准的sql语句查询
       /* Query q = s.createSQLQuery("select * from product_");
        List<Object[]> list = q.list();
        //方法一的for形式
       for(int i =0;i<list.size();i++)
       {
    	   Object[] obj  = list.get(i);
    	   for(int j = 0;j<obj.length;j++)
    	   {
    		   System.out.print(obj[j]+" ");
    	   }
    	   System.out.println();
       }
        //方法二的for形式(foreach)
       for (Object[] objects : list) {
		for (Object object : objects) {
			System.out.print(object+" ");
		}
		System.out.println();
	 }*/
       //测试product-category多对一的情况
       /* Category c = new Category();
        c.setName("c1");
        s.save(c);
        
        Product p =  (Product)s.get(Product.class, 8);
        p.setCategory(c);
      
        s.update(p);*/
        
        //category-poduct一对多的关系
        /*Category c = (Category)s.get(Category.class, 4);
        Set<Product> p = c.getProducts();
        for (Product product : p) {
			System.out.println(product.getName());
		}*/
        
        //实现User-product多对多的关系
        
       /* Set<User> users = new HashSet();
        for(int i=0;i<3;i++)
        {
        	User u = new User();
        	u.setName("user"+i);
        	users.add(u);
        	s.save(u);
        }
        //1个产品被3个用户购买
        Product p =(Product) s.get(Product.class, 1);
        p.setUsers(users);
        s.save(p);*/
      //category-poduct一对多的关系
        /*Category c = (Category)s.get(Category.class, 4);
        Set<Product> p = c.getProducts();
        for (Product product : p) {
			System.out.println(product.getName());
		}*/
        
        //实现User-product多对多的关系
        
       /* Set<User> users = new HashSet();
        for(int i=0;i<3;i++)
        {
        	User u = new User();
        	u.setName("user"+i);
        	users.add(u);
        	s.save(u);
        }
        //1个产品被3个用户购买
        Product p =(Product) s.get(Product.class, 1);
        p.setUsers(users);
        s.save(p);*/
        
        //测试hibernate事务
        /* Product p1=  (Product)s.get(Product.class, 1);
         s.delete(p1);
         Product p2 = (Product)s.get(Product.class, 2);
         p2.setName("超过30个字节超过30个字节超过30个字节超过30个字节超过30个字节超过30个字节超过30个字节超过30个字节超过30个字节超过30个字节超过30个字节超过30个字节超过30个字节超过30个字节超过30个字节");
         s.update(p2);*/
         
        //属性的延时加载
        /**
         * 用load时,只有调用了getname()等方法后才查询数据库,但是get方法是直接就加载数据库
         */
       /* Product p = (Product)s.load(Product.class, 1);
        System.out.println("log1");
        System.out.println(p.getName());
        System.out.println("log2");*/
        /*Product p = (Product)s.get(Product.class, 1);
        System.out.println("log1");
        System.out.println(p.getName());
        System.out.println("log2"); */ 
        
        //关系延迟加载
        /*Category c = (Category)s.get(Category.class,2);
        System.out.println("log1");
        System.out.println(c.getProducts());
        System.out.println("log1");*/
        
        
        //级联delete
       /* Category c = (Category)s.get(Category.class,4);
        s.delete(c);*/
        //级联save-update
       /* Category c = (Category)s.get(Category.class,3);
        Product p1= new Product();
        p1.setName("product01");
        Product p2= new Product();
        p2.setName("product01");
        c.getProducts().add(p1);
        c.getProducts().add(p2);*/
        
        //1级缓存
        /**
         * 当查询的条件是一样的时候,session会存放第一次缓存,当不一样的时候会再次查询
         */
        /*System.out.println("log1");
        Category c1 = (Category)s.get(Category.class,1);
        System.out.println("log2");
        Category c2= (Category)s.get(Category.class,1);
        System.out.println("log3");*/
        
        //2级缓存
       /* System.out.println("log1");
        Category c1 = (Category)s.get(Category.class,1);
        System.out.println("log2");
        Category c2 = (Category)s.get(Category.class,1);
        System.out.println("log3");
        s.getTransaction().commit();
        s.close();
        Session s2 = sf.openSession();
        s2.beginTransaction();
        System.out.println("log4");
        Category c3 = (Category)s2.get(Category.class,2);
        System.out.println("log5");
        s2.getTransaction().commit();
        s2.clear();*/
        
        //分页
       /* String name = "iphone";
        Criteria c= s.createCriteria(Product.class);
        c.add(Restrictions.like("name", "%"+name+"%"));
        c.setFirstResult(0);
        c.setMaxResults(5);
        List<Product> list = c.list();
        for (Product product : list) {
			System.out.println(product.getId());
		}*/
        
        /**
         * get和load获取对象
         */
        System.out.println("log1");
        Product p = (Product) s.get(Product.class, 1);
        System.out.println("log2");
        Product p2 = (Product) s.load(Product.class, 2);
        System.out.println("log3");
        System.out.println(p2.getName());
        System.out.println("log4");
        
        
        s.getTransaction().commit();
        s.close();
        sf.close();
    }
 
}
      