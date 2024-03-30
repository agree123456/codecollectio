from .models import StockData

def index(request):
    data = StockData.objects.all()
    labels = data['날짜'].tolist()
    prices = data['종가'].tolist()
    return render(request, 'chart.html', {'labels': labels, 'prices': prices})