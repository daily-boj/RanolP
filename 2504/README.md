# 2504 괄호의 값



<table>
  <tr>
    <th>랭크</th>
    <th>상태</th>
  </tr>
  <tr>
    <td>
      <a href="http://noj.am/2504">
        <img src="https://static.solved.ac/tier_small/9.svg" height="16px"/>
        Silver II, 2504 괄호의 값
      </a>
    </td>
    <td>
      성공
    </td>
  </tr>
</table>



## 문제 분석

괄호 문자열을 파싱하고, 성공했다면 값을 계산하는 문제입니다.

## 풀이

재귀 하향 파서recursive descent parser를 짜서 AST를 구축합니다.
노드별로 계산 함수를 붙여 적절히 연산합니다.