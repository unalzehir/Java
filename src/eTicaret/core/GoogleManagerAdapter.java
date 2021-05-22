package eTicaret.core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eTicaret.entities.concretes.User;
import eTicaret.google.GoogleManager;

public class GoogleManagerAdapter implements LoaginService {

	@Override
	public void singIn(User user, String[] ePostaList) {
		GoogleManager manager = new GoogleManager();
		
		if(user.getFirstName().length()>=2 && user.getLastName().length()>=2 && user.getPassword().length()>=6)	{
			if (checkMail(user.getePosta())){
				for (String posta : ePostaList) {
					if (posta==user.getePosta()) {
						
						System.out.println("Daha �nce b�yle bir adres ile kay�t yap�ld�.");
						return;
						
					}else {
						
						System.out.println("Kay�t i�lemi ger�ekle�tirildi.");
						return;
						
					}
				}
			}else {
				
				System.out.println("Girilen adres yanl��");			
			}			
			
		}else {
			System.out.println("Kay�t ad, soyad veya parola y�z�nden ger�ekle�tirilemedi.");
		}				
	}
	
	public void sendMail(User user) {
		
		System.out.println("E-Posta adresini do�rulamak i�in " + user.getePosta() +  " adresine g�nderilen link ile aktivasyon yap�n�z.");
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
						
					System.out.println("Ho�geldiniz.");
					return;
					}else {
						
						System.out.println("B�yle bir adres bulunamad�");
						return;
					}
			}
		}
	}
}
