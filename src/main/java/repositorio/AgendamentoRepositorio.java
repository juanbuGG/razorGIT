package repositorio;
import modelo.Agendamento; import java.util.List;
public interface AgendamentoRepositorio {
 void salvar(Agendamento agendamento);
 List<Agendamento> listar();
 boolean existeHorario(String profissional,java.time.LocalDate data,java.time.LocalTime hora);
}
