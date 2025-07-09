package servicos;

import entidades.*;
import excecoes.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ServicoReserva {
    private List<Reserva> reservas = new ArrayList<>();

    public void agendar(Reserva reserva) throws HorarioIndisponivelException, DiasExcedidosException {
        if (reserva.getUsuario() instanceof Aluno) {
            if (!reserva.getDataHoraInicio().toLocalDate().equals(reserva.getDataHoraFim().toLocalDate())) {
                throw new DiasExcedidosException("Alunos só podem reservar por 1 dia.");
            }
        }
        for (Reserva r : reservas) {
            if (r.getEspaco().equals(reserva.getEspaco())) {
                boolean conflito = !(reserva.getDataHoraFim().isBefore(r.getDataHoraInicio()) ||
                        reserva.getDataHoraInicio().isAfter(r.getDataHoraFim()));
                if (conflito) throw new HorarioIndisponivelException("Reserva já cadastrada nesse horário.");
            }
        }
        reservas.add(reserva);
    }

    public List<Reserva> getTodasReservas() {
        return reservas;
    }

    public void removerReserva(Reserva r) {
        reservas.remove(r);
    }
}
