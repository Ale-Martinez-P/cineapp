package pruebascrudrepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ajmpcode.app.model.Noticia;
import com.ajmpcode.app.repository.NoticiasRepository;

public class AppCreate {

	public static void main(String[] args) {
		Noticia noticia = new Noticia();
		noticia.setTitulo("Proximo Estreno: Juego Macabro 8");
		noticia.setDetalle("El mes de septiembre se estrena la nueva entrega de SAW 8");
		
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		repo.save(noticia);
		context.close();
	}

}
