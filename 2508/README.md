# 2508 사탕 박사 고창영



<table>
  <tr>
    <th>랭크</th>
    <th>상태</th>
  </tr>
  <tr>
    <td>
      <a href="http://noj.am/2508">
        <img src="https://static.solved.ac/tier_small/8.svg" height="16px"/>
        Silver III, LV2 2508 사탕 박사 고창영
      </a>
    </td>
    <td>
      성공
    </td>
  </tr>
</table>



## 문제 분석

아래 두 경우에 맞는 문자열의 개수를 세면 됩니다.

```text
v
o  >o<
^
```

아래와 같은 입력은 없습니다.

```text
 v
>o<
 ^
```

## 풀이

o가 등장할 때마다 상하좌우를 비교해 맞는지 확인합니다.
o의 위치에 따라 상하좌우 접근이 될 수 없음에 주의합니다.
