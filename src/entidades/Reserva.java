package entidades;

import java.time.LocalDateTime;

public class Reserva {
    private Usuario usuario;
    private EspacoFisico espaco;
    private LocalDateTime dataHoraInicio, dataHoraFim;


    public Reserva(Usuario usuario, EspacoFisico espaco, LocalDateTime inicio, LocalDateTime fim) {
        this.usuario = usuario;
        this.espaco = espaco;
        this.dataHoraInicio = inicio;
        this.dataHoraFim = fim;
    }

    public Reserva(EspacoFisico espaco, LocalDateTime inicio) {
        this.espaco = espaco;
        this.dataHoraInicio = inicio;
        this.dataHoraFim = inicio.plusHours(1); // padrão: 1 hora
    }
    public void confirmarReserva() {
        System.out.println("Reserva confirmada de " + dataHoraInicio +
                " até " + dataHoraFim + " no espaço: " + espaco);
    }

    public void confirmarReserva(String mensagem) {
        System.out.println("Reserva confirmada de " + dataHoraInicio +
                " até " + dataHoraFim + " no espaço: " + espaco +
                ". Mensagem: " + mensagem);
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