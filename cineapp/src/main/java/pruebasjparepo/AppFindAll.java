package pruebasjparepo;



import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cineapp.model.Noticia;
import com.cineapp.repository.NoticiasRepository;

public class AppFindAll {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository nrepo = context.getBean("noticiasRepository",NoticiasRepository.class );
		
		
		List<Noticia>lista =nrepo.findAll();
	
		for (Noticia tempnoticia: lista) {
			System.out.println(tempnoticia);
			
		}
		
		
		context.close();
		

	}

}
