# 1935 후위 표기식2



<table>
  <tr>
    <th>랭크</th>
    <th>상태</th>
  </tr>
  <tr>
    <td>
      <a href="http://noj.am/1935">
        <img src="https://static.solved.ac/tier_small/8.svg" height="16px"/>
        Silver III, 1935 후위 표기식2
      </a>
    </td>
    <td>
      성공
    </td>
  </tr>
</table>



## 문제 분석

변수가 있는 후위 표기식을 계산하는 문제입니다.

### 입력

변수가 있습니다. HashMap을 사용할 수도 있지만 'A' 에서 'Z' 범위이므로 'A' 값을 빼면 배열에 넣을 수 있습니다.

### 풀이

후위 표기식은 스택으로 풀 수 있습니다. 좌항과 우항만 잘 구별하면 쉽게 풀 수 있습니다.
