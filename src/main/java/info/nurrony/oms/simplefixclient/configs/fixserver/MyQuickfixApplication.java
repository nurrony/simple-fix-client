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

    /**
     * fromApp:
     * This is one of the core entry points for your FIX application. Every
     * application level request will come through here. If, for example, your
     * application is a sell-side OMS, this is where you will get your new order
     * requests. If you were a buy side, you would get your execution reports here.
     * If a FieldNotFound exception is thrown, the counterparty will receive a
     * reject indicating a conditionally required field is missing. The Message
     * class will throw this exception when trying to retrieve a missing field, so
     * you will rarely need the throw this explicitly. You can also throw an
     * UnsupportedMessageType exception. This will result in the counterparty
     * getting a reject informing them your application cannot process those types
     * of messages. An IncorrectTagValue can also be thrown if a field contains a
     * value that is out of range or you do not support.
     */
    @Override
    public void fromApp(Message message, SessionID sessionId)
            throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, UnsupportedMessageType {

        log.info("fromApp: Message={}, SessionId={}, msgType = {}", message, sessionId, fixMessageClassName);

    }

    /**
     * onAdmin:
     * This callback provides you with a peek at the administrative messages that
     * are being sent from your FIX engine to the counter party. This is normally
     * not useful for an application however it is provided for any logging you may
     * wish to do. Notice that the FIX::Message is not const. This allows you to add
     * fields to an administrative message before it is sent out.
     */
    @Override
    public void toAdmin(Message message, SessionID sessionId) {
        log.info("toAdmin: Message={}, SessionId={}", message, sessionId);

    }

    /**
     * fromAdmin:
     * This callback notifies you when an administrative message is sent from a
     * counterparty to your FIX engine. This can be usefull for doing extra
     * validation on logon messages such as for checking passwords. Throwing a
     * `RejectLogon` exception will disconnect the counterparty.
     *
     * @throws FieldNotFound
     * @throws UnsupportedMessageType
     */
    @Override
    public void fromAdmin(Message message, SessionID sessionId) throws FieldNotFound {
        log.info("fromAdmin: Message={}, SessionId={}, messageClass = {}", message, sessionId,
                message.getClass().getName());

    }

    /**
     * toApp:
     * This is a callback for application messages that you are being sent to a
     * counterparty. If you throw a `DoNotSend` exception in this function, the
     * application will not send the message. This is mostly useful if the
     * application has been asked to resend a message such as an order that is no
     * longer relevant for the current market. Messages that are being resent are
     * marked with the PossDupFlag in the header set to true; If a DoNotSend
     * exception is thrown and the flag is set to true, a sequence reset will be
     * sent in place of the message. If it is set to false, the message will simply
     * not be sent. Notice that the FIX::Message is not const. This allows you to
     * add fields before an application message before it is sent out.
     */
    @Override
    public void toApp(Message message, SessionID sessionId) {
        log.info("toApp: Message={}, SessionId={}", message, sessionId);
    }

    /**
     * onCreate:
     * This method is called when quickfix creates a new session. A session comes
     * into and remains in existence for the life of the application. Sessions exist
     * whether or not a counter party is connected to it. As soon as a session is
     * created, you can begin sending messages to it. If no one is logged on, the
     * messages will be sent at the time a connection is established with the
     * counterparty.
     */
    @Override
    public void onCreate(SessionID sessionId) {
        log.info("onCreate: SessionId={}", sessionId);
    }

    /**
     * onLogon:
     * This callback notifies you when a valid logon has been established with a
     * counter party. This is called when a connection has been established and the
     * FIX logon process has completed with both parties exchanging valid logon
     * messages.
     */
    @Override
    public void onLogon(SessionID sessionId) {
        log.info("onLogon: SessionId={}", sessionId);
    }

    /**
     * onLogout:
     * This callback notifies you when an FIX session is no longer online. This
     * could happen during a normal logout exchange or because of a forced
     * termination or a loss of network connection.
     */
    @Override
    public void onLogout(SessionID sessionId) {
        log.info("onLogout: SessionId={}", sessionId);
    }

}
