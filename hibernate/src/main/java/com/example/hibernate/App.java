package com.example.hibernate;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class App 
{
    public static void main( String[] args )
    {
    	SessionFactory sf = Utility.getSessionFactory();
    	
    	Session session = sf.openSession();
    	
    	Product product = new Product();
    	
    	
    	Transaction transaction = session.beginTransaction();
    	
    	Scanner sc = new Scanner(System.in);
    	
    	
    	int x, id;
    	
    	do {
    		System.out.println("Choice:\n1)Add\n2)Find by Id\n3)Retrive all rows\n4)update\n5)Exit");
    		x = sc.nextInt();
    		switch(x) {
    			case 1: {
    				System.out.println("Enter id, name, price");
    				product = new Product();
    				product.setId(sc.nextInt());
    				product.setName(sc.next());
    				product.setPrice(sc.nextFloat());
    				
    				session.persist(product);
    				transaction.commit();
    				
    				System.out.println("saved:" + product);
    				
    				break;
    			}
    			case 2:{
    				System.out.println("Enter Id to find");
    				id = sc.nextInt();
    				
    				product = session.find(Product.class, id);
    				
    				System.out.println(product);
    				
    				break;
    			}
    			case 3:{
    				List<Product> products = session.createQuery("FROM Product", Product.class).getResultList();
    				for(Product p: products) {
    					System.out.println(p);
    				}
    				break;
    			}
    			case 4:{
    				System.out.println("Enter id, name, price");
    				product = new Product();
    				product.setId(sc.nextInt());
    				product.setName(sc.next());
    				product.setPrice(sc.nextFloat());
    				
    				session.merge(product);
    				transaction.commit();
    				break;
    			}
    			case 5: {
    				x = -1;
    				break;
    			}
    			default:{
    				System.out.println("Invalid case");
    			}
    		}
    	}while(x!=-1);
    	
    	session.close();
    	
    	Utility.terminate();
    	
    	sc.close();
    }
}
