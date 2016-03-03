package LYZS;

import java.text.DecimalFormat;

public class LYCalculate {
	//预估入选含税销售折扣额
	public static String hszk(double b,double c){
		DecimalFormat df = new DecimalFormat("#.00");
		double a = (b/100)*c;
		df.format(a);
		return df.format(a);
	}
}
