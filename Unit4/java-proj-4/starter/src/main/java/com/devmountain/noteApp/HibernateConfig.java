package com.devmountain.noteApp;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.devmountain.noteApp.entities.Note;
import com.devmountain.noteApp.entities.User;

@Configuration
public class HibernateConfig {
	@Bean
	public SessionFactory getFactory() {
		SessionFactory factory = new org.hibernate.cfg.Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Note.class).addAnnotatedClass(User.class).buildSessionFactory();

		return factory;
	}
}
