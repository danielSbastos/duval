import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

// Código para cálculo do centroide do polígono irregular
public class AppCalcCentroide {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		double H2, C2H6, CH4, C2H4, C2H2; // gases
		double decH2, decC2H6, decCH4, decC2H4, decC2H2; // porcentagem relativa de cada gás com casa decimal
		double pH2, pC2H6, pCH4, pC2H4, pC2H2; // porcentagem relativa arredondada
		double xH2, xC2H6, xCH4, xC2H4, xC2H2; // coordenada x de cada gás
		double yH2, yC2H6, yCH4, yC2H4, yC2H2; // coordenada y de cada gás
		double A, Cx, Cy; // área do poligono irregular, coordenadas x e y do centróide

		// Solicitação de entrada de valores para cada gás
		System.out.print("Digite o valor em ppm de H2: ");
		H2 = sc.nextDouble();
		System.out.print("Digite o valor em ppm de C2H6: ");
		C2H6 = sc.nextDouble();
		System.out.print("Digite o valor em ppm de CH4: ");
		CH4 = sc.nextDouble();
		System.out.print("Digite o valor em ppm de C2H4: ");
		C2H4 = sc.nextDouble();
		System.out.print("Digite o valor em ppm de C2H2: ");
		C2H2 = sc.nextDouble();

		// Cálculo da porcentagem relativa de cada gás
		decH2 = (H2 / (H2 + CH4 + C2H6 + C2H4 + C2H2)) * 100;
		decCH4 = (CH4 / (H2 + CH4 + C2H6 + C2H4 + C2H2)) * 100;
		decC2H6 = (C2H6 / (H2 + CH4 + C2H6 + C2H4 + C2H2)) * 100;
		decC2H4 = (C2H4 / (H2 + CH4 + C2H6 + C2H4 + C2H2)) * 100;
		decC2H2 = (C2H2 / (H2 + CH4 + C2H6 + C2H4 + C2H2)) * 100;

		// Arredondando para ficar sem casa decimal
		BigDecimal bd1 = new BigDecimal(decH2).setScale(0, RoundingMode.HALF_EVEN);
		pH2 = bd1.doubleValue();

		BigDecimal bd2 = new BigDecimal(decCH4).setScale(0, RoundingMode.HALF_EVEN);
		pCH4 = bd2.doubleValue();

		BigDecimal bd3 = new BigDecimal(decC2H6).setScale(0, RoundingMode.HALF_EVEN);
		pC2H6 = bd3.doubleValue();

		BigDecimal bd4 = new BigDecimal(decC2H4).setScale(0, RoundingMode.HALF_EVEN);
		pC2H4 = bd4.doubleValue();

		BigDecimal bd5 = new BigDecimal(decC2H2).setScale(0, RoundingMode.HALF_EVEN);
		pC2H2 = bd5.doubleValue();

		// Cálculo das coordenadas x e y para cada gás
		// Coordenadas x e y para o gás H2
		xH2 = pH2 * Math.cos(1.5708); // 1.5708 radiano = 90 graus
		yH2 = pH2 * Math.sin(1.5708); // 1.5708 radiano = 90 graus

		// Coordenadas x e y para o gás C2H6
		xC2H6 = pC2H6 * Math.cos(2.82743); // 2.82743 radiano = 162 graus
		yC2H6 = pC2H6 * Math.sin(2.82743); // 2.82743 radiano = 162 graus

		// Coordenadas x e y para o gás CH4
		xCH4 = pCH4 * Math.cos(4.08407); // 4.08407 radiano = 234 graus
		yCH4 = pCH4 * Math.sin(4.08407); // 4.08407 radiano = 234 graus

		// Coordenadas x e y para o gás C2H4
		xC2H4 = pC2H4 * Math.cos(5.34071); // 5.34071 radiano = 306 graus
		yC2H4 = pC2H4 * Math.sin(5.34071); // 5.34071 radiano = 306 graus

		// Coordenadas x e y para o gás C2H2
		xC2H2 = pC2H2 * Math.cos(0.314159); // 0.314159 radiano = 18 graus
		yC2H2 = pC2H2 * Math.sin(0.314159); // 0.314159 radiano = 18 graus

		// Cálculo das coordenadas do centróide

		// Obtenção da área (A) do polígono irregular
		A = (((xH2 * yC2H6) - (xC2H6 * yH2)) + ((xC2H6 * yCH4) - (xCH4 * yC2H6)) + ((xCH4 * yC2H4) - (xC2H4 * yCH4))
				+ ((xC2H4 * yC2H2) - (xC2H2 * yC2H4)) + ((xC2H2 * yH2) - (xH2 * yC2H2))) / 2;

		// Obtenção da coordenada x do centróide
		Cx = (1 / (6 * A)) * ((xH2 + xC2H6) * (xH2 * yC2H6 - xC2H6 * yH2)
				+ (xC2H6 + xCH4) * (xC2H6 * yCH4 - xCH4 * yC2H6) + (xCH4 + xC2H4) * (xCH4 * yC2H4 - xC2H4 * yCH4)
				+ (xC2H4 + xC2H2) * (xC2H4 * yC2H2 - xC2H2 * yC2H4) + (xC2H2 + xH2) * (xC2H2 * yH2 - xH2 * yC2H2));

		// Obtenção da coordenada y do centróide
		Cy = (1 / (6 * A)) * ((yH2 + yC2H6) * (xH2 * yC2H6 - xC2H6 * yH2)
				+ (yC2H6 + yCH4) * (xC2H6 * yCH4 - xCH4 * yC2H6) + (yCH4 + yC2H4) * (xCH4 * yC2H4 - xC2H4 * yCH4)
				+ (yC2H4 + yC2H2) * (xC2H4 * yC2H2 - xC2H2 * yC2H4) + (yC2H2 + yH2) * (xC2H2 * yH2 - xH2 * yC2H2));

		System.out.printf("\nCoordenadas do centroide (Cx = %.2f, Cy = %.2f)", Cx, Cy);

		sc.close();

	}

}






