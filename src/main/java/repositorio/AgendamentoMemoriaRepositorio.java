package repositorio;
import modelo.Agendamento; import java.util.ArrayList; import java.util.List;
import java.time.LocalDate; import java.time.LocalTime;
public class AgendamentoMemoriaRepositorio implements AgendamentoRepositorio {
 private final List<Agendamento> agendamentos=new ArrayList<>();
 public void salvar(Agendamento agendamento){agendamentos.add(agendamento);}
 public List<Agendamento> listar(){return new ArrayList<>(agendamentos);}
 public boolean existeHorario(String profissional,LocalDate data,LocalTime hora){
  for(Agendamento a:agendamentos){if(a.getProfissional().getNome().equalsIgnoreCase(profissional) && a.getData().equals(data) && a.getHora().equals(hora))return true;}
  return false;
 }
}
