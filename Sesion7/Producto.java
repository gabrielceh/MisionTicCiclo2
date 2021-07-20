package Sesion7;

public class Producto {
	private String codigo;
	private int precioCompra;
	private int precioVenta;
	private int cantBodega;
	private int cantRequeridas;
	private int cantMaxInventario;
	public static float porcDescuento = 0.01f;

	//Constructor
	public Producto(String codigo, int precioCompra, int precioVenta, int cantBodega, int cantRequeridas, int cantMaxInventario){
		this.codigo = codigo;
		this.precioCompra = precioCompra;
		this.precioVenta = precioVenta;
		this.cantBodega = cantBodega;
		this.cantRequeridas = cantRequeridas;
		this.cantMaxInventario = cantMaxInventario;
	}
	//SET
	public void setCodigo(String codigo){
		this.codigo = codigo;
	}
	public void setPrecioCompra(int precioCompra){
		this.precioCompra = precioCompra;
	}
	public void setPrecioVenta(int precioVenta) {
		this.precioVenta = precioVenta;
	}
	public void setCantBodega(int cantBodega) {
		this.cantBodega = cantBodega;
	}
	public void setCantRequeridas(int cantRequeridas) {
		if(cantRequeridas < 0){
			this.cantRequeridas = 0;
		}
		else{
			this.cantRequeridas = cantRequeridas;
		}
	}
	public void setCantMaxInventario(int cantMaxInventario) {
		this.cantMaxInventario = cantMaxInventario;
	}
	//GET
	public String getCodigo(){
		return this.codigo;
	}
	public int getPrecioCompra(){
		return this.precioCompra;
	}
	public int getPrecioVenta() {
		return precioVenta;
	}
	public int getCantBodega() {
		return cantBodega;
	}
	public int getCantRequeridas() {
		return cantRequeridas;
	}
	public int getCantMaxInventario() {
		return cantMaxInventario;
	}

	//Metodos
	public boolean solicitarPedido(){
		return cantBodega < cantRequeridas;
	}

	public double totalAPagar(int cantCompra){
		double pagar = cantCompra * precioCompra;
		pagar = pagar - (pagar * porcDescuento);

		return pagar;
	}
}
