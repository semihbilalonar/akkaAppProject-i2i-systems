import akka.actor.typed.ActorSystem;

public class Main {
    public static void main(String[] args) {
        ActorSystem<Actor1.Message> actorSystem1 = ActorSystem.create(Actor1.create(), "actorSystem1");
        ActorSystem<Actor2.Message> actorSystem2 = ActorSystem.create(Actor2.create(), "actorSystem2");

        actorSystem1.tell(new Actor1.Message("Hi from Actor1"));
        actorSystem2.tell(new Actor2.Message("Hi from Actor2"));
    }
}
