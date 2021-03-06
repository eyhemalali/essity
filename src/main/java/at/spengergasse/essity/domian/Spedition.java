package at.spengergasse.essity.domian;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "carriers")

public class Spedition extends AbstractPersistable<Long> {

    @NotBlank
    @Size(min = 2, max = 75)
    @Column(name = "carriers_name", nullable = false)
    private String name;

    @NotBlank
    @Embedded
    private Adresse adresse;

    @NotBlank
    @Size(min = 2, max = 15)
    @Column(name = "phone_number", nullable = false)
    private String telefonNummer;


}
