# {@ problem-title @}

~~~problem-info-table
~~~

## 문제 분석

{@ math: A_0, A_1, \cdots, A_{n - 1}, A_n @}를 전부 더하고 n으로 나누는 문제입니다.

## 입력

T, (빈줄, N, A_i × n) × T입니다. 빈줄에 주의할 필요가 있습니다.

## 풀이

{@ math: a + b \bmod c \equiv (a \bmod c) + (b \bmod c) \bmod c @}입니다.
매 덧셈마다 mod를 수행하면 됩니다.
