package pruebasrelaciones;



import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cineapp.model.Horario;
import com.cineapp.repository.HorarioRepository;

public class AppRepoHorarios {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		HorarioRepository hrepo = context.getBean("horarioRepository", HorarioRepository.class);
		
		List<Horario>lista= hrepo.findAll();
	
		
		for(Horario temphorario: lista) {
			
			System.out.println(temphorario);
			
		}
		System.out.println(lista.size());
		context.close();
		
	}

}
