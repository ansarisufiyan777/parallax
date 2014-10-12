
package manish.com.parallax;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;


public class MyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        final ParallaxScrollView scrollView = (ParallaxScrollView) findViewById(R.id.sv);
        ParallaxDrawable drawable = new ParallaxDrawable(getResources().getDrawable(R.drawable.bg));
        scrollView.setBackground( drawable, 0.2f );
    }
}
