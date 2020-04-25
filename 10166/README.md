# 10166 관중석



<table>
  <tr>
    <th>랭크</th>
    <th>상태</th>
  </tr>
  <tr>
    <td>
      <a href="http://noj.am/10166">
        <img src="https://static.solved.ac/tier_small/9.svg" height="16px"/>
        Silver II, 10166 관중석
      </a>
    </td>
    <td>
      성공
    </td>
  </tr>
</table>



## 문제 분석

원에 ![D_1](https://render.githubusercontent.com/render/math?math=D_1)개부터 ![D_2](https://render.githubusercontent.com/render/math?math=D_2)개까지 같은 간격을 두고 의자를 두었는데, 가운데가 보이는 의자는 무엇인가를 구하는 문제입니다.
원으로 생각하면 복잡합니다.
원의 반지름을 고정하고 북쪽을 잘라내서 선으로 만들면 편할 것 같습니다 [\[1\]][1].

## 풀이

아주 나이브하게 ![n^2](https://render.githubusercontent.com/render/math?math=n%5E2)로 풀었습니다.
선에서 겹치지 않는 점의 개수를 구하는 것이므로,
그냥 점의 위치가 유니크한지만 따지면 됩니다.
`Set` 자료구조를 통해 풀었습니다.

[1]: https://daily-boj.github.io/RanolP/10166/playground.html
