package M6.UF2.Activitat5;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "movimientos", schema = "damas")
@IdClass(MovimientosEntityPK.class)
public class MovimientosEntity {
    private int idMovimiento;
    private int idPartida;
    private int filaOrigen;
    private int columnaOrigen;
    private int filaDestino;
    private int columnaDestino;

    @Id
    @Column(name = "idMovimiento")
    public int getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(int idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    @Id
    @Column(name = "idPartida")
    public int getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(int idPartida) {
        this.idPartida = idPartida;
    }

    @Basic
    @Column(name = "filaOrigen")
    public int getFilaOrigen() {
        return filaOrigen;
    }

    public void setFilaOrigen(int filaOrigen) {
        this.filaOrigen = filaOrigen;
    }

    @Basic
    @Column(name = "columnaOrigen")
    public int getColumnaOrigen() {
        return columnaOrigen;
    }

    public void setColumnaOrigen(int columnaOrigen) {
        this.columnaOrigen = columnaOrigen;
    }

    @Basic
    @Column(name = "filaDestino")
    public int getFilaDestino() {
        return filaDestino;
    }

    public void setFilaDestino(int filaDestino) {
        this.filaDestino = filaDestino;
    }

    @Basic
    @Column(name = "columnaDestino")
    public int getColumnaDestino() {
        return columnaDestino;
    }

    public void setColumnaDestino(int columnaDestino) {
        this.columnaDestino = columnaDestino;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovimientosEntity that = (MovimientosEntity) o;
        return idMovimiento == that.idMovimiento && idPartida == that.idPartida && filaOrigen == that.filaOrigen && columnaOrigen == that.columnaOrigen && filaDestino == that.filaDestino && columnaDestino == that.columnaDestino;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMovimiento, idPartida, filaOrigen, columnaOrigen, filaDestino, columnaDestino);
    }
}
