package ru.samsung.itschool.spacearrays;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class MyDraw extends View implements View.OnClickListener {

	public MyDraw(Context context, AttributeSet attrs) {
		super(context, attrs);
		makeSky();
		this.rocket = new Rocket(BitmapFactory.decodeResource(getResources(), R.drawable.rocket));
		this.rocket2 = new Rocket(BitmapFactory.decodeResource(getResources(), R.drawable.rocket));
		this.SpaceShuttle1= new SpaceShuttle(BitmapFactory.decodeResource(getResources(),R.drawable.spaceshuttleicon));
		this.SpaceShuttle2= new SpaceShuttle(BitmapFactory.decodeResource(getResources(),R.drawable.spaceshuttleicon));
	}
	SpaceShuttle SpaceShuttle1, SpaceShuttle2;
	Rocket rocket, rocket2;


	Paint paint = new Paint();
	@Override
	protected void onDraw(Canvas canvas) {
		
		drawSky(canvas);
		SpaceShuttle1.draw(canvas);
		SpaceShuttle2.draw(canvas);
		SpaceShuttle1.move();
		SpaceShuttle2.move();
		rocket.draw(canvas);
		rocket2.draw(canvas);
		rocket.move();
		rocket2.move();
		// Запрос на перерисовку экрана
		invalidate();
	}
	
	final int numStars = 500;

	int xStar[] = new int[numStars];
	int yStar[] = new int[numStars];
	int alphaStar[] = new int[numStars];

	void makeSky()
	{
		// Звезды генерируются в зоне maxX на maxY
		int maxX = 2000;
		int maxY = 2000;
		for (int i = 0; i < numStars; i++)
		{
		   xStar[i] = (int)(Math.random() * maxX);
		   yStar[i] = (int)(Math.random() * maxY);
		   alphaStar[i] = (int)(Math.random() * 256);
		}
	}

	void drawSky(Canvas canvas)
	{
		canvas.drawColor(Color.BLUE);
		paint.setColor(Color.WHITE);
		paint.setStrokeWidth(2);
		for (int i = 0; i < numStars; i++)
		{
		   paint.setAlpha(alphaStar[i]);
		   alphaStar[i] += (int)(Math.random() * 11) - 5;
		   if (alphaStar[i] > 255) alphaStar[i] = 255;
		   if (alphaStar[i] < 0) alphaStar[i] = 0;
		   canvas.drawCircle(xStar[i], yStar[i], 3, paint);
		}
	}

	@Override
	public void onClick(View view) {

	}
}
