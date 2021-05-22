package eTicaret.business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eTicaret.business.abstracts.UserService;
import eTicaret.dataAccess.abstracts.UserDao;
import eTicaret.entities.concretes.User;

public class UserManager implements UserService {

	private UserDao userDao;
	
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public void singIn(User user, String[] ePostaList) {
		
		if(user.getFirstName().length()>=2 && user.getLastName().length()>=2 && user.getPassword().length()>=6)	{
			if (checkMail(user.getePosta())){
				for (String posta : ePostaList) {
					if (posta==user.getePosta()) {
						
						System.out.println("Daha önce böyle bir adres ile kayıt yapıldı.");
						return;
						
					}else {
						
						System.out.println("Kayıt işlemi gerçekleştirildi.");
						return;
						
					}
				}
			}else {
				
				System.out.println("Girilen adres yanlış");			
			}			
			
		}else {
			System.out.println("Kayıt ad, soyad veya parola yüzünden gerçekleştirilemedi.");
		}				
	}
	
	public void sendMail(User user) {
		
		System.out.println("E-Posta adresini doğrulamak için " + user.getePosta() +  " adresine gönderilen link ile aktivasyon yapınız.");
	}
	
	
	
	public boolean checkMail(String eMail) 	{
		
		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(eMail);
		
		if (matcher.matches()) {
			
			return true;
			
		}else {
			
			return false;
		}		
	}

	@Override
	public void login(User user, String[] ePostaList) {
		
		if (checkMail(user.getePosta())) {
			for (String posta : ePostaList) {
				if (posta==user.getePosta()) {
						if (user.getPassword().length() >= 6) {
							System.out.println("Hoşgeldiniz.");
							return;
						}else {
							
							System.out.println("Yanlış şifre girdiniz.");
							return;
						}
				}else {
					System.out.println("Böyle bir adres bulunamadı");
					return;
				}
			}
		}
	}
}

	

