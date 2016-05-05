package inventario;

public class ModeloInventario1 {
	private double demanda;
	private double cOrdenar;// los costos
	private double cInventario;
	
	private double cantidadOp; //cantidad optima en el inventario
	private double cTotal;
	private double invMedio; //inventario medio
	
	private double t; //tasa de consumo
	private double f; //grecuencia
	
	
	private double cparte1, cparte2;
	
	public ModeloInventario1(double demanda, double cOrdenar, double cInvetario) {
		// TODO Auto-generated constructor stub
		this.demanda = demanda;
		this.cOrdenar = cOrdenar;
		this.cInventario = cInvetario;
		modelo1();
	}
	
	public double cantidadOptima(double demanda_, double cOrdenar_, double cInventario_)
	{
		return Math.sqrt((2*demanda_*cOrdenar_)/cInventario_);
	}
	
	public double costoTotal(double cant, double demanda_, double cOrdenar_, double cInventario_)//dado una cantidad optima determiar el costo total
	{
		return (cant/2)*cInventario_ + (demanda_/cant)*cOrdenar_;
	}
	
	public double costoTotal(double cant)//dado una cantidad determinar el costo total
	{
		cparte1 = (cant/2)*cInventario;
		cparte2 = (demanda/cant)*cOrdenar;
		return cparte1+cparte2;
	}
	
	public void modelo1()
	{
		cantidadOp = cantidadOptima(demanda, cOrdenar, cInventario);
		cTotal =  costoTotal(cantidadOp, demanda, cOrdenar, cInventario);
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
	
	public double getTasa()
	{
		return t;
	}
	
	public double getFrecuencia()
	{
		return f;
	}
	
	public double getCInventario()
	{
		return cparte1;
	}
	public double getCOrdenar()
	{
		return cparte2;
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
