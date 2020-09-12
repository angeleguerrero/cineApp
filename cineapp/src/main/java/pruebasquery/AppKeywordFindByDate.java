package pruebasquery;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cineapp.model.Noticia;
import com.cineapp.repository.NoticiasRepository;

public class AppKeywordFindByDate {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository nrepo = context.getBean("noticiasRepository", NoticiasRepository.class);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<Noticia> lista = null;
		try {
			lista = nrepo.findByFecha(sdf.parse("2020-08-01"));
		} catch (ParseException e) {
		
			e.printStackTrace();
		}

		for(Noticia tempnoticias: lista ) {

				
				System.out.println(tempnoticias);

		}
		
		context.close();
	}

}
