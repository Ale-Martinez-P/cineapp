package pruebascrudrepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.ajmpcode.app.model.Noticia;
import com.ajmpcode.app.repository.NoticiasRepository;

public class AppFindAllById {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		//Recuperar todos los registros [metodo findAll del respositorio]
		Iterable<Noticia> it = repo.findAll();
		for (Noticia n : it) {
			System.out.println(n);
		}
		context.close();
	}

}
