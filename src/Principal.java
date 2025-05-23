import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ClienteParaSolicitudes cliente = new ClienteParaSolicitudes();
        TiposDeCambio tiposDeCambio = cliente.tiposDeCambio();
        ConversionRates tasas = tiposDeCambio.conversion_rates();

        List<ConversionHistorial> historial = new ArrayList<>();



        try {
            int salir = 0;
            while(salir != 7) {
                Conversor.exhibirMenu();
                var opcion = Integer.valueOf(lectura.next());

                if (opcion == 7) {
                    System.out.println("Saliendo del programa...");
                    return;
                }
                System.out.println("Ingrese el valor que desea convertir");
                var valor = Double.parseDouble(String.valueOf(lectura.next()));

                switch (opcion) {
                    case 1 -> {
                        double resultado = valor * tasas.ARS();
                        System.out.println(valor + " USD corresponde a " + valor  * tasas.ARS() + " ARS");
                        historial.add(new ConversionHistorial("USD a ARS",valor,resultado));
                    }
                    case 2 -> {
                        double resultado = valor / tasas.ARS();
                        System.out.println(valor + " ARS corresponde a " + valor  / tasas.ARS() + " USD");
                        historial.add(new ConversionHistorial("ARS a USD",valor,resultado));
                    }
                    case 3 -> {
                        double resultado = valor * tasas.BRL();
                        System.out.println(valor + " USD corresponde a " + valor  * tasas.BRL() + " BRL");
                        historial.add(new ConversionHistorial("USD a BRL",valor,resultado));
                    }
                    case 4 -> {
                        double resultado = valor / tasas.BRL();
                        System.out.println(valor + " BRL corresponde a " + valor  / tasas.BRL() + " USD");
                        historial.add(new ConversionHistorial("BRL a USD",valor,resultado));
                    }
                    case 5 -> {
                        double resultado = valor / tasas.COP();
                        System.out.println(valor + " COP corresponde a " + valor  / tasas.COP() + " USD");
                        historial.add(new ConversionHistorial("COP a USD",valor,resultado));
                    }
                    case 6 -> {
                        double resultado = valor * tasas.COP();
                        System.out.println(valor + " USD corresponde a " + valor  * tasas.COP() + " COP");
                        historial.add(new ConversionHistorial("USD a COP",valor,resultado));
                    }
                    default -> System.out.println("Opcion no valida");


                }
                System.out.println("Historial de conversiones:");

                for(ConversionHistorial conversion : historial) {
                    System.out.println("-" + conversion);
                }
            }

        } catch (NumberFormatException e){
            System.out.println("Numero no encontrado");
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando la Aplicacion");
        }
    }
}
