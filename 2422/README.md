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

<i class="variable">N</i>은 작지만 <i class="variable">M</i>은 큽니다.
가능하면 <i class="variable">N</i> 쪽으로 뚫는 쪽이 좋을 것 같습니다.

## 풀이

(<i class="variable">a</i>, <i class="variable">b</i>, <i class="variable">c</i>) 조합에서,
<i class="variable">a</i> < <i class="variable">b</i> < <i class="variable">c</i>가 보장되면 편해집니다.
중복 조합은 `Map<Int, Set<Int>>`에 넣어두고,
작은 것부터 겹치나 안 겹치나 확인합니다.
<img src="https://render.githubusercontent.com/render/math?math=O(n%5E3m)" alt="O(n^3m)" style="max-width:100%;" >으로 풀었습니다.
