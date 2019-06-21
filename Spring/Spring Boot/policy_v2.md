2019 6 19


파일을 서버에 저장하고
배포 서버가 그 서버에서 파일을 가져간 뒤 Tenth에 업로드하는 방식이다

배포의 배치가 돌면서 실행시키는 스크립트이다
```bash
#!/bin/bash
#-------------------------------------------------------------------------------------#
# tenth beta
# HOST=twg.beta.tset.daumcdn.net
# wirte_key=w_xxx
#-------------------------------------------------------------------------------------#
# tenth live
HOST=twg.tset.daumcdn.net
wirte_key=w_xxxx
#-------------------------------------------------------------------------------------#

svc=gamepub
tenth2_full_path=/gamepub/policy_dev
full_path_to_upload=/daum/service/jenkins/.jenkins/soup/tenth

echo
echo "#-------------------------------------------------------------------------------"
echo "# 1. SOUP 서버에서 약관 파일을 복사"
echo "#-------------------------------------------------------------------------------"
scp gm-user-admin1:/kakaogames/service/soup-admin/tenth/* /daum/service/jenkins/.jenkins/soup/tenth

echo
echo "#-------------------------------------------------------------------------------"
echo "# 2. 복사된 약관 파일을 tenth 로 업로드"
echo "#-------------------------------------------------------------------------------"
for file in /daum/service/jenkins/.jenkins/soup/tenth/*
do
  date=$(date -u --rfc-822)
  option="x-twg-put-option:cplace"
  filename=$(basename $file)
  tenth2_full_pathname="$tenth2_full_path/$filename"
  full_pathname_to_upload="$full_path_to_upload/$filename"
  canonic="PUT\n\n\n$date\n$option\n$tenth2_full_pathname"
  sign=$(echo -n -e "$canonic" | openssl dgst -sha1 -hmac "$wirte_key" -binary | openssl enc -base64)

  curl $HOST:$PORT$tenth2_full_pathname -H  "Authorization: TWG $svc:$sign" -H "Date: $date" -H "X-Twg-Put-Option: cplace" -T $full_pathname_to_upload 2>/dev/null
  echo
done

```


배치 실행시키는 스크립트
./upload_tenth (env에 따라) dev
또는
./upload_tenth (env에 따라) live
