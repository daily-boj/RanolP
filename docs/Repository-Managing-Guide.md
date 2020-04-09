# 저장소 관리 가이드

이 가이드는 본 저장소 및 그 포크들을 위해 남겨두는 가이드로 저장소 사용법에 대해 적어둡니다.

## scripts/

모든 스크립트는 TypeScript로 작성되어 있습니다. `yarn` 의 설치를 필요로 합니다. 저장소 루트에 `boj.sh` 파일이 있어 편하게 사용할 수 있습니다.

`<꺽쇠>`로 감싸진 인수는 필수이며 `[사각 괄호]`로 감싸진 인수는 필수가 아닙니다.

### (TODO) ./boj.sh test \<number\> \[file extension\]

테스트 수트를 수행합니다.
`/{number}/test/` 폴더가 없거나 파일이 하나도 없는 경우 종료 코드 `1`로 종료합니다.
`/{number}/solution.{file extension}` 을 BOJ 실행 환경과 유사한 상태로 만들어 실행합니다.
그리고 모든 `{name}`에 대해, `/{number}/test/{name}.in`을 입력으로 넣었을 때 `/{number}/test/{name}.out` 결과물과 동일한지 검증합니다.
이 검증 과정은 라인 피드 문자 (`\n`)나 뒤에 붙는 공백 문자 등 시각적으로 보이지 않는다고 해도 다르다면 거부합니다.

### ./boj.sh update-readme

`template/README.template.md`를 기반으로 `README.md` 파일을 업데이트합니다. 해당 템플릿 파일은 GFM을 확장한 마크다운 방언을 사용합니다.

### (TODO) ./boj.sh init \<number\> \<language\>

각 언어별 템플릿을 기반으로 프로젝트를 초기화합니다.

### ./boj.sh update-symlink

저장소 루트에 있는 심링크 파일들을 업데이트합니다.

### (TODO) ./boj.sh clean

`.boj-cache/` 폴더를 제거합니다.
