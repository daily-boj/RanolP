# 18187 평면 분할



<table>
  <tr>
    <th>랭크</th>
    <th>상태</th>
  </tr>
  <tr>
    <td>
      <a href="http://noj.am/18187">
        <img src="https://static.solved.ac/tier_small/9.svg" height="16px"/>
        Silver II, 18187 평면 분할
      </a>
    </td>
    <td>
      성공
    </td>
  </tr>
</table>



## 문제 분석

기울기가 -1, 0, 1인 직선만으로 최대한 분할된 평면이 많게 분할하는 문제입니다.

## 풀이

이해가 1도 가지 않습니다. 시행착오를 겪으며 직접 그려봅시다.

| 직선의 수 | 분할된 수 | 이전값 + |
| --------- | --------- | -------- |
| 0         | 1         | N/A      |
| 1         | 2         | 1        |
| 2         | 4         | 2        |
| 3         | 7         | **3**    |
| 4         | 10        | **3**    |
| 5         | 14        | 4        |
| 6         | 19        | **5**    |
| 7         | 24        | **5**    |
| 8         | 30        | 6        |
| 9         | 37        | 7        |

굵게 처리한 부분을 제외하곤 전부 1씩 증가하고 있음을 알아낼 수 있습니다.
<img src="https://latex.codecogs.com/svg.latex?n%20%5Cbmod%203%20%5Cequiv%200" alt="n \bmod 3 \equiv 0" style="max-width:100%;" >인 경우에 증가시키지 않고 그대로 넘어가네요.
이를 이용해서 풀면 됩니다.

![Euler characteristic (χ=V-E+F)](./tag.png)



<a href="https://twitter.com/PSing_Pirim/status/1227451738963238917">

> <table><tr><td><img src="https://pbs.twimg.com/profile_images/1227442623327150080/QYE5fpZ2_normal.png" alt="PSing_Pirim"></td><td><b>PS하는 피림이</b><br>@PSing_Pirim</td></tr></table>
> 
> 고인물 혐오증에 걸린 피림이
>
> ![Image](https://pbs.twimg.com/media/EQjI06-WkAA7Q2V?format=png&name=small)

</a>

