package co.com.poli.taller.backlog.model;

import lombok.Data;

import java.util.Date;

@Data
public class ProjectTask {
    private Long id;
    private String name;
    private String summary;
    private String acceptanceCriteria;
    private String status;
    private int priority;
    private Double hours;
    private Date startDate;
    private Date endDate;
    private String projectIdentifier;
}
