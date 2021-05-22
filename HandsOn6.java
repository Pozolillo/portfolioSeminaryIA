public class HandsOn{
	private double X[] = {0, 56,89,23,12,65,12,46,57,02};
	private double X2[] = {0, 67,90,12,43,78,1,50,76,34};
	private double Y[] = {9,67,23,144,2124,67,2331,890,766,1};
	private double a=0.0;
	private double a2=0.0;
	private void getAParametrer(double dataX, double dataY, double b, int n, double a){
		return ((dataY/n) - (b*(dataX/n)));
		
	}
	private double getBParametrer(double[] dataX, double[] dataY, double a){
		double sumXi = 0.0;
		double sumYi = 0.0;
		double sumXY = 0.0;
		double sumX2 = 0.0;
		double b = 0.0;
		for(int i=0;i<dataX.length;i++){
			sumXi += dataX[i];
			sumYi += dataY[i];
			sumXY += dataX[i]*dataY[i];
			sumX2 += dataX[i]*dataX[i];	
		}
		
		//Calculo del parametro b
		b = ((sumXY - ((sumXi*sumYi)/dataX.length))/(sumX2-((sumXi*sumXi)/dataX.length)));
		//Calculamos el parametro a
		a = getAParametrer(sumXi,sumYi,b,dataX.length,a);
		return b;
		
	}
	public String regresionLineal(){
		//Obtenemos parametro a
		int ciclo = 10;
		double b1 = getBParametrer(X,Y,a);
		double b2 = getBParametrer(X2,Y,a2);
		String regLineal= "Valor de a1 =" + a + "Valor de b1="+b1+"\n";
		regLineal+= "Valor de a2 =" + a2 + "Valor de b2="+b2+"\n";
		for(int i=0;i<X.length;i++){
			regLineal+="Cuando X es "+X[i]+" Y es "+ (a+(b1*X[i]))+(a2+(b2*X2[i]))+"\n";
		}
		return regLineal;
		 	
	}
	public static void main(String args[]){
		HandsOn regresion = new HandsOn();
		System.out.print(regresion.regresionLineal());	
	}
}
