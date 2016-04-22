package inventario;

public class ModeloInventario1 {
	private double demanda;
	private double cOrdenar;// los costos
	private double cInventario;
	
	private double cantidadOp; //cantidad optima en el inventario
	private double cTotal;
	
	private double frecuencia;
	private double tasa;
	
	
	public ModeloInventario1(double demanda, double cOrdenar, double cInvetario) {
		// TODO Auto-generated constructor stub
		this.demanda = demanda;
		this.cOrdenar = cOrdenar;
		this.cInventario = cInvetario;
		modelo1();
		System.out.println(cantidadOp);
		System.out.println(cTotal);
		System.out.println(frecuencia);
		System.out.println(tasa);
		System.out.println(costoTotal(150));
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
		return (cant/2)*cInventario + (demanda/cant)*cOrdenar;
	}
	
	public void modelo1()
	{
		cantidadOp = cantidadOptima(demanda, cOrdenar, cInventario);
		cTotal =  costoTotal(cantidadOp, demanda, cOrdenar, cInventario);
		frecuencia = cantidadOp/demanda;
		tasa = demanda/cantidadOp;
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
