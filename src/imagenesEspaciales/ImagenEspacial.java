package imagenesEspaciales;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ImagenEspacial {
	private String imagenComprimida;
	private String imagenDescomprimida;
	
	public ImagenEspacial(String pathI) throws FileNotFoundException{
		Scanner sc = new Scanner(new File(pathI));
		
		this.imagenDescomprimida = sc.nextLine();
		this.imagenComprimida = sc.nextLine();
		
		sc.close();
	}
	
	public StringBuilder Comprimir(){
		char [] array = this.imagenDescomprimida.toCharArray();
		char caracterActual;
		int repeticiones = 1;
		int j=0;
		
		StringBuilder cadenaComprimida = new StringBuilder();
		
		for (int i = 0; i < array.length; i++) {
			caracterActual = array[i];
			j = i+1;
			while (j < array.length && caracterActual == array[j]){
				repeticiones++;
				j++;
				i++;
			}
			if (repeticiones >= 4){
				cadenaComprimida.append("(" + caracterActual + repeticiones + ") ");
				repeticiones = 1;
			}else{
				for (int k = 0; k < repeticiones; k++) {
						cadenaComprimida.append(caracterActual);
				}
			}
		}
		
		System.out.println(cadenaComprimida);
		return cadenaComprimida;
	}
	
	public void Resolver(String pathO, StringBuilder cadenaComprimida, StringBuilder cadenaDescomprimida) throws IOException{
		PrintWriter pw = new PrintWriter(new FileWriter(pathO));
		pw.println(cadenaComprimida);
		pw.println(cadenaDescomprimida);
		pw.close();
	}
	
	public StringBuilder Descomprimir(){
		StringBuilder cadenaDescomprimida = new StringBuilder();
		char[] array = this.imagenComprimida.toCharArray();
		char caracterActual;
		int repeticiones;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == '('){
				i++;
				caracterActual = array[i];
				i++;
				repeticiones =array[i] - '0';
				i++;
				for (int j = 0; j < repeticiones; j++) {
					cadenaDescomprimida.append(caracterActual);
				}
			}else if(array[i] != ' ' || array[i] != ')'){
				cadenaDescomprimida.append(array[i]);
			}
		}
		System.out.println(cadenaDescomprimida);
		return cadenaDescomprimida;
	}

}
