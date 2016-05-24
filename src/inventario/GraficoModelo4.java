package inventario;

import java.util.ArrayList;

public class GraficoModelo4 {
	
	private ModeloInventario4 modelo4;
	
	
	ArrayList<Double> ejex = new ArrayList<Double>();
	
	
	public GraficoModelo4(ModeloInventario4 m1) {
		// TODO Auto-generated constructor stub
		
		this.modelo4 = m1;
		
	}
	
	
	public Double[] arreglox()
	{
		
		double cantidad = 0;
		
		while (cantidad < modelo4.getInvMax())
		{
			cantidad+= modelo4.getProduccion();
			ejex.add(cantidad);
			
			System.out.println(cantidad);
		}
		
		
		
		return null;
	}
	
	

}
