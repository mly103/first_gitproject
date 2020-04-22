package com.mly.democommon;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
@EqualsAndHashCode(of = "id")
public class BaseEntity implements Serializable {
    private static final long serialVersionId = 1L;
    @Id
    private long id;
    private Date createdOn;
    private String createdBy;
    private Date updatedOn;
    private String updateBy;
}
