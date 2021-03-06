package at.spengergasse.essity.domian;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "delivery_notes")

public class Lieferschein extends AbstractPersistable<Long> {
@NotNull
@Column(name = "license_plate", nullable = false)
private String  kennzeichen;


@Column(name = "start_ts")
private LocalDateTime erstwiegungsTS;

    /**
     * Gewicht in KG
     */
    @Min(0) @Max(38000)
@Column(name = "start_weight")
private Long erstwiegungsGewicht;


@Column(name = "end_st")
private LocalDateTime zweitwiegungsTS;

    /**
     * Gewicht in KG
     */
    @Min(0) @Max(38000)
@Column(name = "end_weight")
private Long zweitwiegungsGewicht;
    /**
     * Gewicht in KG
     */
    @Min(0) @Max(38000)
@Column(name = "tara_weight")
private Long taraGewicht;

@Enumerated(EnumType.STRING)
private Qualitaet qualitaet;

@NotBlank
@Size(max = 12)
@Column(name = "description")
private String bezeichnung;

@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(foreignKey = @ForeignKey(name = "FK_delivery_notes_2_supplier"))
private Lieferfirma lieferfirma;

@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(foreignKey = @ForeignKey(name = ))
private Spedition spedition;

}
