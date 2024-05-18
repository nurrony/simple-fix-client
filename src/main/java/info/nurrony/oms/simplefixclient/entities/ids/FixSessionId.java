package com.investar.oms.broker.domain.entities.fixserver.ids;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class FixSessionId implements Serializable {

  private static final long serialVersionUID = 1L;

  private String beginString;

  private String senderCompId;

  private String senderSubId;

  private String senderLocId;

  private String targetCompId;

  private String targetSubId;

  private String targetLocId;

  private String sessionQualifier;

  private LocalDateTime creationTime;

  private int incomingSeqnum;

  private int outgoingSeqnum;

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((beginString == null) ? 0 : beginString.hashCode());
    result = prime * result + ((creationTime == null) ? 0 : creationTime.hashCode());
    result = prime * result + incomingSeqnum;
    result = prime * result + outgoingSeqnum;
    result = prime * result + ((senderCompId == null) ? 0 : senderCompId.hashCode());
    result = prime * result + ((senderLocId == null) ? 0 : senderLocId.hashCode());
    result = prime * result + ((senderSubId == null) ? 0 : senderSubId.hashCode());
    result = prime * result + ((sessionQualifier == null) ? 0 : sessionQualifier.hashCode());
    result = prime * result + ((targetCompId == null) ? 0 : targetCompId.hashCode());
    result = prime * result + ((targetLocId == null) ? 0 : targetLocId.hashCode());
    result = prime * result + ((targetSubId == null) ? 0 : targetSubId.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    FixSessionId other = (FixSessionId) obj;
    if (beginString == null) {
      if (other.beginString != null)
        return false;
    } else if (!beginString.equals(other.beginString))
      return false;
    if (creationTime == null) {
      if (other.creationTime != null)
        return false;
    } else if (!creationTime.equals(other.creationTime))
      return false;
    if (incomingSeqnum != other.incomingSeqnum)
      return false;
    if (outgoingSeqnum != other.outgoingSeqnum)
      return false;
    if (senderCompId == null) {
      if (other.senderCompId != null)
        return false;
    } else if (!senderCompId.equals(other.senderCompId))
      return false;
    if (senderLocId == null) {
      if (other.senderLocId != null)
        return false;
    } else if (!senderLocId.equals(other.senderLocId))
      return false;
    if (senderSubId == null) {
      if (other.senderSubId != null)
        return false;
    } else if (!senderSubId.equals(other.senderSubId))
      return false;
    if (sessionQualifier == null) {
      if (other.sessionQualifier != null)
        return false;
    } else if (!sessionQualifier.equals(other.sessionQualifier))
      return false;
    if (targetCompId == null) {
      if (other.targetCompId != null)
        return false;
    } else if (!targetCompId.equals(other.targetCompId))
      return false;
    if (targetLocId == null) {
      if (other.targetLocId != null)
        return false;
    } else if (!targetLocId.equals(other.targetLocId))
      return false;
    if (targetSubId == null) {
      if (other.targetSubId != null)
        return false;
    } else if (!targetSubId.equals(other.targetSubId))
      return false;
    return true;
  }
}
