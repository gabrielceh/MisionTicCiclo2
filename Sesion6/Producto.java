package Sesion6;

public class Producto {
	private String codigo;
	private int precio, cantBodega, cantRequeridas, cantMaxInventario;
	public static float descuento = 0.01f;

	public Producto(String codigo, int precio, int cantBodega, int cantRequeridas, int cantMaxInventario){
		this.codigo = codigo;
		this.precio = precio;
		this.cantBodega = cantBodega;
		this.cantRequeridas = cantRequeridas;
		this.cantMaxInventario = cantMaxInventario;
	}
	//Getter
	public String getCodigo(){
		return codigo;
	}
	public int getPrecio(){
		return precio;
	}
	public int getCantBodega(){
		return cantBodega;
	}
	public int getCantRequeridas(){
		return cantRequeridas;
	}
	public int getCantMaxInventario(){
		return cantMaxInventario;
	}
	//Setter
	public void setCodigo(String codigo){
		this.codigo = codigo;
	}
	public void setPrecio(int precio){
		this.precio = precio;
	}
	public void setCantBodega(int cantBodega) {
		this.cantBodega = cantBodega;
	}
	public void setCantRequeridas(int cantRequeridas) {
		this.cantRequeridas = cantRequeridas;
	}
	public void setCantMaxInventario(int cantMaxInventario) {
		this.cantMaxInventario = cantMaxInventario;
	}


	//Metodos
	public boolean solicitarPedido(){
		return cantBodega < cantRequeridas;
	}

	public double totalAPagar(int cantCompra){
		double pagar = cantCompra * precio;
		pagar = pagar - (pagar * descuento);

		return pagar;
	}

}
