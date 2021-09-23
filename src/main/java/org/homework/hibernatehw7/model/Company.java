package org.homework.hibernatehw7.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"projects", "developers","customers"})
@ToString(exclude = {"projects","developers"})
@Entity
@Table(name = "companies")
public class Company implements BaseModel<Long> {

    private static final long serialVersionUID = 2028374651928374653L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "name", length = 30)
    private String name;

    @Column(name = "city", length = 40)
    private String city;

    @OneToMany(mappedBy = "company", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private Set<Project> projects;

    @OneToMany(mappedBy = "company", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private Set<Developer> developers;

    @OneToMany(mappedBy = "company", cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Set<Customer> customers;
}
