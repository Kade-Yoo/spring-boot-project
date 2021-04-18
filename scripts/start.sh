#!/usr/bin/env bash

ABSPATH=$(readlink -f $0)
ABSDIR=$(dirname $ABSPATH)
source ${ABSDIR}/profile.sh

REPOSITORY=/home/ec2-user/app/step3

PROJECT_NAME=spring-boot-project

echo "> Build 파일 복사"
cp $REPOSITORY/zip/*.jar $REPOSITORY/

echo "> 현재 구동 중인 애플리케이션 pid 확인"

JAR_NAME=$(ls -tr $REPOSITORY/*.jar | tail -n 1)

echo "> JAR_NAME: $JAR_NAME"
echo "> $JAR_NAME 에 실행권한 추가"

chmod +x $JAR_NAME

echo "> $JAR_NAME 실행"

IDLE_PROFILE=$(find_idle_profile)

echo "> $IDLE_PROFILE 실행"
echo "> application-$IDLE_PROFILE 실행"

nohup java -jar -Dspring.config.location=classpath:/application.properties,classpath:/application-"$IDLE_PROFILE".properties,/home/ec2-user/app/application-oauth.properties,/home/ec2-user/app/application-real-db.properties -Dspring.profiles.active="$IDLE_PROFILE" "$JAR_NAME" > "$REPOSITORY"/nohup-"$IDLE_PROFILE".out 2>&1 &