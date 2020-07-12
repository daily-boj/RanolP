# 1041 주사위



<table>
  <tr>
    <th>랭크</th>
    <th>상태</th>
  </tr>
  <tr>
    <td>
      <a href="http://noj.am/1041">
        <img src="https://static.solved.ac/tier_small/10.svg" height="16px"/>
        Silver I, 1041 주사위
      </a>
    </td>
    <td>
      성공
    </td>
  </tr>
</table>



## 문제 분석

주사위를 쌓았을 때 바깥으로 보이는 면을 최소화하는 문제입니다.

## 풀이

<i class="variable">n</i> = 1인 경우 바닥을 제외한 5면이 보입니다.
그렇지 않은 경우, 육면체에 쌓인 주사위 다음 네 종류로 나누어볼 수 있습니다.

- 꼭지점 : 3면을 드러내고 있습니다.
- 모서리 : 2면을 드러내고 있습니다.
- 면 : 1면을 드러내고 있습니다.
- 속 : 아무 것도 드러내지 않고 있습니다.

꼭지점은 위쪽에 4개 존재하고,
모서리는 위쪽에 <img src="https://latex.codecogs.com/svg.latex?(n%20-%202)%20%5Ctimes%204" alt="(n - 2) \times 4" style="max-width:100%;" >개, 옆쪽 기둥에 <img src="https://latex.codecogs.com/svg.latex?(n%20-%201)%20%5Ctimes%204" alt="(n - 1) \times 4" style="max-width:100%;" >개.
면은 위쪽에 <img src="https://latex.codecogs.com/svg.latex?(n%20-%202)%20%5Ctimes%20(n%20-%202)" alt="(n - 2) \times (n - 2)" style="max-width:100%;" >개, 옆면에 <img src="https://latex.codecogs.com/svg.latex?(n%20-%202)%20%5Ctimes%20(n%20-%201)" alt="(n - 2) \times (n - 1)" style="max-width:100%;" >개 있습니다.

3면을 구할 때 서로 이웃한 면만 구해야 한다는 것에 주의하면
<img src="https://latex.codecogs.com/svg.latex?O(1)" alt="O(1)" style="max-width:100%;" >로 풀 수 있습니다.
