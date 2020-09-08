package pruebascrudrepo;

import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cineapp.model.Noticia;
import com.cineapp.repository.NoticiasRepository;

public class AppUpdate {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository nrepo = context.getBean("noticiasRepository", NoticiasRepository.class);
		
//		1-Buscar entidad
		Optional<Noticia>optional= nrepo.findById(5);
		if(optional.isPresent()) {
			Noticia noticia = optional.get();
			noticia.setEstatus("Inactiva");
			nrepo.save(noticia);
			System.out.println(noticia);
			
		}else {
			
			System.out.println("No fue encontrada");
		}
		
		
		
//		2-Actualizar entidad
		
		
		
		context.close();

	}

}
