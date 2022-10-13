package be.condorcet.api3projet.entities;
import lombok.*;
import javax.management.ConstructorParameters;
import javax.persistence.*;

@Data @NoArgsConstructor @AllArgsConstructor @RequiredArgsConstructor
@ToString
@Entity
@Table(name = "APICOURS", schema = "ora49", catalog = "orcl")
public class Cours {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cours_generator")
    @SequenceGenerator(name = "cours_generator", sequenceName = "APICOURS_SEQ", allocationSize = 1)
    private Integer idcours;
    @NonNull
    private String code;
    @NonNull
    private String intitule;
}
