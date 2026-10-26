package servico;
import modelo.*; import repositorio.AgendamentoRepositorio;
import java.time.LocalDate; import java.time.LocalTime; import java.util.List;
public class AgendamentoService {
 private final AgendamentoRepositorio repositorio;
 public AgendamentoService(AgendamentoRepositorio repositorio){this.repositorio=repositorio;}
 public Agendamento agendar(LocalDate data,LocalTime hora,Cliente cliente,Servico servico,Profissional profissional,String observacoes){
  if(data==null||hora==null||cliente==null||servico==null||profissional==null)throw new IllegalArgumentException("Dados obrigatorios ausentes");
  if(cliente.getNome()==null||cliente.getNome().isBlank()||servico.getNome()==null||servico.getNome().isBlank()||profissional.getNome()==null||profissional.getNome().isBlank())throw new IllegalArgumentException("Nome obrigatorio");
  if(data.isBefore(LocalDate.now()))throw new IllegalArgumentException("Data no passado");
  if(repositorio.existeHorario(profissional.getNome(),data,hora))throw new IllegalArgumentException("Profissional ocupado neste horario");
  Agendamento a=new Agendamento(data,hora,cliente,servico,profissional,observacoes==null?"":observacoes);
  repositorio.salvar(a);return a;
 }
 public List<Agendamento> listar(){return repositorio.listar();}
}
