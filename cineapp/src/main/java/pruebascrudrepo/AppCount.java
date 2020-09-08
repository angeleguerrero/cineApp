package pruebascrudrepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cineapp.repository.NoticiasRepository;

public class AppCount {

	
	public static void main(String[]args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository nrepo = context.getBean("noticiasRepository", NoticiasRepository.class );
		
//		Contar registros en la tabla
		long num = nrepo.count();
		System.out.println("Se Encontraron: " + num + " Registros" );
		
		context.close();
		
	}
	
}
