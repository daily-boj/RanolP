# 16510 Predictable Queue



<table>
  <tr>
    <th>랭크</th>
    <th>상태</th>
  </tr>
  <tr>
    <td>
      <a href="http://noj.am/16510">
        <img src="https://static.solved.ac/tier_small/10.svg" height="16px"/>
        Silver I, 16510 Predictable Queue
      </a>
    </td>
    <td>
      성공
    </td>
  </tr>
</table>



## 문제 분석

일의 개수 <i class="variable">n</i>과 테스트케이스의 수 <i class="variable">m</i>이 주어지고
각 일에 들어가는 시간들이 주어질 때, <i class="variable">T</i>만큼 시간이 있다면,
앞에서부터 몇 개의 일을 마칠 수 있는지 구하는 문제입니다.

## 풀이

지금 일을 끝내려면 앞 일을 끝내야 하므로,
앞 일을 처리하는 데에 걸린 시간 + 지금 일에 걸리는 시간이 있어야 지금 일을 처리할 수 있습니다.
이렇게 앞부터 하나하나 누적합을 구한 다음, T를 이진 탐색하면 됩니다.
