# 2547 사탕 선생 고창영



<table>
  <tr>
    <th>랭크</th>
    <th>상태</th>
  </tr>
  <tr>
    <td>
      <a href="http://noj.am/2547">
        <img src="https://static.solved.ac/tier_small/3.svg" height="16px"/>
        Bronze III, 2547 사탕 선생 고창영
      </a>
    </td>
    <td>
      성공
    </td>
  </tr>
</table>



## 문제 분석

A<sub>0</sub>, A<sub>1</sub>, ..., A<sub>n - 1</sub>, A<sub>n</sub>를 전부 더하고 n으로 나누는 문제입니다.

## 입력

T, (빈줄, N, A_i × n) × T입니다. 빈줄에 주의할 필요가 있습니다.

## 풀이

a + b mod c = (a mod c) + (b mod c) mod c입니다. 매 덧셈마다 mod를 수행하면 됩니다.
