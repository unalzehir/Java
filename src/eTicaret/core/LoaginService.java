package eTicaret.core;

import eTicaret.entities.concretes.User;

public interface LoaginService {

	void singIn(User user, String[] ePostaList);
	void login (User user, String[] ePostaList);
}
