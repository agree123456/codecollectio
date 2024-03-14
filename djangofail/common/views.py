from django.contrib.auth import authenticate, login, logout
from django.shortcuts import render, redirect
from common.forms import UserForm
from .models import StockData
import pandas as pd
def logout_view(request):
    logout(request)
    return redirect('index')


def signup(request):
    if request.method == "POST":
        form = UserForm(request.POST)
        if form.is_valid():
            form.save()
            username = form.cleaned_data.get('username')
            raw_password = form.cleaned_data.get('password1')
            user = authenticate(username=username, password=raw_password)  # 사용자 인증
            login(request, user)  # 로그인
            return redirect('index')
    else:
        form = UserForm()
    return render(request, 'common/signup.html', {'form': form})


def page_not_found(request, exception):
    return render(request, 'common/404.html', {})




def index(request):
    data = pd.read_csv('common/코스피지수 과거 데이터.csv')
    labels = data['날짜'].tolist()
    prices = data['종가'].tolist()
    return render(request, 'chart/chart.html', {'labels': labels, 'prices': prices})

# def upload_csv(request):
#     if request.method == 'POST':
#         form = UploadFileForm(request.POST, request.FILES)
#         if form.is_valid():
#             data = StockData.read_csv(request.FILES['file'])
#             for index, row in data.iterrows():
#                 StockData.objects.create(date=row['date'], close=row['close'])
#             return redirect('index')
#     else:
#         form = UploadFileForm()
#     return render(request, 'upload.html', {'form': form})