package com.investar.oms.broker.domain.entities.fixserver.internals;

import java.io.Serializable;

import com.investar.oms.broker.domain.entities.fixserver.ids.FixMessageId;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "fix_messages")
@IdClass(FixMessageId.class)
public class FixMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "beginstring", length = 8)
    private String beginString;

    @Id
    @Column(name = "sendercompid", length = 64)
    private String senderCompId;

    @Id
    @Column(name = "sendersubid", length = 64)
    private String senderSubId;

    @Id
    @Column(name = "senderlocid", length = 64)
    private String senderLocId;

    @Id
    @Column(name = "targetcompid", length = 64)
    private String targetCompId;

    @Id
    @Column(name = "targetsubid", length = 64)
    private String targetSubId;

    @Id
    @Column(name = "targetlocid", length = 64)
    private String targetLocId;

    @Id
    @Column(name = "session_qualifier", length = 64)
    private String sessionQualifier;

    @Id
    @Column(name = "msgseqnum")
    private int msgSeqNum;

    @Column(name = "message", columnDefinition = "text")
    private String message;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((beginString == null) ? 0 : beginString.hashCode());
        result = prime * result + ((message == null) ? 0 : message.hashCode());
        result = prime * result + msgSeqNum;
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
        FixMessage other = (FixMessage) obj;
        if (beginString == null) {
            if (other.beginString != null)
                return false;
        } else if (!beginString.equals(other.beginString))
            return false;
        if (message == null) {
            if (other.message != null)
                return false;
        } else if (!message.equals(other.message))
            return false;
        if (msgSeqNum != other.msgSeqNum)
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
