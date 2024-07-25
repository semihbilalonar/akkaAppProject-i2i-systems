import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;

public class Actor1 extends AbstractBehavior<Actor1.Message> {

    public static class Message {
        public final String content;

        public Message(String content) {
            this.content = content;
        }
    }

    public static Behavior<Message> create() {
        return Behaviors.setup(Actor1::new);
    }

    private Actor1(ActorContext<Message> context) {
        super(context);
    }

    @Override
    public Receive<Message> createReceive() {
        return newReceiveBuilder()
                .onMessage(Message.class, this::onMessage)
                .build();
    }

    private Behavior<Message> onMessage(Message message) {
        getContext().getLog().info("Received message: " + message.content);
        return this;
    }
}
