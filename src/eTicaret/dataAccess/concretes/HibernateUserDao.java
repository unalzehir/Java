package eTicaret.dataAccess.concretes;

import eTicaret.dataAccess.abstracts.UserDao;
import eTicaret.entities.concretes.User;

public class HibernateUserDao implements UserDao {

	@Override
	public void signIn(User user) {
		
		System.out.println("Sisteme kayýt olundu: " + user.getFirstName());
		
	}

}
