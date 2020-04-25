# 3447 버그왕



<table>
  <tr>
    <th>랭크</th>
    <th>상태</th>
  </tr>
  <tr>
    <td>
      <a href="http://noj.am/3447">
        <img src="https://static.solved.ac/tier_small/5.svg" height="16px"/>
        Bronze I, 3447 버그왕
      </a>
    </td>
    <td>
      성공
    </td>
  </tr>
</table>



## 문제 분석

`BUG` 문자열을 지우는 문제입니다.
`BUBUGG` 나 `BBUGUG` 같이 BUG 안 BUG가 사라지는 경우도 처리해야 합니다.

## 풀이

스택에 문자를 쌓습니다.
현재 문자가 `G`이고 뒤 문자가 `U`, 뒤뒤 문자가 `B`라면 3개를 모두 pop합니다.
이후 문자를 전부 합쳐서 출력합니다.
