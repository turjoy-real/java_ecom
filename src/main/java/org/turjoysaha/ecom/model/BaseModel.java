package org.turjoysaha.ecom.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BaseModel {
    @Id
    @GeneratedValue(generator = "uuidGenerator")
//    @GenericGenerator(name = "uuidGenerator", strategy = "uuid4")
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private UUID id;
}
