package obliczenia;

public class DenHa {

	//double alfa, beta, gama, fi1, fi2, fi3, l1, l2, l3, z;
	static double cos(double angle) {
		return Math.cos(Math.toRadians(angle));
	}

	static double sin(double angle) {
		return Math.sin(Math.toRadians(angle));
	}

	static double zaokr(double v) {
		v = Math.round(v * 10);
		v = v / 10;
		return v;
	}

	static double[][] transX(int d) {
		double[][] trans = new double[4][4];

		trans[0][0] = 1;
		trans[0][1] = 0;
		trans[0][2] = 0;
		trans[0][3] = d;

		trans[1][0] = 0;
		trans[1][1] = 1;
		trans[1][2] = 0;
		trans[1][3] = 0;

		trans[2][0] = 0;
		trans[2][1] = 0;
		trans[2][2] = 1;
		trans[2][3] = 0;

		trans[3][0] = 0;
		trans[3][1] = 0;
		trans[3][2] = 0;
		trans[3][3] = 1;

		return trans;
	}

	static double[][] transZ(int d) {
		double[][] trans = new double[4][4];

		trans[0][0] = 1;
		trans[0][1] = 0;
		trans[0][2] = 0;
		trans[0][3] = 0;

		trans[1][0] = 0;
		trans[1][1] = 1;
		trans[1][2] = 0;
		trans[1][3] = 0;

		trans[2][0] = 0;
		trans[2][1] = 0;
		trans[2][2] = 1;
		trans[2][3] = d;

		trans[3][0] = 0;
		trans[3][1] = 0;
		trans[3][2] = 0;
		trans[3][3] = 1;

		return trans;
	}

	static double[][] RotZ(double fi) {
		double[][] trans = new double[4][4];

		trans[0][0] = cos(fi);
		trans[0][1] = -sin(fi);
		trans[0][2] = 0;
		trans[0][3] = 0;

		trans[1][0] = sin(fi);
		trans[1][1] = cos(fi);
		trans[1][2] = 0;
		trans[1][3] = 0;

		trans[2][0] = 0;
		trans[2][1] = 0;
		trans[2][2] = 1;
		trans[2][3] = 0;

		trans[3][0] = 0;
		trans[3][1] = 0;
		trans[3][2] = 0;
		trans[3][3] = 1;

		return trans;
	}

	static double[][] RotX(double fi) {
		double[][] trans = new double[4][4];

		trans[0][0] = 1;
		trans[0][1] = 0;
		trans[0][2] = 0;
		trans[0][3] = 0;

		trans[1][0] = 0;
		trans[1][1] = cos(fi);
		trans[1][2] = -sin(fi);
		trans[1][3] = 0;

		trans[2][0] = 0;
		trans[2][1] = sin(fi);
		trans[2][2] = cos(fi);
		trans[2][3] = 0;

		trans[3][0] = 0;
		trans[3][1] = 0;
		trans[3][2] = 0;
		trans[3][3] = 1;

		return trans;
	}

	static double[][] miks(double[][] mat1, double[][] mat2) { // mnozenie
																// macierzy
		double[][] tab = new double[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				tab[i][j] = 0;
				for (int k = 0; k < 4; k++) {
					tab[i][j] += (mat1[i][k] * mat2[k][j]);
					tab[i][j] = zaokr(tab[i][j]);
				}
			}
		}
		return tab;
	}

	public void readMatrix(double[][] mat) { // wyswietlanie macierzy
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++)
				System.out.print(zaokr(mat[i][j]) + "   ");

			System.out.println("");
		}

	}

	public static double[][] t1,t2,t3,t4,t5;
	public static double[][] t12,t13,t14,t15;
	static public double[][] dh(double fi1, double fi2, double fi3, int d1, int d2,
			int d3, int z) {
		//double[][] tab = new double[4][4];

		t1 = miks(RotZ(fi1), transZ(d1));

		t2 = miks(RotX(-90), RotZ(fi2));

		t3 = miks(transX(d2), RotZ(fi3));

		t4 = miks(transX(d3), RotZ(-90));

		t5 = miks(RotX(-90), transZ(z));

		t12 = miks(t1, t2);
		t13 = miks(t12, t3);
		t14 = miks(t13, t4);
		t15 = miks(t14, t5);

		return t15;
	}
	/*public DenHa(){
		//dh(0, -45, 45, 1, 1, 1, 1);
	}//*/
	public static void main(String[] args) {

		//new DenHa().readMatrix(dh(0, -45, 45, 1, 1, 1, 1));
	}

}
