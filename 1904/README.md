# 1904 01타일



<table>
  <tr>
    <th>랭크</th>
    <th>상태</th>
  </tr>
  <tr>
    <td>
      <a href="http://noj.am/1904">
        <img src="https://static.solved.ac/tier_small/8.svg" height="16px"/>
        Silver III, 1904 01타일
      </a>
    </td>
    <td>
      성공
    </td>
  </tr>
</table>



## 문제 분석

0과 1이 쓰인 타일이 있습니다. 0은 언제나 00으로 붙어있습니다.
<i class="variable">n</i>이 주어질 때,
위 타일로 만들 수 있는 길이가 <i class="variable">n</i>인 2진 수열의 개수를 구하는 문제입니다.

## 풀이

| <i class="variable">n</i> | 만들 수 있는 2진 수열 |
| 1            | `1`                   |
| 2            | `11`, `00`            |
| 3            | `111`, `100`, `001`   |

1이거나 2일 때는 간단하게 구할 수 있습니다.
3보다 커지면 맨 앞을 `1`로 채우거나 `00`으로 채울 수 있습니다.
만약 `1`로 채운다면 <i class="variable">n</i> - 1 길이인 2진 수열들이 뒤에 붙을 수 있을 것이며,
`00`으로 채운다면 <i class="variable">n</i> - 2 길이인 2진 수열들이 뒤에 붙을 수 있을 것입니다.
점화식으로 나타내면 다음과 같습니다:

![F(n) = F(n - 1) + F(n - 2)](https://render.githubusercontent.com/render/math?math=F(n)%20%3D%20F(n%20-%201)%20%2B%20F(n%20-%202))

매우 익숙합니다, 네 피보나치 수열입니다!
따라서 ![n](https://render.githubusercontent.com/render/math?math=n)번째 피보나치 수를 구하면 됩니다.
15746로 나눈 나머지임에 주의해야 합니다.
