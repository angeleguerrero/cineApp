package pruebasrelaciones;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cineapp.model.Detalle;
import com.cineapp.repository.DetallesRepository;

public class AppReoDetalles {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		DetallesRepository drepo = context.getBean("detallesRepository", DetallesRepository.class);
		
		List<Detalle>lista = drepo.findAll();
		for (Detalle tmpdetalle : lista) {
				System.out.println(tmpdetalle);
			
		}
		
		
		
	context.close();

	}

}
