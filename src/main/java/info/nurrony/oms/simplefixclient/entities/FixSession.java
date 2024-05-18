package info.nurrony.oms.simplefixclient.entities;

import java.time.LocalDateTime;

import info.nurrony.oms.simplefixclient.entities.ids.FixSessionId;
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
@Table(name = "fix_sessions")
@IdClass(FixSessionId.class)
public class FixSession {

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

    @Column(name = "creation_time")
    private LocalDateTime creationTime;

    @Column(name = "incoming_seqnum")
    private int incomingSeqnum;

    @Column(name = "outgoing_seqnum")
    private int outgoingSeqnum;

}
