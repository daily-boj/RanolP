# {@ problem-title @}

~~~problem-info-table
~~~

## 문제 분석

기울기가 {@ math: -1, 0, 1 @}인 직선만으로 최대한 분할된 평면이 많게 분할하는 문제입니다.

## 풀이

이해가 1도 가지 않습니다. 시행착오를 겪으며 직접 그려봅시다.

| 직선의 수 | 분할된 수 | 이전값 + |
| --------- | --------- | -------- |
| 0         | 1         | N/A      |
| 1         | 2         | 1        |
| 2         | 4         | 2        |
| 3         | 7         | **3**    |
| 4         | 10        | **3**    |
| 5         | 14        | 4        |
| 6         | 19        | **5**    |
| 7         | 24        | **5**    |
| 8         | 30        | 6        |
| 9         | 37        | 7        |

굵게 처리한 부분을 제외하곤 전부 1씩 증가하고 있음을 알아낼 수 있습니다.
n mod 3 = 0인 경우에 증가시키지 않고 그대로 넘어가네요.
이를 이용해서 풀면 됩니다.

![Euler characteristic (χ=V-E+F)](./tag.png)

~~~pirim
"goin"
~~~