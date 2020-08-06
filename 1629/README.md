# 1629 곱셈



<table>
  <tr>
    <th>랭크</th>
    <th>상태</th>
  </tr>
  <tr>
    <td>
      <a href="http://noj.am/1629">
        <img src="https://static.solved.ac/tier_small/10.svg" height="16px"/>
        Silver I, 1629 곱셈
      </a>
    </td>
    <td>
      성공
    </td>
  </tr>
</table>



## 문제 분석

<img src="https://latex.codecogs.com/svg.latex?A%5EB%20%5Cbmod%20C" alt="A^B \bmod C" style="max-width:100%;" >을 빠르게 구하는 문제입니다.

## 풀이

<img src="https://latex.codecogs.com/svg.latex?A%5E%7B2%5En%7D" alt="A^{2^n}" style="max-width:100%;" >를 미리 계산해둡니다.
<img src="https://latex.codecogs.com/svg.latex?A%5Em%20%5Ctimes%20A%5En%20%3D%20A%5E%7Bm%2Bn%7D" alt="A^m \times A^n = A^{m+n}" style="max-width:100%;" >임을 이용해서,
거듭제곱을 계산합니다.
