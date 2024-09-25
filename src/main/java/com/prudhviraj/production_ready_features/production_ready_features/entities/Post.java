package com.prudhviraj.production_ready_features.production_ready_features.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Audited
public class Post extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String title;
    @Column(length = 5000)
    private String description;
}
