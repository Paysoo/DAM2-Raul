package M6.UF2.Activitat5;

import javafx.scene.control.Tab;
import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.metamodel.EntityType;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final SessionFactory ourSessionFactory;
    private static String jugador;

    public Main(String jugador) {
        this.jugador = jugador;
    }

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
        Session session = null;
        session = getSession();

        Scanner teclado = new Scanner(System.in);

        boolean salir = false;
        try {
            do {
                Tablero tablero = new Tablero();
                Ficha[][] fichas = tablero.getFichas();
                System.out.println("Selecciona una opcion:\n1 - Jugar\n2 - Historial\n3 - Salir");
                int opcion = teclado.nextInt();
                jugador = "blanco";

                switch (opcion) {
                    case 1:

                        session.beginTransaction();

                        PartidaEntity partida = new PartidaEntity();
                        partida.setGanador("X");

                        session.save(partida);
                        session.getTransaction().commit();

                        do {
                            MovimientosEntity movimiento = new MovimientosEntity();

                            System.out.println("Turno jugador: " + jugador);

                            tablero.mostrar();
                            tablero.moverFicha(partida.getIdPartida(), movimiento);
                            cambiarTurno();

                            session.beginTransaction();
                            session.save(movimiento);
                            session.getTransaction().commit();

                        } while (tablero.partidaEnCurso(partida));
                        tablero.mostrar();

                        session.beginTransaction();
                        session.update(partida);
                        session.getTransaction().commit();


                        break;

                    case 2:
                        Query queryPartidas = session.createQuery("SELECT p.id,p.ganador FROM PartidaEntity p");
                        List<Object[]> listPartidas = queryPartidas.list();
                        for (Object[] datos : listPartidas) {
                            System.out.println("Partida: " + datos[0] + " -- Ganador: " + datos[1]);
                        }
                        System.out.println("\nSelecciona la partida que quieres ver");
                        int partidaVer = teclado.nextInt();

                        Query queryMovimientos = session.createQuery("SELECT m.filaOrigen,m.columnaOrigen,m.filaDestino,m.columnaDestino FROM MovimientosEntity m WHERE m.idPartida = " + partidaVer);
                        List<Object[]> listMovimientos = queryMovimientos.list();

                        tablero.mostrar();
                        System.out.println("------------------\n");

                        for (Object[] datos : listMovimientos) {
                            Thread.sleep(3000);
                            int filaOrigen = (int) datos[0];
                            int columnaOrigen = (int) datos[1];
                            int filaDestino = (int) datos[2];
                            int columnaDestino = (int) datos[3];
                            char tipo = fichas[filaOrigen][columnaOrigen].getTipo();
                            String color = fichas[filaOrigen][columnaOrigen].getColor();

                            System.out.println("Jugador: "+ jugador + "\nDe: " + filaOrigen + " - " + columnaOrigen + "\nA: " + filaDestino + " - " + columnaDestino);

                            fichas[filaOrigen][columnaOrigen] = null;
                            fichas[filaDestino][columnaDestino] = new Ficha(tipo,color);
                            tablero.mostrar();
                            System.out.println("------------------\n");
                            cambiarTurno();

                        }

                        break;

                    case 3:
                        salir = true;
                        break;

                    default:
                        System.out.println("Selecciona una opcion valida");
                        break;
                }
            } while (!salir);
        } finally {
            session.close();
        }
    }

    // METODO CAMBIAR DE TURNO
    private static void cambiarTurno() {
        if (jugador.equals("blanco")) {
            jugador = "negro";

        } else {
            jugador = "blanco";

        }

    }

    public String getJugador() {
        return jugador;
    }

}
