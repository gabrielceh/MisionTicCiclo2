package Sesion5;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Cantida de productos: ");
		int cant = input.nextInt();
		input.nextLine();

		Producto arrayProductos[] = new Producto[cant];

		for(int i = 0; i < cant; i++){
			System.out.print((i+1) + ". Ingrese el codigo, precio compra, cantidades en bodega, cantidades requeridas en una linea separados por espacio: ");
			String datos[] = input.nextLine().split(" ");
			String cod = datos[0];
			int prec = Integer.parseInt(datos[1]);
			int cantBod = Integer.parseInt(datos[2]);
			int cantReq = Integer.parseInt(datos[3]);
			Producto producto = new Producto(cod,prec,cantBod,cantReq);
			arrayProductos[i] = producto;
			System.out.println("");
		}

		//Alarma
		for(int i = 0; i < arrayProductos.length; i++){
			if(arrayProductos[i].solicitarPedido()){
				System.out.println("Se debe solicitar pedido al proveedor");
				System.out.println("⚠⚠Alarma para el producto con codigo " + arrayProductos[i].getCodigo() + "⚠⚠");
				System.out.println("");
			}
		}
		//Menor cant en bodega
		int menor = arrayProductos[0].getCantBodega();
		String codMenor = arrayProductos[0].getCodigo();
		for(int i = 0; i < arrayProductos.length; i++){
			if(arrayProductos[i].getCantBodega() < menor){
				menor = arrayProductos[i].getCantBodega();
				codMenor = arrayProductos[i].getCodigo();
			}
		}
		System.out.println("Codigo Producto con menor cantidad en bodega: " + codMenor);
		System.out.println("");

		for (int i = 0; i < arrayProductos.length; i++) {
			System.out.println(arrayProductos[i].toString());
		}

	}
}
