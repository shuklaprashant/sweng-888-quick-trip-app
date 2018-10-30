REGION=$1
SERVICE_NAME=$2
PROFILE=$3
PRIMARY='\033[0;34m'
NC='\033[0m' # No Color

printf "${PRIMARY}* Getting ECR Credentials \`${SERVICE_NAME}\`${NC}\n";
aws ecr get-login --profile $PROFILE --region $REGION --no-include-email > credentials.sh
printf "${PRIMARY}* Increasing credentials.sh permissions to allow execution \`${SERVICE_NAME}\`${NC}\n";
chmod 755 ./credentials.sh
(./credentials.sh)
rm credentials.sh
printf "${PRIMARY}* ECR Credentials removed \`${SERVICE_NAME}\`${NC}\n";

printf "${PRIMARY}* Locating the ECR repository for service \`${SERVICE_NAME}\`${NC}\n";

# Find the ECR repo to push to
REPO=`aws ecr describe-repositories \
	 --profile $PROFILE \
    --region $REGION \
	--repository-names "$SERVICE_NAME" \
	--query "repositories[0].repositoryUri" \
	--output text`

if [ "$?" != "0" ]; then
    # The repository was not found, create it
	printf "${PRIMARY}* Creating new ECR repository for service \`${SERVICE_NAME}\`${NC}\n";
	REPO=`aws ecr create-repository \
		 --profile $PROFILE \
		--region $REGION \
		--repository-name "$SERVICE_NAME" \
		--query "repository.repositoryUri" \
		--output text`
fi

printf "${PRIMARY}* Building \`${SERVICE_NAME}\`${NC}\n";

# Build the container, and assign a tag to it for versioning
# Tag for versioning the container images, currently set to timestamp
TAG=`latest +%s`

(npm install);
docker build -t $SERVICE_NAME .
docker tag $SERVICE_NAME:latest $REPO:latest

# Push the image
printf "${PRIMARY}* Pushing \`${SERVICE_NAME}\`${NC}\n";

docker push $REPO:latest