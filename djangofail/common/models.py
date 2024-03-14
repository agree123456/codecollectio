from django.db import models
import pandas as pd

class StockData(models.Model):
    date = models.DateField()
    close = models.FloatField()

    @staticmethod
    def read_csv(file_path):
        data = pd.read_csv(file_path)
        return data