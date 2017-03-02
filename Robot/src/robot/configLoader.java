package robot;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.vecmath.Color3f;

public class configLoader {

	static FileReader fr;
	static String[][] conf;

	configLoader() {
		try {

			fr = new FileReader("src\\robot\\config");
			BufferedReader br = new BufferedReader(fr);
			conf = new String[33][2];
			int i = 0;
			String[] line;
			while (br.ready()) {
				line = br.readLine().split("#", 2);
				conf[i][0] = line[0];
				if (line[1].equals(""))
					conf[i][1] = null;
				else
					conf[i][1] = line[1];
				System.out.println(i + " - " + conf[i][1]);
				i++;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// kolor tla

	Color3f bgColor() {
		Color3f c = new Color3f(new Color(Integer.parseInt(conf[0][1])));
		return c;
	}

	Color bgColorbtn() {
		return new Color(Integer.parseInt(conf[0][1]));
	}

	// kolor kierunkowego œwiat³a

	Color3f dLightColor() {
		Color3f c = new Color3f(new Color(Integer.parseInt(conf[1][1])));
		return c;
	}

	Color dLightColorbtn() {
		return new Color(Integer.parseInt(conf[1][1]));
	}

	// kolor rozproszonego œwiat³a

	Color3f aLightColor() {
		Color3f c = new Color3f(new Color(Integer.parseInt(conf[2][1])));
		return c;
	}

	Color aLightColorbtn() {
		return new Color(Integer.parseInt(conf[2][1]));
	}

	
	
	Color czlonyColor() {
		return new Color(Integer.parseInt(conf[27][1]));
	}
		
	Color przegubyColor() {
		return new Color(Integer.parseInt(conf[28][1]));
	}
	
	Color podstawaColor() {
		return new Color(Integer.parseInt(conf[29][1]));
	}
	
	Color chwytakColor() {
		return new Color(Integer.parseInt(conf[30][1]));
	}
	
	Color srubyColor() {
		return new Color(Integer.parseInt(conf[31][1]));
	}
	
	Color podlogaColor() {
		return new Color(Integer.parseInt(conf[32][1]));
	}
	

	// zakres0 Teta1

	int gama0() {
		return Integer.parseInt(conf[4][1]);

	}

	// zakres0 Teta2

	int alfa0() {
		return Integer.parseInt(conf[5][1]);

	}

	// zakres0 Teta3

	int beta0() {
		return Integer.parseInt(conf[6][1]);

	}

	// zakres0 Z

	int Z0() {
		return Integer.parseInt(conf[7][1]);

	}

	// zakres Teta1

	int gama1() {
		return Integer.parseInt(conf[8][1]);

	}

	// zakres Teta2

	int alfa1() {
		return Integer.parseInt(conf[9][1]);

	}

	// zakres Teta3

	int beta1() {
		return Integer.parseInt(conf[10][1]);

	}

	// zakres Z

	int Z1() {
		return Integer.parseInt(conf[11][1]);

	}

	// poczatkowa teta1
	int poczGama() {
		return Integer.parseInt(conf[12][1]);
	}

	// poczatkowa teta2
	int poczAlfa() {
		return Integer.parseInt(conf[13][1]);
	}

	// poczatkowa teta3
	int poczBeta() {
		return Integer.parseInt(conf[14][1]);
	}

	// poczatkowy Z
	int poczZ() {
		return Integer.parseInt(conf[15][1]);
	}

	// predkosci i przyspieszenia

	// w1
	double w1() {
		return Double.parseDouble(conf[19][1]);
	}

	// w2
	double w2() {
		return Double.parseDouble(conf[20][1]);
	}

	// w3
	double w3() {
		return Double.parseDouble(conf[21][1]);
	}

	// e1
	double e1() {
		return Double.parseDouble(conf[22][1]);
	}

	// e2
	double e2() {
		return Double.parseDouble(conf[23][1]);
	}

	// e3
	double e3() {
		return Double.parseDouble(conf[24][1]);
	}

	// z prêdkoœæ
	double zv() {
		return Double.parseDouble(conf[25][1]);
	}

	// z przyspieszenie
	double za() {
		return Double.parseDouble(conf[26][1]);
	}

	
	//d³ugoœci cz³onów
	int l1() {
		return Integer.parseInt(conf[16][1]);
	}
	
	int l2() {
		return Integer.parseInt(conf[17][1]);
	}
	
	int l3() {
		return Integer.parseInt(conf[18][1]);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new configLoader();
		saveProp(null);
	}

	private static FileWriter fw;

	// zapis pojedynczej w³aœciwoœci
	public static void saveProp(String arg, String value) {

		String wholeText = "";

		String line;
		for (int i = 0; i < 33; i++) {
			line = "";
			if (conf[i][0].equals(arg)) {
				conf[i][1] = value;
			}
			line += conf[i][0] + "#" + conf[i][1];
			wholeText += line + "\n";
		}
		try {
			fw = new FileWriter("src/robot/config");
			fw.write(wholeText);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void saveProp(String[][] arg) {

		for (int i = 0; i < 33; i++) {
			for(int j = 0; j < 23; j++)
			saveProp(arg[j][0],arg[j][1]);
		}

	}

}
