package Proyecto;

import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

/* Requisitos
        Diseñar y codificar una aplicación informática para una compañia de gestion aeroportuaria satisfaciendo los siguientes requisitos

        Para cada aeropuerto es necesario saber:
        A.- Todas las compañías de vuelos que operan en él
        B.- Nombre del aeropuerto, la ciudad donde se ubica y el país al que pertenece

        Cada Compañía se caracteriza por el nombre y la lista de vuelos que ofrece
        Los vuelos están definidos por su identificador, la ciudad de origen, la ciudad de destino, el precio del viaje, la lista de pasajeros, el número máximo de pasajeros permitidos en el vuelo y el número real de pasajeros que ha reservado asiento en el avión

        Los aeropuertos puede ser privados o públicos
        A.- Los aeropuertos privados tiene una serie de empresas que los patrocinan y es necesario saber el nombre de cada una de esas empresas
        B.- Para los aeropuertos públicos se requiere saber la cantidad de dinero correspondiente a la subvención gubernamental

        Se necesita gestionar también la información de los pasajeros
        a para cada pasajero se necesita saber nombre , número de pasaporte y nacionalidad

        La aplicación tendrá un menú con las siguientes opciones
        1.- Consultar los aeropuertos gestionados, indicando separadamente los aeropuertos públicos y privados. Para cada uno de ellos deberá mostrar su nombre, la ciudad de ubicación y el país al que pertenece.
        2.- Visualizar las empresas que patrocinan un determinado aeropuerto en cada caso sea privado, o la cuantía de la subvención en caso de que se trate de un aeropuerto público.
        3.- Para un determinado aeropuerto, se debe poder mostrar la lista de compañías que vuelan desde ese aeropuerto
        4.- Para una determinada compañía que opera en un aeropuerto concreto, listar todos los posibles vuelos que dicha compañía ofrece, mostrando su identificador, la ciudad de origen y destino y el precio del vuelo.
        5.- Mostrar todos los posibles vuelos (identificador) que parten de una ciudad de origen a otra ciudad destino (indicadas por el usuario) y mostrar su precio
*/
public class Principal {
    static Scanner entrada = new Scanner(System.in);
    final static int num = 4;
    static Aeropuerto[] aeropuertos = new Aeropuerto[num];

    public static void main(String[] args) {
        insertarDatosAeropuerto(aeropuertos);
        menu();

    }

    public static void insertarDatosAeropuerto(@NotNull Aeropuerto  aero[]) {
        aero[0] = new AeropuertoPublico("Jorge Chavez", "Lima", "Peru", 800000);
        aero[0].insertarCompania(new Compania("AeroPeru"));
        aero[0].insertarCompania(new Compania("LATAM"));

        aero[0].getCompania("AeroPeru").insertarVuelo(new Vuelo("IB20", "Lima", "Mexico", 2600, 100));
        aero[0].getCompania("AeroPeru").insertarVuelo(new Vuelo("IC36", "Lima", "Buenos Aires", 1900, 130));
        aero[0].getCompania("LATAM").insertarVuelo(new Vuelo("L840", "Lima", "Londres", 8560.90, 240));

        aero[0].getCompania("AeroPeru").getVuelo("IB20").insertarPasajero(new Pasajero("Marco", "GJ49","Mexicano"));

        //aero[0].getCompania("AeroPeru").getVuelo("IB20").insertarPasajero(new Pasajero("Marco", "JCAMFJ", "Mexicano"));
        aero[0].getCompania("AeroPeru").getVuelo("IB20").insertarPasajero(new Pasajero("Marco", "JCAMFJ", "Mexicano"));
        aero[0].getCompania("AeroPeru").getVuelo("IB20").insertarPasajero(new Pasajero("Dulce", "DDSDL8", "Mexicana"));
        aero[0].getCompania("AeroPeru").getVuelo("IC36").insertarPasajero(new Pasajero("Juan", "JAB590", "Mexicano"));
        aero[0].getCompania("LATAM").getVuelo("L840").insertarPasajero(new Pasajero("Andrea", "ARN5945", "Peruana"));

        aero[1] = new AeropuertoPublico("Benito Juarez", "Tijuana", "Mexico", 500000);
        aero[1].insertarCompania(new Compania("AeroMexico"));
        aero[1].insertarCompania(new Compania("AeroBus"));
        aero[1].getCompania("AeroMexico").insertarVuelo(new Vuelo("KSPGT", "Tijuana", "Guadalajara", 3800, 120));
        aero[1].getCompania("AeroMexico").insertarVuelo(new Vuelo("KVODR", "Tijuana", "Berlin", 10900, 230));
        aero[1].getCompania("AeroBus").insertarVuelo(new Vuelo("SPDk49", "Tijuana", "Londres", 8560.90, 240));

        aero[1].getCompania("AeroMexico").getVuelo("KSPGT").insertarPasajero(new Pasajero("Ricardo", "JCAMRRFJ", "Mexicana"));
        aero[1].getCompania("AeroMexico").getVuelo("KSPGT").insertarPasajero(new Pasajero("Alejandra", "DMSDL968", "Mexicana"));
        aero[1].getCompania("AeroMexico").getVuelo("KVODR").insertarPasajero(new Pasajero("Daniela", "JAB590", "Mexicana"));
        aero[1].getCompania("AeroBus").getVuelo("SPDk49").insertarPasajero(new Pasajero("Martha", "ARN5945", "Peruana"));

        aero[2] = new AeropuertoPublico("Lincon", "San Diego", "Estados Unidos", 600000);
        aero[2].insertarCompania(new Compania("AeroUsa"));
        aero[2].insertarCompania(new Compania("AirWashington"));
        aero[2].getCompania("AeroUsa").insertarVuelo(new Vuelo("SD9485", "Tijuana", "Guadalajara", 3800, 120));
        aero[2].getCompania("AeroUsa").insertarVuelo(new Vuelo("SD9873", "Tijuana", "Berlin", 10900, 230));
        aero[2].getCompania("AirWashington").insertarVuelo(new Vuelo("SPDk49", "Tijuana", "Londres", 8560.90, 240));
        aero[2].getCompania("AeroUsa").getVuelo("SD9485").insertarPasajero(new Pasajero("Pedro", "SOKF94uj", "Estadounidense"));
        aero[2].getCompania("AeroUsa").getVuelo("SD9485").insertarPasajero(new Pasajero("Sthephan", "SJKO048", "Estadounidense"));
        aero[2].getCompania("AeroUsa").getVuelo("SD9873").insertarPasajero(new Pasajero("Kimberly", "SKNGJ0987", "Estadounidense"));
        aero[2].getCompania("AirWashington").getVuelo("SPDk49").insertarPasajero(new Pasajero("Maria", "MSXOJDF08", "Mexicana"));

/*
        aero[3] = new AeropuertoPublico("Lazaro Cardenas", "Monterrey", "Mexico", 6000000);
        aero[3].insertarCompania(new Compania("AeroMexico"));
        aero[3].insertarCompania(new Compania("AeroBus"));
        aero[3].getCompania("AeroMexico").insertarVuelo(new Vuelo("MSKFD947", "Monterrey", "Guadalajara", 3800, 120));
        aero[3].getCompania("AeroMexico").insertarVuelo(new Vuelo("MTKFL95", "Monterrey", "Berlin", 10900, 230));
        aero[3].getCompania("AeroBus").insertarVuelo(new Vuelo("KROG639", "Monterrey", "Londres", 8560.90, 240));
        aero[3].getCompania("AeroMexico").getVuelo("MSKFD947").insertarPasajero(new Pasajero("Alejandro", "MKGPS598", "Mexicona"));
        aero[3].getCompania("AeroMexico").getVuelo("MSKFD947").insertarPasajero(new Pasajero("Danna", "MPKN49580", "Mexicana"));
        aero[3].getCompania("AeroMexico").getVuelo("KROG639").insertarPasajero(new Pasajero("Oscar", "MDOSJ5984", "Mexiccano"));
        aero[3].getCompania("AeroBus").getVuelo("KROG639").insertarPasajero(new Pasajero("Alberto", "MLRJ0658", "Mexicano"));
*/
        aero[3] = new AeropuertoPrivado("Marquez de Leon", "La Paz", "Mexico");
        aero[3].insertarCompania(new Compania("AeroMexico"));
        aero[3].insertarCompania(new Compania("AeroBus"));
        aero[3].getCompania("AeroMexico").insertarVuelo(new Vuelo("LSDO95", "La Paz", "Guadalajara", 1800, 120));
        aero[3].getCompania("AeroMexico").insertarVuelo(new Vuelo("LGF956", "La Paz", "guadalajara", 10900, 230));
        aero[3].getCompania("AeroBus").insertarVuelo(new Vuelo("LTJX86", "La Paz", "Tijuana", 8560.90, 240));
        aero[3].getCompania("AeroMexico").getVuelo("LSDO95").insertarPasajero(new Pasajero("Mariana", "NFFTPS598", "Mexicana"));
        aero[3].getCompania("AeroMexico").getVuelo("LSDO95").insertarPasajero(new Pasajero("Cristina", "NFJON49580", "Mexicana"));
        aero[3].getCompania("AeroMexico").getVuelo("LGF956").insertarPasajero(new Pasajero("Emilio", "SDKSJ5984", "Mexiccano"));
        aero[3].getCompania("AeroBus").getVuelo("LTJX86").insertarPasajero(new Pasajero("Diego", "MALS0658", "Mexicano"));


    }

    public static void menu() {
        String nombreAeropuerto, nombreCompania, origen, destino;
        int opcion;
        Aeropuerto aeropuerto;
        Compania compania;
        do {
            System.out.println("\t. :::::::M E N U::::::: .");
            System.out.println("1.- Ver aeropuertos gestionados");
            System.out.println("2.- Ver empresas (privado) o subvencionada (publico)");
            System.out.println("3.- Lista de compania de un aeropuerto");
            System.out.println("4.- Lista de vuelos por compania ");
            System.out.println("5.- Listar posibles vuelos de origen a destinos");
            System.out.println("6.- Salir");
            System.out.println("7.- Opcion");
            opcion = entrada.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("");
                    mostrarDatosAeropuertos(aeropuertos);
                    break;
                case 2:
                    System.out.println("");
                    mostrarPatrocinio(aeropuertos);
                    break;
                case 3:
                    entrada.nextLine();
                    System.out.println("\n Digite el nombre del aeropuerto: ");
                    nombreAeropuerto = entrada.nextLine();
                    aeropuerto = buscarAeropuerto(nombreAeropuerto, aeropuertos);
                    if (aeropuerto == null) {
                        System.out.println("El aeropuerto no existe");

                    } else {
                        mostrarCompanias(aeropuerto);

                    }

                    break;
                case 4:
                    System.out.println("\n Digite el nombre dle aeropuerto");
                    nombreAeropuerto = entrada.nextLine();
                    aeropuerto = buscarAeropuerto(nombreAeropuerto, aeropuertos);
                    if (aeropuerto == null) {
                        System.out.println("El aeropueto no existe");
                    } else {
                        System.out.println("\n Digite el nombre de la compania");
                        nombreCompania = entrada.nextLine();
                        compania = aeropuerto.getCompania(nombreCompania);
                        mostrarVuelos(compania);
                    }
                    break;
                case 5:
                    entrada.nextLine();
                    System.out.println("\n Digite la ciudad origen: ");
                    origen = entrada.nextLine();
                    System.out.println("Digite la ciudad destino: ");
                    destino = entrada.nextLine();
                    mostrarVueloOrigenDestino(origen, destino, aeropuertos);
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Error, se equivoco de opcion de menu");

            }
            System.out.println("");
        } while (opcion != 6);
    }

    public static void mostrarDatosAeropuertos(@NotNull Aeropuerto aeropuertos[]) {
        for (int i = 0; i < aeropuertos.length; i++) {
            if (aeropuertos[i] instanceof AeropuertoPrivado) {
                System.out.println("Aeropuerto Privado");
                System.out.println("Nombre: " + aeropuertos[i].getNombre());
                System.out.println("Ciudad: " + aeropuertos[i].getCiudad());
                System.out.println("Pais: " + aeropuertos[i].getPais());
            } else {
                System.out.println("Aeropuerto Publico");
                System.out.println("Nombre: " + aeropuertos[i].getNombre());
                System.out.println("Ciudad: " + aeropuertos[i].getCiudad());
                System.out.println("Pais: " + aeropuertos[i].getPais());
            }
            System.out.println("");
        }
    }

    public static void mostrarPatrocinio(@NotNull Aeropuerto aeropuertos[]) {
        String empresas[];
        for (int i = 0; i < aeropuertos.length; i++) {
            if (aeropuertos[i] instanceof AeropuertoPrivado) {
                System.out.println("Aeropuerto privado: " + aeropuertos[i].getNombre());
                empresas = ((AeropuertoPrivado) aeropuertos[i]).getListaEmpresas();
                for (int j = 0; j < empresas.length; j++) {
                    System.out.println(empresas[j]);

                }
            } else {
                System.out.println("Aeropuerto publico: " + aeropuertos[i].getNombre());
                System.out.println("Subvencion: " + ((AeropuertoPublico) aeropuertos[i]).getSubvencion());
            }
        }
    }

    public static Aeropuerto buscarAeropuerto(String nombre, Aeropuerto aeropuertos[]) {
        boolean encontrado = false;
        int i = 0;
        Aeropuerto aero = null;
        while ((!encontrado) && (i < aeropuertos.length)) {
            if (nombre.equals(aeropuertos[i].getNombre())) {
                encontrado = true;
                aero = aeropuertos[i];
            }
            i++;
        }
        return aero;
    }

    public static void mostrarCompanias(@NotNull Aeropuerto aeropuerto) {
        System.out.println("\n Las companias del aeropuerto: " + aeropuerto.getNombre());
        for (int i = 0; i < aeropuerto.getNumCompania(); i++) {
            System.out.println(aeropuerto.getCompania(i).getNombre());

        }
    }

    public static void mostrarVuelos(@NotNull Compania compania) {
        Vuelo vuelo;
        System.out.println("Los vuelos de la compania: " + compania.getNombre());
        for (int i = 0; i < compania.getNumVuelo(); i++) {
            vuelo = compania.getVuelo(i);
            System.out.println("Identificador: " + vuelo.getIdentificador());
            System.out.println("Origen: " + vuelo.getCiudadOrigen());
            System.out.println("Destino: " + vuelo.getCiudadDestino());
            System.out.println("Precio: " + vuelo.getPrecio());
            System.out.println("");

        }
    }

    public static Vuelo[] buscarVuelosOrigenDestinos(String origen, String destino, @NotNull Aeropuerto aeropuertos[]) {
        Vuelo vuelo;
        int contador = 0;
        Vuelo listaVuelos[];

        for (int i = 0; i < aeropuertos.length; i++) {
            for (int j = 0; j < aeropuertos[i].getNumCompania(); j++) {
                for (int k = 0; k < aeropuertos[i].getCompania(j).getNumVuelo(); k++) {
                    vuelo = aeropuertos[i].getCompania(j).getVuelo(k);
                    if ((origen.equals(vuelo.getCiudadOrigen())) && (destino.equals(vuelo.getCiudadDestino()))) {
                        contador++;
                    }
                }
            }
        }
        listaVuelos = new Vuelo[contador];
        int q = 0;

        for (int i = 0; i < aeropuertos.length; i++) {
            for (int j = 0; j < aeropuertos[i].getNumCompania(); j++) {
                for (int k = 0; k < aeropuertos[i].getCompania(j).getNumVuelo(); k++) {
                    vuelo = aeropuertos[i].getCompania(j).getVuelo(k);
                    if ((origen.equals(vuelo.getCiudadOrigen())) && (destino.equals(vuelo.getCiudadDestino()))) {
                        listaVuelos[q] = vuelo;
                        q++;
                    }
                }
            }
        }
        return listaVuelos;
    }

    public static void mostrarVueloOrigenDestino(String origen, String destino, Aeropuerto aeropuertos[]) {
        Vuelo vuelos[];
        vuelos = buscarVuelosOrigenDestinos(origen, destino, aeropuertos);
        if (vuelos.length == 0) {
            System.out.println("No extiten el vuelos");

        } else {
            System.out.println("\nVuelos encontrados: ");
            for (int i = 0; i < vuelos.length; i++) {
                System.out.println("Identificador: " + vuelos[i].getIdentificador());
                System.out.println("Ciudad origen: " + vuelos[i].getCiudadOrigen());
                System.out.println("Ciudad destino: " + vuelos[i].getCiudadDestino());
                System.out.println("Precio: " + vuelos[i].getPrecio());
                System.out.println("");
            }
        }
    }
}
