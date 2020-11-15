package ru.job4j.oop;

     class Ball {
        public void runFromAll(Hare hare, Wolf wolf, Fox fox) {
        }
    }

     class Hare {
        public void tryEat(Ball ball) {
        }
    }

    class Wolf {
        public void tryEat(Ball ball) {
        }
    }

    class Fox {
        public void tryEat(Ball ball) {
        }
    }
public class BallStory {
    public static void main(String[] args) {
        Ball ball = new Ball();
        Hare hare = new Hare();
        Wolf wolf = new Wolf();
        Fox fox = new Fox();

        ball.runFromAll(hare, wolf, fox);
        hare.tryEat(ball);
        wolf.tryEat(ball);
        fox.tryEat(ball);

    }
}