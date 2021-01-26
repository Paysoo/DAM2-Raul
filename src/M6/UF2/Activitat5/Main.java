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
            PartidaEntity partida = new PartidaEntity("X");
            session.save(partida);
            session.getTransaction().commit();

            MovimientosEntity movimiento1 = new MovimientosEntity(partida.getIdPartida(), 1, 2, 3, 4);


            session.beginTransaction();
            session.save(movimiento1);
            session.getTransaction().commit();

            MovimientosEntity movimiento2 = new MovimientosEntity(partida.getIdPartida(), 2, 3, 4, 5);
            session.beginTransaction();
            session.save(movimiento2);
            session.getTransaction().commit();

        } finally{
            session.close();
        }
    }
}