package testes;

import br.com.caelum.vraptor.Resource;

@Resource
public class Mundo {

	public String boasVindas() {
		int x = 5;
		int y = 6;
		return " " + (x + y);
	}
}