# {@ problem-title @}

~~~problem-info-table
~~~

## 문제 분석

로마 숫자를 아라비아 숫자로 변환하는 문제입니다.

## 풀이

Regex를 통해 IX 같은 '-1 문자열'을 미리 치환합니다.
'-1 문자열'을 제외하면 문자에 할당된 값을 더하는 것으로 문제를 해결할 수 있습니다.
