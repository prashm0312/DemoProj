package com.cdac.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.cdac.pojo.FourWheeler;
import com.cdac.pojo.TwoWheeler;
import com.cdac.pojo.Vehicle;


public class AppMain {

	public static void main(String[] args) {

		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		
		SessionFactory sf = config.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		FourWheeler fw = new FourWheeler();
		fw.setVehicleId(101);
		fw.setSeating_capacity(4);
		fw.setSteering_type("power");
		
		TwoWheeler tw = new TwoWheeler();
		tw.setVehicleId(201);
		tw.setSeating_capacity(2);
		tw.setHandle_type("straight");
		
		session.save(fw);
		session.save(tw);
		
		transaction.commit();
		
		System.out.println("objects saved");
		
		sf.close();
	}
}








