# {@ problem-title @}

~~~problem-info-table
~~~

## 문제 분석

BUG 문자열을 지우는 문제입니다. `BUBUGG` 나 `BBUGUG` 같이 BUG 안 BUG가 사라지는 경우도 처리해야 합니다.

## 풀이

스택에 문자를 쌓습니다. 현재 문자가 G이고 뒤 문자가 U, 뒤뒤 문자가 B라면 3개를 모두 pop합니다. 이후 문자를 전부 합쳐서 출력합니다.
