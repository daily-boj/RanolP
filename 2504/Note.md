# {@ problem-title @}

~~~problem-info-table
~~~

## 문제 분석

괄호 문자열을 파싱하고, 성공했다면 값을 계산하는 문제입니다.

## 풀이

재귀 하향 파서recursive descent parser를 짜서 AST를 구축합니다.
노드별로 계산 함수를 붙여 적절히 연산합니다.