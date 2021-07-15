package Sesion5;

public class Producto {
	private String codigo;
	private int precioCompra;
	private int cantBodega;
	private int cantRequerida;

	public Producto(String codigo, int precioCompra, int cantBodega, int cantRequerida){
		this.codigo = codigo;
		this.precioCompra = precioCompra;
		this.cantBodega = cantBodega;
		this.cantRequerida = cantRequerida;
	}
	//Setters
	public void setCodigo(String codigo){
		this.codigo = codigo;
	}
	public void setPrecioCompra(int precioCompra){
		this.precioCompra = precioCompra;
	}
	public void setCantBodega(int cantBodega){
		this.cantBodega = cantBodega;
	}
	public void setCantRequerida(int cantRequerida){
		this.cantRequerida = cantRequerida;
	}
	//Getters
	public String getCodigo(){
		return this.codigo;
	}
	public int getPrecioCompra(){
		return this.precioCompra;
	}
	public int getCantBodega(){
		return this.cantBodega;
	}
	public int getCantRequerida(){
		return this.cantRequerida;
	}

	//Metodos
	public boolean solicitarPedido(){
		return cantBodega < cantRequerida;
	}

	@Override
	public String toString(){
		String cadena = "Codigo: " + codigo + "\n";
		cadena += "Precio compra: " + precioCompra + "\n";
		cadena += "Cant. Bodega: " + cantBodega + "\n";
		cadena += "Cant. Requeridas: " + cantRequerida + "\n";

		return cadena;
	}


}
