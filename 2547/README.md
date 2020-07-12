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

<img src="https://latex.codecogs.com/svg.latex?A_0%2C%20A_1%2C%20%5Ccdots%2C%20A_%7Bn%20-%201%7D%2C%20A_n" alt="A_0, A_1, \cdots, A_{n - 1}, A_n" style="max-width:100%;" >를 전부 더하고 <i class="variable">n</i>으로 나누는 문제입니다.

## 입력

T, (빈줄, N, A<sub>i</sub> × n) × T입니다. 빈줄에 주의할 필요가 있습니다.

## 풀이

<img src="https://latex.codecogs.com/svg.latex?a%20%2B%20b%20%5Cbmod%20c%20%5Cequiv%20(a%20%5Cbmod%20c)%20%2B%20(b%20%5Cbmod%20c)%20%5Cbmod%20c" alt="a + b \bmod c \equiv (a \bmod c) + (b \bmod c) \bmod c" style="max-width:100%;" >입니다.
매 덧셈마다 mod를 수행하면 됩니다.
