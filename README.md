# 한이음 공모전 작품
## 너의 마음은
<br>
<br>
<br>
<br>

### 현재 진행 현황
1. REST API 서버를 구현하여 영상을 분석하여 얻어낸 데이터들의 CREATE, READ, DELETE 기능을 구현해놓음
2. access token 을 통한 api 요청 통제 해놓기
3. 상담자가 상담 도중 적은 내용들을 같이 받아 DB 에 저장
4. 해당 emotion 분석 정보들을 보여주는 과정에서 상담 도중 적은 내용들을 같이 보여줌 ( 수정 여부 생각하기 )

영상으로 받아놓은 emotion.json 파일을 클라이언트 측 일렉트론 앱에서 ipc 렌더러에서 신호를 수신 받아 
렌더러 측으로 json 데이터를 전달하여 리엑트에서 서버로 해당 데이터의 처리 요청받으면 이 데이터를 관리하고
리엑트에서 데이터에 대한 요청 서비스를 대응하는 구조