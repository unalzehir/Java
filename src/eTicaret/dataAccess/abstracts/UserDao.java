package eTicaret.dataAccess.abstracts;

import eTicaret.entities.concretes.User;

public interface UserDao {

	void signIn(User user);
}
