import acm.graphics.*;
import acm.graphics.GLabel;

import java.util.List;

public class HangmanCanvas extends GCanvas {

    private static final int SCAFFOLD_HEIGHT = 360;
    private static final int BEAM_LENGTH = 144;
    private static final int ROPE_LENGTH = 18;
    private static final int HEAD_RADIUS = 36;
    private static final int BODY_LENGTH = 144;
    private static final int ARM_OFFSET_FROM_HEAD = 28;
    private static final int UPPER_ARM_LENGTH = 72;
    private static final int LOWER_ARM_LENGTH = 44;
    private static final int HIP_WIDTH = 36;
    private static final int LEG_LENGTH = 108;
    private static final int FOOT_LENGTH = 28;



    public void reset() {
        removeAll();
    }

    public void displayWord(String word) {
        GLabel label = new GLabel(word);
        label.setFont("SansSerif-20");
        double x = (getWidth() - label.getWidth()) / 2;
        double y = (getHeight() + label.getAscent()) / 1.5;
        add(label, x, y);
    }

    public void drawStickFigure() {

    }

    private List<GObject> creteStickFigure(){
        GOval head = new GOval(10, 10, 72, 72);

        double xHead = getWidth()/2;
        GLine body = new GLine(xHead, 30,xHead, 90 );


    }

}
