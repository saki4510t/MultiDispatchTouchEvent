# MultiDispatchTouchEvent

---

通常はViewヒエラルキーの上から順にenableでfocusableなViewの
dispatchTouchEventを呼び出して最初にtrueを返したViewのみが
イベント処理を行なえるのに対して、重なり合った複数のViewの下側も
含めてタッチした位置に存在するViewに対してdispatchTouchEventの
呼び出し処理を行なえるかどうかをテストするViewGroup
(同じタッチイベントで複数の子Viewへタッチイベント生成＆操作できる)

