package com.how2java.test;
 
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
        Category c = (Category)s.get(Category.class, 4);
        Set<Product> p = c.getProducts();
        for (Product product : p) {
			System.out.println(product.getName());
		}
        s.getTransaction().commit();
        s.close();
        sf.close();
    }
 
}