# {@ problem-title @}

~~~problem-info-table
~~~

## 문제 분석

N은 작지만 M은 큽니다. 가능하면 N 쪽으로 뚫는 쪽이 좋을 것 같습니다.

### 풀이

(a, b, c) 조합에서 a < b < c가 보장되면 편해집니다. 중복 조합은 `Map<Int, Set<Int>>`에 넣어두고 작은 것부터 겹치나 안 겹치나 확인합니다. O(n<sup>3</sup>m)으로 풀었습니다.
