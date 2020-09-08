package pruebascrudrepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cineapp.repository.NoticiasRepository;

public class AppExist {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository nrepo = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		int IdNoticia=1;
		System.out.println(nrepo.existsById(IdNoticia));
		context.close();

	}

}
