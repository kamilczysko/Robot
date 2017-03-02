package robot;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import obliczenia.DenHa;
import obliczenia.prPrzysp;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class PredkosciPrzyspieszenia extends JDialog {

	/**
	 * Launch the application.
	 */
	prPrzysp pp;
	public static void main(String[] args) {
		try {
			//PredkosciPrzyspieszenia dialog = new PredkosciPrzyspieszenia();
			//dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			//dialog.setVisible(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create t
	 * he dialog.
	 */
	double [] pl ;
	JLabel label1;
	int  var;
	JLabel lblPrdkoWypadkowa;
	
	public PredkosciPrzyspieszenia( double w2,double w3, double v,  double fi2,
			double fi3,double l2, double l3,double z) {
		
		setResizable(false);
		setTitle("Pr\u0119dko\u015Bci");
		setBounds(1000, 450, 640, 535);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		{
			JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			getContentPane().add(tabbedPane, BorderLayout.CENTER);
			{
				JPanel panel = new JPanel();
				tabbedPane.addTab("Prêdkoœci", null, panel, null);
				panel.setLayout(null);
				{
					JLabel lblNewLabel = new JLabel("");
					lblNewLabel.setIcon(new ImageIcon(PredkosciPrzyspieszenia.class.getResource("/robot/ikony/schematpredkosci.png")));
					lblNewLabel.setBounds(279, 11, 340, 425);
					panel.add(lblNewLabel);
				}
				{
					JLabel lblPrdkociLiniowe = new JLabel("Pr\u0119dko\u015Bci liniowe:");
					lblPrdkociLiniowe.setFont(new Font("Arial", Font.PLAIN, 15));
					lblPrdkociLiniowe.setBounds(10, 161, 126, 14);
					panel.add(lblPrdkociLiniowe);
				}
				{
					label1 = new JLabel();
					label1.setToolTipText("mm/s");
					label1.setFont(new Font("Arial", Font.BOLD, 15));
					label1.setBounds(10, 191, 259, 14);
					panel.add(label1);
					
				}
				
				lblPrdkoWypadkowa = new JLabel("Pr\u0119dko\u015B\u0107 wypadkowa: "+var/100);
				lblPrdkoWypadkowa.setFont(new Font("Arial", Font.PLAIN, 15));
				lblPrdkoWypadkowa.setBounds(10, 216, 259, 14);
				panel.add(lblPrdkoWypadkowa);
			}
		}
		setVels(w2,w3,v,fi2,fi3,l2,l3,z);
	}
	public void setVels(double w2,double w3, double v, double fi2,
			double fi3,double l2, double l3,double z){
		
		pp = new prPrzysp(w2,w3,v,fi2,fi3,l2,l3,z);
		pl= pp.predkosci(w2,w3,fi2,fi3,l2,l3,z);
		label1.setText(("[ "+pl[0]+" , "+pl[1]+" , "+pl[2] +" ]"));
		var = (int)((Math.sqrt(Math.pow(pl[0], 2)+Math.pow(pl[1], 2)+Math.pow(pl[2], 2))*100));
		lblPrdkoWypadkowa.setText("Pr\u0119dko\u015B\u0107 wypadkowa: "+var/100);
	}
}
