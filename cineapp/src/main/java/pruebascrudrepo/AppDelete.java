package pruebascrudrepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cineapp.repository.NoticiasRepository;

public class AppDelete {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository nrepo = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		int IdNoticia=4;
		if(nrepo.existsById(IdNoticia)) {
			nrepo.deleteById(IdNoticia);
			
		}else {
			
			System.out.println("El Registro no existe");
		}
		
		
		
		context.close();

	}

}
