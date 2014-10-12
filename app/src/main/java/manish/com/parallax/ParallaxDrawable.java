package manish.com.parallax;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/**
 * Created by manishcm on 12/10/14.
 */
public class ParallaxDrawable extends Drawable {

    Drawable mDrawable;
    private int mWidth;
    private int mHeight;
    float mScrollXOffset;
    float mScrollYOffset;

    ParallaxDrawable(Drawable d) {
        mDrawable = d;
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.translate(-mScrollXOffset, -mScrollYOffset);
        mDrawable.draw(canvas);
        canvas.translate(mScrollXOffset, mScrollYOffset);
    }

    @Override
    public void setAlpha(int i) {
        mDrawable.setAlpha(i);
    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {
        mDrawable.setColorFilter(colorFilter);
    }

    @Override
    public int getOpacity() {
        return mDrawable.getOpacity();
    }

    void setSize(int width, int height) {
        mWidth = width;
        mHeight = height;
    }

    void setScrollOffset(float scrollXOffset, float scrollYOffset) {
        mScrollXOffset = scrollXOffset;
        mScrollYOffset = scrollYOffset;
    }

    protected void onBoundsChange(Rect bounds) {
        mDrawable.setBounds(new Rect(bounds.top, bounds.left, bounds.left + mWidth, bounds.top + mHeight));
    }
}
