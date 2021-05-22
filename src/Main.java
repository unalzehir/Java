import eTicaret.business.concretes.UserManager;
import eTicaret.core.GoogleManagerAdapter;
import eTicaret.dataAccess.concretes.HibernateUserDao;
import eTicaret.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		
		User user = new User(1,"Ünal","Zehir","unal@gmail.com","123456");
		User user2 = new User(2,"Engin","Demiroð","engin@gmail.com","987654321");
		
		String[] ePostaList = {"ali@gmail.com", "veli@gmail.com"};
		String[] ePostaParolaList = {"ali123", "veli123"};
		
		UserManager userManager = new UserManager(new HibernateUserDao());
		userManager.singIn(user, ePostaList);
		

		GoogleManagerAdapter googleManagerAdapter = new GoogleManagerAdapter();
		googleManagerAdapter.login(user2, ePostaList);
		
		
	}

}
