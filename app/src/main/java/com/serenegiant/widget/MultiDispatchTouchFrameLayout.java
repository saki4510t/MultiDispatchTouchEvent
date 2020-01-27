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
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * 通常はViewヒエラルキーの上から順にenableでfocusableなViewの
 * dispatchTouchEventを呼び出して最初にtrueを返した子Viewのみが
 * イベント処理を行なえるのに対して、重なり合った複数のViewの下側も
 * 含めてタッチした位置に存在するViewに対してdispatchTouchEventの
 * 呼び出し処理を行うViewGroup
 * (同じタッチイベントで複数の子Viewへタッチイベント生成＆操作できる)
 */
public class MultiDispatchTouchFrameLayout extends FrameLayout {
	private static final boolean DEBUG = false;	// set false on production
	private static final String TAG = MultiDispatchTouchFrameLayout.class.getSimpleName();

	private final SparseBooleanArray mDispatched = new SparseBooleanArray();
	private final Rect mWorkRect = new Rect();

	/**
	 * コンストラクタ
	 * @param context
	 */
	public MultiDispatchTouchFrameLayout(@NonNull final Context context) {
		this(context, null, 0);
	}

	/**
	 * コンストラクタ
	 * @param context
	 * @param attrs
	 */
	public MultiDispatchTouchFrameLayout(@NonNull final Context context,
		@Nullable final AttributeSet attrs) {

		this(context, attrs, 0);
	}

	/**
	 * コンストラクタ
	 * @param context
	 * @param attrs
	 * @param defStyleAttr
	 */
	public MultiDispatchTouchFrameLayout(@NonNull final Context context,
		@Nullable final AttributeSet attrs, final int defStyleAttr) {

		super(context, attrs, defStyleAttr);
		// 子クラスへフォーカスを与えないようにする
		setDescendantFocusability(FOCUS_BLOCK_DESCENDANTS);
		setFocusable(true);
	}

	@Override
	public boolean dispatchTouchEvent(final MotionEvent ev) {
		if (onFilterTouchEventForSecurity(ev)) {
			boolean result = false;
			final int children = getChildCount();
			for (int i = 0; i < children; i++) {
				final View v = getChildAt(i);
				final int id = v.hashCode();
				v.getHitRect(mWorkRect);
				if (v.isEnabled() && isFocusable()
					&& mWorkRect.contains((int)ev.getX(), (int)ev.getY())
					&& mDispatched.get(id, true)) {

					// 子Viewが有効＆子ViewのhitRect内をタッチ&子Viewがイベントをハンドリングしているとき
					final boolean dispatched = v.dispatchTouchEvent(ev);
					mDispatched.put(id, dispatched);
					result |= dispatched;
				}
			}
			final int action = ev.getAction();
			if (((action == MotionEvent.ACTION_UP)
				|| (action == MotionEvent.ACTION_CANCEL))
				 	&& ev.getPointerCount() == 1) {
				mDispatched.clear();
			}
//			if (!result) {
//				// 子Viewがどれもイベントをハンドリングしなかったときは上位に任せる
//				// もしかすると子ViewのdispatchTouchEventが2回呼び出されるかも
//				result = super.dispatchTouchEvent(ev);
//			}
			if (DEBUG) Log.v(TAG, "dispatchTouchEvent:result=" + result);
			return result;
		} else {
			return super.dispatchTouchEvent(ev);
		}
	}

}
