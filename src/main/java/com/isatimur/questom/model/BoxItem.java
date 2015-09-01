package com.isatimur.questom.model;

import javax.persistence.Entity;

/**
 * Created by tisachenko on 01.09.15.
 */
@Entity
public class BoxItem extends AbstractEntityId {

//    @OneToOne
//    @JoinColumn
//    private Account createdByAccount;

    private String title;
    private String body;

    private BoxType type;

//    @OneToOne
//    @JoinColumn
//    private BoxLocation location;

//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "CREATION_TIME")
//    private Date creationDate;

//    private BoxMetric metric;

//    private BoxStatus status;


}
