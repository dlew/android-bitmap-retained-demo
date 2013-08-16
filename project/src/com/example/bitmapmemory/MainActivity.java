package com.example.bitmapmemory;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class MainActivity extends Activity {

	private Bitmap mBitmap;

	private ImageView mImageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);

		mImageView = (ImageView) findViewById(R.id.image_view);

		findViewById(R.id.button).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this, SecondActivity.class));
			}
		});
	}

	@Override
	protected void onStart() {
		super.onStart();

		// Load the Bitmap into the ImageView
		mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.large_resource);
		mImageView.setImageBitmap(mBitmap);
	}

	@Override
	protected void onStop() {
		super.onStop();

		// Try as hard as we can to clear the Bitmap so it doesn't consume
		// memory while the Activity is hidden
		mImageView.setImageBitmap(null);
		mBitmap.recycle();
		mBitmap = null;
	}

}
