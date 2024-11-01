import java.util.Scanner;

// Código para localização do tipo de falha no Pentágono de Duval
public class AppPentDuval {

	static void tipoFalha(double Cx, double Cy) {
		// Obtenção do coeficiente angular de cada reta do Pentágono de Duval
		double m1, m2, m3, m4, m5, m6, m7, m8, m9, m10, m11, m12, m13, m14, m15; // m = coeficiente angular

		m1 = ((40.0) - (12.4)) / ((0.0) - (-38.0));
		m2 = ((12.4) - (3.1)) / ((-38.0) - (-35.0));
		m3 = ((3.1) - (1.5)) / ((-35.0) - (0.0));
		m4 = ((3.1) - (-32.4)) / ((-35.0) - (-23.5));
		m5 = ((-32.4) - (-32.4)) / ((-23.5) - (23.5));
		m6 = ((-32.4) - (-4.0)) / ((-22.5) - (-6.0));
		m7 = ((-4.0) - (-3.0)) / ((-6.0) - (0.0));
		m8 = ((-4.0) - (-32.0)) / ((-6.0) - (1.0));
		m9 = ((-30.0) - (-32.4)) / ((24.3) - (23.5));
		m10 = ((-30.0) - (-3.0)) / ((24.3) - (0.0));
		m11 = ((-6.1) - (-30.0)) / ((32.0) - (24.3));
		m12 = ((1.5) - (16.0)) / ((0.0) - (4.0));
		m13 = ((16.0) - (-6.1)) / ((4.0) - (32.0));
		m14 = ((12.0) - (-6.1)) / ((38.0) - (32.0));
		m15 = ((40.0) - (12.0)) / ((0.0) - (38.0));

		// Substituição da leitura do centroide em cada parâmetro de centroide (P)
		double P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15; // função de cada reta

		P1 = (m1 * (Cx - (-38.0))) - (Cy - (12.4));
		P2 = (m2 * (Cx - (-35.0))) - (Cy - (3.1));
		P3 = (m3 * (Cx - (0))) - (Cy - (1.5));
		P4 = (m4 * (Cx - (-23.5))) - (Cy - (-32.4));
		P5 = (m5 * (Cx - (-23.5))) - (Cy - (-32.4));
		P6 = (m6 * (Cx - (-6.0))) - (Cy - (-4.0));
		P7 = (m7 * (Cx - (0.0))) - (Cy - (-3.0));
		P8 = (m8 * (Cx - (1.0))) - (Cy - (-32.4));
		P9 = (m9 * (Cx - (23.5))) - (Cy - (-32.4));
		P10 = (m10 * (Cx - (0))) - (Cy - (-3.0));
		P11 = (m11 * (Cx - (24.3))) - (Cy - (-30.0));
		P12 = (m12 * (Cx - (4.0))) - (Cy - (16.0));
		P13 = (m13 * (Cx - (32.0))) - (Cy - (-6.1));
		P14 = (m14 * (Cx - (32.0))) - (Cy - (-6.1));
		P15 = (m15 * (Cx - (38.0))) - (Cy - (12.0));

		// Condicionais para localizar a região onde se encontra o centroide

		if ((Cx <= 0.0 && Cx >= -1.0) && (Cy <= 33.0 && Cy >= 24.5)) {
			System.out.println("\nTipo de falha detectada: PD");
		} else if ((Cx == 0.0 && Cy == 1.5) || (Cx == 0.0 && Cy == -3.0)) {
			System.out.println("\nTipo de falha detectada: D2");
		} else if ((Cx < 0.0 && Cy > 1.5) && (P1 >= 0.0 && P2 <= 0.0 && P3 < 0.0)) {
			System.out.println("\nTipo de falha detectada: S");
		} else if ((Cx <= 0.0 && Cy <= 3.1) && (P3 >= 0.0 && P4 <= 0.0 && P5 <= 0.0 && P6 > 0.0 && P7 < 0.0)) {
			System.out.println("\nTipo de falha detectada: T1 mini");
		} else if ((Cx <= 0.0 && Cy <= 3.1) && (P3 >= 0.0 && P4 <= 0.0 && P5 <= 0.0 && P6 < 0.0)) {
			System.out.println("\nTipo de falha detectada: T1");
		} else if ((Cx < 1.0) && (P5 <= 0.0 && P6 >= 0.0 && P8 > 0.0)) {
			System.out.println("\nTipo de falha detectada: T2");
		} else if ((Cx >= -6.0) && (P5 <= 0.0 && P7 >= 0.0 && P8 <= 0.0 && P9 <= 0.0 && P10 > 0.0)) {
			System.out.println("\nTipo de falha detectada: T3");
		} else if ((Cx > 0.0) && (P10 <= 0.0 && P11 <= 0.0 && P12 >= 0.0 && P13 >= 0.0)) {
			System.out.println("\nTipo de falha detectada: D2");
		} else if ((Cx >= 0.0) && (P12 < 0.0 && P15 >= 0.0)) {
			System.out.println("\nTipo de falha detectada: D1 mini");
		} else if ((Cx > 0.0) && (P12 >= 0.0 && P13 < 0.0 && P14 <= 0.0 && P15 >= 0.0)) {
			System.out.println("\nTipo de falha detectada: D1");
		} else {
			System.out.println("\nTipo de falha detectada: indeterminado");
		}

	};

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String inputCoords;
		double Cx, Cy;

        System.out.print("Deseja inserir coordenadas [S/n]: ");
		inputCoords = sc.next();
		if (inputCoords.equals("S") || inputCoords.equals("s")) {
			System.out.print("Digite o valor de Cx: ");
			Cx = sc.nextDouble();
			System.out.print("Digite o valor de Cy: ");
			Cy = sc.nextDouble();

			tipoFalha(Cx, Cy);
			return;
		}


		// Teste com os dados de entrada do artigo de CHEIM (2020)
		Cx = -7.35;
		Cy = -5.79;
		System.out.printf(
				"\n\nPara os valores de centroide de (-7.35, -5.79), obtidos de CHEIM (2020), "
				+ "o tipo de falha esperado é T1. \nCom os cálculos do código: ");
		tipoFalha(Cx, Cy);

		// Teste com os dados de entrada que obtivemos
		Cx = -7.32;
		Cy = -5.64;
		System.out.printf(
				"\n\nPara os valores de centroide de (-7.35, -5.79), obtidos com nosso primeiro algoritmo, "
				+ "o tipo de falha esperado é T1. \nCom os cálculos do código: ");
		tipoFalha(Cx, Cy);

		// Testes para cada região do Pentágono de Duval
		System.out.printf(
				"\n\n\n\nINÍCIO DOS TESTES PARA CENTROIDES DE PONTOS DE INTERSEÇÕES OU PONTOS PASSÍVEIS DE ERROS");

		System.out.print("\n\n\n**** TESTES PARA PD ****");
		Cx = -0.5;
		Cy = 25.0;
		System.out.printf("\n\n(%.2f, %.2f)PD", Cx, Cy);
		tipoFalha(Cx, Cy);

		Cx = -1.0;
		Cy = 33.0;
		System.out.printf("\n(%.2f, %.2f)PD", Cx, Cy);
		tipoFalha(Cx, Cy);

		Cx = 0.0;
		Cy = 24.5;
		System.out.printf("\n(%.2f, %.2f)PD", Cx, Cy);
		tipoFalha(Cx, Cy);

		System.out.print("\n\n\n**** TESTES PARA S **** ");
		Cx = -10.0;
		Cy = 10.0;
		System.out.printf("\n\n(%.2f, %.2f)S", Cx, Cy);
		tipoFalha(Cx, Cy);

		Cx = -2.0;
		Cy = 33.0;
		System.out.printf("\n(%.2f, %.2f)S", Cx, Cy);
		tipoFalha(Cx, Cy);

		Cx = -2.0;
		Cy = 24.5;
		System.out.printf("\n(%.2f, %.2f)S", Cx, Cy);
		tipoFalha(Cx, Cy);

		Cx = -35.0;
		Cy = 3.2;
		System.out.printf("\n(%.2f, %.2f)S", Cx, Cy);
		tipoFalha(Cx, Cy);

		Cx = -37.9;
		Cy = 12.4;
		System.out.printf("\n(%.2f, %.2f)S", Cx, Cy);
		tipoFalha(Cx, Cy);

		Cx = -38.0;
		Cy = 12.4;
		System.out.printf("\n(%.2f, %.2f)S", Cx, Cy);
		tipoFalha(Cx, Cy);

		System.out.print("\n\n\n**** TESTES PARA T1 **** ");
		Cx = -1.0;
		Cy = -1.0;
		System.out.printf("\n\n(%.2f, %.2f)T1 mini", Cx, Cy);
		tipoFalha(Cx, Cy);

		Cx = -25.0;
		Cy = -20.0;
		System.out.printf("\n(%.2f, %.2f)T1", Cx, Cy);
		tipoFalha(Cx, Cy);

		Cx = -35.0;
		Cy = 3.1;
		System.out.printf("\n(%.2f, %.2f)T1", Cx, Cy);
		tipoFalha(Cx, Cy);

		Cx = -23.5;
		Cy = -32.4;
		System.out.printf("\n(%.2f, %.2f)T1", Cx, Cy);
		tipoFalha(Cx, Cy);

		System.out.print("\n\n\n**** TESTES PARA T2 ****");
		Cx = -10.0;
		Cy = -25.0;
		System.out.printf("\n\n(%.2f, %.2f)T2", Cx, Cy);
		tipoFalha(Cx, Cy);

		Cx = -22.5;
		Cy = -32.4;
		System.out.printf("\n(%.2f, %.2f)T2", Cx, Cy);
		tipoFalha(Cx, Cy);

		System.out.print("\n\n\n**** TESTES PARA T3 ****");
		Cx = 10.0;
		Cy = -25.0;
		System.out.printf("\n\n(%.2f, %.2f)T3", Cx, Cy);
		tipoFalha(Cx, Cy);

		Cx = -6.0;
		Cy = -4.0;
		System.out.printf("\n(%.2f, %.2f)T3", Cx, Cy);
		tipoFalha(Cx, Cy);

		Cx = 1.0;
		Cy = -32.4;
		System.out.printf("\n(%.2f, %.2f)T3", Cx, Cy);
		tipoFalha(Cx, Cy);

		Cx = 23.5;
		Cy = -32.4;
		System.out.printf("\n(%.2f, %.2f)T3", Cx, Cy);
		tipoFalha(Cx, Cy);

		System.out.print("\n\n\n**** TESTES PARA D2 ****");
		Cx = 20.0;
		Cy = -10.0;
		System.out.printf("\n\n(%.2f, %.2f)D2", Cx, Cy);
		tipoFalha(Cx, Cy);

		Cx = 5.0;
		Cy = 10.0;
		System.out.printf("\n(%.2f, %.2f)D2", Cx, Cy);
		tipoFalha(Cx, Cy);

		Cx = 0.0;
		Cy = 1.5;
		System.out.printf("\n(%.2f, %.2f)D2", Cx, Cy);
		tipoFalha(Cx, Cy);

		Cx = 0.0;
		Cy = -3.0;
		System.out.printf("\n(%.2f, %.2f)D2", Cx, Cy);
		tipoFalha(Cx, Cy);

		Cx = 24.3;
		Cy = -30.0;
		System.out.printf("\n(%.2f, %.2f)D2", Cx, Cy);
		tipoFalha(Cx, Cy);

		Cx = 32.0;
		Cy = -6.1;
		System.out.printf("\n(%.2f, %.2f)D2", Cx, Cy);
		tipoFalha(Cx, Cy);

		Cx = 4.0;
		Cy = 16.0;
		System.out.printf("\n(%.2f, %.2f)D2", Cx, Cy);
		tipoFalha(Cx, Cy);

		System.out.print("\n\n\n**** TESTES PARA D1 ****");

		Cx = 20.0;
		Cy = 20.0;
		System.out.printf("\n\n(%.2f, %.2f)D1", Cx, Cy);
		tipoFalha(Cx, Cy);

		Cx = 38.0;
		Cy = 12.0;
		System.out.printf("\n(%.2f, %.2f)D1", Cx, Cy);
		tipoFalha(Cx, Cy);

		Cx = 0.5;
		Cy = 10.0;
		System.out.printf("\n(%.2f, %.2f)D1mini", Cx, Cy);
		tipoFalha(Cx, Cy);

		Cx = 0.0;
		Cy = 40.0;
		System.out.printf("\n(%.2f, %.2f)D1mini", Cx, Cy);
		tipoFalha(Cx, Cy);

		sc.close();

	}

}
