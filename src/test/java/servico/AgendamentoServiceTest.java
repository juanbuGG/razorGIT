package servico;

import modelo.Cliente;
import modelo.Profissional;
import modelo.Servico;
import repositorio.AgendamentoMemoriaRepositorio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.*;

class AgendamentoServiceTest {
    private AgendamentoService service;
    private Cliente cliente;
    private Servico servico;
    private Profissional profissional;

    @BeforeEach
    void preparar() {
        service = new AgendamentoService(new AgendamentoMemoriaRepositorio());
        cliente = new Cliente(1, "Ana", "48999999999");
        servico = new Servico("Corte");
        profissional = new Profissional("Carlos");
    }

    @Test
    void deveCadastrarAgendamentoValido() {
        service.agendar(LocalDate.now().plusDays(1), LocalTime.of(10, 0), cliente, servico, profissional, "");
        assertEquals(1, service.listar().size());
    }

    @Test
    void deveBloquearHorarioDuplicadoParaMesmoProfissional() {
        LocalDate data = LocalDate.now().plusDays(1);
        LocalTime hora = LocalTime.of(10, 0);
        service.agendar(data, hora, cliente, servico, profissional, "");
        assertThrows(IllegalArgumentException.class,
            () -> service.agendar(data, hora, cliente, servico, profissional, ""));
        assertEquals(1, service.listar().size());
    }

    @Test
    void deveBloquearDataPassada() {
        assertThrows(IllegalArgumentException.class,
            () -> service.agendar(LocalDate.now().minusDays(1), LocalTime.of(10, 0), cliente, servico, profissional, ""));
    }

    @Test
    void deveBloquearClienteSemNome() {
        Cliente invalido = new Cliente(2, "", "48999999999");
        assertThrows(IllegalArgumentException.class,
            () -> service.agendar(LocalDate.now().plusDays(1), LocalTime.of(10, 0), invalido, servico, profissional, ""));
    }
}
