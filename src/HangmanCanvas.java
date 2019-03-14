import acm.graphics.*;
import acm.graphics.GLabel;

import java.util.ArrayList;
import java.util.List;

public class HangmanCanvas extends GCanvas {

    private List<GObject> stickFigure;
    private List<GObject> scaffolding;

    public HangmanCanvas(){
        this.stickFigure = creteStickFigure();
        this.scaffolding = creteScaffolding();
    }

    public void reset() {
        removeAll();
    }

    public void displayHint(String word) {
        GLabel label = new GLabel(word);
        label.setFont("SansSerif-20");
        double x = (getWidth() - label.getWidth()) / 2;
        double y = (getHeight() + label.getAscent()) / 1.2;
        add(label, x, y);

    }

    public void displaySecretWord(String word) {
        GLabel label = new GLabel(word);
        label.setFont("SansSerif-20");
        double x = (getWidth() - label.getWidth()) / 2;
        double y = (getHeight() + label.getAscent()) / 1.1;
        add(label, x, y);

    }

    public void drawFigure(int guess) {
        this.drawScaffolding();
        this.drawStickFigure(guess);

    }

    private void drawStickFigure(int guess) {
        int numParts = 8 - guess;
        for (int i = 0; i < numParts; i++) {
            add(this.stickFigure.get(i));
        }
    }

    private void drawScaffolding() {
        for (GObject part :
        this.scaffolding) {
            add(part);
        }

    }

    private List<GObject> creteStickFigure() {
        List<GObject> stickFigure = new ArrayList<>();

        //GOval head = new GOval(164, 80, 50, 50);
        GImage head = new GImage("felix-el-ladron-bautista.jpg",164,45);
        GLine body = new GLine(189, 130, 189, 230);
        GLine leftArm = new GLine(189, 130, 140, 180);
        GLine rightArm = new GLine(189, 130, 238, 180);
        GLine leftLeg = new GLine(189, 230, 140, 300);
        GLine rightLeg = new GLine(189, 230, 238, 300);
        GLine leftFoot = new GLine(139, 300, 119, 300);
        GLine rightFoot = new GLine(238, 300, 258, 300);

        stickFigure.add(head);
        stickFigure.add(body);
        stickFigure.add(leftArm);
        stickFigure.add(rightArm);
        stickFigure.add(leftLeg);
        stickFigure.add(rightLeg);
        stickFigure.add(leftFoot);
        stickFigure.add(rightFoot);

        return stickFigure;
    }

    private List<GObject> creteScaffolding(){
        List<GObject> scaffolding = new ArrayList<>();

        GLine part1 = new GLine(50, 30,50, 350);
        GLine part2 = new GLine(50, 30,189, 30);
        GLine rope = new GLine(189, 30,189, 80);

        scaffolding.add(part1);
        scaffolding.add(part2);
        scaffolding.add(rope);

        return scaffolding;
    }

}
