package loesning4_runs_array;

import java.util.Random;

public class Die {
	private Random generator;
	private int max;

	public Die(int max) {
		if (max > 1) {
			this.max = max;
			this.generator = new Random();
		}
		else{
			System.out.println("Fejl ved oprettelse af Die. Der skal v�re mindst 2 sider p� terningen.");
		}
	}

	public int throwDie() {
		return generator.nextInt(max) + 1;
	}

}
