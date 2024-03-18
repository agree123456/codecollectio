# 모듈 import
import requests
import oauth2 as oauth
import pprint

# pandas
import pandas as pd
import numpy as np

# warning
import warnings
warnings.filterwarnings("ignore")

# eBEST OPEN API 접속 클래스
class eBESTConnect:
    # 초기화 함수
    def __init__(self, app_key, app_secret):
        # 기본 도메인, URL 설정
        self._domain = "https://openapi.ebestsec.co.kr:8080"
        self._path = None
        self._url = f'{self._domain}/{self._path}'
        self.access_token = self.get_token(app_key, app_secret)
    
    '''
    # 접근토큰 발급받는 합수
    # 접근토큰 유효기간 : 신청일로부터 익일 07시까지, 만료시 재발급 후 이용
    /**
    * @param APP_KEY : API 키
    * @param APP_SECRET : API 시크릿 키
    * @return ACCESS_TOKEN : 접속 토큰
    */
    '''
    def get_token(self, app_key, app_secret):
        header = {"content-type":"application/x-www-form-urlencoded"}
        param = {"grant_type":"client_credentials",
                "appkey":app_key,
                "appsecretkey":app_secret,
                "scope":"oob"
                }
        PATH = "oauth2/token"
        DOMAIN = self._domain
        URL = f"{DOMAIN}/{PATH}"

        request = requests.post(URL, verify=False, headers=header, params=param ,timeout=3)

        if __name__ == "__main__":
            print("URL          : ", URL, "\n")               
            print("OAuth        : ")
            pprint.pprint(request.json()) 
        
        ACCESS_TOKEN = request.json()["access_token"] 

        return ACCESS_TOKEN