package com.serenegiant.multidispatchtouchevent
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
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 * A simple [Fragment] subclass.
 */
class Fragment1
	: Fragment() {

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?): View? { // Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_fragment1, container, false)
	}

	companion object {
		private const val DEBUG = true // set false on production
		private val TAG = Fragment1::class.java.simpleName
	}

	init {
		if (DEBUG) Log.v(TAG, "コンストラクタ:")
	}
}