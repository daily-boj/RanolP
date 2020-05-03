# 17363 우유가 넘어지면?



<table>
  <tr>
    <th>랭크</th>
    <th>상태</th>
  </tr>
  <tr>
    <td>
      <a href="http://noj.am/17363">
        <img src="https://static.solved.ac/tier_small/5.svg" height="16px"/>
        Bronze I, 17363 우유가 넘어지면?
      </a>
    </td>
    <td>
      성공
    </td>
  </tr>
</table>



## 문제 분석

문자열을 돌리는 문제입니다.
특수 문자들도 돌아간 문자로 바꾸어야 합니다.

## 풀이

문자를 돌아간 문자로 변환한 다음,
매 줄의 0번 인덱스는 length - 1번에, 1번은 length - 2번에, ...추가하기를 반복합니다.
문자열을 합쳐서 출력하면 됩니다.
