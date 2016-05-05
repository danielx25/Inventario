package inventario;

public class testmain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("hola mundo");
//		ModeloInventario1 modelo1 = new ModeloInventario1(100, 100, 0.02);
//		System.out.println();
//		System.out.println();
//		ModeloInventario2 modelo2 = new ModeloInventario2(0.75, 8000, 30, 3);
		
		
		ModeloInventario4 modelo4 = new ModeloInventario4(40000, 350, 3000, 400000);
		System.out.println("cantidad optima: "+modelo4.getCantidadOptima());
		System.out.println(modelo4.getInvMax());
		System.out.println("costo total: "+ modelo4.getCostoTotal());
	}

}
