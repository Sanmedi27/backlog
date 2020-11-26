package co.com.poli.taller.backlog.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

@Entity
@Table(name = "tbl_backlog")
public class BackLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "project_identifier")
    @NotEmpty(message = "El identificador de proyecto no debe ser vacio")
    private String projectIdentifier;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectIdentifier() {
        return projectIdentifier;
    }

    public void setProjectIdentifier(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BackLog backLog = (BackLog) o;
        return Objects.equals(id, backLog.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
