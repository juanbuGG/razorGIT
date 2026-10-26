package modelo;
import java.time.LocalDate; import java.time.LocalTime;
public class Agendamento {
 private final LocalDate data; private final LocalTime hora;
 private final Cliente cliente; private final Servico servico; private final Profissional profissional;
 private final String observacoes;
 public Agendamento(LocalDate data,LocalTime hora,Cliente cliente,Servico servico,Profissional profissional,String observacoes){
 this.data=data;this.hora=hora;this.cliente=cliente;this.servico=servico;this.profissional=profissional;this.observacoes=observacoes;
 }
 public LocalDate getData(){return data;} public LocalTime getHora(){return hora;}
 public Cliente getCliente(){return cliente;} public Servico getServico(){return servico;}
 public Profissional getProfissional(){return profissional;} public String getObservacoes(){return observacoes;}
}
