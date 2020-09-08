package pruebasjparepo;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Sort;

import com.cineapp.model.Noticia;
import com.cineapp.repository.NoticiasRepository;

public class AppSorting {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository nrepo = context.getBean("noticiasRepository",NoticiasRepository.class );
		
		
//		Obtener Entidades por un campo
//		List<Noticia> lista= nrepo.findAll(Sort.by("titulo").descending());
//		for (Noticia tempnoticias: lista) {
//			System.out.println(tempnoticias);
//			
//		}
		
//		Obtener entidades por dos campos
		List<Noticia> lista= nrepo.findAll(Sort.by("fecha").descending().and(Sort.by("titulo").ascending()));
		for (Noticia tempnoticias: lista) {
			System.out.println(tempnoticias);
			
		}
		
		
		
		context.close();

	}

}
