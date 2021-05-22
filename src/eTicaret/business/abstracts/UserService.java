package eTicaret.business.abstracts;



import eTicaret.entities.concretes.User;

public interface UserService {

	void singIn(User user, String[] ePostaList);
	void login(User user, String[] ePostaList);

	
}
