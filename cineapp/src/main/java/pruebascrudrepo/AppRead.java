package pruebascrudrepo;

import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cineapp.model.Noticia;
import com.cineapp.repository.NoticiasRepository;

public class AppRead {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository nrepo = context.getBean("noticiasRepository", NoticiasRepository.class);

		Optional<Noticia> noticia = nrepo.findById(1);
		System.out.println(noticia.get());
		context.close();
		
	}

}
