package obliczenia;

public class prPrzysp {

	DenHa dh;

	double w1, w2, w3, v;
	double a1, a2, a3, av;
	double l1, l2, l3, z, fi1, fi2, fi3;

	public prPrzysp(double w2, double w3, double v,
			 double fi2,
			double fi3,  double l2, double l3,double z) {
		this.w1 = w1;
		this.w2 = w2;
		this.w3 = w3;
		this.v = v;
		this.a1 = a1;
		this.a2 = a2;
		this.a3 = a3;
		this.av = av;
		this.l1 = l1;
		this.l2 = l2;
		this.l3 = l3;
		this.fi1 = fi1;
		this.fi2 = fi2;
		this.fi3 = fi3;
		this.z = z;
		this.dh = dh;
	}

	public double [] predkosci(double w2,double w3,double fi2,double fi3,double l2, double l3, double z){
		double [] tab = new double [3];
		
		double vb = Math.toRadians(w2);
		double vbx = vb * Math.cos(Math.toRadians(fi2));
		double vbz = vb * Math.sin(Math.toRadians(fi2));
		
		double vcb = Math.toRadians(w2-w3) * (l3+z);
		double vcbx = vcb * Math.cos(Math.toRadians(fi2-fi3));
		double vcbz = vcb * Math.sin(Math.toRadians(fi2-fi3));

		
		double vkx = v/100 * Math.sin(Math.toRadians(fi2-fi3));
		double vkz = v/100 * Math.cos(Math.toRadians(fi2-fi3));
		
	
		
		tab[0] = ((int)((vbx+vcbx+vkx)*1000))/1000;
		tab[1] = 0;
		tab[2]= ((int)((vbz+vcbz+vkz)*1000))/1000;
		
	//	System.out.println("Predkosc w x: "+tab[0]);
				
		return tab;
	}
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// new prPrzysp(new DenHa());

	}

}
