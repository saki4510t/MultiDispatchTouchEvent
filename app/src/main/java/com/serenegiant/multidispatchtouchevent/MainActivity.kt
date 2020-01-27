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
import androidx.appcompat.app.AppCompatActivity

 class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		if (USE_FRAGMENT) {
			setContentView(R.layout.activity_main2)
			supportFragmentManager
				.beginTransaction()
				.replace(R.id.container1, Fragment1())
				.replace(R.id.container2, Fragment2())
				.replace(R.id.container3, Fragment3())
				.commit()
		} else {
			setContentView(R.layout.activity_main)
		}
	}

	companion object {
		/**
		 * true: Fragmentを2枚重ねた時にそれぞれのFragment内のViewに対して
		 * タッチイベントを起こせるかどうかを確認
		 * false: 1つのレイアウトファイル内で重ねた2つのViewに対して
		 * タッチイベントを起こせるかどうかを確認
		 */
		private const val USE_FRAGMENT = true
	}
}