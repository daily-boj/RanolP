# 2435 기상청 인턴 신현수



<table>
  <tr>
    <th>랭크</th>
    <th>상태</th>
  </tr>
  <tr>
    <td>
      <a href="http://noj.am/2435">
        <img src="https://static.solved.ac/tier_small/8.svg" height="16px"/>
        Silver III, 2435 기상청 인턴 신현수
      </a>
    </td>
    <td>
      성공
    </td>
  </tr>
</table>



## 문제 분석

길이가 ![n](https://render.githubusercontent.com/render/math?math=n)인 수열이 주어졌을 때,
연속적인 ![k](https://render.githubusercontent.com/render/math?math=k)개의 원소를 더한 값 중 가장 큰 값을 구하는 문제입니다.

## 풀이

현재까지 나온 값 중 최대 값과 이전 합을 저장합니다.
이전 합의 가장 첫 값을 빼고 지금 값을 더하면 새로운 합이 나옵니다.
최대 값과 비교해서 저장하고, 이전 값에 저장하면 됩니다.
