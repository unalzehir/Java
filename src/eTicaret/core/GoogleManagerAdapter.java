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
						
						System.out.println("Daha önce böyle bir adres ile kayýt yapýldý.");
						return;
						
					}else {
						
						System.out.println("Kayýt iþlemi gerçekleþtirildi.");
						return;
						
					}
				}
			}else {
				
				System.out.println("Girilen adres yanlýþ");			
			}			
			
		}else {
			System.out.println("Kayýt ad, soyad veya parola yüzünden gerçekleþtirilemedi.");
		}				
	}
	
	public void sendMail(User user) {
		
		System.out.println("E-Posta adresini doðrulamak için " + user.getePosta() +  " adresine gönderilen link ile aktivasyon yapýnýz.");
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
						
					System.out.println("Hoþgeldiniz.");
					return;
					}else {
						
						System.out.println("Böyle bir adres bulunamadý");
						return;
					}
			}
		}
	}
}
