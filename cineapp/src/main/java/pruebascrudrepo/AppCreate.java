package pruebascrudrepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cineapp.model.Noticia;
import com.cineapp.repository.NoticiasRepository;

public class AppCreate {

	public static void main(String[] args) {
		
		Noticia noticia = new Noticia();
		noticia.setTitulo("Prueba Noticias");
		noticia.setDetalle("Prueba detalle de noticias");
		
		
		
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository nrepo =  context.getBean("noticiasRepository", NoticiasRepository.class);
		
		nrepo.save(noticia);
		System.out.println("Save OK");
		
		context.close();

	}

}
