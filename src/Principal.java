import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ClienteParaSolicitudes cliente = new ClienteParaSolicitudes();
            TiposDeCambio tiposDeCambio = cliente.tiposDeCambio();
            ConversionRates tasas = tiposDeCambio.conversion_rates();


        try {
            int salir = 0;
            while(salir != 7) {
                Conversor.exhibirMenu();
                var opcion = Integer.valueOf(lectura.next());

                if (opcion == 7) {
                    System.out.println("Saliendo del programa...");
                    break; // rompe el while y termina
                }
                System.out.println("Ingrese el valor que desea convertir");
                var valor = Double.parseDouble(String.valueOf(lectura.next()));

                switch (opcion) {
                    case 1 -> System.out.println(valor + " USD corresponde a " + valor  * tasas.ARS() + " ARS");
                    case 2 -> System.out.println(valor + " ARS corresponde a " + valor  / tasas.ARS() + " USD");
                    case 3 -> System.out.println(valor + " USD corresponde a " + valor  * tasas.BRL() + " BRL");
                    case 4 -> System.out.println(valor + " BRL corresponde a " + valor  / tasas.BRL() + " USD");
                    case 5 -> System.out.println(valor + " COP corresponde a " + valor  / tasas.COP() + " USD");
                    case 6 -> System.out.println(valor + " USD corresponde a " + valor  * tasas.COP() + " COP");
                    default -> System.out.println("Opcion no valida");


                }

            }

        } catch (NumberFormatException e){
            System.out.println("Numero no encontrado");
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando la Aplicacion");
        } finally {
            lectura.close();
        }
    }
}
