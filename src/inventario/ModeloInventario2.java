package inventario;

public class ModeloInventario2 {
	
	private double demanda;
	private double cOrdenar;// los costos
	private double cInventario;
	
	private double cTotal;
	private double cantidadOp; //cantidad optima en el inventario
	private double invMedio; //inventario medio
	
	private double t;
	private double f;
	
	private double x_L;//Cantidad m�xima de unidades en agotamiento
	private double x_S;//Inventario en mano, es decir lo que realmente se tiene.
	
	public ModeloInventario2(double x_L, double demanda, double cOrdenar, double cInvetario) {
		// TODO Auto-generated constructor stub
		this.demanda = demanda;
		this.cOrdenar = cOrdenar;
		this.cInventario = cInvetario;
		this.x_L = x_L;
		modelo1();
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
		t = cantidadOp/demanda;
		f = demanda/cantidadOp;
		invMedio = cantidadOp/2;
	}
	
	
	public double getCantidadOptima()
	{
		return cantidadOp;
	}
	
	public double getCostoTotal()
	{
		return cTotal;
	}

	public double getNivelOptimoInventario()
	{
		return x_S;
	}

	public double getTasa()
	{
		return t;
	}

	public double getFrecuencia()
	{
		return f;
	}

	public double getInventarioMedio()
	{
		return invMedio;
	}

	public double getPuntoReorden(double demora)
	{
		return t*demora;
	}
	
	public double getDemanda()
	{
		return demanda;
	}

	public  double getcOrdenar()
	{
		return  cOrdenar;
	}

	public  double getcInventario()
	{
		return  cInventario;
	}

}
