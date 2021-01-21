package M6.UF2.Activitat5;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class MovimientosEntityPK implements Serializable {
    private int idMovimiento;
    private int idPartida;

    @Column(name = "idMovimiento")
    @Id
    public int getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(int idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    @Column(name = "idPartida")
    @Id
    public int getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(int idPartida) {
        this.idPartida = idPartida;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovimientosEntityPK that = (MovimientosEntityPK) o;
        return idMovimiento == that.idMovimiento && idPartida == that.idPartida;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMovimiento, idPartida);
    }
}
