package prismcplex;

public class Cplex_Wrapper_Main {
	private static Cplex_Wrapper_Main main;

	// --------------------------------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		main = new Cplex_Wrapper_Main();
	}

	// --------------------------------------------------------------------------------------------------------------------------------
	public Cplex_Wrapper_Main() {
	}

	public static Cplex_Wrapper_Main get_main() {
		return main;
	}
}
