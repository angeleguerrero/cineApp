package pruebasjparepo;





import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cineapp.repository.NoticiasRepository;

public class AppDeleteAllInBatch {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository nrepo = context.getBean("noticiasRepository",NoticiasRepository.class );
		
//		Borra todo y la sentencia no la ejecuta registro por registro
		nrepo.deleteAllInBatch();
		
	
		
		
		context.close();
		

	}

}
