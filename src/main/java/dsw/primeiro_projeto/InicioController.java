package dsw.primeiro_projeto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InicioController {
	
	@GetMapping("/inicio")
	public String inicio(@RequestParam(value = "nome", defaultValue = "World") String name) {
		return String.format("Olá %s", name);
	}
	
	@GetMapping(path="/bean")
	public PrimeiroBean bean() {
		return new PrimeiroBean("Meu Primeiro Bean!");
	}

}
