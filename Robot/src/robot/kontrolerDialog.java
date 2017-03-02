package robot;

import javax.swing.JDialog;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import obliczenia.DenHa;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import java.awt.Toolkit;

public class kontrolerDialog extends JDialog {

	/**
	 * 
	 */
	private JSlider slider, slider_1, slider_2, slider_3;
	private JLabel lblNewLabel_3, lblNewLabel_2, lblNewLabel_1, lblNewLabel;

	public double alfa, beta, gama;
	int l1, l2, l3, z;

	public static double nalfa, nbeta, ngama, nz;

	private static final long serialVersionUID = -3975623360776501117L;
	private JButton btnReset;
	private JTextField podstawa;
	private JTextField przegub1;
	private JTextField przegub2;
	private JTextField posuw;
	private JButton btnStop;
	private JButton btnAn;

	grafika g;

	public kontrolerDialog(final grafika g, final configLoader cl,
			final prostaKin pk) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(kontrolerDialog.class.getResource("/robot/ikony/joys.png")));
		setAlwaysOnTop(true);
		setResizable(false);
		setTitle("Kontroler");
		setBounds(950, 100, 550, 220);
		setVisible(false);

		this.g = g;
		slider = new JSlider();
		slider_1 = new JSlider();
		slider_2 = new JSlider();
		slider_3 = new JSlider();

		loadProp(cl);
		loadStartProp(cl);

		savePos(cl);

		setDH(pk, setDH(cl));

		lblNewLabel_3 = new JLabel("Ob\u00F3t w podstawie: "
				+ slider.getValue());

		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				lblNewLabel_3.setText("Ob\u00F3t w podstawie: "
						+ slider.getValue());
				// podstawa.setText(""+slider.getValue());
				g.rotGama(slider.getValue());
				savePos(cl);
				setDH(pk, setDH(cl));

			}
		});

		lblNewLabel_2 = new JLabel("Obr\u00F3t w pierwszym przegubie: "
				+ slider_1.getValue());
		slider_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				lblNewLabel_2.setText("Obr\u00F3t w pierwszym przegubie: "
						+ slider_1.getValue());
				// przegub1.setText(""+slider_1.getValue());
				g.rotAlfa(slider_1.getValue());
				savePos(cl);
				setDH(pk, setDH(cl));
			}
		});

		lblNewLabel_1 = new JLabel("Ob\u00F3r w drugim przegubie: "
				+ slider_2.getValue());
		slider_2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				lblNewLabel_1.setText("Ob\u00F3r w drugim przegubie: "
						+ slider_2.getValue());
				// przegub2.setText(""+slider_2.getValue());
				g.rotBeta(slider_2.getValue());
				savePos(cl);
				setDH(pk, setDH(cl));
			}
		});		lblNewLabel = new JLabel("Posuw: " + slider_3.getValue());
		slider_3.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				lblNewLabel.setText("Posuw: " + slider_3.getValue());
				// posuw.setText(""+slider_3.getValue());
				g.transZ(slider_3.getValue());
				savePos(cl);
				setDH(pk, setDH(cl));
			}
		});

		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loadStartProp(cl);
				//pp.setVels(cl.w2(), cl.w3(), cl.zv(), cl.poczAlfa(), cl.poczBeta(), cl.l2(), cl.l3(), cl.Z1());
			}
		});

		podstawa = new JTextField();
		podstawa.setColumns(10);

		przegub1 = new JTextField();
		przegub1.setColumns(10);

		przegub2 = new JTextField();
		przegub2.setColumns(10);

		posuw = new JTextField();
		posuw.setColumns(10);

		setTF();
		btnAn = new JButton("Start");
		btnAn.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {

				getN();
				System.out.println(b(gama - ngama));
				interpoluj(cl.w1(), b(gama - ngama), cl.w2(), b(alfa - nalfa),
						cl.w3(), b(beta - nbeta), cl.zv(), b(z - nz));

				t = new Thread(r);

				if (!t.isAlive()) {
					t.start();
				} else {
					t.resume();
				}
			}
		});

		btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				btnAn.setEnabled(true);
				btnStop.setEnabled(false);
				t.stop();
			}
		});
		btnStop.setEnabled(false);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout
				.setHorizontalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.TRAILING)
														.addGroup(
																Alignment.LEADING,
																groupLayout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								lblNewLabel_3)
																						.addComponent(
																								lblNewLabel)
																						.addComponent(
																								lblNewLabel_2,
																								GroupLayout.DEFAULT_SIZE,
																								218,
																								Short.MAX_VALUE)
																						.addComponent(
																								lblNewLabel_1))
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								przegub1,
																								GroupLayout.PREFERRED_SIZE,
																								54,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								podstawa,
																								GroupLayout.PREFERRED_SIZE,
																								54,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								przegub2,
																								GroupLayout.PREFERRED_SIZE,
																								54,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								posuw,
																								GroupLayout.PREFERRED_SIZE,
																								54,
																								GroupLayout.PREFERRED_SIZE))
																		.addGap(34))
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGap(74)
																		.addComponent(
																				btnStop)
																		.addPreferredGap(
																				ComponentPlacement.RELATED,
																				93,
																				Short.MAX_VALUE)
																		.addComponent(
																				btnAn)
																		.addGap(19)))
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.TRAILING)
														.addGroup(
																groupLayout
																		.createParallelGroup(
																				Alignment.TRAILING,
																				false)
																		.addComponent(
																				slider_3,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(
																				slider_2,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(
																				slider,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(
																				slider_1,
																				GroupLayout.DEFAULT_SIZE,
																				214,
																				Short.MAX_VALUE))
														.addComponent(btnReset))
										.addContainerGap()));
		groupLayout
				.setVerticalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																groupLayout
																		.createParallelGroup(
																				Alignment.BASELINE)
																		.addComponent(
																				lblNewLabel_3)
																		.addComponent(
																				podstawa,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE))
														.addComponent(
																slider,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(11)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																groupLayout
																		.createParallelGroup(
																				Alignment.BASELINE)
																		.addComponent(
																				lblNewLabel_2)
																		.addComponent(
																				przegub1,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE))
														.addComponent(
																slider_1,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																groupLayout
																		.createParallelGroup(
																				Alignment.BASELINE)
																		.addComponent(
																				lblNewLabel_1)
																		.addComponent(
																				przegub2,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE))
														.addComponent(
																slider_2,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								lblNewLabel)
																						.addComponent(
																								slider_3,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE))
																		.addPreferredGap(
																				ComponentPlacement.RELATED,
																				22,
																				Short.MAX_VALUE)
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								btnReset)
																						.addComponent(
																								btnAn)
																						.addComponent(
																								btnStop)))
														.addComponent(
																posuw,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addContainerGap()));
		getContentPane().setLayout(groupLayout);
	}

	void savePos(configLoader cl) {
		gama = slider.getValue();
		alfa = slider_1.getValue();
		beta = slider_2.getValue();
		z = slider_3.getValue();

		l1 = cl.l1();
		l2 = cl.l2();
		l3 = cl.l3();
	}

	void setTF() {

		przegub1.setText("0");
		posuw.setText("0");
		podstawa.setText("0");
		przegub2.setText("0");
	}

	@SuppressWarnings("static-access")
	double[][] setDH(configLoader cl) {

		l1 = cl.l1();
		l2 = cl.l2();
		l3 = cl.l3();
		return new DenHa().dh(gama, alfa - 90, beta, l1, l2, l3, z);
	}

	void setDH(prostaKin pk, double[][] tab) {
		DefaultTableModel dtm = (DefaultTableModel) pk.table.getModel();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				dtm.setValueAt(tab[i][j], i, j);
			}
		}
	}

	// */
	void loadProp(configLoader cl) { // ³adowanie zakresów
		slider.setMaximum(cl.gama1());
		slider.setMinimum(cl.gama0());

		slider_1.setMaximum(cl.alfa1());
		slider_1.setMinimum(cl.alfa0());

		slider_2.setMaximum(cl.beta1());
		slider_2.setMinimum(cl.beta0());

		slider_3.setMaximum(cl.Z1());
		slider_3.setMinimum(cl.Z0());

	}

	void loadStartProp(configLoader cl) { // ³adowanie pozycji pocz¹tkowej

		slider.setValue(cl.poczGama());
		slider_1.setValue(cl.poczAlfa());
		slider_2.setValue(cl.poczBeta());
		slider_3.setValue(cl.poczZ());
	}

	// animacje

	Runnable r;
	Thread t;

	
	  public void interpoluj(double w1, final double r1, double w2, final
	  double r2, double w3, final double r3, double v, final double ppz) {
	  
	  final int gamaT = (int) b((1 / (w1 / 1000))); final int alfaT = (int)
	  b((1 / (w2 / 1000))); final int betaT = (int) b((1 / (w3 / 1000))); final
	  int pp = (int) b(1 / (v / 1000));
	  
	  System.out.println(gamaT + " - " + alfaT + " - " + betaT + " - " + pp); r
	  = new Runnable() {
	  
	  public void run() { btnStop.setEnabled(true); btnAn.setEnabled(false);
	  
	  for (int i = 0; i < r1; i++) { if (ngama < gama) gama -= 1; else gama +=
	  1; slider.setValue((int) gama); try { Thread.sleep(gamaT); } catch
	  (InterruptedException e) { // TODO Auto-generated // catch block
	  e.printStackTrace(); } }
	  
	 for (int i = 0; i < r2; i++) { if (nalfa < alfa) alfa -= 1; else alfa +=
	 1; slider_1.setValue((int) alfa); try { Thread.sleep(alfaT); } catch
	  (InterruptedException e) { // TODO Auto-generated // catch block
	  e.printStackTrace(); } }
	  
	  for (int i = 0; i < (int) r3; i++) { if (nbeta < beta) beta -= 1; else
	  beta += 1; slider_2.setValue((int) beta); try { Thread.sleep(betaT); }
	  catch (InterruptedException e) { // TODO Auto-generated // catch block
	  e.printStackTrace(); } }
	  
	  for (int i = 0; i < (int) ppz; i++) { if (nz < z) z -= 1; else z += 1;
	  slider_3.setValue((int) z); try { Thread.sleep(pp); } catch
	  (InterruptedException e) { // TODO Auto-generated // catch block
	  e.printStackTrace(); } }
	  
	  btnStop.setEnabled(false); btnAn.setEnabled(true);
	  
	  } }; }//
	 
	double b(double v) { // zwraca wartoœæ bezwzglêdn¹
		if (v >= 0)
			return v;
		else
			return -v;
	}

	int max(int a, int b, int c, int d) { // zwraca najwiêszk¹ wartoœæ
		if (a >= b && a >= c && a >= d)
			return a;
		else if (b >= a && b >= c && b >= d)
			return b;
		else if (c >= a && c >= b && c >= d)
			return c;
		else if (d >= a && d >= b && d >= c)
			return d;
		else
			return a;
	}

	void getN() {
		ngama = Double.parseDouble(podstawa.getText());
		nalfa = Double.parseDouble(przegub1.getText());
		nbeta = Double.parseDouble(przegub2.getText());
		nz = Double.parseDouble(posuw.getText());
	}

}
