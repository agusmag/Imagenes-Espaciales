package imagenesEspaciales;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		String pathI = "./IN/LoteBase.txt";
		String pathO = "./OUT/LoteBase.txt";
		ImagenEspacial imagen = new ImagenEspacial(pathI);
		StringBuilder imagenComprimida, imagenDescomprimida = new StringBuilder();
		
		imagenComprimida = imagen.Comprimir();
		imagenDescomprimida = imagen.Descomprimir();
		imagen.Resolver(pathO, imagenComprimida, imagenDescomprimida);

	}

}
