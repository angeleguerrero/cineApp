package pruebasjparepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.cineapp.model.Noticia;
import com.cineapp.repository.NoticiasRepository;

public class AppPagin {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository nrepo = context.getBean("noticiasRepository",NoticiasRepository.class );

//	Paginacion
//	Page<Noticia>page =	nrepo.findAll(PageRequest.of(0, 2));
		
//	Paginacion y ordenamiento	
	Page<Noticia>page =	nrepo.findAll(PageRequest.of(0, 3, Sort.by("titulo")));
	for(Noticia tempnoticia: page){
		System.out.println(tempnoticia);	
	}
	
		
		context.close();
	}

}
