package Sesion7;

/*
* A 15000 20000 80 110 150
* B 20000 25000 50 100 120
* C 15000 18000 50 50 90*/

import java.text.DecimalFormat;
import java.util.Scanner;

public class MainS7 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Cantidad de productos: ");
		int cant = input.nextInt();
		input.nextLine();

		Producto[] arrProductos = new Producto[cant];

		for(int i = 0; i < cant; i++){
			System.out.println("Ingrese los sgtes datos en una linea y separados por espacio");
			System.out.println("código, el precio de compra, el precio de venta, la cantidad en bodega, la cantidad mínima requerida y la cantidad máxima de inventario permitida");
			String datos[] = input.nextLine().split(" ");
			int precCom = Integer.parseInt(datos[1]);
			int precVen = Integer.parseInt(datos[2]);
			int cantBod = Integer.parseInt(datos[3]);
			int cantMin = Integer.parseInt(datos[4]);
			int cantMax = Integer.parseInt(datos[5]);

			Producto p = new Producto(datos[0], precCom, precVen, cantBod, cantMin, cantMax);
			arrProductos[i] = p;
			
			System.out.println("Solicitar pedido: " + (p.solicitarPedido() ? "SI" : "NO"));
			System.out.println("");
		}

		//Porducto mayor cantidades en bodega
		int mayor = arrProductos[0].getCantBodega();
		String codigoMayor = arrProductos[0].getCodigo();
		for(int i = 0; i < arrProductos.length; i++){
			if(arrProductos[i].getCantBodega() > mayor){
				mayor = arrProductos[i].getCantBodega();
				codigoMayor = arrProductos[i].getCodigo();
			}
		}
		System.out.println("");
		System.out.println("Producto con mayor cant en Bodega: " + codigoMayor);
		System.out.println("");

		//Total a pagar de un producto
		System.out.println("Ingrese codigo de producto a consultar el total a pagar: ");
		String codConsulta = input.nextLine();
		System.out.println("Ingrese las unidades a comprar: ");
		int undCompra = Integer.parseInt(input.nextLine());
		boolean encontrado = false;
		double totalPagar = 0;
		DecimalFormat formato = new DecimalFormat("#.00");
		for(int i = 0; i < arrProductos.length; i++){
			if(arrProductos[i].getCodigo().equalsIgnoreCase(codConsulta)){
				encontrado = true;
				totalPagar = arrProductos[i].totalAPagar(undCompra);
			}
		}
		System.out.println(encontrado ?( "Total a pagar: $" + formato.format(totalPagar)) : "No se encontró el codigo");
		System.out.println("");

		//Cambiar cant min requeridas
		System.out.println("Ingrese codigo de producto a modificar las unidades requeridas en bodega: ");
		String codConsultaCantReq = input.nextLine();
		System.out.println("Ingrese las unidades minimas en bodega: ");
		int cantMin = Integer.parseInt(input.nextLine());
		boolean encontrado_2 = false;
		int cantAnt = 0;
		int pos = 0;
		for(int i = 0; i < arrProductos.length; i++){
			if(arrProductos[i].getCodigo().equalsIgnoreCase(codConsultaCantReq)){
				encontrado_2 = true;
				pos = i;
				cantAnt = arrProductos[i].getCantRequeridas();
				arrProductos[i].setCantRequeridas(cantMin);
			}
		}
		if(encontrado_2){
			System.out.println("Articulo" + codConsultaCantReq + " actualizado\n");
			System.out.println("Antes - Cantidades minimas requeridas en bodegas: " + cantAnt);
			System.out.println("Ahora - Cantidades minimas requeridas en bodegas: " + arrProductos[pos].getCantRequeridas());
		}
		else{
			System.out.println("Articulo " + codConsultaCantReq + " no encontrado");
		}

	}
}
