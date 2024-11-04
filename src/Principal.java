import java.util.Scanner;

public class Principal {
    public static void main(String[] args){

        Scanner lectura = new Scanner(System.in);
        ConsultarMoneda consultarMoneda = new ConsultarMoneda();
        Utilidades utilidades = new Utilidades();
        Monedas moneda;
        double cantidad;

        while (true){
            try{

                System.out.println(utilidades.menu());
                int opcion = lectura.nextInt();

                if (opcion == 7){
                    System.out.println("Finalizando el programa...");
                    break;
                }

                if (opcion==1){
                    System.out.println("Ingresa el valor que desea convertir: ");
                    cantidad = lectura.nextDouble();
                    moneda = consultarMoneda.convertir("USD", "ARS", cantidad);
                    System.out.println(moneda);

                    System.out.println("El valor "+cantidad+" [USD]"+" Corresponde al valor final de =>>> "+
                            moneda.conversion_result()+" [ARS]");
                }else if (opcion==2){
                    System.out.println("Ingresa el valor que desea convertir: ");
                    cantidad = lectura.nextDouble();
                    moneda = consultarMoneda.convertir("ARS", "USD", cantidad);
                    System.out.println(moneda);

                    System.out.println("El valor "+cantidad+" [ARS]"+" Corresponde al valor final de =>>> "+
                            moneda.conversion_result()+" [USD]");
                }else if (opcion==3){
                    System.out.println("Ingresa el valor que desea convertir: ");
                    cantidad = lectura.nextDouble();
                    moneda = consultarMoneda.convertir("USD", "BRL", cantidad);
                    System.out.println(moneda);

                    System.out.println("El valor "+cantidad+" [USD]"+" Corresponde al valor final de =>>> "+
                            moneda.conversion_result()+" [BRL]");
                }else if (opcion==4){
                    System.out.println("Ingresa el valor que desea convertir: ");
                    cantidad = lectura.nextDouble();
                    moneda = consultarMoneda.convertir("BRL", "USD", cantidad);
                    System.out.println(moneda);

                    System.out.println("El valor "+cantidad+" [BRL]"+" Corresponde al valor final de =>>> "+
                            moneda.conversion_result()+" [USD]");
                }else if (opcion==5){
                    System.out.println("Ingresa el valor que desea convertir: ");
                    cantidad = lectura.nextDouble();
                    moneda = consultarMoneda.convertir("USD", "COP", cantidad);
                    System.out.println(moneda);

                    System.out.println("El valor "+cantidad+" [USD]"+" Corresponde al valor final de =>>> "+
                            moneda.conversion_result()+" [COP]");
                }else if (opcion==6){
                    System.out.println("Ingresa el valor que desea convertir: ");
                    cantidad = lectura.nextDouble();
                    moneda = consultarMoneda.convertir("COP", "ARS", cantidad);
                    System.out.println(moneda);

                    System.out.println("El valor "+cantidad+" [COP]"+" Corresponde al valor final de =>>> "+
                            moneda.conversion_result()+" [USD]");
                }else {
                    System.out.println("Por favor elija una opción válida.");
                }
            }catch (Exception e){
                System.out.println("Ocurrió un error, por favor inténtelo de nuevo.");
                lectura.nextLine();
            }
        }

    }
}
