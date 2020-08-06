# {@ problem-title @}

~~~problem-info-table
~~~

## 문제 분석

{@ math: A^B \bmod C @}을 빠르게 구하는 문제입니다.

## 풀이

{@ math: A^{2^n} @}를 미리 계산해둡니다.
{@ math: A^m \times A^n = A^{m+n} @}임을 이용해서,
거듭제곱을 계산합니다.
