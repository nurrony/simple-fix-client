package info.nurrony.oms.simplefixclient.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "fix_messages_log_outgoing")
public class FixMessageLogOutgoing implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "beginstring", length = 8)
    private String beginString;

    @Column(name = "sendercompid", length = 64)
    private String senderCompId;

    @Column(name = "sendersubid", length = 64)
    private String senderSubId;

    @Column(name = "senderlocid", length = 64)
    private String senderLocId;

    @Column(name = "targetcompid", length = 64)
    private String targetCompId;

    @Column(name = "targetsubid", length = 64)
    private String targetSubId;

    @Column(name = "targetlocid", length = 64)
    private String targetLocId;

    @Column(name = "session_qualifier", length = 64)
    private String sessionQualifier;

    @Column(columnDefinition = "text")
    private String text;

    private LocalDateTime time;

    // ----------------- system related methods ------
    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final FixMessageLogOutgoing other = (FixMessageLogOutgoing) obj;
        return Objects.equals(id, other.getId());
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : super.hashCode();
    }

    @Override
    public String toString() {
        return "MessageLogOutgoing[" + "id=" + getId() + ", sendercompid='" + getSenderCompId() + "]";
    }
}
