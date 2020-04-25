# 2422 한윤정이 이탈리아에 가서 아이스크림을 사먹는데



<table>
  <tr>
    <th>랭크</th>
    <th>상태</th>
  </tr>
  <tr>
    <td>
      <a href="http://noj.am/2422">
        <img src="https://static.solved.ac/tier_small/6.svg" height="16px"/>
        Silver V, 2422 한윤정이 이탈리아에 가서 아이스크림을 사먹는데
      </a>
    </td>
    <td>
      성공
    </td>
  </tr>
</table>



## 문제 분석

![N](https://render.githubusercontent.com/render/math?math=N)은 작지만 ![M](https://render.githubusercontent.com/render/math?math=M)은 큽니다.
가능하면 ![N](https://render.githubusercontent.com/render/math?math=N) 쪽으로 뚫는 쪽이 좋을 것 같습니다.

## 풀이

![(a, b, c)](https://render.githubusercontent.com/render/math?math=(a%2C%20b%2C%20c)) 조합에서 ![a < b < c](https://render.githubusercontent.com/render/math?math=a%20%3C%20b%20%3C%20c)가 보장되면 편해집니다.
중복 조합은 `Map<Int, Set<Int>>`에 넣어두고,
작은 것부터 겹치나 안 겹치나 확인합니다.
![O(n^3m)](https://render.githubusercontent.com/render/math?math=O(n%5E3m))으로 풀었습니다.
