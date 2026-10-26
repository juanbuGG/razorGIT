package app;
import modelo.*; import repositorio.*; import servico.AgendamentoService;
import java.time.LocalDate; import java.time.LocalTime;
public class Main {
 public static void main(String[] args){
  AgendamentoService sistema=new AgendamentoService(new AgendamentoMemoriaRepositorio());
  Cliente cliente=new Cliente(1,"Juan","49999999999");
  Servico corte=new Servico("Corte de cabelo"); Profissional barbeiro=new Profissional("Carlos");
  LocalDate data=LocalDate.now().plusDays(1); LocalTime hora=LocalTime.of(14,0);
  Agendamento a=sistema.agendar(data,hora,cliente,corte,barbeiro,"Primeira visita");
  conferir(sistema.listar().size()==1,"Cadastro e listagem");
  conferir(a.getCliente().getNome().equals("Juan"),"Dados do cliente");
  boolean conflito=false;
  try{sistema.agendar(data,hora,cliente,corte,barbeiro,"");}catch(IllegalArgumentException e){conflito=true;}
  conferir(conflito,"Bloqueio de horario duplicado");
  boolean passado=false;
  try{sistema.agendar(LocalDate.now().minusDays(1),hora,cliente,corte,barbeiro,"");}catch(IllegalArgumentException e){passado=true;}
  conferir(passado,"Bloqueio de data passada");
  System.out.println("Todos os testes passaram. Total de agendamentos: "+sistema.listar().size());
 }
 private static void conferir(boolean condicao,String teste){if(!condicao)throw new AssertionError(teste);System.out.println("OK - "+teste);}
}
