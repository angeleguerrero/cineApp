package pruebascrudrepo;


import java.util.LinkedList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cineapp.model.Noticia;
import com.cineapp.repository.NoticiasRepository;

public class FindAllById {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository nrepo = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		List<Integer> Ids = new LinkedList<Integer>();
		Ids.add(1);
		Ids.add(3);
		
		Iterable<Noticia>iterable = nrepo.findAllById(Ids);
		for(Noticia tempnoticias: iterable) {
			System.out.println(tempnoticias);
			
		}
		
		
		
		
		
		context.close();


	}

}
