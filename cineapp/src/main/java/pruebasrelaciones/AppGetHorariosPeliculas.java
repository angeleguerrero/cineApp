package pruebasrelaciones;

import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cineapp.model.Pelicula;
import com.cineapp.repository.PeliculasRepository;

public class AppGetHorariosPeliculas {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext contex = new ClassPathXmlApplicationContext("root-context.xml");
		PeliculasRepository prepo = contex.getBean("peliculasRepository", PeliculasRepository.class);
		Optional<Pelicula>opt= prepo.findById(7);
		
		
		System.out.println(opt.get().getLhorarios());	
			System.out.println("Hay un total de : "+opt.get().getLhorarios().size() +"para la Pelicula seleccionada");	
		
		
		
		contex.close();

	}

}
