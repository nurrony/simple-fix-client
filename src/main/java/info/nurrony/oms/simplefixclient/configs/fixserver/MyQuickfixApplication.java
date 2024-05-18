package info.nurrony.oms.simplefixclient.configs.fixserver;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import quickfix.Application;
import quickfix.FieldNotFound;
import quickfix.IncorrectDataFormat;
import quickfix.IncorrectTagValue;
import quickfix.Message;
import quickfix.SessionID;
import quickfix.SessionSettings;
import quickfix.UnsupportedMessageType;

@Slf4j
@RequiredArgsConstructor
public class MyQuickfixApplication implements Application {

    final private SessionSettings sessionSettings;

    @Override
    public void fromApp(Message message, SessionID sessionId)
            throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, UnsupportedMessageType {

        log.info("fromApp: Message={}, SessionId={}, msgType = {}", message, sessionId, fixMessageClassName);

    }

    @Override
    public void toAdmin(Message message, SessionID sessionId) {
        log.info("toAdmin: Message={}, SessionId={}", message, sessionId);

    }

    @Override
    public void fromAdmin(Message message, SessionID sessionId) throws FieldNotFound {
        log.info("fromAdmin: Message={}, SessionId={}, messageClass = {}", message, sessionId,
                message.getClass().getName());

    }

    @Override
    public void toApp(Message message, SessionID sessionId) {
        log.info("toApp: Message={}, SessionId={}", message, sessionId);
    }

    @Override
    public void onCreate(SessionID sessionId) {
        log.info("onCreate: SessionId={}", sessionId);
    }

    @Override
    public void onLogon(SessionID sessionId) {
        log.info("onLogon: SessionId={}", sessionId);
    }

    @Override
    public void onLogout(SessionID sessionId) {
        log.info("onLogout: SessionId={}", sessionId);
    }

}
