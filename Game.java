public class Game {
    double[] payoffMatrix;
    double p;
    double q;

    Game() {
        this.payoffMatrix = Main.INITIAL_PAYOFF_MATRIX.clone();
    }

    void mixedEquilibria() {
        this.q = (this.payoffMatrix[2] + 1) / (this.payoffMatrix[0] + this.payoffMatrix[2] + 2);
        this.p = (this.payoffMatrix[3] + 1) / (this.payoffMatrix[1] + this.payoffMatrix[3] + 2);
    }
}