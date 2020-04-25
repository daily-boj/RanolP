# {@ problem-title @}

~~~problem-info-table
~~~

## 문제 분석

{@ math: N @}은 작지만 {@ math: M @}은 큽니다.
가능하면 {@ math: N @} 쪽으로 뚫는 쪽이 좋을 것 같습니다.

## 풀이

{@ math: (a, b, c) @} 조합에서 {@ math: a < b < c @}가 보장되면 편해집니다.
중복 조합은 `Map<Int, Set<Int>>`에 넣어두고,
작은 것부터 겹치나 안 겹치나 확인합니다.
{@ math: O(n^3m) @}으로 풀었습니다.
