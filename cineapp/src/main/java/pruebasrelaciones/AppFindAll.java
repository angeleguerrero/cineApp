package pruebasrelaciones;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cineapp.model.Pelicula;
import com.cineapp.repository.PeliculasRepository;

public class AppFindAll {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		PeliculasRepository prepo = context.getBean("peliculasRepository", PeliculasRepository.class);
		
		List<Pelicula>lista= prepo.findAll();
		for (Pelicula tmpvar: lista) {
			System.out.println(tmpvar);
			
		}
		
		
		context.close();
		
	}

}
