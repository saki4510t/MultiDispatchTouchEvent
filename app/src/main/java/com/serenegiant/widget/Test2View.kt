package com.serenegiant.widget
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

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View

/**
 * テスト用のView
 * このViewはタッチイベントを処理しない(onTouchEventがfalseを返す)
 */
class Test2View
	@JvmOverloads
	constructor(context: Context?, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
		: View(context, attrs, defStyleAttr) {

//	override fun dispatchTouchEvent(event: MotionEvent): Boolean {
//		if (DEBUG) Log.v(TAG, "dispatchTouchEvent(${id}):${event.action}")
//		return super.dispatchTouchEvent(event)
//	}

	@SuppressLint("ClickableViewAccessibility")
	override fun onTouchEvent(event: MotionEvent): Boolean {
		if (DEBUG) Log.v(TAG, "onTouchEvent(${id}):${event.action}")
		super.onTouchEvent(event)
		// このViewはタッチイベントを処理する
		return false
	}

	companion object {
		private const val DEBUG = true // set false on production
		private val TAG = Test2View::class.java.simpleName
	}
}