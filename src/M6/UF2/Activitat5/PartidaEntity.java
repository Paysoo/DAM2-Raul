package M6.UF2.Activitat5;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "partida", schema = "damas")
public class PartidaEntity {
    private int idPartida;
    private String ganador;

    public PartidaEntity(String ganador) {
        this.ganador = ganador;
    }

    public PartidaEntity() {

    }

    @Id
    @GeneratedValue
    @Column(name = "idPartida")
    public int getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(int idPartida) {
        this.idPartida = idPartida;
    }

    @Basic
    @Column(name = "ganador")
    public String getGanador() {
        return ganador;
    }

    public void setGanador(String ganador) {
        this.ganador = ganador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PartidaEntity that = (PartidaEntity) o;
        return idPartida == that.idPartida && Objects.equals(ganador, that.ganador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPartida, ganador);
    }
}
