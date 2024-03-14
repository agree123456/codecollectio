# 모듈 import
# warning
import warnings
warnings.filterwarnings("ignore")

# 접속 모듈
from connect import eBESTConnect
from ebestapi import eBESTAPI

# 현물주문 Class
class StockOrder(eBESTAPI):
    def __init__(self, access_token, _order_body_params):
        super().__init__(access_token)
        # URL 재설정
        self._path = "stock/order"
        
        # 거래코드와 바디 설정
        self.tr_cd = "CSPAT00601"
        self._order_body_params = _order_body_params
        self.body = self.make_body(self._order_body_params)
        
        # 주문결과 JSON 데이터 확인
        self._json_data = self.make_request(self._path, self.tr_cd, self.body)
        
        # 데이터프레임으로 변환
        self.outblock_list = ["OutBlock1", "OutBlock2"]
        self._data_frame = self.make_df(self._json_data, self.tr_cd, self.outblock_list)
        
        # CSV로 저장
        # self.save_csv(self._data_frame, self.tr_cd)
        
    # 바디 생성 함수
    def make_body(self, _order_body_params):
        _body = {
            "CSPAT00601InBlock1": {
                  "IsuNo" : _order_body_params['ticker'] # 종목번호(앞에 A 필수)
                , "OrdQty" : _order_body_params['ord_qty'] # 주문수량
                , "OrdPrc" : _order_body_params['ord_price'] # 주문가
                , "BnsTpCode" : _order_body_params['bnstp_code'] # 매매구분(1:매도, 2:매수)
                , "OrdprcPtnCode" : _order_body_params['ord_prc_code'] # 호가유형코드
                , "MgntrnCode" : '000' # 신용거래코드
                , 'LoanDt' : '' # 대출일 (없으면 빈칸)
                , 'OrdCndiTpCode' : '0' # 주문조건(0:없음, 1:IOC, 2:FOK)
            }
        }
        
        return _body
    
## 주문 바디 파라미터 설정
'''
- 코드 범례
"OrdprcPtnCode" - 호가유형코드
00@지정가
03@시장가
05@조건부지정가
06@최유리지정가
07@최우선지정가
61@장개시전시간외종가
81@시간외종가
82@시간외단일가
'''

def make_order_params(ticker, ord_qty, ord_price, bnstp_code):
    '''
    # 바디에 넣어줄 파라미터 설정
    # 테스트에서는 편의상 전부 시장가로 주문하겠습니다.
    # 추후 모델이 산출한 변수들로 대입
    '''
    _order_body_params = {
        'ticker' : ticker # 종목번호(앞에 A 필수)
        , 'ord_qty': ord_qty # 주문수량
        , 'ord_price' : ord_price # 주문가
        , 'bnstp_code' : bnstp_code # 매매구분(1:매도, 2:매수)
        , 'ord_prc_code' : '03' # 호가유형코드, 테스트에서는 시장가 대입
    }
    return _order_body_params

## (테스트용) 공통 파라미터 주입
ticker_list = ['A099440', 'A001470', 'A038110', 'A013990']

## 함수 실행
# OPEN API 키 설정
APP_KEY = 'PSGfwLiFjkhtsSvd206vLlSS3B2KBUN8FThC'
APP_SECRET = '2j2l3tfh8ObeserXe6YGsIRtoRJFT3UE'

# 토큰 생성
conn = eBESTConnect(APP_KEY, APP_SECRET)
ACCESS_TOKEN = conn.access_token

# 주문 실행
for ticker in ticker_list:
    ord_qty = 10
    ord_price = 0
    bnstp_code = "2"

    _order_body_params = make_order_params(ticker, ord_qty, ord_price, bnstp_code)
    stock_order = StockOrder(ACCESS_TOKEN, _order_body_params)