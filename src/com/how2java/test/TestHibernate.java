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
        //��ȡ����
       /* Product p = (Product)s.get(Product.class, 6);
        System.out.println(p.getName());*/
        //ɾ������
        /*Product p =  (Product)s.get(Product.class, 6);
        s.delete(p);*/
        //�޸Ķ���
        /*Product p = (Product)s.get(Product.class, 5);
        System.out.println(p.getName());
        p.setName("iphone X");
        s.update(p);*/
       // ��ѯHQL,hibernate�Դ��Ĳ�ѯ���
       /*Query q = s.createQuery("from Product p where p.name like ?");
        q.setString(0, "%iphone1%");
        List<Product> ps = q.list();
        for(int i =0;i<ps.size();i++)
        {
        	
        	System.out.println(ps.get(i).getName());
        }*/
        //ʹ��Criteria��ѯ
        /*Criteria c = s.createCriteria(Product.class);
        c.add(Restrictions.like("name", "%iphone%"));
        List<Product> ps = c.list();
        for(int i =0;i<ps.size();i++)
        {
        	System.out.println(ps.get(i).getName());
        }*/
        //ͨ����׼��sql����ѯ
       /* Query q = s.createSQLQuery("select * from product_");
        List<Object[]> list = q.list();
        //����һ��for��ʽ
       for(int i =0;i<list.size();i++)
       {
    	   Object[] obj  = list.get(i);
    	   for(int j = 0;j<obj.length;j++)
    	   {
    		   System.out.print(obj[j]+" ");
    	   }
    	   System.out.println();
       }
        //��������for��ʽ(foreach)
       for (Object[] objects : list) {
		for (Object object : objects) {
			System.out.print(object+" ");
		}
		System.out.println();
	 }*/
       //����product-category���һ�����
       /* Category c = new Category();
        c.setName("c1");
        s.save(c);
        
        Product p =  (Product)s.get(Product.class, 8);
        p.setCategory(c);
      
        s.update(p);*/
        
        //category-poductһ�Զ�Ĺ�ϵ
        /*Category c = (Category)s.get(Category.class, 4);
        Set<Product> p = c.getProducts();
        for (Product product : p) {
			System.out.println(product.getName());
		}*/
        
        //ʵ��User-product��Զ�Ĺ�ϵ
        
       /* Set<User> users = new HashSet();
        for(int i=0;i<3;i++)
        {
        	User u = new User();
        	u.setName("user"+i);
        	users.add(u);
        	s.save(u);
        }
        //1����Ʒ��3���û�����
        Product p =(Product) s.get(Product.class, 1);
        p.setUsers(users);
        s.save(p);*/
      //category-poductһ�Զ�Ĺ�ϵ
        /*Category c = (Category)s.get(Category.class, 4);
        Set<Product> p = c.getProducts();
        for (Product product : p) {
			System.out.println(product.getName());
		}*/
        
        //ʵ��User-product��Զ�Ĺ�ϵ
        
       /* Set<User> users = new HashSet();
        for(int i=0;i<3;i++)
        {
        	User u = new User();
        	u.setName("user"+i);
        	users.add(u);
        	s.save(u);
        }
        //1����Ʒ��3���û�����
        Product p =(Product) s.get(Product.class, 1);
        p.setUsers(users);
        s.save(p);*/
        
        //����hibernate����
        /* Product p1=  (Product)s.get(Product.class, 1);
         s.delete(p1);
         Product p2 = (Product)s.get(Product.class, 2);
         p2.setName("����30���ֽڳ���30���ֽڳ���30���ֽڳ���30���ֽڳ���30���ֽڳ���30���ֽڳ���30���ֽڳ���30���ֽڳ���30���ֽڳ���30���ֽڳ���30���ֽڳ���30���ֽڳ���30���ֽڳ���30���ֽڳ���30���ֽ�");
         s.update(p2);*/
         
        //���Ե���ʱ����
        /**
         * ��loadʱ,ֻ�е�����getname()�ȷ�����Ų�ѯ���ݿ�,����get������ֱ�Ӿͼ������ݿ�
         */
       /* Product p = (Product)s.load(Product.class, 1);
        System.out.println("log1");
        System.out.println(p.getName());
        System.out.println("log2");*/
        /*Product p = (Product)s.get(Product.class, 1);
        System.out.println("log1");
        System.out.println(p.getName());
        System.out.println("log2"); */ 
        
        //��ϵ�ӳټ���
        /*Category c = (Category)s.get(Category.class,2);
        System.out.println("log1");
        System.out.println(c.getProducts());
        System.out.println("log1");*/
        
        
        //����delete
       /* Category c = (Category)s.get(Category.class,4);
        s.delete(c);*/
        //����save-update
       /* Category c = (Category)s.get(Category.class,3);
        Product p1= new Product();
        p1.setName("product01");
        Product p2= new Product();
        p2.setName("product01");
        c.getProducts().add(p1);
        c.getProducts().add(p2);*/
        
        //1������
        /**
         * ����ѯ��������һ����ʱ��,session���ŵ�һ�λ���,����һ����ʱ����ٴβ�ѯ
         */
        /*System.out.println("log1");
        Category c1 = (Category)s.get(Category.class,1);
        System.out.println("log2");
        Category c2= (Category)s.get(Category.class,1);
        System.out.println("log3");*/
        
        //2������
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
        
        //��ҳ
        String name = "iphone";
        Criteria c= s.createCriteria(Product.class);
        c.add(Restrictions.like("name", "%"+name+"%"));
        c.setFirstResult(2);
        c.setMaxResults(5);
        List<Product> list = c.list();
        for (Product product : list) {
			System.out.println(product.getId());
		}
        
        s.getTransaction();
        s.close();
        sf.close();
    }
 
}
      