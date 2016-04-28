package inventario;

public class ModeloInventario2 {
	
	private double demanda;
	private double cOrdenar;// los costos
	private double cInventario;
	
	private double cTotal;
	private double cantidadOp; //cantidad optima en el inventario
	
	private double frecuencia;
	private double tasa;
	
	private double x_L;//Cantidad máxima de unidades en agotamiento
	private double x_S;//Inventario en mano, es decir lo que realmente se tiene.
	
	public ModeloInventario2(double x_L, double demanda, double cOrdenar, double cInvetario) {
		// TODO Auto-generated constructor stub
		this.demanda = demanda;
		this.cOrdenar = cOrdenar;
		this.cInventario = cInvetario;
		this.x_L = x_L;
		modelo1();
		System.out.println("cantidad optima:         "+cantidadOp);
		System.out.println("nivel maximo inventario: "+x_S);
		System.out.println("costo total:             "+cTotal);
		System.out.println(frecuencia);
		System.out.println(tasa);
		System.out.println(costoTotal(150));
	}
	
	public double cantidadOptima(double x_L_,double demanda_, double cOrdenar_, double cInventario_)
	{
		//return Math.sqrt(2*cOrdenar_*demanda_*x_L_)*Math.sqrt((x_L_+cInventario_)/x_L_);
		return Math.sqrt(Math.pow(x_L_, 2) + (2*cOrdenar_*demanda_)/cInventario_);
	}
	
	public double cantidadOptimaInvetario(double x_L_,double demanda_, double cOrdenar_, double cInventario_)
	{
		//return Math.sqrt(2*cOrdenar_*demanda_*x_L_)*Math.sqrt((x_L_+cInventario_)/x_L_);
		return -x_L_+ Math.sqrt(Math.pow(x_L_, 2) + (2*cOrdenar_*demanda_)/cInventario_);
	}
	
	
	public double costoTotal(double x_L_, double x_S_, double demanda_, double cOrdenar_, double cInventario_)
	{
		//return Math.sqrt(2*cOrdenar_*demanda_*x_L_) * Math.sqrt(cInventario_/(cInventario_+x_L_));
		return (cOrdenar_*demanda_)/(x_S_+x_L_)+ cInventario_*Math.pow(x_S_, 2)/(2*(x_L_+x_S_));
	}
	
	public double costoTotal(double cant)
	{
		return (x_S/2)*cInventario + (demanda/x_S)*cOrdenar;
	}
	
	
	public void modelo1()
	{
		cantidadOp = cantidadOptima(x_L,demanda, cOrdenar, cInventario);
		x_S = cantidadOptimaInvetario(x_L, demanda, cOrdenar, cInventario);
		cTotal =  costoTotal(x_L, x_S, demanda, cOrdenar, cInventario);
		frecuencia = x_S/demanda;
		tasa = demanda/x_S;
	}
	
	
	public double getCantidadOptima()
	{
		return cantidadOp;
	}
	
	public double getCostoTotal()
	{
		return cTotal;
	}
	
	public double getFrecuencia()
	{
		return frecuencia;
	}
	
	public double getcuantasVecesPerdir()
	{
		return tasa;
	}
	
	

}
