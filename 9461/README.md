# 9461 파도반 수열



<table>
  <tr>
    <th>랭크</th>
    <th>상태</th>
  </tr>
  <tr>
    <td>
      <a href="http://noj.am/9461">
        <img src="https://static.solved.ac/tier_small/8.svg" height="16px"/>
        Silver III, 9461 파도반 수열
      </a>
    </td>
    <td>
      성공
    </td>
  </tr>
</table>



## 문제 분석

가장 안쪽부터 삼각형을 가장 긴 변에 붙여가며 도형을 만들어 나갑니다.

## 풀이

점화식은 다음과 같습니다.

P(n) = P(n - 1) + P(n - 5)

문제에 앞 10개의 값이 주어져 있으므로 n - 5가 나오지 않을 일은 없습니다.
DP 배열을 하나 만들고 재귀로 풀면 됩니다.
