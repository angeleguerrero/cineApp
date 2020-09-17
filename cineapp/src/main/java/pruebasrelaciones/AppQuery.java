package pruebasrelaciones;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cineapp.repository.PeliculasRepositoryQuery;

public class AppQuery {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		PeliculasRepositoryQuery prquery = context.getBean("peliculasRepositoryQuery", PeliculasRepositoryQuery.class);
		
		prquery.findAll();
		
		
		
		context.close();
	}

}
