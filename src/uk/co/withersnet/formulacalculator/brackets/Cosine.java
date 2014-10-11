package uk.co.withersnet.formulacalculator.brackets;

import java.text.DecimalFormat;

import uk.co.withersnet.formulacalculator.util.GlobalConstants;
import uk.co.withersnet.formulacalculator.util.Node;
import uk.co.withersnet.formulacalculator.util.Number;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class Cosine extends OpenBracket {
	
	
	@Override
	public Number modify(Number n) {
		//rounding probems occur using sin
		DecimalFormat df = new DecimalFormat("#." + GlobalConstants.maxPrecision);
		if(GlobalConstants.deg){
			return new Number(df.format(Math.cos(Math.toRadians(n.valueOf()))));
		}else{
			return new Number(df.format(Math.cos(n.valueOf())));
		}
	}
	
	@Override
	public void updateBounds(int x, int y, Paint paint) {
		paint.getTextBounds("cos(", 0, 3, bounds);
		bounds.set(x, y, x + bounds.width() + GlobalConstants.spacing, y);
	}
	@Override
	public void draw(Canvas canvas, Paint paint) {
		canvas.drawText("cos", bounds.left, bounds.bottom, paint);
		Rect r = new Rect();
		paint.getTextBounds("cos", 0, 3, r);
		
		paint.setTextSize(bounds.height() * 1.3f);
		paint.setTextScaleX(((float)GlobalConstants.fontSize) / ((float)bounds.height()));
		
		canvas.drawText("(", bounds.left + r.width(), bounds.bottom - (bounds.height() * 0.1f), paint);
		
		paint.setTextSize(GlobalConstants.fontSize);
		paint.setTextScaleX(1);
	}
	@Override
	public String toString() {
		return "cos(";
	}
	
	@Override
	public Node getClone() {
		return new Cosine();
	}
}
