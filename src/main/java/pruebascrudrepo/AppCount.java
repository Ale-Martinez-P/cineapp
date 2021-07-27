package pruebascrudrepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ajmpcode.app.repository.NoticiasRepository;

public class AppCount {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		// Contar numeros de registros en la tabla [metodo count() del repositorio]
		long num = repo.count();
		System.out.println("Se encontraron: "+ num + " registros.");
		context.close();
	}

}
