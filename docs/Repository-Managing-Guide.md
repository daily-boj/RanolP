# 저장소 관리 가이드

이 가이드는 본 저장소 및 그 포크들을 위해 남겨두는 가이드로 저장소 사용법에 대해 적어둡니다.

## 설치

1. 저장소를 포크하고 클론하세요.
2. `cd scripts`를 하고 `yarn` 혹은 `npm install`을 통해 의존성을 설치하세요.
3. `cd ../`로 다시 원래 폴더로 돌아가서, `./boj.sh reset`을 실행하고 수락하세요.
4. :tada: 끝!

## scripts/

모든 스크립트는 TypeScript로 작성되어 있습니다. `yarn` 의 설치를 필요로 합니다. 저장소 루트에 `boj.sh` 파일이 있어 편하게 사용할 수 있습니다.

`<꺽쇠>`로 감싸진 인수는 필수이며 `[사각 괄호]`로 감싸진 인수는 필수가 아닙니다.

### ./boj.sh reset

폴더를 첫 상태로 초기화합니다.
새로 설치하려는 게 아니면 실행하지 마세요!

### ./boj.sh init [--id \<number\>]

문제 초기 설정을 수행합니다.
템플릿을 기반으로 솔루션 파일, meta.json, Note.md를 생성합니다.
Note.md의 경우 생략하고 이후에 다시 명령어를 수행해 생성할 수 있습니다.
솔루션 템플릿 파일은 `template/{language-id}/*.{file extension}` 에 저장하며,
기본적으로 `template/{language-id}/main.{file extension}`이 선택됩니다.
스페이스 키로 선택/해제할 수 있습니다.
각 템플릿은 줄바꿈 문자 두 개로(`\n\n`) 결합하여 사용합니다.
`main` 템플릿이 맨 아래 오는 것이 보장됩니다.

### (TODO) ./boj.sh test \<number\>

솔루션 파일을 선택하고 테스트 수트를 수행합니다.
`/{number}/test/` 폴더가 없거나 파일이 하나도 없는 경우 종료 코드 `1`로 종료합니다.
`/{number}/solution.{file extension}` 을 BOJ 실행 환경과 유사한 상태로 만들어 실행합니다.
그리고 모든 `{name}`에 대해, `/{number}/test/{name}.in`을 입력으로 넣었을 때 `/{number}/test/{name}.out` 결과물과 동일한지 검증합니다.
이 검증 과정은 라인 피드 문자 (`\n`)나 뒤에 붙는 공백 문자 등 시각적으로 보이지 않는다고 해도 다르다면 거부합니다.

### ./boj.sh update-readme [--force]

`template/README.template.md`를 기반으로 `README.md` 파일을,
`{problem-number}/Note.md`를 기반으로 `{problem-number}/README.md` 파일을 업데이트합니다.
해당 템플릿 파일은 GFM을 확장한 마크다운 방언[\[1\]][1]을 사용합니다.

### ./boj.sh update-symlink

저장소 루트에 있는 심링크 파일들을 업데이트합니다.

### (TODO) ./boj.sh clean

`.boj-cache/` 폴더를 제거합니다.

[1]: ./PGFM.md