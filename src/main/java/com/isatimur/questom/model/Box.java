package com.isatimur.questom.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by tisachenko on 01.09.15.
 */
@Entity
public class Box extends AbstractEntityId {

    @OneToOne
    @JoinColumn
    private User createdByUser;

    private String title;
    private String body;

    private BoxType type;

    @OneToOne
    @JoinColumn
    private BoxLocation location;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATION_TIME")
    private Date creationDate;

    private BoxMetric metric;

    private BoxStatus status;


}
