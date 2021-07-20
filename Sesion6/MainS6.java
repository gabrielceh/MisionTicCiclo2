package Sesion6;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MainS6 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Cantidad de productos: ");
		int cant = input.nextInt();
		input.nextLine();

		Producto[] arrProductos = new Producto[cant];

		for(int i = 0; i < cant; i++){
			System.out.print("Ingrese el codigo del producto: ");
			String codigo = input.nextLine();
			System.out.print("Ingrese el precio del producto: ");
			int precio = input.nextInt();
			System.out.print("Ingrese cant en bodega del producto: ");
			int cantBod = input.nextInt();
			System.out.print("Ingrese cant requeridas del producto: ");
			int cantReq = input.nextInt();
			System.out.print("Ingrese cant Max en inventario del producto: ");
			int cantMAxInv = input.nextInt();
			input.nextLine();

			Producto p = new Producto(codigo,precio,cantBod,cantReq,cantMAxInv);
			arrProductos[i] = p;
			//Alerta solicitar pedido
			if(arrProductos[i].solicitarPedido()){
				System.out.println("⚠⚠Se debe solicitar pedido para el producto de codigo: " + arrProductos[i].getCodigo());
				System.out.println("");
			}
			System.out.println("");
		}


		//Codigo producto mayor cantidad
		int mayorCant = arrProductos[0].getCantBodega();
		String codMayor = arrProductos[0].getCodigo();

		for(int i = 0; i < arrProductos.length; i++){
			if(arrProductos[i].getCantBodega() > mayorCant){
				mayorCant = arrProductos[i].getCantBodega();
				codMayor = arrProductos[i].getCodigo();
			}
		}
		System.out.println("Producto con mayor cantidad en bodega: " +  codMayor);

		//Mostrar total a pagar
		System.out.print("Digite codigo para realizar compra: ");
		String codBus = input.nextLine();
		DecimalFormat formato = new DecimalFormat("#.00");
		for(int i = 0; i < arrProductos.length; i++){
			if(arrProductos[i].getCodigo().equalsIgnoreCase(codBus)){
				System.out.print("Ingrese las unidades a comprar del producto cod:" + arrProductos[i].getCodigo() + ": ");
				int undCompra = input.nextInt();
				input.nextLine();
				arrProductos[i].totalAPagar(undCompra);
				System.out.println("Total a pagar del producto " + codBus + ": $" + formato.format(arrProductos[i].totalAPagar(undCompra)));
				break;
			}
		}



	}
}
