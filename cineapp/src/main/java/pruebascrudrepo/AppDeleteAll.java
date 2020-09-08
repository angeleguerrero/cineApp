package pruebascrudrepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cineapp.repository.NoticiasRepository;


public class AppDeleteAll {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository nrepo = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		
		nrepo.deleteAll();
		
		context.close();

	}

}
