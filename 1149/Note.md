# {@ problem-title @}

~~~problem-info-table
~~~

## 문제 분석

앞뒤 집과 색이 다르게 집을 칠하되, 가장 싼 가격으로 칠하는 문제입니다.
모든 집을 고려하면 힘드니 두 집만 생각하면 편할 것 같습니다.

## 풀이

지금 집에 색을 칠할 때, 최선의 경우는 다음과 같습니다.

- R : 이전 집의 G, B를 칠하는 가격 중 최소 + 현재 가격
- G : 이전 집의 R, B를 칠하는 가격 중 최소 + 현재 가격
- B : 이전 집의 R, G를 칠하는 가격 중 최소 + 현재 가격

이전 집의 R, G, B를 저장하고 매번 최선을 고르면 됩니다.