package com.test.revision;

import org.hibernate.envers.RevisionListener;

/**
 * Created by RKasturi on 12/6/2016.
 */
public class CustomRevisionListener  implements RevisionListener
{
  @Override
  public void newRevision(Object revisionEntity)
  {
    CustomRevisionEntity entity=(CustomRevisionEntity) revisionEntity;
    entity.setUserId(123);
    entity.setEventType(2);
  }
}
