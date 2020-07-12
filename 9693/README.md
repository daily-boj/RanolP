# 9693 시파르



<table>
  <tr>
    <th>랭크</th>
    <th>상태</th>
  </tr>
  <tr>
    <td>
      <a href="http://noj.am/9693">
        <img src="https://static.solved.ac/tier_small/8.svg" height="16px"/>
        Silver III, 9693 시파르
      </a>
    </td>
    <td>
      성공
    </td>
  </tr>
</table>



## 문제 분석

<img src="https://latex.codecogs.com/svg.latex?N!%20%2F%2010%5EM" alt="N! / 10^M" style="max-width:100%;" >이 정수가 되는 값 중 가장 큰수를 구하는 문제입니다.
N이 5보다 크므로 정답은 1보다 큼이 보장됩니다.

## 풀이

### 정리

1, 2, 3, 4, ...이 5를 몇 개 갖고 있는지 계산해서 저장해둡니다.
이 때, 계속 5로 나누는 방법을 사용해 이전에 계산한 결과를 활용합니다.
5의 인수 개수 누적합을 만들어 n번 값을 출력합니다.

### 보조 정리: 5 ≤ n인 n!이 가진 2의 인수는 5보다 많다

모든 정수는 다음을 만족합니다:

- mod 10이 0, 2, 4, 6, 8인 경우 2의 배수
- mod 10이 0, 5인 경우 5의 배수

따라서 2를 인수로 가지는 수가 5를 인수로 가지는 수보다 5/2배 더 많다고 할 수 있습니다.

또, <img src="https://latex.codecogs.com/svg.latex?2%5Ex" alt="2^x" style="max-width:100%;" >가 <img src="https://latex.codecogs.com/svg.latex?5%5Ex" alt="5^x" style="max-width:100%;" >보다 더 느리게 증가하므로,
10 ≤ a, b이고 |a - b| ≤ 10인 두 정수를 소인수분해 했을 때, 2의 차수가 더 높다고 추측할 수 있습니다.

따라서 1, 2, 3, ..., n - 1, n을 모두 곱하는 n!의 인수는 2가 많다고 볼 수 있습니다.

...추측인데 왜 증명이냐구요?



<a href="https://twitter.com/PSing_Pirim/status/1228871684825858055">

> <table><tr><td><img src="https://pbs.twimg.com/profile_images/1227442623327150080/QYE5fpZ2_normal.png" alt="PSing_Pirim"></td><td><b>PS하는 피림이</b><br>@PSing_Pirim</td></tr></table>
> 
> 새로운 증명법을 알게 된 피림이
>
> ![Image](https://pbs.twimg.com/media/EQ3UR_KUYAAbJfA?format=png&name=small)

</a>


