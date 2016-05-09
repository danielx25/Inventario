package inventario;

public class ModeloInventario4 {
	
	private double demanda;
	private double cOrdenar;// los costos
	private double cInventario;
	private double produccion;// tasa produccion
	
	private double cantidadOp; //cantidad optima en el inventario
	private double cTotal;
	private double invMax; //inventario maximo
	private double invMedio; //inventario medio
	
	private double t;
	private double f;
	
	public ModeloInventario4(double demanda, double cOrdenar, double cInvetario,double produccion) {
		// TODO Auto-generated constructor stub
		this.demanda = demanda;
		this.cOrdenar = cOrdenar;
		this.cInventario = cInvetario;
		this.produccion = produccion;
		modelo1();
	}
	
	
	public double cantidadOptima(double demanda_, double cOrdenar_, double cInvetario_,double produccion_)
	{
		return Math.sqrt( (2*cOrdenar_*demanda_*produccion_)/(cInvetario_*(produccion_-demanda_)) );
	}
	
	public double inventarioMax(double demanda_, double produccion_, double cantidadOp_)
	{
		return (1- demanda_/produccion_)*cantidadOp_;
	}
	
	public double costoTotal(double cant, double demanda_,double produccion_,  double cOrdenar_, double cInventario_)//dado una cantidad optima determiar el costo total
	{
		return  (cOrdenar_*demanda_)/cant + cInventario_*cant*(produccion_- demanda_)/(2*produccion_);
	}
	
	public void modelo1()
	{
		cantidadOp = cantidadOptima(demanda, cOrdenar, cInventario, produccion);
		invMax = inventarioMax(demanda, produccion, cantidadOp);
		cTotal = costoTotal(cantidadOp, demanda, produccion, cOrdenar, cInventario);
		
		System.out.println(demanda);
		System.out.println(cOrdenar);
		System.out.println(cInventario);
		System.out.println(produccion);
		
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
	
	public double getInvMax()
	{
		return invMax;
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
	
	

}
