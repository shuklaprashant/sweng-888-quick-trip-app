REGION=$1
REPOSITORY=$2

docker stop $(docker ps -aq)
docker rm $(docker ps -aq)
aws ecr get-login --region $REGION --no-include-email > credentials.sh
chmod 755 credentials.sh
./credentials.sh
rm ./credentials.sh

REPO=`aws ecr describe-repositories \
      --region $REGION \
      --repository-name $REPOSITORY \
      --query "repositories[0].repositoryUri" \
      --output text`

docker pull $REPO:latest
docker run -d -p 80:3000 -e AWS_REGION=$REGION $REPO:latest