# WebRTC_ex

## 1. 예제 소스 다운로드 
[webrtc.googlesource.com](webrtc.googlesource.com/src/+/master/examples/androidapp/webrtc.googlesource.com/src/+/master/examples/androidapp/)

## 2. autobanh.jar 파일을 프로젝트 안에 넣어주기
third_party > autobanh > lib 폴더에 있는 autobanh.jar 파일을 프로젝트 안에 넣어주기<br>
![캡처](https://user-images.githubusercontent.com/62804036/120833928-54500600-c59d-11eb-89ac-b23bf09721b5.JPG)
Android -> Project 로 변경<br>
Project 에서 app - libs 폴더에 autobanh.jar 파일을 넣는다(libs가 없어서 만들어줌).
## 3. build.gradle
```
implementation 'org.webrtc:google-webrtc:1.0.32006'
implementation files('libs/autobanh.jar')
```
### 4. 예제 리소스 코드 붙여넣기 및 수정
다 함.

### 5. Manifests
```
<uses-feature android:name="android.hardware.camera"/>
<uses-feature android:name="android.hardware.camera.autofocus"/>
<uses-feature android:glEsVersion="0x00020000" android:required="true"/>
<uses-permission android:name="android.permission.CAMERA"/>
<uses-permission android:name="android.permission.CHANGE_NETWORK_STATE"/>
<uses-permission android:name="android.permission.MODIFY_AUDIO_SETTINGS"/>
<uses-permission android:name="android.permission.RECORD_AUDIO"/>
<uses-permission android:name="android.permission.BLUETOOTH"/>
<uses-permission android:name="android.permission.INTERNET"/>
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
<uses-permission android:name="android.permission.CAPTURE_VIDEO_OUTPUT"
    tools:ignore="ProtectedPermissions" />
    
<application
    ...
    android:allowBackup="false"
    android:supportsRtl="false"
    tools:ignore="HardcodedDebugMode">
    <activity
        android:name="ConnectActivity"
        android:label="@string/app_name"
        android:windowSoftInputMode="adjustPan">
        <intent-filter>
            <action android:name="android.intent.action.MAIN" />
            <category android:name="android.intent.category.LAUNCHER" />
        </intent-filter>
        <intent-filter>
            <action android:name="android.intent.action.VIEW" />

            <category android:name="android.intent.category.DEFAULT" />
            <category android:name="android.intent.category.BROWSABLE" />

            <data
                android:host="appr.tc"
                android:scheme="https" />
            <data
                android:host="appr.tc"
                android:scheme="http" />
        </intent-filter>
    </activity>
    <activity
        android:name="SettingsActivity"
        android:label="@string/settings_name"></activity>
    <activity
        android:name="CallActivity"
        android:configChanges="orientation|smallestScreenSize|screenSize|screenLayout"
        android:label="@string/app_name"
        android:screenOrientation="fullUser"
        android:theme="@style/CallActivityTheme"></activity>
</application>
```

# 생각해본 앞으로의 진행상황(❓❓)

### ✔화면 구성<br>
번호입력후 입장 -> 캠화면 (풀스크린, 전면카메라, 통화끊기, 음소거)<br>

❔❔1️⃣<br> 번호 입력 받는거를 스터디방 이름 (String)으로 입력받는걸로 변경 <br><br>
❔❔2️⃣<br> 그렇다면 방생성후 이걸 DB로 받는 것은?<br><br>
❔❔3️⃣<br> fragment_call.xml이 캠 화면인데 상단에 공지사항 및 방 이름 적고 그 밑으로 캠 화면 뜨게 하면 될 것 같은데 이거 사이즈 변경 어떻게 하는지<br><br>
❔❔4️⃣<br> xml말고 Java파일들은.. 최대한 보면서 코드 흐름 이해하는게 우선인 것 같음, 어차피 우리가 못짤듯<br><br>
