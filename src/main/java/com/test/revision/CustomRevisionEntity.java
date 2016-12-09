package com.test.revision;

import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by RKasturi on 12/6/2016.
 */
@Entity
@Table(name = "audit")
@RevisionEntity(CustomRevisionListener .class)
public class CustomRevisionEntity implements Serializable
{
  @Id
  @GeneratedValue
  @RevisionNumber
  @Column(name = "version_number")
  private int versionNumber;

  @RevisionTimestamp
  @Column(name = "version_time")
  private long timestamp;

  @Column(name = "user_id")
  private int userId;

  @Column(name = "event_type")
  private int eventType;

  public int getUserId()
  {
    return userId;
  }

  public void setUserId(int userId)
  {
    this.userId = userId;
  }

  public int getVersionNumber()
  {
    return versionNumber;
  }

  public void setVersionNumber(int versionNumber)
  {
    this.versionNumber = versionNumber;
  }

  public long getTimestamp()
  {
    return timestamp;
  }

  public void setTimestamp(long timestamp)
  {
    this.timestamp = timestamp;
  }

  public int getEventType()
  {
    return eventType;
  }

  public void setEventType(int eventType)
  {
    this.eventType = eventType;
  }
}
