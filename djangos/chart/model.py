from django.db import models
import pandas as pd

class StockData(models.Model):
    def read_csv(file_path):
        data = pd.read_csv('./코스피지수 과거 데이터.csv')
        return data