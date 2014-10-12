package manish.com.parallax;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ScrollView;

/**
 * Created by manishcm on 12/10/14.
 */
public class ParallaxScrollView extends ScrollView {
    private ParallaxDrawable mDrawable;
    private float mScrollFactor = 1.0f;

    public ParallaxScrollView(Context context) {
        super(context);
        init();
    }

    public ParallaxScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ParallaxScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    void init() {
        getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                getViewTreeObserver().removeOnPreDrawListener(this);

                mDrawable = (ParallaxDrawable) getBackground();

                if(mDrawable != null && mDrawable instanceof ParallaxDrawable) {
                    View child = getChildAt(0);
                    int width = child.getWidth();
                    int height = (int) (getHeight() + (child.getHeight() - getHeight()) * mScrollFactor);
                    mDrawable.setSize(width, height);
                }

                return true;
            }
        });
    }

    protected void onScrollChanged(int x, int y, int oldX, int oldY) {
        if(mDrawable != null && mDrawable instanceof ParallaxDrawable) {
            mDrawable.setScrollOffset(x*mScrollFactor, y*mScrollFactor);
        }
    }

    public void setBackground(Drawable d, float scrollFactor) {
        setBackground(d);
        mScrollFactor = scrollFactor;
    }
}
