package M6.UF2.Activitat5;

import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.metamodel.EntityType;

import java.util.Map;

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
        try{
            session = getSession();
            session.beginTransaction();

            PartidaEntity partida = new PartidaEntity();
            partida.setGanador("X");

            session.save(partida);
            session.getTransaction().commit();

            Tablero tablero = new Tablero();
            jugador = "blanco";

            do {
                MovimientosEntity movimiento = new MovimientosEntity();

                System.out.println("Turno jugador: " + jugador);

                tablero.mostrar();
                tablero.moverFicha(partida.getIdPartida(), movimiento);
                cambiarTurno();

                session.beginTransaction();
                session.save(movimiento);
                session.getTransaction().commit();

            } while(tablero.partidaEnCurso());

            // poner ganador de partida y guardarla

        } finally{
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
