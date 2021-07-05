package creating.apirest.digital.innovation.CreateApiRest.entidades;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class CadastroPessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String sobreNome;

    @Column(nullable = false, unique = true)
    private String cpf;

    private LocalDate birthday;

    @OneToMany(fetch = FetchType.LAZY, cascade ={ CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<CadastroPhones> phones = new ArrayList<>();
}
