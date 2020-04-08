cd scripts
filename=$1
shift
yarn run ts-node bin/${filename} $@