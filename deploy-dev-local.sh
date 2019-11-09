#!/bin/sh

if ! aws ecr get-login --no-include-email --region eu-central-1; then
  echo "Произошла ошибка при логине на aws"
  exit 1
fi

if ! ./gradlew -Pdev,swagger,aws,no-liquibase,grahiql,graphql jib; then
  echo "Произошла при сборке Docker образа"
  exit 1
fi

if ! aws ecs update-service --service arn:aws:ecs:eu-central-1:739120348252:service/NRBOOM-dev-NRBoomAppService-1V352D5FDNIRY --cluster arn:aws:ecs:eu-central-1:739120348252:cluster/NRBOOM-dev-NRBoomCluster-1BH82SMEV5OLL --force-new-deployment; then
  echo "Произошла ошибка при перезапуске сервиса"
  exit 1
fi
