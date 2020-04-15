# 1735 분수 합



<table>
  <tr>
    <th>랭크</th>
    <th>상태</th>
  </tr>
  <tr>
    <td>
      <a href="http://noj.am/1735">
        <img src="https://static.solved.ac/tier_small/9.svg" height="16px"/>
        Silver II, 1735 분수 합
      </a>
    </td>
    <td>
      성공
    </td>
  </tr>
</table>



## 문제 분석

분수의 덧셈을 하는 문제입니다. 기약 분수로 출력해야 합니다.

## 풀이

파이썬 표준 라이브러리에 `Fraction` 이 있습니다.
정석적인 풀이는 통분한 다음 더하고, 분모와 분자의 최대공배수를 구해 나누는 것입니다.
