package pruebasquery;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cineapp.model.Noticia;
import com.cineapp.repository.NoticiasRepository;

public class AppKeywordfind_Between_Date {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository nrepo = context.getBean("noticiasRepository", NoticiasRepository.class);
		List<Noticia>lista=null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
			try {
				lista= nrepo.findByFechaBetween(sdf.parse("2019-07-31"), sdf.parse("2021-07-31"));
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
			
			
	
		for(Noticia tempvar : lista) {
			System.out.println(tempvar);
		}
		
			context.close();
	}

}
