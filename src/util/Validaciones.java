package util;

public class Validaciones {
	
	public static final String TEXTO = "[a-zA-Z·ÈÌÛ˙Ò¸¡…Õ”⁄—‹\\s]{2,50}";
	public static final String DNI = "[0-9]{8}";
	 
	public static final String STOCK = "\\d+";
	public static final String FECHA = "((19|20)\\d\\d)[-/](0?[1-9]|1[012])[-/](0?[1-9]|[12][0-9]|3[01])";
	public static final String CORREO = "[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})";
	public static final String RUC = "\\d{11}";
	public static final String PRECIO="\\d+.\\d";
	public static final String TELEFONO_PROVEEDOR = "[0-9]{9}";
}
