package com.serenegiant.widget;
/*
 * MultiDispatchTouchEvent
 *
 * Copyright (c) 2020 saki t_saki@serenegiant.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
*/

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * テスト用のView
 * このViewはタッチイベントを処理する(onTouchEventがtrueを返す)
 */
public class Test1View extends View {
	private static final boolean DEBUG = true;	// set false on production
	private static final String TAG = Test1View.class.getSimpleName();

	public Test1View(final Context context) {
		this(context, null, 0);
	}

	public Test1View(final Context context, @Nullable final AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public Test1View(final Context context, @Nullable final AttributeSet attrs, final int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	@Override
	public boolean dispatchTouchEvent(final MotionEvent event) {
		if (DEBUG) Log.v(TAG, "dispatchTouchEvent:" + event.getAction());
		return super.dispatchTouchEvent(event);
	}

	@Override
	public boolean onTouchEvent(final MotionEvent event) {
//		if (DEBUG) Log.v(TAG, "onTouchEvent:" + event.getAction());
		super.onTouchEvent((event));
		// このViewはタッチイベントを処理する
		return true;
	}

}
