public class ConversionHistorial {
    private String tipo;
    private double valorOriginal;
    private double valorConvertido;

    public ConversionHistorial(String tipo, double valorOriginal, double valorConvertido) {
        this.tipo = tipo;
        this.valorOriginal = valorOriginal;
        this.valorConvertido = valorConvertido;
    }

    @Override
    public String toString() {
        return tipo + ": " + valorOriginal + " -> " + valorConvertido;
    }
}
