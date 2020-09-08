package pruebascrudrepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cineapp.model.Noticia;
import com.cineapp.repository.NoticiasRepository;

public class AppFindAll {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository nrepo = context.getBean("noticiasRepository",NoticiasRepository.class );
		
		Iterable<Noticia> iterable = nrepo.findAll();
		
		for (Noticia tmpnoticia : iterable) {
			System.out.println(tmpnoticia);
			
		}
		
		context.close();

	}

}
