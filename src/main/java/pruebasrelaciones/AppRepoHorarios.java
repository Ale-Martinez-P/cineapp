package pruebasrelaciones;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ajmpcode.app.model.Horario;
import com.ajmpcode.app.repository.HorariosRepository;

public class AppRepoHorarios {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		// Recuperar todas las entidades de tipo Horario
		HorariosRepository repo = context.getBean("horariosRepository", HorariosRepository.class);
		List<Horario> lista = repo.findAll();		
		System.out.println("Numero de entidades"+ lista.size());		
		for (Horario h : lista) {
			System.out.println(h);
		}		
		context.close();
	}

}
