package entidades;
import java.time.LocalDateTime;
public class Reserva {
    private Usuario usuario; private EspacoFisico espaco;
    private LocalDateTime dataHoraInicio, dataHoraFim;
    public Reserva(Usuario usuario, EspacoFisico espaco, LocalDateTime inicio, LocalDateTime fim) {
        this.usuario = usuario; this.espaco = espaco;
        this.dataHoraInicio = inicio; this.dataHoraFim = fim;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public EspacoFisico getEspaco() {
        return espaco;
    }
    public LocalDateTime getDataHoraInicio() {
        return dataHoraInicio;
    }
    public LocalDateTime getDataHoraFim() {
        return dataHoraFim;
    }
}